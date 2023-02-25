package com.traffic.sensor.data.producer.trafficsensorproducer.kafka.service;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.traffic.sensor.data.producer.trafficsensorproducer.dao.TrafficSensorDataProducerErrorLogDAOService;
import com.traffic.sensor.data.producer.trafficsensorproducer.dto.LogEntry;
import com.traffic.sensor.data.producer.trafficsensorproducer.dto.Sensor;

@Service
public class TrafficSensorDataKafkaProducer {
	
	private static final String KAFKAERROR = "Apache Kafka Error";

	@Autowired
	private KafkaTemplate<String, Sensor> kafkaTemplate;
	@Autowired
	private TrafficSensorDataProducerErrorLogDAOService trafficSensorDataProducerErrorLogDAOService;
	
	public void sendMessage(Sensor message) {
		CompletableFuture<SendResult<String, Sensor>> future =kafkaTemplate.send(null, message);
		future.whenComplete((success, ex) ->{
			if(!(Objects.isNull(ex))) {
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				String sensorId = message.getId();
				trafficSensorDataProducerErrorLogDAOService.updateEntry(new LogEntry(sensorId, timestamp, message, KAFKAERROR));
			} 
		});
	}
}
