package com.traffic.sensor.data.producer.trafficsensorproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class TrafficSensorProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrafficSensorProducerApplication.class, args);
	}

}
