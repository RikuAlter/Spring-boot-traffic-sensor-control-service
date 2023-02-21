package com.springboot.traffic.sensor.control.service.trafficcontrolservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Riku
 * 
 * A simple command line runner, to work mostly as a test tool to visualize the changes made by running queries against the database manually
 *
 */
@Component
public class TrafficSignalServiceCommandLineRunner implements CommandLineRunner{

	@Autowired
	private TrafficSignalDAOService trafficSignalSensorRepository;

	@Override
	public void run(String... args) throws Exception {
		trafficSignalSensorRepository.findAll();
	}
	
}
