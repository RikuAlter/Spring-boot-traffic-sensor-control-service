package com.springboot.traffic.sensor.control.service.trafficcontrolservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.traffic.sensor.control.service.trafficcontrolservice.dao.TrafficSignalDAOService;
import com.springboot.traffic.sensor.control.service.trafficcontrolservice.dtos.Sensor;
import com.springboot.traffic.sensor.control.service.trafficcontrolservice.sensorcomservice.TrafficControlSensorCommunicationService;

@RestController
public class TrafficSignalServiceController {
	
	@Autowired
	private TrafficSignalDAOService trafficSignalDAOService;
	
	@Autowired
	private TrafficControlSensorCommunicationService trafficControlSensorCommunicationService;
	
	@GetMapping("/sensors")
	public List<Sensor> retrieveAllTrafficPoleData(){
		return trafficSignalDAOService.findAll();
	}
	
	@GetMapping(path = "/sensors/{id}")
	public Sensor retrievePoleDataById(@PathVariable String id) {
		return trafficSignalDAOService.findById(id);
	}
	
	@PatchMapping(path = "/sensors")
	public void updatePoleData(@RequestBody Sensor sensor) {
		trafficSignalDAOService.update(sensor);
	}
	
	@PatchMapping(path = "/updatesensor/{id}")
	public String updateSensorDirect(@PathVariable String id, @RequestBody Sensor message) {
		return trafficControlSensorCommunicationService.doCallSensorService(id, message);
	}
}
