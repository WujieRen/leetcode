DROP TABLE IF EXISTS `coalmine_2`.`ods_opc_ua`;
CREATE EXTERNAL TABLE `coalmine_2`.`ods_opc_ua`(
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
LOCATION 'hdfs://hdp1.utopin.cn:8020/dap/coalmine_2/ods_opc_ua'