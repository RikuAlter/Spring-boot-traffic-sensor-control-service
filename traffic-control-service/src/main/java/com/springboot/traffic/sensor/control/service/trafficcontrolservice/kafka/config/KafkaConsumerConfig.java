package com.springboot.traffic.sensor.control.service.trafficcontrolservice.kafka.config;

import java.util.Map;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.springboot.traffic.sensor.control.service.trafficcontrolservice.dtos.Sensor;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

	@Bean
	public ConsumerFactory<String, Sensor> consumerFactory(KafkaProperties kafkaProperties){
		Map<String, Object> config = kafkaProperties.buildConsumerProperties();
		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new JsonDeserializer<>(Sensor.class));
	}
	
	@Bean
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Sensor>> kafkaListenerContainerFactory(KafkaProperties kafkaProperties){
		ConcurrentKafkaListenerContainerFactory<String, Sensor> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory(kafkaProperties));
		return factory;
	}
}
