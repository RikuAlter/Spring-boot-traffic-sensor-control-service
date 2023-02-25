package com.springboot.traffic.sensor.control.service.trafficcontrolservice.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springboot.traffic.sensor.control.service.trafficcontrolservice.dao.TrafficSignalDAOService;
import com.springboot.traffic.sensor.control.service.trafficcontrolservice.dtos.Sensor;

@Service
public class TrafficSensorDataKafkaConsumer {

	@Autowired
	private TrafficSignalDAOService trafficSignalDAOService;
	
	@KafkaListener(topics = "traffic-sensor-topic", containerFactory = "kafkaListenerContainerFactory")
	public void consume(Sensor sensor) {
		trafficSignalDAOService.update(sensor);
	}
}
