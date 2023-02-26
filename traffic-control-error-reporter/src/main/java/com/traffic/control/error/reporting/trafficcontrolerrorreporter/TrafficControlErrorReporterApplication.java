package com.traffic.control.error.reporting.trafficcontrolerrorreporter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TrafficControlErrorReporterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrafficControlErrorReporterApplication.class, args);
	}

}
