package com.traffic.control.error.reporting.trafficcontrolerrorreporter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.traffic.control.error.reporting.trafficcontrolerrorreporter.emailservice.TrafficControlErrorEmailMessagingService;

@RestController
public class TrafficControlErrorReportingServiceController {
	
	@Autowired
	private TrafficControlErrorEmailMessagingService trafficControlErrorEmailMessagingService;
	
	@PostMapping("/invokeEmailSender/{broker}")
	public void invokeEmailSender(@PathVariable String broker) throws JsonProcessingException {
		trafficControlErrorEmailMessagingService.sendMessage(broker);
	}
}
