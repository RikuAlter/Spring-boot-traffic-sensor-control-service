package com.springboot.traffic.sensor.control.service.trafficcontrolservice.sensorcomservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.traffic.sensor.control.service.trafficcontrolservice.dtos.Sensor;

@Service
public class TrafficControlSensorCommunicationService {
	
	@Value("${traffic.sensor.protocol}")
	private String sensorProtocol;
	
	@Value("${traffic.sensor.host}")
	private String sensorHost;
	
	@Value("${traffic.sensor.port}")
	private String sensorPort;
	
	@Value("${traffic.sensor.groupuri}")
	private String sensorGroupURI;
	
	@Bean
	private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
	    SimpleClientHttpRequestFactory clientHttpRequestFactory  = new SimpleClientHttpRequestFactory();
	    clientHttpRequestFactory.setConnectTimeout(10000);
	    clientHttpRequestFactory.setReadTimeout(10000);
	    return clientHttpRequestFactory;
	}
	
	public String doCallSensorService(String sensorId, Sensor message) {
		String sensorURI = sensorProtocol + "://" + sensorHost + ":" + sensorPort + "/" + sensorGroupURI + "/" + sensorId;
		RestTemplate restTemplate = new RestTemplate();
		Sensor response = restTemplate.patchForObject(sensorURI, message, Sensor.class);
		if(response != null)
			return "Success";
		else
			return "Failure";
			
	}
}
