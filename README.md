# spring-boot-spring-kafka
Integration of a Spring Boot application with Apache Kafka, sending and consuming messages from the appliction.

[<img height="400px" width="400px" alt="Spring Boot with Kafka diagram" src="https://github.com/dmullandev/spring-boot-spring-kafka/blob/main/docs/spring-boot-kafka-diagrams.PNG"/>](https://app.diagrams.net//)
</br>

### Where to start
**Clone Repo**\
To start with clone this entire repo - then build the separate projects by their dependency hierarchy.

**Installation - Kafka + Zookeeper**\
Local install is needed of both Kafka + Zookeeper (Kafka 3.4+ contains packaged zookeeper, separate install not needed)
See link: https://kafka.apache.org/quickstart

Post install - start using files 1)**zookeeper-server-start** 2)**kafka-server-start**

**Start producer App**
Using IDE menu or specifying maven goal '**spring-boot:run**' to start the producer.

**Postman**
Using postman:
1) Set HTTP POST request: http://localhost:8099/api/v1/businessobjects
2) Set body as JSON with following format:
```json
{
    "businessObjectId" : 999,
    "basicBusinessObjectInformation" : {
        "objectType" : "KAFKA_TYPE",
        "objectDescription" : "Object for relaying kafka object information"
    }
}
```
