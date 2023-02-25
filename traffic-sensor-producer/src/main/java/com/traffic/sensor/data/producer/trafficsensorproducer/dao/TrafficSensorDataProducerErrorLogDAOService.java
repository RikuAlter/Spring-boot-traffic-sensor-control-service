package com.traffic.sensor.data.producer.trafficsensorproducer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.traffic.sensor.data.producer.trafficsensorproducer.dto.LogEntry;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class TrafficSensorDataProducerErrorLogDAOService {
	
	@Autowired
	private EntityManager entityManager;
	
	public List<LogEntry> findAll(){
		return entityManager.createNamedQuery("LogEntry.findAll", LogEntry.class).getResultList();
	}
	
	public LogEntry updateEntry(final LogEntry logEntry) {
		return entityManager.merge(logEntry);
	}
}
