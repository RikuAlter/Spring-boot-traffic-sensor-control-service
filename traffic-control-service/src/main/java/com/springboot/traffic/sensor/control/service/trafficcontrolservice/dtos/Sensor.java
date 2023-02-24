package com.springboot.traffic.sensor.control.service.trafficcontrolservice.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries(value = { @NamedQuery(name = "Sensor.findAll", query = "SELECT e FROM Sensor e") })
public class Sensor {

	@Id
	private String id;
	private String direction;
	private String status;
	private String location;

	public Sensor() {
		
	}

	public Sensor(String id, String direction, String status, String location) {
		super();
		this.id = id;
		this.direction = direction;
		this.status = status;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "PoleData [id=" + id + ", status=" + status + ", direction=" + direction + ", location=" + location
				+ "]";
	}

}
