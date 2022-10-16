## Kafka

> **version**
>
> - 
> - 

--------------------
### Kafka를 활용한 CDC, Change Data Capture Test

  1. Trigger - DB 부하.
  2. Spring Batch - 데이터 유실 위험 및 서버 부하 우려
  3. ETL - ETL 서버 부하 우려
  4. Kafka - TEST 진행중.

--------------------
### Development environment(offline)
  - Spring Boot 2.7
  - Java11
  - Gradle
  - [Kafka](https://spring.io/projects/spring-kafka)
    - wurstmeister/kafka
    - wurstmeister/zookeeper
  - Debezium