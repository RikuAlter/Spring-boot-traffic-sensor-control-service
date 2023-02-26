package com.traffic.sensor.data.producer.trafficsensorproducer.dto;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "logentry")
@NamedQueries(value = { @NamedQuery(name = "LogEntry.findAll", query = "SELECT e FROM LogEntry e") })
public class LogEntry {

	@EmbeddedId
	private LogEntryId logEntryId;
	private String sensor_loc;
	private String reason;

	public LogEntry() {
	}

	public LogEntry(LogEntryId logEntryId, String sensor_loc, String reason) {
		super();
		this.logEntryId = logEntryId;
		this.sensor_loc = sensor_loc;
		this.reason = reason;
	}

	public LogEntryId getLogEntryId() {
		return logEntryId;
	}

	public void setLogEntryId(LogEntryId logEntryId) {
		this.logEntryId = logEntryId;
	}

	public String getSensor_loc() {
		return sensor_loc;
	}

	public void setSensor_loc(String sensor_loc) {
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
		return "LogEntry [logEntryId=" + logEntryId + ", sensor_loc=" + sensor_loc + ", reason=" + reason + "]";
	}

}
