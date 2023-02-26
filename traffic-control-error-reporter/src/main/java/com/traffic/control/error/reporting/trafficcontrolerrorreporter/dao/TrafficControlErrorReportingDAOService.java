package com.traffic.control.error.reporting.trafficcontrolerrorreporter.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.traffic.control.error.reporting.trafficcontrolerrorreporter.dto.LogEntry;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class TrafficControlErrorReportingDAOService {
	
	private static final String KAFKAERROR = "Apache Kafka Error";
	private static final String INVALIDSTATE = "Invalid sensor state";

	@Autowired
	private EntityManager entityManager;
	
	public List<LogEntry> findAll(){
		return entityManager.createNamedQuery("LogEntry.findAll", LogEntry.class).getResultList();
	}
	
	public List<LogEntry> findKafkaIssues(){
		return findAll().stream().filter(issue -> issue.getReason().equalsIgnoreCase(KAFKAERROR)).collect(Collectors.toList());
	}
	
	public List<LogEntry> findSensorIssues(){
		return findAll().stream().filter(issue -> issue.getReason().equalsIgnoreCase(INVALIDSTATE)).collect(Collectors.toList());
	}
	
	public void dropKafkaValues() {
		Query dropKafkaQuery = entityManager.createNamedQuery("LogEntry.dropBroker");
		dropKafkaQuery.setParameter("reason", KAFKAERROR);
		dropKafkaQuery.executeUpdate();
	}
	
	public void dropSensorValues() {
		Query dropSensorQuery = entityManager.createNamedQuery("LogEntry.dropBroker");
		dropSensorQuery.setParameter("reason", INVALIDSTATE);
		dropSensorQuery.executeUpdate();
	}
}
