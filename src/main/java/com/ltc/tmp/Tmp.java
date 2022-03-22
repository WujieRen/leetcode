package com.ltc.tmp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2022/3/20
 * @description
 */
public class Tmp {

    /**
     * 构造树
     * @param obj
     * @param node
     * @param parentNodeList
     */
    public static void json2Tre(JSONObject obj, Node node, List<Node> parentNodeList) {
        List<JSONArray> jryjList = new LinkedList<>();
        for (String key : obj.keySet()) {
            Object val = obj.get(key);
            if (val instanceof String || val instanceof Integer) {
                LinkedHashMap<String, Object> map = new LinkedHashMap();
                map.put(key, val);
                node.colums.add(map);
                continue;
            }
            if (val instanceof JSONObject) {
                json2Tre((JSONObject) val, node, parentNodeList);
                continue;
            }
            if (val instanceof JSONArray) {
                JSONArray jsry = (JSONArray) val;
                node.setSize(node.getSize() > jsry.size() ? node.getSize() : jsry.size());
                jryjList.add(jsry);
            }
        }

        for (JSONArray jsry : jryjList) {
            List<Node> newNoLis = new LinkedList<>();
            boolean flag = parentNodeList.isEmpty();
            for (int i = 0; i < jsry.size(); ++i) {
                JSONObject jsonObject = jsry.getJSONObject(i);
                Node newNode = new Node(new LinkedList<>(), new LinkedList<>());
                if(flag) {
                    parentNodeList.add(newNode);
                } else {
                   for(Node n : parentNodeList) {
                       if(n.getSize() != 0 && n.getSize() == n.children.size())
                           continue;
                       n.children.add(newNode);
                   }
                }
                newNoLis.add(newNode);
                json2Tre(jsonObject, newNode, newNoLis);
            }
            parentNodeList = newNoLis;
        }
    }

    /**
     * 遍历树
     */
    private static List<List<LinkedHashMap<String, Object>>> res = new LinkedList<>();
    private static List<LinkedHashMap<String, Object>> list = new LinkedList<>();

    public static void iterateData(Node root) {
        if (root.children.isEmpty()) {
            res.add(new LinkedList<>(list));
            return;
        }
        List<Node> childs = root.children;
        for (Node node : childs) {
            list.addAll(node.colums);
            iterateData(node);
            list.removeAll(node.colums);
        }
    }

    public static void main(String[] args) {
//        String json = "{\"root\":{\"code\":\"DB14/T 671.1-2012\",\"data\":[{\"point\":[{\"ps_station_code\":\"000006\",\"ps_station_entertime\":\"2021-05-05 05:45:14\"}],\"ps_person_card\":\"01315\"},{\"point\":[{\"ps_station_code\":\"000007\",\"ps_station_entertime\":\"2021-05-16 06:54:38\"},{\"ps_station_code\":\"000008\",\"ps_station_entertime\":\"2021-05-16 07:00:09\"},{\"ps_station_code\":\"000009\",\"ps_station_entertime\":\"2021-05-16 07:05:59\"},{\"ps_station_code\":\"000010\",\"ps_station_entertime\":\"2021-05-16 07:05:33\"}],\"ps_person_card\":\"01433\"}],\"head\":{\"cs_data_time\":\"2021-05-16 09:19:32\",\"cs_mine_code\":610631010,\"cs_mine_addr\":[{\"1k\":\"hl\",\"2k\":\"dt\"},{\"1k\":\"xz\",\"2k\":\"sm\"}]},\"a1\":\"a1v\",\"B\":[{\"b1\":\"b1v\"},{\"b1\":\"fsdafas\"}]}}";
//        String json = "{\"code\":\"1\",\"date\":\"312321312\",\"root\":{\"name\":\"fda\",\"address\":{\"ad1\":\"aaa\"}}}";
//        String json = "{\"code\":\"1\",\"date\":\"312321312\",\"root\":{\"name\":\"fda\",\"address\":{\"ad1\":\"aaa\",},\"ary\":[{\"phone\":\"fsfdsds\"},{\"phone\":\"343\"}]}}";
//        String json = "{\"data\":[{\"school_name\":\"西北农林大学\",\"school_id\":\"XBNLDX\",\"depart\":[{\"name\":\"\"}]},{\"school_name\":\"西北大学\",\"school_id\":\"XBDX\",\"depart\":[{\"name\":\"行政\"},{\"name\":\"财务\"}]}],\"msg\":\"西北校园分布\",\"status\":0,\"cc\":[{\"cc1\":\"西北\"},{\"cc2\":\"未央\"}]}";
        String json = "{\"data\":[{\"school_name\":\"西北农林大学\",\"school_id\":\"XBNLDX\",\"depart\":[{\"name\":\"\",\"sister\":[{\"city\":\"\"}]}]},{\"school_name\":\"西北大学\",\"school_id\":\"XBDX\",\"depart\":[{\"name\":\"行政\",\"sister\":[{\"city\":\"chengdu\"},{\"city\":\"xian\"}]},{\"name\":\"财务\",\"sister\":[{\"city\":\"\"}]}]}],\"msg\":\"西北校园分布\",\"status\":0,\"cc\":[{\"cc1\":\"西北\"},{\"cc1\":\"未央\"}]}";
        Node root = new Node(new LinkedList<>(), new LinkedList<>());
        json2Tre(JSONObject.parseObject(json), root, root.children);
        System.out.println(root);
        list.addAll(root.colums);
        iterateData(root);
        System.out.println(res);

    }

}

/**
 * 树结构
 */
@Data
@NoArgsConstructor
class Node {
    List<LinkedHashMap<String, Object>> colums;
    List<Node> children;
    int size;
    Node(List<LinkedHashMap<String, Object>> colums, List<Node> children) {
        this.colums = colums;
        this.children = children;
    }
}
