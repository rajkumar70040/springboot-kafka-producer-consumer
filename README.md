🚀 Spring Boot + Apache Kafka – Producer & Consumer with Objects

This project demonstrates how to implement Apache Kafka Producer–Consumer communication in a Spring Boot application using a custom Java object (IndianFestival).

📌 Features

Producer publishes Java objects (IndianFestival) as JSON messages.

Consumer listens to Kafka topic and automatically deserializes JSON back to Java objects.

REST APIs to send and read messages.

Centralized exception handling with @RestControllerAdvice.

Uses Spring Kafka JsonSerializer & JsonDeserializer.

🛠️ Tech Stack

Java 17+

Spring Boot 3.x

Apache Kafka

REST APIs

Lombok

📂 Project Structure
src/main/java/com/nit
│── model/IndianFestival.java                # POJO class
│── publisher/KafkaMessageSender.java        # Kafka Producer
│── subscriber/KafkaMessageSubscriber.java   # Kafka Consumer
│── rest/KafkaMessageOperationsController.java  # REST Controller
│── advice/KafkaMessageOperationsControllerAdvice.java  # Exception Handler

⚙️ Configuration (application.properties)
spring.application.name=BootKafkaproj02-WorkingObjs

# Kafka topic
app.tpc.name=nittpc621

# Server
server.servlet.context-path=/BootKafkaProj02
server.port=4041

# Producer properties
spring.kafka.producer.bootstrap-server=localhost:9092
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.springframework.kafka.support.serializer.JsonSerializer

# Consumer properties
spring.kafka.consumer.bootstrap-server=localhost:9092
spring.kafka.consumer.key-deserializer=org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer=org.springframework.kafka.support.serializer.JsonDeserializer
spring.kafka.consumer.properties.spring.json.trusted.packages=com.nit.model

▶️ How to Run

Start Zookeeper & Kafka (Kafka should run on localhost:9092):

zookeeper-server-start.sh config/zookeeper.properties
kafka-server-start.sh config/server.properties


Create Kafka Topic:

kafka-topics.sh --create --topic nittpc621 --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1


Run Spring Boot App:

mvn spring-boot:run


Test APIs (Postman / cURL):

Send message

POST http://localhost:4041/BootKafkaProj02/message-api/send
Content-Type: application/json  

{
  "fid": 101,
  "fname": "Diwali",
  "season": "Winter",
  "reason": "Festival of Lights",
  "dressCode": "Traditional"
}


Read message

GET http://localhost:4041/BootKafkaProj02/message-api/read

📖 Sample Output

✅ Producer:

message sent


✅ Consumer Console:

message is :: IndianFestival(fid=101, fname=Diwali, season=Winter, reason=Festival of Lights, dressCode=Traditional)
