# Kafka Series

Here i covered some topics,

- Kafka producer
- Kafka Consumer
- Integration test with test container

Some command for *Kafka Producer* ,

- Start Zookeeper:
  `sh bin/zookeeper-server-start.sh config/zookeeper.properties`
- Start Kafka:
  `sh bin/kafka-server-start.sh config/server.properties`
- Run Consumer: `D:\kafka\practice\kafka_2.12-3.1.0\bin\windows>kafka-console-consumer.bat --bootstrap-server 127.0.0.1:9092 --topic first_topic`
- Describe Topic: `sh bin/kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic first_event`
- Run Producer: `sh bin/kafka-console-producer.sh --broker-list localhost:9092 --topic first_event`
- Run Consumer:
  `sh bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic first_event --from-beginning`