package com.springboot.traffic.sensor.control.service.trafficcontrolservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.traffic.sensor.control.service.trafficcontrolservice.dtos.PoleData;

public interface TrafficSignalSensorRepository extends JpaRepository<PoleData, String>{

}
