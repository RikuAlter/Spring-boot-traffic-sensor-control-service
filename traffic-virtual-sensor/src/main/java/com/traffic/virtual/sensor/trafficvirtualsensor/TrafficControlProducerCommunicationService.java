package com.traffic.virtual.sensor.trafficvirtualsensor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.traffic.virtual.sensor.trafficvirtualsensor.sensor.dto.Sensor;

@Service
public class TrafficControlProducerCommunicationService {

	@Value("${traffic.control.producer}")
	private String sensorGroupURI;
	
	@Bean
	private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
	    SimpleClientHttpRequestFactory clientHttpRequestFactory  = new SimpleClientHttpRequestFactory();
	    clientHttpRequestFactory.setConnectTimeout(10000);
	    clientHttpRequestFactory.setReadTimeout(10000);
	    return clientHttpRequestFactory;
	}
	
	public String doCallProducerService(Sensor message) {
		String sensorURI = sensorGroupURI;
		RestTemplate restTemplate = new RestTemplate();
		Sensor response = restTemplate.postForObject(sensorURI, message, Sensor.class);
		if(response != null)
			return "Success";
		else
			return "Failure";
			
	}
}
