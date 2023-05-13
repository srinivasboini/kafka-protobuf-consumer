package com.srini.protobuf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaProtobufConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProtobufConsumerApplication.class, args);
	}

}
