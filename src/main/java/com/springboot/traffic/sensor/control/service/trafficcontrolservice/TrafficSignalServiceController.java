package com.springboot.traffic.sensor.control.service.trafficcontrolservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.traffic.sensor.control.service.trafficcontrolservice.dao.TrafficSignalSensorRepository;
import com.springboot.traffic.sensor.control.service.trafficcontrolservice.dtos.PoleData;

@RestController
public class TrafficSignalServiceController {
	
	@Autowired
	private TrafficSignalSensorRepository trafficSignalSensorRepository;
	
	
	@RequestMapping("/view-all")
	private List<PoleData> retrieveAllTrafficPoleData(){
		return trafficSignalSensorRepository.findAll();
	}
}
