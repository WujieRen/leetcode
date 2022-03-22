DROP TABLE IF EXISTS `coalmine_1`.`ods_opc_ua`;
CREATE EXTERNAL TABLE `coalmine_1`.`ods_opc_ua`(
  `dap_id` string COMMENT '唯一标识id',
  `level1_en` string COMMENT '1级英文名',
  `level1_zh` string COMMENT '1级中文名',
  `level2_en` string COMMENT '2级英文名',
  `level2_zh` string COMMENT '2级中文名',
  `level3_en` string COMMENT '3级英文名',
  `level3_zh` string COMMENT '3级中文名',
  `level4_en` string COMMENT '4级英文名',
  `level4_zh` string COMMENT '4级中文名',
  `level5_en` string COMMENT '5级英文名',
  `level5_zh` string COMMENT '5级中文名',
  `level6_en` string COMMENT '6级英文名',
  `level6_zh` string COMMENT '6级中文名',
  `level7_en` string COMMENT '7级英文名',
  `level7_zh` string COMMENT '7级中文名',
  `level8_en` string COMMENT '8级英文名',
  `level8_zh` string COMMENT '8级中文名',
  `identifier` string COMMENT '测点唯一标识',
  `tag_en` string COMMENT '标签英文名',
  `tag_zh` string COMMENT '标签中文名',
  `tag_value` string COMMENT '标签值',
  `system` string COMMENT '系统',
  `device` string COMMENT '设备',
  `generation_time` string COMMENT '数据本身生成时间',
  `save_time` string COMMENT '数据保存(入库)时间',
  `count` string COMMENT '以.分割的层数'
)
PARTITIONED BY (`dt` string)
ROW FORMAT SERDE 'org.apache.hive.hcatalog.data.JsonSerDe'
STORED AS INPUTFORMAT 'org.apache.hadoop.mapred.TextInputFormat'
OUTPUTFORMAT 'org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat'
LOCATION 'hdfs://hdp1.utopin.cn:8020/dap/coalmine_1/ods_opc_ua'

MSCK REPAIR TABLE coalmine_1.ods_opc_ua;





----------------------------   皮带     ---------------------------
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_101pd PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '101皮带%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_1bpd PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '一部皮带%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_2sspd PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '二上山皮带%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_8pqpd PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '八盘区皮带%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_b11bpd PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '北一一部皮带%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_b12bpd PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '北一二部皮带%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_b2pd PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '北二皮带%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_x11bpd PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '西一一部皮带%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_x12bpd PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '西一二部皮带%';


select * from (
select a.dap_id a_id, b.dap_id b_id from
( SELECT dap_id FROM ods_opc_ua WHERE dt='20211231' AND system='PDZ' ) a
left join
( SELECT dap_id FROM ods_opc_ua WHERE dt='20211231' AND tag_zh LIKE '101皮带%') b
on a.dap_id=b.dap_id
) c where c.b_id is null limit 5;


----------------------------   101皮带     ---------------------------
SELECT * FROM coalmine_1.ods_opc_ua t
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND system='PDZ'

SELECT * FROM coalmine_1.ods_opc_ua t
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '101皮带%'

----------------------------   一部皮带     ---------------------------
SELECT * FROM coalmine_1.ods_opc_ua t
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '一部皮带%'


----------------------------   二上山皮带     ---------------------------
SELECT * FROM coalmine_1.ods_opc_ua t
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '二上山皮带%'

SELECT * FROM coalmine_1.ods_opc_ua t
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND system='PDESS'





----------------------------   八盘区皮带     ---------------------------
SELECT * FROM coalmine_1.ods_opc_ua t
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '八盘区皮带%'

SELECT * FROM coalmine_1.ods_opc_ua t
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND system='PDBPQ'



----------------------------   北一一部皮带     ---------------------------
SELECT * FROM coalmine_1.ods_opc_ua t
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '北一一部皮带%'

SELECT * FROM coalmine_1.ods_opc_ua t
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND system='PDBYYB'



----------------------------   北一二部皮带     ---------------------------
SELECT * FROM coalmine_1.ods_opc_ua t
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '北一二部皮带%'

SELECT * FROM coalmine_1.ods_opc_ua t
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND system='PDBYEB'



----------------------------   北二皮带     ---------------------------
SELECT * FROM coalmine_1.ods_opc_ua t
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '北二皮带%'

SELECT * FROM coalmine_1.ods_opc_ua t
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND system='PDBE'




----------------------------   西一一部皮带     ---------------------------
SELECT * FROM coalmine_1.ods_opc_ua t
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '西一一部皮带%'

SELECT * FROM coalmine_1.ods_opc_ua t
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND system='PDXYYB'


----------------------------   西一二部皮带     ---------------------------
SELECT * FROM coalmine_1.ods_opc_ua t
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '西一二部皮带%'

SELECT * FROM coalmine_1.ods_opc_ua t
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND system='PDXYEB'




----------------------------   四号风井压风     ---------------------------
SELECT count(*) FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND system='YFSHFJ'

SELECT count(*) FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '四号风井压风%'

INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_4hfjyf PARTITION(dt='20211224') SELECT dap_id, level1_en, level1_zh, level2_en, level2_zh, level3_en, level3_zh, level4_en, level4_zh, level5_en, level5_zh, level6_en, level6_zh, level7_en, level7_zh, level8_en, level8_zh, identifier, tag_en, tag_zh, tag_value, system, device, generation_time, save_time, count FROM coalmine_1.ods_opc_ua WHERE dt='20211224' AND tag_zh LIKE '四号风井压风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_4hfjyf PARTITION(dt='20211225') SELECT dap_id, level1_en, level1_zh, level2_en, level2_zh, level3_en, level3_zh, level4_en, level4_zh, level5_en, level5_zh, level6_en, level6_zh, level7_en, level7_zh, level8_en, level8_zh, identifier, tag_en, tag_zh, tag_value, system, device, generation_time, save_time, count FROM coalmine_1.ods_opc_ua WHERE dt='20211225' AND tag_zh LIKE '四号风井压风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_4hfjyf PARTITION(dt='20211226') SELECT dap_id, level1_en, level1_zh, level2_en, level2_zh, level3_en, level3_zh, level4_en, level4_zh, level5_en, level5_zh, level6_en, level6_zh, level7_en, level7_zh, level8_en, level8_zh, identifier, tag_en, tag_zh, tag_value, system, device, generation_time, save_time, count FROM coalmine_1.ods_opc_ua WHERE dt='20211226' AND tag_zh LIKE '四号风井压风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_4hfjyf PARTITION(dt='20211227') SELECT dap_id, level1_en, level1_zh, level2_en, level2_zh, level3_en, level3_zh, level4_en, level4_zh, level5_en, level5_zh, level6_en, level6_zh, level7_en, level7_zh, level8_en, level8_zh, identifier, tag_en, tag_zh, tag_value, system, device, generation_time, save_time, count FROM coalmine_1.ods_opc_ua WHERE dt='20211227' AND tag_zh LIKE '四号风井压风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_4hfjyf PARTITION(dt='20211228') SELECT dap_id, level1_en, level1_zh, level2_en, level2_zh, level3_en, level3_zh, level4_en, level4_zh, level5_en, level5_zh, level6_en, level6_zh, level7_en, level7_zh, level8_en, level8_zh, identifier, tag_en, tag_zh, tag_value, system, device, generation_time, save_time, count FROM coalmine_1.ods_opc_ua WHERE dt='20211228' AND tag_zh LIKE '四号风井压风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_4hfjyf PARTITION(dt='20211229') SELECT dap_id, level1_en, level1_zh, level2_en, level2_zh, level3_en, level3_zh, level4_en, level4_zh, level5_en, level5_zh, level6_en, level6_zh, level7_en, level7_zh, level8_en, level8_zh, identifier, tag_en, tag_zh, tag_value, system, device, generation_time, save_time, count FROM coalmine_1.ods_opc_ua WHERE dt='20211229' AND tag_zh LIKE '四号风井压风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_4hfjyf PARTITION(dt='20211230') SELECT dap_id, level1_en, level1_zh, level2_en, level2_zh, level3_en, level3_zh, level4_en, level4_zh, level5_en, level5_zh, level6_en, level6_zh, level7_en, level7_zh, level8_en, level8_zh, identifier, tag_en, tag_zh, tag_value, system, device, generation_time, save_time, count FROM coalmine_1.ods_opc_ua WHERE dt='20211230' AND tag_zh LIKE '四号风井压风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_4hfjyf PARTITION(dt='20211231') SELECT dap_id, level1_en, level1_zh, level2_en, level2_zh, level3_en, level3_zh, level4_en, level4_zh, level5_en, level5_zh, level6_en, level6_zh, level7_en, level7_zh, level8_en, level8_zh, identifier, tag_en, tag_zh, tag_value, system, device, generation_time, save_time, count FROM coalmine_1.ods_opc_ua WHERE dt='20211231' AND tag_zh LIKE '四号风井压风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_4hfjyf PARTITION(dt='20220101') SELECT dap_id, level1_en, level1_zh, level2_en, level2_zh, level3_en, level3_zh, level4_en, level4_zh, level5_en, level5_zh, level6_en, level6_zh, level7_en, level7_zh, level8_en, level8_zh, identifier, tag_en, tag_zh, tag_value, system, device, generation_time, save_time, count FROM coalmine_1.ods_opc_ua WHERE dt='20220101' AND tag_zh LIKE '四号风井压风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_4hfjyf PARTITION(dt='20220102') SELECT dap_id, level1_en, level1_zh, level2_en, level2_zh, level3_en, level3_zh, level4_en, level4_zh, level5_en, level5_zh, level6_en, level6_zh, level7_en, level7_zh, level8_en, level8_zh, identifier, tag_en, tag_zh, tag_value, system, device, generation_time, save_time, count FROM coalmine_1.ods_opc_ua WHERE dt='20220102' AND tag_zh LIKE '四号风井压风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_4hfjyf PARTITION(dt='20220103') SELECT dap_id, level1_en, level1_zh, level2_en, level2_zh, level3_en, level3_zh, level4_en, level4_zh, level5_en, level5_zh, level6_en, level6_zh, level7_en, level7_zh, level8_en, level8_zh, identifier, tag_en, tag_zh, tag_value, system, device, generation_time, save_time, count FROM coalmine_1.ods_opc_ua WHERE dt='20220103' AND tag_zh LIKE '四号风井压风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_4hfjyf PARTITION(dt='20220104') SELECT dap_id, level1_en, level1_zh, level2_en, level2_zh, level3_en, level3_zh, level4_en, level4_zh, level5_en, level5_zh, level6_en, level6_zh, level7_en, level7_zh, level8_en, level8_zh, identifier, tag_en, tag_zh, tag_value, system, device, generation_time, save_time, count FROM coalmine_1.ods_opc_ua WHERE dt='20220104' AND tag_zh LIKE '四号风井压风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_4hfjyf PARTITION(dt='20220105') SELECT dap_id, level1_en, level1_zh, level2_en, level2_zh, level3_en, level3_zh, level4_en, level4_zh, level5_en, level5_zh, level6_en, level6_zh, level7_en, level7_zh, level8_en, level8_zh, identifier, tag_en, tag_zh, tag_value, system, device, generation_time, save_time, count FROM coalmine_1.ods_opc_ua WHERE dt='20220105' AND tag_zh LIKE '四号风井压风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_4hfjyf PARTITION(dt='20220106') SELECT dap_id, level1_en, level1_zh, level2_en, level2_zh, level3_en, level3_zh, level4_en, level4_zh, level5_en, level5_zh, level6_en, level6_zh, level7_en, level7_zh, level8_en, level8_zh, identifier, tag_en, tag_zh, tag_value, system, device, generation_time, save_time, count FROM coalmine_1.ods_opc_ua WHERE dt='20220106' AND tag_zh LIKE '四号风井压风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_4hfjyf PARTITION(dt='20220107') SELECT dap_id, level1_en, level1_zh, level2_en, level2_zh, level3_en, level3_zh, level4_en, level4_zh, level5_en, level5_zh, level6_en, level6_zh, level7_en, level7_zh, level8_en, level8_zh, identifier, tag_en, tag_zh, tag_value, system, device, generation_time, save_time, count FROM coalmine_1.ods_opc_ua WHERE dt='20220107' AND tag_zh LIKE '四号风井压风%';


INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_4hfjyf PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '四号风井压风%';


0: jdbc:hive2://hdp2.utopin.cn:10000> select count(1) from coalmine_1.dwd_opc_ua_4hfjyf;
+----------+
|   _c0    |
+----------+
| 3913280  |
+----------+
0: jdbc:hive2://hdp3.utopin.cn:10016> select count(1) from coalmine_1.dwd_opc_ua_4hfjyf where dt<='20220106';
+-----------+
| count(1)  |
+-----------+
| 3408230   |
+-----------+





--------------------------------------    瓦斯抽放   --------------------
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_3hwscf PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '三号瓦斯抽放%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_4hwscf PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '四号瓦斯抽放%';


--------------------------------------    三号瓦斯抽放   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '三号瓦斯抽放%'



--------------------------------------    四号瓦斯抽放   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '四号瓦斯抽放%'





--------------------------------------   通风
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_3hzstf PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '三号主扇通风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_4hzstf PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '四号主扇通风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_js1009jf PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '局扇1009进风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_js1010fy PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '局扇1010辅运%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_js624jf PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '局扇624进风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_js625hf PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '局扇625回风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_js627hf PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '局扇627回风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_js627jf PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '局扇627进风%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_js809fy PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '局扇809辅运%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_js814jf PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '局扇814进风%';


--------------------------------------    三号主扇通风   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '三号主扇通风%'
--------------------------------------    四号主扇通风   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '四号主扇通风%'


--------------------------------------    局扇624进风   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '局扇624进风%'
--------------------------------------    局扇627进风   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '局扇627进风%'
--------------------------------------    局扇814进风   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '局扇814进风%'
--------------------------------------    局扇1009进风   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '局扇1009进风%'


--------------------------------------    局扇809辅运   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '局扇809辅运%'
--------------------------------------    局扇1010辅运   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '局扇1010辅运%'


--------------------------------------    局扇625回风   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '局扇625回风%'
--------------------------------------    局扇627回风   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '局扇627回风%'






--------------------------------------   水处理
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_1hzybf PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '一号中央泵房%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_2hzybf PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '二号中央泵房%';


--------------------------------------    一号中央泵房   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '一号中央泵房%'
--------------------------------------    二号中央泵房   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '二号中央泵房%'



SELECT count(1) FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '三号主扇通风%';



---------------------------------------   变电所
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_1hzybds PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '一号中央变电所%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_2hzybds PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '二号中央变电所%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_3hzybds PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '三号中央变电所%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_3hbds PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '三号变电所%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_8pqbds PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '八盘区变电所%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_b1bds PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '北一变电所%';
INSERT OVERWRITE TABLE coalmine_1.dwd_opc_ua_b2bds PARTITION(dt) SELECT * FROM coalmine_1.ods_opc_ua WHERE tag_zh LIKE '北二变电所%';

--------------------------------------    一号中央变电所   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '一号中央变电所%'
--------------------------------------    二号中央变电所   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '二号中央变电所%'
--------------------------------------    三号中央变电所   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '三号中央变电所%'
--------------------------------------    三号变电所   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '三号变电所%'
--------------------------------------    八盘区变电所   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '八盘区变电所%'
--------------------------------------    北一变电所   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '北一变电所%'
--------------------------------------    北二变电所   --------------------
SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '北二变电所%'



























































