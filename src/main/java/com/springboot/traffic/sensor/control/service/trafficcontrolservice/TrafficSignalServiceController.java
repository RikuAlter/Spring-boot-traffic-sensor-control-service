package com.springboot.traffic.sensor.control.service.trafficcontrolservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.traffic.sensor.control.service.trafficcontrolservice.dao.TrafficSignalDAOService;
import com.springboot.traffic.sensor.control.service.trafficcontrolservice.dtos.PoleData;

@RestController
public class TrafficSignalServiceController {
	
	@Autowired
	private TrafficSignalDAOService trafficSignalDAOService;
	
	@GetMapping(path = "/sensors")
	@RequestMapping("/view-all")
	public List<PoleData> retrieveAllTrafficPoleData(){
		return trafficSignalDAOService.findAll();
	}
	
	@GetMapping(path = "/sensor/{id}")
	public PoleData retrievePoleDataById(@PathVariable String id) {
		return trafficSignalDAOService.findById(id);
	}
}
