
#################################################
################   logstash  ####################
#################################################
nohup bin/logstash -f config/custom/ >/dev/null 2>&1 &


#################################################
##################   hive  ######################
#################################################
beeline -u jdbc:hive2://hdp2.utopin.cn:10000 -n hdfs
set hive.load.data.owner=hdfs


#################################################
#################   spark  ######################
#################################################
/usr/utopin/3.0.0.0-1245/spark-3.0.0/bin/beeline -u jdbc:hive2://hdp3.utopin.cn:10016 -n hdfs


#################################################
#################   kafka  ######################
#################################################
./kafka-console-consumer.sh --bootstrap-server 192.168.168.11:6667 --from-beginning --topic test_opc_ua

./kafka-topics.sh --create --partitions 1 --replication-factor 1 --bootstrap-server 192.168.168.11:6667 --topic test_opc_ua