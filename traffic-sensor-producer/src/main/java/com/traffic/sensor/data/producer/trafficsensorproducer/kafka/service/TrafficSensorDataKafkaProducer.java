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
import com.traffic.sensor.data.producer.trafficsensorproducer.dto.LogEntryId;
import com.traffic.sensor.data.producer.trafficsensorproducer.dto.Sensor;
import com.traffic.sensor.data.producer.trafficsensorproducer.validator.TrafficControlServiceMessageValidator;

@Service
public class TrafficSensorDataKafkaProducer {
	
	private static final String KAFKAERROR = "Apache Kafka Error";
	private static final String INVALIDSTATE = "Invalid sensor state";

	@Autowired
	private KafkaTemplate<String, Sensor> kafkaTemplate;
	@Autowired
	private TrafficSensorDataProducerErrorLogDAOService trafficSensorDataProducerErrorLogDAOService;
	@Autowired
	private TrafficControlServiceMessageValidator trafficControlServiceMessageValidator;
	
	public void sendMessage(Sensor message) {
		
		if(trafficControlServiceMessageValidator.isValidMessage(message)) {
			CompletableFuture<SendResult<String, Sensor>> future =kafkaTemplate.send("traffic-sensor-topic", message);
			future.whenComplete((success, ex) ->{
				if(!(Objects.isNull(ex))) {
					logError(message, KAFKAERROR);
				} 
			});
		} else {
			logError(message, INVALIDSTATE);
		}
	}
	
	private void logError(Sensor message, String reason) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		trafficSensorDataProducerErrorLogDAOService.updateEntry(new LogEntry(new LogEntryId(message.getId(), timestamp), message.getLocation(), reason));
	}
}
