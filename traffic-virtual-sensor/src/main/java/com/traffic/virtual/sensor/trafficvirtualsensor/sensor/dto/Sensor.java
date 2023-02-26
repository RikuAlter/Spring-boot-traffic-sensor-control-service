package com.traffic.virtual.sensor.trafficvirtualsensor.sensor.dto;

public class Sensor {

	private String id;
	private String location;
	private String status;
	private String direction;

	public Sensor() {

	}

	public Sensor(String id, String location, String status, String direction) {
		super();
		this.id = id;
		this.location = location;
		this.status = status;
		this.direction = direction;
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

	@Override
	public String toString() {
		return "Sensor [id=" + id + ", location=" + location + ", status=" + status + ", direction=" + direction + "]";
	}

}
