package com.springboot.traffic.sensor.control.service.trafficcontrolservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;

import com.springboot.traffic.sensor.control.service.trafficcontrolservice.dtos.PoleData;

@Component
public class TrafficSignalDAOService{
	
	@Autowired
	private EntityManager entityManager;
	
	public List<PoleData> findAll(){
		return entityManager.createNamedQuery("PoleData.findAll", PoleData.class).getResultList();
	}
	
	public PoleData findById(String id) {
		return entityManager.find(PoleData.class, id);
	}
}
