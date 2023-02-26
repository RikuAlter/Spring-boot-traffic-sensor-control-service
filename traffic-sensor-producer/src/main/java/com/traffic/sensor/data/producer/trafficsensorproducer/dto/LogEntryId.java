package com.traffic.sensor.data.producer.trafficsensorproducer.dto;

import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class LogEntryId{

	private String sensor_id;
	private Timestamp timestamp;

	public LogEntryId() {
		
	}
	
	public LogEntryId(String sensor_id, Timestamp timestamp) {
		super();
		this.sensor_id = sensor_id;
		this.timestamp = timestamp;
	}

	public String getSensor_id() {
		return sensor_id;
	}

	public void setSensor_id(String sensor_id) {
		this.sensor_id = sensor_id;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sensor_id, timestamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogEntryId other = (LogEntryId) obj;
		return Objects.equals(sensor_id, other.sensor_id) && Objects.equals(timestamp, other.timestamp);
	}

	@Override
	public String toString() {
		return "LogEntryId [sensor_id=" + sensor_id + ", timestamp=" + timestamp + "]";
	}

}
