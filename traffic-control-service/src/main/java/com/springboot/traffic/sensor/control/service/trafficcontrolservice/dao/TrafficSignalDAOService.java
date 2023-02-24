package com.springboot.traffic.sensor.control.service.trafficcontrolservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import com.springboot.traffic.sensor.control.service.trafficcontrolservice.dtos.Sensor;

@Component
@Transactional
public class TrafficSignalDAOService{
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Sensor> findAll(){
		return entityManager.createNamedQuery("Sensor.findAll", Sensor.class).getResultList();
	}
	
	public Sensor findById(final String id) {
		return entityManager.find(Sensor.class, id);
	}
	
	public Sensor update(final Sensor sensor) {
		return entityManager.merge(sensor);
	}
}
