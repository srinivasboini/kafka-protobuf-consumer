package com.srini.protobuf;


import io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializer;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * The type Kafka protobuf consumer application.
 */
@SpringBootApplication
@EnableKafka
public class KafkaProtobufConsumerApplication {


	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(KafkaProtobufConsumerApplication.class, args);
	}

}
