package com.traffic.sensor.data.producer.trafficsensorproducer.dto;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries(value = { @NamedQuery(name = "LogEntry.findAll", query = "SELECT e FROM LogEntry e") })
public class LogEntry {

	@Id
	private String sensor_id;
	@Id
	private Timestamp timestamp;
	private String sensor_loc;
	private String reason;

	public LogEntry() {
	}

	public LogEntry(String sensor_id, Timestamp timestamp, String sensor_loc, String reason) {
		super();
		this.sensor_id = sensor_id;
		this.timestamp = timestamp;
		this.sensor_loc = sensor_loc;
		this.reason = reason;
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

	public String getMessage() {
		return sensor_loc;
	}

	public void setMessage(String sensor_loc) {
		this.sensor_loc = sensor_loc;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "TrafficSensorDataProducerErrorLogDAOService [sensor_id=" + sensor_id + ", timestamp=" + timestamp
				+ ", message=" + sensor_loc + ", reason=" + reason + "]";
	}

}
