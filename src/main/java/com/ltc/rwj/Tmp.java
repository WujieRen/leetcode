package com.ltc.rwj;

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

    /*public static void construct(JSONObject obj, Node node, List<Node> parentNodeList) {
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
                construct((JSONObject) val, node, parentNodeList);
                continue;
            }
            if (val instanceof JSONArray) {
                jryjList.add((JSONArray) val);
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
                       n.children.add(newNode);
                   }
                }
                newNoLis.add(newNode);
                construct(jsonObject, newNode, newNoLis);
            }
            parentNodeList = newNoLis;
        }
    }*/

    public static void construct(JSONObject obj, Node node) {
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
                construct((JSONObject) val, node);
                continue;
            }
            if (val instanceof JSONArray) {
                jryjList.add((JSONArray) val);
            }
        }

        for (JSONArray jsry : jryjList) {
            Node newNode = null;
            int childSize = node.children.size();
            for (int i = 0; i < jsry.size(); ++i) {
                JSONObject jsonObject = jsry.getJSONObject(i);
                newNode = new Node(new LinkedList<>(), new LinkedList<>());
                if (childSize == 0) {
                    node.children.add(newNode);
                } else {
                    for (Node n : node.children) {
                        n.children.add(newNode);
                    }
                }
                construct(jsonObject, newNode);
            }
//            node = newNode == null ? node : newNode;
            node = newNode;
        }
    }

    public static void fillTree(List<Node> nodes) {
        if (nodes == null || nodes.isEmpty()) return;
        for (Node node : nodes) {
            fillTree(node.children);
        }

        List<Node> sync = null;
        for (Node n : nodes) {
            if (!n.children.isEmpty()) {
                sync = n.children;
                break;
            }
        }
        if (sync == null) return;
        for (Node n : nodes) {
            if (n.children.isEmpty()) n.children = sync;
        }
    }

    private static List<List<LinkedHashMap<String, Object>>> res = new LinkedList<>();
    private static List<LinkedHashMap<String, Object>> list = new LinkedList<>();

    public static void iterateData(Node root) {
//        list.addAll(root.colums);
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
//        String json = "{\"data\":[{\"school_name\":\"北京大学\",\"school_id\":\"BJDX\"},{\"school_name\":\"清华大学\",\"school_id\":\"QHDX\"}],\"msg\":\"北京校园分布\",\"status\":1,\"cc\":{\"cc1\":\"北京\",\"cc2\":\"海淀\"}}";
        String json = "[{\"data\":[{\"school_name\":\"西北农林大学\",\"school_id\":\"XBNLDX\"},{\"school_name\":\"西北大学\",\"school_id\":\"XBDX\",\"depart\":[{\"name\":\"行政\"},{\"name\":\"财务\"}]}],\"msg\":\"西北校园分布\",\"status\":0,\"cc\":{\"cc1\":\"西北\",\"cc2\":\"未央\"}},{\"data\":[{\"school_name\":\"北京大学\",\"school_id\":\"BJDX\"},{\"school_name\":\"清华大学\",\"school_id\":\"QHDX\"}],\"msg\":\"北京校园分布\",\"status\":1,\"cc\":{\"cc1\":\"北京\",\"cc2\":\"海淀\"}}]";
        Node root = new Node(new LinkedList<>(), new LinkedList<>());
//        root.children.add(new Node(new LinkedList<>(), new LinkedList<>()));
//        construct(JSONObject.parseObject(json), root, root.children);
//        JSONArray.parseArray(json).forEach(jsbj -> construct((JSONObject) jsbj, root)); //TODO: 我这种处理方式不能把JSONArray的所有jsbj都放在一个root去处理，否则数据会有误
//        construct(JSONObject.parseObject(json), root);
        /*System.out.println(root);
        fillTree(root.children);
        System.out.println(root);
        list.addAll(root.colums);
        iterateData(root);
        System.out.println(res);*/

        /*JSONArray jsry = JSONArray.parseArray(json);
        for(int i = 0; i < jsry.size(); ++i) {
            Node node = new Node(new LinkedList<>(), new LinkedList<>());
            construct(jsry.getJSONObject(i), node);
            fillTree(node.children);
            list.addAll(node.colums);
            iterateData(node);
            System.out.println(res);
        }*/

        JSONArray.parseArray(json).forEach(jsbj -> construct((JSONObject) jsbj, root));
        System.out.println(root);
        fillTree(root.children);
        System.out.println(root);
        list.addAll(root.colums);
        iterateData(root);
        System.out.println(res);
    }


}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Node {
    List<LinkedHashMap<String, Object>> colums;
    List<Node> children;
}
