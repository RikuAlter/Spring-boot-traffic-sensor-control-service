package com.traffic.control.error.reporting.trafficcontrolerrorreporter.emailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.traffic.control.error.reporting.trafficcontrolerrorreporter.dao.TrafficControlErrorReportingDAOService;

@Service
public class TrafficControlErrorEmailMessagingService {

	@Value("${spring.mail.username}")
	private String senderId;

	@Value("${traffic.control.email.kafka.support.recipient}")
	private String kafkaRecipient;

	@Value("${traffic.control.email.maintainance.recipient}")
	private String maintainanceRecipient;

	@Value("${traffic.control.email.kafka.mailtext}")
	private String kafkaMailText;

	@Value("${traffic.control.email.maintainance.mailtext}")
	private String maintainanceMailText;
	
	@Value("${traffic.control.email.kafka.support.subject}")
	private String kafkaSubject;
	
	@Value("${traffic.control.email.maintainance.subject}")
	private String maintainanceSubject;

	@Autowired
	private TrafficControlErrorReportingDAOService trafficControlErrorReportingDAOService;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private static final String KAFKABROKER = "kafka";

	public void sendMessage(String recipient) throws JsonProcessingException {
		SimpleMailMessage message = new SimpleMailMessage();
		String receiver="";
		String messageText=fetchIssueList(recipient);
		String messageSubject="";
		
		message.setFrom(senderId);
		if(recipient.equalsIgnoreCase(KAFKABROKER)) {
			receiver=kafkaRecipient;
			messageText=kafkaMailText + " " + messageText;
			messageSubject=kafkaSubject;
		} else {
			receiver=maintainanceRecipient;
			messageText=maintainanceMailText + " " + messageText;
			messageSubject=maintainanceSubject;
		}
		message.setTo(receiver);
		message.setSubject(messageSubject);
		message.setText(messageText);
		javaMailSender.send(message);
	}

	public String fetchIssueList(String recipient) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		if (recipient.equalsIgnoreCase(KAFKABROKER))
			return objectMapper.writeValueAsString(trafficControlErrorReportingDAOService.findKafkaIssues());
		else
			return objectMapper.writeValueAsString(trafficControlErrorReportingDAOService.findSensorIssues());
	}
}
