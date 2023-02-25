package com.traffic.sensor.data.producer.trafficsensorproducer.kafka.config;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.traffic.sensor.data.producer.trafficsensorproducer.dto.Sensor;

@Configuration
public class KafkaProducerConfig {

	@Bean
	public ProducerFactory<String, Sensor> producerFactory(KafkaProperties kafkaProperties){
		return new DefaultKafkaProducerFactory<>(kafkaProperties.buildProducerProperties(), new StringSerializer(), new JsonSerializer<Sensor>());
	}
	
	@Bean
	public KafkaTemplate<String, Sensor> kafkaTemplate(KafkaProperties kafkaProperties){
		return new KafkaTemplate<>(producerFactory(kafkaProperties));
	}
}
