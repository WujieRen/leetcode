

select distinct split(identifier, '\\.')[0] from ods_opc_ua where dt='20220103';


SELECT * FROM (SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND system='YFSHFJ') t WHERE 1=0

set hive.load.data.owner=hdfs;

select regexp_replace(reflect("java.util.UUID", "randomUUID"), '-', '') as dap_id,* from coalmine_1.ods_abc

SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND system in ('SHWS', 'SHWSJC', 'SHWSDL')



SELECT count(1) FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '%局扇1010辅运%'


SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '%局扇1009进风%'

SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '局扇1010辅运%'

SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '局扇624进风%'


SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '局扇625回风%'


SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '局扇627回风%'


SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '局扇627进风%'

SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '局扇809辅运%'

SELECT * FROM coalmine_1.ods_opc_ua
WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd')
AND tag_zh LIKE '局扇814进风%'


+-----------------------------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+-----------------------------------------+------------------------+------------------------+------------+------------+----------+----------------+----------------                  -+--------+-----------+
|              dap_id               | level1_en  | level1_zh  | level2_en  | level2_zh  | level3_en  | level3_zh  | level4_en  | level4_zh  | level5_en  | level5_zh  | level6_en  | level6_zh  | level7_en  | level7_zh  | level8_en  | level8_zh  |               identifier                |         tag_en         |         tag_zh         | tag_value  |   system   |  device  | generate_time  |    save_time                      | count  |    dt     |
+-----------------------------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+-----------------------------------------+------------------------+------------------------+------------+------------+----------+----------------+----------------                  -+--------+-----------+
| 60489e817c344943ad30ce1ea14fe94d  | SHZSTF     | 四号主扇通风| 1HFJ     | 1号风机     | 2JDJ       | 2级电机    | SPZD       | 水平振动   | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | SHZSTF.Device1.SHZSTF_1HFJ_2JDJ_SPZD    | SHZSTF_1HFJ_2JDJ_SPZD  | 四号主扇通风.1号风机.2级电机.水平振动  | 2.0023148  | SHZSTF     | Device1  | NULL           | 20220103235834  | 4      | 20220104  |
| 4225a39fa34647189b3c00e3cc474e87  | SHZSTF     | 四号主扇通风| 1HFJ     | 1号风机     | SPFMKD     | 水平风门开 | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | SHZSTF.Device1.SHZSTF_1HFJ_SPFMKD       | SHZSTF_1HFJ_SPFMKD     | 四号主扇通风.1号风机.水平风门开度     | 0          | SHZSTF     | Device1  | NULL            | 20220103235834  | 3      | 20220104  |
| fe6f9a9373cf4d06af1170536da97282  | SHZSTF     | 四号主扇通风| 1HFJ     | 1号风机     | CKFS       | 出口风速   | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | SHZSTF.Device1.SHZSTF_1HFJ_CKFS         | SHZSTF_1HFJ_CKFS       | 四号主扇通风.1号风机.出口风速       | 17.54099   | SHZSTF     | Device1  | NULL              | 20220103235834  | 3      | 20220104  |
| 522754d679bf40fea376c14c2f95502f  | SHZSTF     | 四号主扇通风| 1HFJ     | 1号风机     | TJLL       | 体积流量   | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | SHZSTF.Device1.SHZSTF_1HFJ_TJLL         | SHZSTF_1HFJ_TJLL       | 四号主扇通风.1号风机.体积流量       | 210.4919   | SHZSTF     | Device1  | NULL              | 20220103235834  | 3      | 20220104  |
| 53c2fdafabb54b10970b72031ce09582  | SHZSTF     | 四号主扇通风| 1HFJ     | 1号风机     | BP1        | 变频1      | SCDL       | 输出电流   | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | SHZSTFBP1.Device1.SHZSTF_1HFJ_BP1_SCDL  | SHZSTF_1HFJ_BP1_SCDL   | 四号主扇通风.1号风机.变频1.输出电流   | 481        | SHZSTFBP1  | Device1  | NULL            | 20220103235834  | 4      | 20220104  |
+-----------------------------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+-----------------------------------------+------------------------+------------------------+------------+------------+----------+----------------+-----------------+--------+-----------+

+-----------------------------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+---------------------------------------+-----------------------+-----------------------+-------------+----------+----------+----------------+-----------------+--------+-----------+
|              dap_id               | level1_en  | level1_zh  | level2_en  | level2_zh  | level3_en  | level3_zh  | level4_en  | level4_zh  | level5_en  | level5_zh  | level6_en  | level6_zh  | level7_en  | level7_zh  | level8_en  | level8_zh  |              identifier               |        tag_en         |        tag_zh         |  tag_value  |  system  |  device  | generate_time  |    save_time    | count  |    dt     |
+-----------------------------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+---------------------------------------+-----------------------+-----------------------+-------------+----------+----------+----------------+-----------------+--------+-----------+
| 4d80b44c1702473fac0f62760acc8b7c  | SHZSTF     | 三号主扇通风| YHFJ      | 一号风机   | FL         | 风量         | NULL       | NULL     | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | SHZSTF1.Device1.SHZSTF_YHFJ_FL        | SHZSTF_YHFJ_FL        | 三号主扇通风.一号风机.风量        | 244.91057   | SHZSTF1  | Device1  | NULL           | 20220103235833  | 3      | 20220104  |
| 9c41220e843e49f8b465ff569d0f7824  | SHZSTF     | 三号主扇通风| YHFJ      | 一号风机   | FY         | 负压         | NULL       | NULL     | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | SHZSTF1.Device1.SHZSTF_YHFJ_FY        | SHZSTF_YHFJ_FY        | 三号主扇通风.一号风机.负压        | -3416.6665  | SHZSTF1  | Device1  | NULL           | 20220103235833  | 3      | 20220104  |
| 8da15078fc10434aadbbb282ad5ad731  | SHZSTF     | 三号主扇通风| YHFJ      | 一号风机   | RZWDVWD2   | 绕组温度V温度| NULL       | NULL     | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | SHZSTF1.Device1.SHZSTF_YHFJ_RZWDVWD2  | SHZSTF_YHFJ_RZWDVWD2  | 三号主扇通风.一号风机.绕组温度V温度2  | 51.49       | SHZSTF1  | Device1  | NULL           | 20220103235833  | 3      | 20220104  |
| a423b507c9a54dc39342d62c7327a21e  | SHZSTF     | 三号主扇通风| YHFJ      | 一号风机   | ZZCWD6     | 主轴承温度6  | NULL       | NULL     | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | SHZSTF1.Device1.SHZSTF_YHFJ_ZZCWD6    | SHZSTF_YHFJ_ZZCWD6    | 三号主扇通风.一号风机.主轴承温度6    | 47.91       | SHZSTF1  | Device1  | NULL           | 20220103235833  | 3      | 20220104  |
| 4b08b31cd8c14823875e811c5f3ad748  | SHZSTF     | 三号主扇通风| YHFJ      | 一号风机   | DQYXZDZ    | 当前Y向振动值| NULL       | NULL     | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | NULL       | SHZSTF1.Device1.SHZSTF_YHFJ_DQYXZDZ   | SHZSTF_YHFJ_DQYXZDZ   | 三号主扇通风.一号风机.当前Y向振动值   | 0.775463    | SHZSTF1  | Device1  | NULL           | 20220103235834  | 3      | 20220104  |
+-----------------------------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+------------+---------------------------------------+-----------------------+-----------------------+-------------+----------+----------+----------------+-----------------+--------+-----------+






DROP TABLE IF EXISTS coalmine_1.ods_plc_aqjc_aqcs_rwj;

CREATE TABLE coalmine_1.ods_plc_aqjc_aqcs_rwj (
    dap_id string COMMENT '唯一id',
    cs_data_time string COMMENT '数据生成时间',
    cs_mine_code string COMMENT '煤矿代码',
    ss_system_instime string COMMENT '安全监控系统安装时间',
    ss_system_prodate string COMMENT '安全监控系统生产日期',
    ss_system_maeffec string COMMENT '安全监控系统煤安标志有效期',
    ss_system_name string COMMENT '安全监控系统名称',
    ss_system_maker string COMMENT '安全监控系统制造商',
    ss_system_model string COMMENT '安全监控系统型号',
    ss_system_manum string COMMENT '安全监控系统煤安标志号',
    generation_time string,
    save_time string
)
COMMENT '安全系统初始化文件'
PARTITIONED BY (dt string)
STORED AS ORC
LOCATION 'hdfs://hdp1.utopin.cn:8020/dap/coalmine_1/ods_plc_anquanjiance_aqcs_rwj';

INSERT INTO TABLE coalmine_1.ods_plc_aqjc_aqcs_rwj SELECT * FROM coalmine_1.ods_plc_aqjc_aqcs WHERE dt>='20211118';


DROP TABLE IF EXISTS coalmine_1.ods_plc_aqjc_aqss_rwj_dam;
CREATE TABLE coalmine_1.ods_plc_aqjc_aqss_rwj (
    dap_id char(32) COMMENT '唯一ID',
    cs_data_time string COMMENT '数据生成时间',
    cs_mine_code string COMMENT '煤矿代码',
    ss_switching_value string COMMENT '开关量传感器监测值',
    ss_station_code string COMMENT '安全监控系统分站代码',
    ss_transducer_state string COMMENT '传感器运行状态代码',
    ss_analog_value string COMMENT '模拟量传感器监测值',
    ss_transducer_code string COMMENT '传感器代码',
    generation_time string,
    save_time string
)
COMMENT '30s监测文件'
PARTITIONED BY (dt string)
STORED AS ORC
LOCATION 'hdfs://hdp1.utopin.cn:8020/dap/coalmine_1/ods_plc_aqjc_aqss_rwj';

INSERT INTO TABLE coalmine_1.ods_plc_aqjc_aqss_rwj SELECT * FROM coalmine_1.ods_plc_aqjc_aqss WHERE dt>='20211208';







DROP TABLE IF EXISTS coalmine_1.ods_plc_aqjc_aqss_rwj_dam;
CREATE TABLE coalmine_1.ods_plc_aqjc_aqss_rwj (
    dap_id char(32) COMMENT '唯一ID',
    cs_data_time string COMMENT '数据生成时间',
    cs_mine_code string COMMENT '煤矿代码',
    ss_switching_value string COMMENT '开关量传感器监测值',
    ss_station_code string COMMENT '安全监控系统分站代码',
    ss_transducer_state string COMMENT '传感器运行状态代码',
    ss_analog_value string COMMENT '模拟量传感器监测值',
    ss_transducer_code string COMMENT '传感器代码',
    generation_time string,
    save_time string
)
COMMENT '30s监测文件'
PARTITIONED BY (dt string)
STORED AS ORC
LOCATION 'hdfs://hdp1.utopin.cn:8020/dap/coalmine_1/ods_plc_aqjc_aqss_rwj';





ods_plc_aqjc_aqss   coalmine_1.ods_plc_aqjc_aqss_dam
ods_plc_aqjc_aqkc   coalmine_1.ods_plc_aqjc_aqkc_dam
ods_plc_aqjc_aqmc   coalmine_1.ods_plc_aqjc_aqmc_dam
ods_plc_aqjc_aqfz   coalmine_1.ods_plc_aqjc_aqfz_dam



DROP TABLE IF EXISTS coalmine_1.ods_plc_aqjc_aqss_dam;
CREATE TABLE coalmine_1.ods_plc_aqjc_aqss_dam(
    dap_id string COMMENT '唯一ID',
    cs_data_time string COMMENT '数据生成时间',
    cs_mine_code string COMMENT '煤矿代码',
    ss_switching_value string COMMENT '开关量传感器监测值',
    ss_station_code string COMMENT '安全监控系统分站代码',
    ss_transducer_state string COMMENT '传感器运行状态代码',
    ss_analog_value string COMMENT '模拟量传感器监测值',
    ss_transducer_code string COMMENT '传感器代码',
    generation_time string,
    save_time string
)
COMMENT '30s监测文件'
PARTITIONED BY (dt string)
STORED AS ORC
LOCATION 'hdfs://hdp1.utopin.cn:8020/dap/coalmine_1/ods_plc_aqjc_aqss_dam';
INSERT INTO TABLE coalmine_1.ods_plc_aqjc_aqss_dam SELECT * FROM coalmine_1.ods_plc_aqjc_aqss;

DROP TABLE IF EXISTS coalmine_1.ods_plc_aqjc_aqkc_dam;
CREATE TABLE coalmine_1.ods_plc_aqjc_aqkc_dam(
    dap_id string COMMENT '唯一ID',
    cs_data_time string COMMENT '数据生成时间',
    cs_mine_code string COMMENT '煤矿代码',
    ss_transducer_name string COMMENT '传感器参量名称',
    ss_station_code string COMMENT '安全监控系统分站代码',
    ss_transducer_point string COMMENT '传感器监测地点',
    ss_transducer_code string COMMENT '传感器代码',
    ss_poffarea_code string COMMENT '断电区域代码',
    ss_gisnode_code string COMMENT '安全监控系统空间节点代码',
    ss_transducer_type string COMMENT '传感器参量代码',
    generation_time string COMMENT '',
    save_time string COMMENT ''
)
COMMENT '开关量传感器文件'
PARTITIONED BY (dt string)
STORED AS ORC
LOCATION 'hdfs://hdp1.utopin.cn:8020/dap/coalmine_1/ods_plc_aqjc_aqkc_dam';
INSERT INTO TABLE coalmine_1.ods_plc_aqjc_aqkc_dam SELECT * FROM coalmine_1.ods_plc_aqjc_aqkc;


CREATE TABLE coalmine_1.ods_plc_aqjc_aqmc_dam(
    dap_id string COMMENT '唯一ID',
    cs_data_time string COMMENT '数据生成时间',
    cs_mine_code string COMMENT '煤矿代码',
    ss_analog_pofflow string COMMENT '模拟量断电下限',
    ss_analog_unit string COMMENT '计量单位',
    ss_transducer_name string COMMENT '传感器参量名称',
    ss_analog_alarmhigh string COMMENT '模拟量报警上限',
    ss_transducer_point string COMMENT '传感器监测地点',
    ss_transducer_code string COMMENT '传感器代码',
    ss_gisnode_code string COMMENT '安全监控系统空间节点代码',
    ss_analog_lower string COMMENT '模拟量量程下限',
    ss_analog_ponlow string COMMENT '模拟量复电下限',
    ss_station_code string COMMENT '安全监控系统分站代码',
    ss_analog_ponhigh string COMMENT '模拟量复电上限',
    ss_poffarea_code string COMMENT '断电区域代码',
    ss_transducer_type string COMMENT '传感器参量代码',
    ss_analog_high string COMMENT '模拟量量程上限',
    ss_analog_alarmlow string COMMENT '模拟量报警下限',
    ss_analog_poffhigh string COMMENT '模拟量断电上限',
    generation_time string,
    save_time string
)
COMMENT '模拟量传感器文件'
PARTITIONED BY (dt string)
STORED AS ORC
LOCATION 'hdfs://hdp1.utopin.cn:8020/dap/coalmine_1/ods_plc_aqjc_aqmc_dam';
INSERT INTO TABLE coalmine_1.ods_plc_aqjc_aqmc_dam SELECT * FROM coalmine_1.ods_plc_aqjc_aqmc;


CREATE TABLE coalmine_1.ods_plc_aqjc_aqfz_dam(
    dap_id string COMMENT '唯一ID',
    cs_data_time string COMMENT '数据生成时间',
    cs_mine_code string COMMENT '煤矿代码',
    ss_station_code string COMMENT '安全监控系统分站代码',
    ss_gisnode_code string COMMENT '安全监控系统空间节点代码',
    ss_station_name string COMMENT '安全监控系统分站名称',
    ss_station_location string COMMENT '安全监控系统分站安装地点',
    generation_time string,
    save_time string
)
COMMENT '安全监控系统分站文件'
PARTITIONED BY (dt string)
STORED AS ORC
LOCATION 'hdfs://hdp1.utopin.cn:8020/dap/coalmine_1/ods_plc_aqjc_aqfz_dam';
INSERT INTO TABLE coalmine_1.ods_plc_aqjc_aqfz_dam SELECT * FROM coalmine_1.ods_plc_aqjc_aqfz;
	  


+-----------------------------------+-------------------------------------+-------------------------------------+----------------------------------------+----------------------------------------+----------------------------------------+--------------------------------------------+----------------------------------------+----------------------------------+---------------------------+
|   ods_plc_aqjc_aqfz_dam.dap_id    | ods_plc_aqjc_aqfz_dam.cs_data_time  | ods_plc_aqjc_aqfz_dam.cs_mine_code  | ods_plc_aqjc_aqfz_dam.ss_station_code  | ods_plc_aqjc_aqfz_dam.ss_gisnode_code  | ods_plc_aqjc_aqfz_dam.ss_station_name  | ods_plc_aqjc_aqfz_dam.ss_station_location  | ods_plc_aqjc_aqfz_dam.generation_time  | ods_plc_aqjc_aqfz_dam.save_time  | ods_plc_aqjc_aqfz_dam.dt  |
+-----------------------------------+-------------------------------------+-------------------------------------+----------------------------------------+----------------------------------------+----------------------------------------+--------------------------------------------+----------------------------------------+----------------------------------+---------------------------+
| 76f56dd9b8ac45bc9c1ed202e586460b  | 2021-11-21 00:14:43                 | 610631015                           | 000001                                 | 1                                      | 1#分站                                   | 一部机尾                                       | 20211121001443                         | 20211211102254                   | 20211121                  |
| 3461c6e63c254609a5d6bf23256307ce  | 2021-11-21 00:14:43                 | 610631015                           | 000002                                 | 1                                      | 2#分站                                   | 3#变电所                                      | 20211121001443                         | 20211211102254                   | 20211121                  |
| d91cecc621a940e38962b27272c023bb  | 2021-11-21 00:14:43                 | 610631015                           | 000003                                 | 1                                      | 3#分站                                   | 501运顺巷本煤层管道抽放                              | 20211121001443                         | 20211211102254                   | 20211121                  |
| 259c02fb18f64756a6474bd7827bc63f  | 2021-11-21 00:14:43                 | 610631015                           | 000004                                 | 1                                      | 4#分站                                   | 1010辅运巷本煤层抽放                               | 20211121001443                         | 20211211102254                   | 20211121                  |
| 212a051eae7e467d9795fef0ede85140  | 2021-11-21 00:14:43                 | 610631015                           | 000005                                 | 1                                      | 5#分站                                   | 1008抽放，1007回风抽放                            | 20211121001443                         | 20211211102254                   | 20211121                  |
| 9659c33fece440bdbd6941a2a921edd4  | 2021-11-21 00:14:43                 | 610631015                           | 000006                                 | 1                                      | 6#分站                                   | 1009抽放，1008回风                              | 20211121001443                         | 20211211102254                   | 20211121                  |
| b1a9296a3316478998170428c0e1731f  | 2021-11-21 00:14:43                 | 610631015                           | 000007                                 | 1                                      | 7#分站                                   | 1#中央变 ·（209风门）                             | 20211121001443                         | 20211211102254                   | 20211121                  |
| 39e5bb1f9b59492e8560f3bde76ab61c  | 2021-11-21 00:14:43                 | 610631015                           | 000008                                 | 1                                      | 8#分站                                   | 北一临时变                                      | 20211121001443                         | 20211211102254                   | 20211121                  |
| eb0ffd209727428d88954e2b78a0086f  | 2021-11-21 00:14:43                 | 610631015                           | 000009                                 | 1                                      | 9#分站                                   | 501运顺掘进                                    | 20211121001443                         | 20211211102254                   | 20211121                  |
| a747339ab64c4ef19b9ae12c9a6c5478  | 2021-11-21 00:14:43                 | 610631015                           | 000010                                 | 1                                      | 10#分站                                  | 1009辅运抽放                                   | 20211121001443                         | 20211211102254                   | 20211121                  |
+-----------------------------------+-------------------------------------+-------------------------------------+----------------------------------------+----------------------------------------+----------------------------------------+--------------------------------------------+----------------------------------------+----------------------------------+---------------------------+




SELECT * FROM coalmine_1.ods_plc_aqjc_aqss_dam limit 11;

+-----------------------------------+-------------------------------------+-------------------------------------+-------------------------------------------+----------------------------------------+--------------------------------------------+----------------------------------------+-------------------------------------------+----------------------------------------+----------------------------------+---------------------------+
|   ods_plc_aqjc_aqss_dam.dap_id    | ods_plc_aqjc_aqss_dam.cs_data_time  | ods_plc_aqjc_aqss_dam.cs_mine_code  | ods_plc_aqjc_aqss_dam.ss_switching_value  | ods_plc_aqjc_aqss_dam.ss_station_code  | ods_plc_aqjc_aqss_dam.ss_transducer_state  | ods_plc_aqjc_aqss_dam.ss_analog_value  | ods_plc_aqjc_aqss_dam.ss_transducer_code  | ods_plc_aqjc_aqss_dam.generation_time  | ods_plc_aqjc_aqss_dam.save_time  | ods_plc_aqjc_aqss_dam.dt  |
+-----------------------------------+-------------------------------------+-------------------------------------+-------------------------------------------+----------------------------------------+--------------------------------------------+----------------------------------------+-------------------------------------------+----------------------------------------+----------------------------------+---------------------------+
| 88cad504dafd4b11990f9f682411c25a  | 2021-11-21 00:00:28                 | 610631015                           | NULL                                      | 000006                                 | 0                                          | 26.20                                  | 001046                                    | 20211121000028                         | 20211210150018                   | 20211121                  |
| 69ae6b2e827342aea470e1e2d66ac5e7  | 2021-11-21 00:00:28                 | 610631015                           | NULL                                      | 000006                                 | 0                                          | 24.80                                  | 001047                                    | 20211121000028                         | 20211210150018                   | 20211121                  |
| 99178b2a3b584c46990f8c88ed19eef1  | 2021-11-21 00:00:28                 | 610631015                           | NULL                                      | 000006                                 | 0                                          | 35.50                                  | 001048                                    | 20211121000028                         | 20211210150018                   | 20211121                  |
| d08e2aad9aed4cfd8a68afb24fb02773  | 2021-11-21 00:00:28                 | 610631015                           | NULL                                      | 000006                                 | 0                                          | 14.40                                  | 001049                                    | 20211121000028                         | 20211210150018                   | 20211121                  |
| e66b1cab7d7d4f689f3097edc5674e57  | 2021-11-21 00:00:28                 | 610631015                           | NULL                                      | 000006                                 | 0                                          | 2.05                                   | 001052                                    | 20211121000028                         | 20211210150018                   | 20211121                  |
| 98c41177126e4a90895c397333e7cd3f  | 2021-11-21 00:00:28                 | 610631015                           | NULL                                      | 000006                                 | 0                                          | 0.00                                   | 001053                                    | 20211121000028                         | 20211210150018                   | 20211121                  |
| d557bd784e52400cbefa7b5ffc658619  | 2021-11-21 00:00:28                 | 610631015                           | NULL                                      | 000006                                 | 0                                          | 94.80                                  | 002900                                    | 20211121000028                         | 20211210150018                   | 20211121                  |
| 983cc0691f4d478990f71fc36ac4c73c  | 2021-11-21 00:00:28                 | 610631015                           | NULL                                      | 000006                                 | 0                                          | 24.40                                  | 002901                                    | 20211121000028                         | 20211210150018                   | 20211121                  |
| e72703db876f45bea8890df178883c92  | 2021-11-21 00:00:28                 | 610631015                           | NULL                                      | 000006                                 | 0                                          | 4.30                                   | 002902                                    | 20211121000028                         | 20211210150018                   | 20211121                  |
| 5ee13948c3734ad39e844f74b93fb03c  | 2021-11-21 00:00:28                 | 610631015                           | NULL                                      | 000006                                 | 0                                          | 76.50                                  | 002903                                    | 20211121000028                         | 20211210150018                   | 20211121                  |
| eaa45dc61b8d44d5b297dae72a1b0032  | 2021-11-21 00:00:28                 | 610631015                           | NULL                                      | 000006                                 | 0                                          | 0.65                                   | 002906                                    | 20211121000028                         | 20211210150018                   | 20211121                  |
+-----------------------------------+-------------------------------------+-------------------------------------+-------------------------------------------+----------------------------------------+--------------------------------------------+----------------------------------------+-------------------------------------------+----------------------------------------+----------------------------------+---------------------------+
select * from (
SELECT cs_mine_code, c1 FROM (
  SELECT DISTINCT  cs_mine_code, ss_transducer_code c1 FROM coalmine_1.ods_plc_aqjc_aqss_dam --where ss_transducer_code='009106' AND nvl(ss_switching_value, '')!=''
) aqss
LEFT JOIN  (
  SELECT DISTINCT  ss_transducer_code c2 FROM coalmine_1.ods_plc_aqjc_aqmc_dam
) aqmc
ON aqss.c1 = aqmc.c2
) a limit 50;
WHERE c2 == ''



select * from coalmine_1.ods_plc_aqjc_aqmc_dam limit 11;
+-----------------------------------+-------------------------------------+-------------------------------------+------------------------------------------+---------------------------------------+-------------------------------------------+--------------------------------------------+--------------------------------------------+-------------------------------------------+----------------------------------------+----------------------------------------+-----------------------------------------+----------------------------------------+------------------------------------------+-----------------------------------------+-------------------------------------------+---------------------------------------+-------------------------------------------+-------------------------------------------+----------------------------------------+----------------------------------+---------------------------+
|   ods_plc_aqjc_aqmc_dam.dap_id    | ods_plc_aqjc_aqmc_dam.cs_data_time  | ods_plc_aqjc_aqmc_dam.cs_mine_code  | ods_plc_aqjc_aqmc_dam.ss_analog_pofflow  | ods_plc_aqjc_aqmc_dam.ss_analog_unit  | ods_plc_aqjc_aqmc_dam.ss_transducer_name  | ods_plc_aqjc_aqmc_dam.ss_analog_alarmhigh  | ods_plc_aqjc_aqmc_dam.ss_transducer_point  | ods_plc_aqjc_aqmc_dam.ss_transducer_code  | ods_plc_aqjc_aqmc_dam.ss_gisnode_code  | ods_plc_aqjc_aqmc_dam.ss_analog_lower  | ods_plc_aqjc_aqmc_dam.ss_analog_ponlow  | ods_plc_aqjc_aqmc_dam.ss_station_code  | ods_plc_aqjc_aqmc_dam.ss_analog_ponhigh  | ods_plc_aqjc_aqmc_dam.ss_poffarea_code  | ods_plc_aqjc_aqmc_dam.ss_transducer_type  | ods_plc_aqjc_aqmc_dam.ss_analog_high  | ods_plc_aqjc_aqmc_dam.ss_analog_alarmlow  | ods_plc_aqjc_aqmc_dam.ss_analog_poffhigh  | ods_plc_aqjc_aqmc_dam.generation_time  | ods_plc_aqjc_aqmc_dam.save_time  | ods_plc_aqjc_aqmc_dam.dt  |
+-----------------------------------+-------------------------------------+-------------------------------------+------------------------------------------+---------------------------------------+-------------------------------------------+--------------------------------------------+--------------------------------------------+-------------------------------------------+----------------------------------------+----------------------------------------+-----------------------------------------+----------------------------------------+------------------------------------------+-----------------------------------------+-------------------------------------------+---------------------------------------+-------------------------------------------+-------------------------------------------+----------------------------------------+----------------------------------+---------------------------+
| 36e41722ab2d49f69c153ab4f7559fd0  | 2021-09-03 10:01:23                 | 610631015                           | -0.01                                    | ppm                                   | 一氧化碳                                      | 24.00                                      | 一部机尾一氧化碳                                   | 005827                                    | 1                                      | 0.00                                   | -0.01                                   | 000001                                 | -0.01                                    | 0                                       | M0104                                     | 1000.00                               | -0.01                                     | -0.01                                     | 20210903100123                         | 20211211102204                   | 20210903                  |
| 3486f1b377444cbdad8ec5d5c25fc6b4  | 2021-09-03 10:01:23                 | 610631015                           | -0.01                                    | ppm                                   | 一氧化碳                                      | 24.00                                      | 2#上山机头一氧化碳                                 | 005829                                    | 1                                      | 0.00                                   | -0.01                                   | 000001                                 | -0.01                                    | 0                                       | M0104                                     | 1000.00                               | -0.01                                     | -0.01                                     | 20210903100123                         | 20211211102204                   | 20210903                  |
| eae695820dc04d4fbe2ee1f08e5e4451  | 2021-09-03 10:01:23                 | 610631015                           | 1.50                                     | %CH4                                  | 甲烷                                        | 1.50                                       | 2#煤仓上方激光甲烷                                 | 005828                                    | 1                                      | 0.00                                   | 1.49                                    | 000001                                 | 1.49                                     | 0002                                    | M0101                                     | 100.00                                | -0.01                                     | 1.50                                      | 20210903100123                         | 20211211102204                   | 20210903                  |
| edbcf6243e944f43b4e60854ae943adf  | 2021-09-03 10:01:23                 | 610631015                           | 1.00                                     | %CH4                                  | 甲烷                                        | 0.75                                       | 二盘区回风204水仓激光甲烷                             | 001734                                    | 1                                      | 0.00                                   | 0.90                                    | 000002                                 | 0.90                                     | 0001                                    | M0101                                     | 100.00                                | -0.01                                     | 1.00                                      | 20210903100123                         | 20211211102204                   | 20210903                  |
| 89513ce955b1480ab314d7bf5805a45b  | 2021-09-03 10:01:23                 | 610631015                           | -0.01                                    | %CH4                                  | 甲烷                                        | 0.50                                       | 3#变电所激光甲烷                                  | 001059                                    | 1                                      | 0.00                                   | -0.01                                   | 000002                                 | -0.01                                    | 0                                       | M0101                                     | 100.00                                | -0.01                                     | -0.01                                     | 20210903100123                         | 20211211102204                   | 20210903                  |
| 9cfc0a17011a4fa090fd6ac485b1659a  | 2021-09-03 10:01:23                 | 610631015                           | -0.01                                    | ℃                                     | 温度                                        | 34.00                                      | 3#变电所温度                                    | 001058                                    | 1                                      | -5.00                                  | -0.01                                   | 000002                                 | -0.01                                    | 0                                       | M0201                                     | 45.00                                 | -0.01                                     | -0.01                                     | 20210903100123                         | 20211211102204                   | 20210903                  |
| 13961c41a3e940a0a6d83e317c05be79  | 2021-09-03 10:01:23                 | 610631015                           | -0.01                                    | ppm                                   | 一氧化碳                                      | 24.00                                      | 二部皮带中部驱动一氧化碳                               | 001031                                    | 1                                      | 0.00                                   | -0.01                                   | 000002                                 | -0.01                                    | 0                                       | M0104                                     | 1000.00                               | -0.01                                     | -0.01                                     | 20210903100123                         | 20211211102204                   | 20210903                  |
| b0c55192a71948858b5e7d7ec2fa9eaa  | 2021-09-03 10:01:23                 | 610631015                           | -0.01                                    | m3/min                                | 其它（模拟量）                                   | -0.01                                      | 501运顺本煤层管道抽放GD3(B)工混流量                     | 000804                                    | 1                                      | 0.00                                   | -0.01                                   | 000003                                 | -0.01                                    | 0                                       | M9999                                     | 1500.00                               | -0.01                                     | -0.01                                     | 20210903100123                         | 20211211102204                   | 20210903                  |
| d451a0e53bb144318e72457046dab633  | 2021-09-03 10:01:23                 | 610631015                           | -0.01                                    | ℃                                     | 温度                                        | -0.01                                      | 501运顺本煤层管道抽放GD3(B)温度                       | 000805                                    | 1                                      | 0.00                                   | -0.01                                   | 000003                                 | -0.01                                    | 0                                       | M0201                                     | 100.00                                | -0.01                                     | -0.01                                     | 20210903100123                         | 20211211102204                   | 20210903                  |
| 47c48768ab7849b5af59a5a5f9d7a1b0  | 2021-09-03 10:01:23                 | 610631015                           | -0.01                                    | Kpa                                   | 其它（模拟量）                                   | -0.01                                      | 501运顺本煤层管道抽放GD3(B)负压                       | 000806                                    | 1                                      | 0.00                                   | -0.01                                   | 000003                                 | -0.01                                    | 0                                       | M9999                                     | 100.00                                | -0.01                                     | -0.01                                     | 20210903100123                         | 20211211102204                   | 20210903                  |
| 4f8bb339e38548c39a09352f1d85327e  | 2021-09-03 10:01:23                 | 610631015                           | -0.01                                    | m3/min                                | 其它（模拟量）                                   | -0.01                                      | 501运顺本煤层管道抽放GD3(B)标况流量                     | 000807                                    | 1                                      | 0.00                                   | -0.01                                   | 000003                                 | -0.01                                    | 0                                       | M9999                                     | 1500.00                               | -0.01                                     | -0.01                                     | 20210903100123                         | 20211211102204                   | 20210903                  |
+-----------------------------------+-------------------------------------+-------------------------------------+------------------------------------------+---------------------------------------+-------------------------------------------+--------------------------------------------+--------------------------------------------+-------------------------------------------+----------------------------------------+----------------------------------------+-----------------------------------------+----------------------------------------+------------------------------------------+-----------------------------------------+-------------------------------------------+---------------------------------------+-------------------------------------------+-------------------------------------------+----------------------------------------+----------------------------------+---------------------------+

select * from coalmine_1.ods_plc_aqjc_aqmc where dt in
(
  select max(dt) from coalmine_1.ods_plc_aqjc_aqmc
) limit 5;


--开关维度表
ss_transducer_code	传感器代码
cs_mine_code	煤矿代码
ss_transducer_name	传感器参量名称
ss_station_code	安全监控系统分站代码
ss_gisnode_code	安全监控系统空间节点代码
ss_transducer_type	传感器参量代码


select count(distinct cs_mine_code,ss_station_code,ss_transducer_code) from coalmine_1.ods_plc_aqjc_aqkc; -- 504
select count(distinct cs_mine_code,ss_station_code,ss_transducer_code) from coalmine_1.ods_plc_aqjc_aqgx; -- 252
select count(distinct cs_mine_code,ss_station_code,ss_transducer_code) from coalmine_1.ods_plc_aqjc_aqss; -- 1005
select count(distinct cs_mine_code,ss_station_code,ss_transducer_code) from coalmine_1.ods_plc_aqjc_aqkd; -- 392
select count(distinct cs_mine_code,ss_station_code,ss_transducer_code) from coalmine_1.ods_plc_aqjc_aqbj; -- 0
select count(distinct cs_mine_code,ss_station_code,ss_transducer_code) from coalmine_1.ods_plc_aqjc_aqmt; --

select count(distinct *) from (
SELECT DISTINCT cs_mine_code,ss_station_code,ss_transducer_code FROM coalmine_1.ods_plc_aqjc_aqkc
UNION ALL
SELECT DISTINCT cs_mine_code,ss_station_code,ss_transducer_code FROM coalmine_1.ods_plc_aqjc_aqgx
UNION ALL
SELECT DISTINCT cs_mine_code,ss_station_code,ss_transducer_code FROM coalmine_1.ods_plc_aqjc_aqss
UNION ALL
SELECT DISTINCT cs_mine_code,ss_station_code,ss_transducer_code FROM coalmine_1.ods_plc_aqjc_aqkd
UNION ALL
SELECT DISTINCT cs_mine_code,ss_station_code,ss_transducer_code FROM coalmine_1.ods_plc_aqjc_aqbj
UNION ALL
SELECT DISTINCT cs_mine_code,ss_station_code,ss_transducer_code FROM coalmine_1.ods_plc_aqjc_aqmt
) res;

--1361
--




application_1638946418145_0100	hdfs  dap-plc_aqjc_AQKJ_暂无数据不启动	Apache Flink	default	0	Wed Dec 15 17:39:55 +0800 2021	N/A	RUNNING	UNDEFINED	2	2	4096	0	0	3.0	3.0
application_1638946418145_0097	hdfs	dap-mqtt_hlkylr_624	  Apache Flink	default	0	Wed Dec 15 15:57:27 +0800 2021	N/A	RUNNING	UNDEFINED	2	2	4096	0	0	3.0	3.0
application_1638946418145_0076	hdfs	dap-plc_aqjc_AQMT	    Apache Flink	default	0	Sat Dec 11 11:37:33 +0800 2021	N/A	RUNNING	UNDEFINED	2	2	4096	0	0	3.0	3.0
application_1638946418145_0075	hdfs	dap-plc_aqjc_MKSX	    Apache Flink	default	0	Sat Dec 11 11:37:04 +0800 2021	N/A	RUNNING	UNDEFINED	2	2	4096	0	0	3.0	3.0
application_1638946418145_0074	hdfs	dap-plc_aqjc_AQDQ	    Apache Flink	default	0	Sat Dec 11 11:36:31 +0800 2021	N/A	RUNNING	UNDEFINED	2	2	4096	0	0	3.0	3.0
application_1638946418145_0071	hdfs	dap-plc_aqjc_AQFZ	    Apache Flink	default	0	Sat Dec 11 10:21:45 +0800 2021	N/A	RUNNING	UNDEFINED	2	2	4096	0	0	3.0	3.0
application_1638946418145_0070	hdfs	dap-plc_aqjc_AQMC	    Apache Flink	default	0	Sat Dec 11 10:20:59 +0800 2021	N/A	RUNNING	UNDEFINED	2	2	4096	0	0	3.0	3.0
application_1638946418145_0069	hdfs	dap-plc_aqjc_AQKC	    Apache Flink	default	0	Sat Dec 11 10:20:33 +0800 2021	N/A	RUNNING	UNDEFINED	2	2	4096	0	0	3.0	3.0
application_1638946418145_0058	hdfs	dap-plc_aqjc_AQCS	    Apache Flink	default	0	Fri Dec 10 15:51:26 +0800 2021	N/A	RUNNING	UNDEFINED	2	2	4096	0	0	3.0	3.0
application_1638946418145_0057	hdfs	dap-plc_aqjc_AQLJ	    Apache Flink	default	0	Fri Dec 10 15:50:13 +0800 2021	N/A	RUNNING	UNDEFINED	2	2	4096	0	0	3.0	3.0
application_1638946418145_0056	hdfs	dap-plc_aqjc_AQGX	    Apache Flink	default	0	Fri Dec 10 15:49:19 +0800 2021	N/A	RUNNING	UNDEFINED	2	2	4096	0	0	3.0	3.0
application_1638946418145_0054	hdfs	dap-plc_aqjc_AQSS	    Apache Flink	default	0	Fri Dec 10 14:51:13 +0800 2021	N/A	RUNNING	UNDEFINED	2	2	4096	0	0	3.0	3.0
application_1638946418145_0048	hdfs	dap-plc_aqjc_AQKD	    Apache



SELECT count(1) FROM coalmine_1.ods_opc_ua WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd');--48157
SELECT count(1) FROM coalmine_1.ods_opc_ua WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd') AND system in ('BDSBY','BDSBE','BDSYHZY','BDSEHZY','BDSSHZY','BDSSH','BDSBPQ');

select count(1) from dwd_opc_ua_b1bds WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd');  -- 8403
select count(1) from dwd_opc_ua_b2bds WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd');  -- 8765
select count(1) from dwd_opc_ua_1hzybds WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd');  -- 3062
select count(1) from dwd_opc_ua_2hzybds WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd');  -- 12501
select count(1) from dwd_opc_ua_3hzybds WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd');  -- 4987
select count(1) from dwd_opc_ua_3hbds WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd');  -- 123
select count(1) from dwd_opc_ua_8pqbds WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd'); -- 10316

show partitions dwd_opc_ua_b1bds;  -- 1000
show partitions dwd_opc_ua_b2bds;  -- 1073
show partitions dwd_opc_ua_1hzybds;  -- 467
show partitions dwd_opc_ua_2hzybds;  -- 1628
show partitions dwd_opc_ua_3hzybds;  -- 860
show partitions dwd_opc_ua_3hbds;  -- 17
show partitions dwd_opc_ua_8pqbds; -- 1259

truncate table dwd_opc_ua_b1bds;  -- 1000
truncate table dwd_opc_ua_b2bds;  -- 1073
truncate table dwd_opc_ua_1hzybds;  -- 467
truncate table dwd_opc_ua_2hzybds;  -- 1628
truncate table dwd_opc_ua_3hzybds;  -- 860
truncate table dwd_opc_ua_3hbds;  -- 17
truncate table dwd_opc_ua_8pqbds; -- 1259


msck repair table coalmine_1.dwd_aqjc_analog_property    ;
msck repair table coalmine_1.dwd_aqjc_switching_property ;
msck repair table coalmine_1.dwd_opc_ua_101pd            ;
msck repair table coalmine_1.dwd_opc_ua_1bpd             ;
msck repair table coalmine_1.dwd_opc_ua_1hzybds          ;
msck repair table coalmine_1.dwd_opc_ua_1hzybf           ;
msck repair table coalmine_1.dwd_opc_ua_2hzybds          ;
msck repair table coalmine_1.dwd_opc_ua_2hzybf           ;
msck repair table coalmine_1.dwd_opc_ua_2sspd            ;
msck repair table coalmine_1.dwd_opc_ua_3hbds            ;
msck repair table coalmine_1.dwd_opc_ua_3hwscf           ;
msck repair table coalmine_1.dwd_opc_ua_3hzstf           ;
msck repair table coalmine_1.dwd_opc_ua_3hzybds          ;
msck repair table coalmine_1.dwd_opc_ua_4hfjyf           ;
msck repair table coalmine_1.dwd_opc_ua_4hwscf           ;
msck repair table coalmine_1.dwd_opc_ua_4hzstf           ;
msck repair table coalmine_1.dwd_opc_ua_8pqbds           ;
msck repair table coalmine_1.dwd_opc_ua_8pqpd            ;
msck repair table coalmine_1.dwd_opc_ua_b12bpd           ;
msck repair table coalmine_1.dwd_opc_ua_b1bds            ;
msck repair table coalmine_1.dwd_opc_ua_b2bds            ;
msck repair table coalmine_1.dwd_opc_ua_b2pd             ;
msck repair table coalmine_1.dwd_opc_ua_gzm807           ;
msck repair table coalmine_1.dwd_opc_ua_js1009jf         ;
msck repair table coalmine_1.dwd_opc_ua_js1010fy         ;
msck repair table coalmine_1.dwd_opc_ua_js624jf          ;
msck repair table coalmine_1.dwd_opc_ua_js625hf          ;
msck repair table coalmine_1.dwd_opc_ua_js627hf          ;
msck repair table coalmine_1.dwd_opc_ua_js627jf          ;
msck repair table coalmine_1.dwd_opc_ua_js809fy          ;
msck repair table coalmine_1.dwd_opc_ua_js814jf          ;
msck repair table coalmine_1.dwd_opc_ua_x11bpd           ;
msck repair table coalmine_1.dwd_opc_ua_x12bpd           ;
msck repair table coalmine_1.dwd_plc_aqjc_aqss_analog    ;
msck repair table coalmine_1.dwd_plc_aqjc_aqss_switch    ;
msck repair table coalmine_1.ods_kyjc_basicinfo          ;
msck repair table coalmine_1.ods_kyjc_realtimedata       ;
msck repair table coalmine_1.ods_mqtt_hlkylr_624         ;
msck repair table coalmine_1.ods_opc_ua                  ;
msck repair table coalmine_1.ods_plc_aqjc_aqbj           ;
msck repair table coalmine_1.ods_plc_aqjc_aqcs           ;
msck repair table coalmine_1.ods_plc_aqjc_aqdq           ;
msck repair table coalmine_1.ods_plc_aqjc_aqfz           ;
msck repair table coalmine_1.ods_plc_aqjc_aqfz_dam       ;
msck repair table coalmine_1.ods_plc_aqjc_aqgx           ;
msck repair table coalmine_1.ods_plc_aqjc_aqkc           ;
msck repair table coalmine_1.ods_plc_aqjc_aqkc_dam       ;
msck repair table coalmine_1.ods_plc_aqjc_aqkd           ;
msck repair table coalmine_1.ods_plc_aqjc_aqlj           ;
msck repair table coalmine_1.ods_plc_aqjc_aqmc           ;
msck repair table coalmine_1.ods_plc_aqjc_aqmc_dam       ;
msck repair table coalmine_1.ods_plc_aqjc_aqmt           ;
msck repair table coalmine_1.ods_plc_aqjc_aqss           ;
msck repair table coalmine_1.ods_plc_aqjc_aqss_dam       ;
msck repair table coalmine_1.ods_plc_aqjc_mksx           ;
msck repair table coalmine_1.ods_plc_ky_dev              ;
msck repair table coalmine_1.ods_plc_ky_rtdata           ;
msck repair table coalmine_1.ods_plc_sw_dev              ;
msck repair table coalmine_1.ods_plc_sw_rtdata           ;
msck repair table coalmine_1.ods_rydw_basicinfo          ;
msck repair table coalmine_1.ods_rydw_realtimedata       ;
msck repair table coalmine_1.ods_sgjc_realtimedata       ;
msck repair table coalmine_1.ods_swjc_basicinfo          ;
msck repair table coalmine_1.ods_swjc_realtimedata;




-- ------------------------------  皮带 ---------------------------------------
show partitions coalmine_1.dwd_opc_ua_101pd;
-- show partitions coalmine_1.dwd_opc_ua_1bpd;
show partitions coalmine_1.dwd_opc_ua_2sspd;
show partitions coalmine_1.dwd_opc_ua_8pqpd;
show partitions coalmine_1.dwd_opc_ua_b11bpd;
show partitions coalmine_1.dwd_opc_ua_b12bpd;
show partitions coalmine_1.dwd_opc_ua_b2pd;
show partitions coalmine_1.dwd_opc_ua_x11bpd;
show partitions coalmine_1.dwd_opc_ua_x12bpd;


SELECT COUNT(1) FROM coalmine_1.ods_opc_ua WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd'); -- 20870

SELECT COUNT(1) FROM coalmine_1.dwd_opc_ua_101pd WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd'); -- 4232
-- SELECT COUNT(1) FROM coalmine_1.dwd_opc_ua_1bpd WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd');
SELECT COUNT(1) FROM coalmine_1.dwd_opc_ua_2sspd WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd'); -- 700
SELECT COUNT(1) FROM coalmine_1.dwd_opc_ua_8pqpd WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd'); -- 7026
SELECT COUNT(1) FROM coalmine_1.dwd_opc_ua_b11bpd WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd'); -- 656
SELECT COUNT(1) FROM coalmine_1.dwd_opc_ua_b12bpd WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd'); -- 5803
SELECT COUNT(1) FROM coalmine_1.dwd_opc_ua_b2pd WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd'); -- 1233
SELECT COUNT(1) FROM coalmine_1.dwd_opc_ua_x11bpd WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd'); -- 520
SELECT COUNT(1) FROM coalmine_1.dwd_opc_ua_x12bpd WHERE dt=date_format(date_sub(current_date, 1), 'yyyyMMdd'); -- 700




