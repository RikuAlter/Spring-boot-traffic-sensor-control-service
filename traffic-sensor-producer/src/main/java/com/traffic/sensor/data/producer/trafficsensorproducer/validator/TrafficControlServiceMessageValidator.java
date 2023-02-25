package com.traffic.sensor.data.producer.trafficsensorproducer.validator;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.traffic.sensor.data.producer.trafficsensorproducer.dto.Sensor;

@Component
public class TrafficControlServiceMessageValidator {
	
	private static final List<String> VALID_STATES = Arrays.asList("Red", "Green", "Yellow");

	public boolean isValidMessage(Sensor message) {
		String sensorState = message.getStatus();
		return VALID_STATES.contains(sensorState);
	}
}
