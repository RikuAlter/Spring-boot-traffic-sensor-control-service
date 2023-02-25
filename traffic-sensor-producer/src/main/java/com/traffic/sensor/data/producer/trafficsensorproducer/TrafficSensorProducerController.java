package com.traffic.sensor.data.producer.trafficsensorproducer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.traffic.sensor.data.producer.trafficsensorproducer.dao.TrafficSensorDataProducerErrorLogDAOService;
import com.traffic.sensor.data.producer.trafficsensorproducer.dto.LogEntry;
import com.traffic.sensor.data.producer.trafficsensorproducer.dto.Sensor;
import com.traffic.sensor.data.producer.trafficsensorproducer.kafka.service.TrafficSensorDataKafkaProducer;

@RestController
public class TrafficSensorProducerController {
	
	@Autowired
	private TrafficSensorDataProducerErrorLogDAOService trafficSensorDataProducerErrorLogDAOService;
	
	@Autowired
	private TrafficSensorDataKafkaProducer trafficSensorDataKafkaProducer;
	
	@GetMapping("/errorlog")
	public List<LogEntry> retrieveAllErrorLog(){
		return trafficSensorDataProducerErrorLogDAOService.findAll();
	}
	
	@GetMapping("/errorlog/{id}")
	public List<LogEntry> retrieveAllErrorLogForSensor(@PathVariable String id){
		return trafficSensorDataProducerErrorLogDAOService.findAll().stream().filter(logEntry -> id == logEntry.getSensor_id()).collect(Collectors.toList());
	}
	
	@PostMapping("/test-producer")
	public void testKafkaProducer(@RequestBody Sensor sensor) {
		trafficSensorDataKafkaProducer.sendMessage(sensor);
	}
}
