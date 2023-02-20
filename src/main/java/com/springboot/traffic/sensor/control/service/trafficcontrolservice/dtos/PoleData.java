package com.springboot.traffic.sensor.control.service.trafficcontrolservice.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries(value = { @NamedQuery(name = "findAll", query = "Select e from sensor e") })
public class PoleData {

	@Id
	private String id;
	private String status;
	private String direction;
	private String location;

	public PoleData(String id, String status, String direction, String location) {
		super();
		this.id = id;
		this.status = status;
		this.direction = direction;
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
