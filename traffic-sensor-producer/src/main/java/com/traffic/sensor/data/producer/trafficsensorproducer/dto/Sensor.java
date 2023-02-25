package com.traffic.sensor.data.producer.trafficsensorproducer.dto;

import java.io.Serializable;

public class Sensor implements Serializable{

	private static final long serialVersionUID = 1717198103569833691L;
	private String id;
	private String location;
	private String direction;
	private String status;

	public Sensor() {

	}

	public Sensor(String id, String location, String direction, String status) {
		super();
		this.id = id;
		this.location = location;
		this.direction = direction;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Sensor [id=" + id + ", location=" + location + ", direction=" + direction + ", status=" + status + "]";
	}
	
}
