package com.traffic.virtual.sensor.trafficvirtualsensor;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.traffic.virtual.sensor.trafficvirtualsensor.sensor.dto.Sensor;

@RestController
public class TrafficVirtualSensorController {
	
	private String sensorID = "000-001";
	private String sensorLoc = "Loc-01";
	private String sensorDirection = "North";
	private String sensorStatus = "Red";
	
	private Sensor sensor = new Sensor(sensorID, sensorLoc, sensorStatus, sensorDirection);

	@PatchMapping("/sensor")
	public Sensor updateSensor(@RequestBody Sensor message) {
		sensor.setStatus(message.getStatus());
		sensor.setLocation(message.getLocation());
		sensor.setDirection(message.getDirection());
		return sensor;
	}
}
