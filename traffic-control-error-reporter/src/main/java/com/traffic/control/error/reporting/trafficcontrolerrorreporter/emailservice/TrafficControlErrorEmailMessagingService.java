package com.traffic.control.error.reporting.trafficcontrolerrorreporter.emailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
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
		
		if(recipient.equalsIgnoreCase(KAFKABROKER))
			sendMessageKafka();
		else
			sendMessageMaintainance();
	}

	public String fetchIssueList(String recipient) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		if (recipient.equalsIgnoreCase(KAFKABROKER))
			return objectMapper.writeValueAsString(trafficControlErrorReportingDAOService.findKafkaIssues());
		else
			return objectMapper.writeValueAsString(trafficControlErrorReportingDAOService.findSensorIssues());
	}
	
	@Scheduled(fixedDelay = 120000)
	public void sendMessageKafka() throws JsonProcessingException {
		SimpleMailMessage message = new SimpleMailMessage();
		String messageList = fetchIssueList(KAFKABROKER);
		if(messageList.length()>3) {
			String messageText = kafkaMailText + " " + messageList;
			message.setFrom(senderId);
			message.setTo(kafkaRecipient);
			message.setSubject(kafkaSubject);
			message.setText(messageText);
			javaMailSender.send(message);
			trafficControlErrorReportingDAOService.dropKafkaValues();
		}
	}
	
	@Scheduled(fixedDelay = 120000)
	public void sendMessageMaintainance() throws JsonProcessingException {
		SimpleMailMessage message = new SimpleMailMessage();
		String messageList = fetchIssueList("Maintainance");
		if(messageList.length()>3) {
			String messageText = maintainanceMailText + " " + messageList;
			message.setFrom(senderId);
			message.setTo(maintainanceRecipient);
			message.setSubject(maintainanceSubject);
			message.setText(messageText);
			javaMailSender.send(message);
			trafficControlErrorReportingDAOService.dropSensorValues();
		}
	}
}
