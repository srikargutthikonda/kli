package com.posidex.appconfig;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.posidex.prime.service.impl.CustomerRequestServiceImpl;

@Component
public class SendAndReceiveJMSMessage {
	private static Logger logger = Logger.getLogger(SendAndReceiveJMSMessage.class);
	@Autowired
	private Environment environment;

	@Autowired
	private JmsTemplate jmsTemplate;

	//private Message message;

	private static final String RESPONSE_QUEUE = "PSX_NSP_PM_RESP_QUEUE";

	private static final String REQUEST_QUEUE = "PSX_NSP_PM_QUEUE";

	public void sendMessage(String clientMessage, long psxId) {
		
		String Psx_ID = String.valueOf(psxId);
		
		logger.info("Engine request parameters_____posidexId ??______"+Psx_ID+"_");
		logger.info(clientMessage);
		logger.info("To Which  Queue your sending ___ ?? "+REQUEST_QUEUE); 
		 

		 
		 try {

			
			jmsTemplate.send(REQUEST_QUEUE, new MessageCreator() {

				@Override
				public Message createMessage(Session session) throws JMSException {
					Message	message = ((javax.jms.Session) session).createTextMessage(clientMessage);
					message.setStringProperty("PSX_PSX_ID", String.valueOf(psxId));
					return message;
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Object receiveMessage(long psxId) {
		Object receivedMessage = null;
		try {
			jmsTemplate.setReceiveTimeout(10000);
			receivedMessage = jmsTemplate.receiveSelected(RESPONSE_QUEUE, "PSX_PSX_ID='" + String.valueOf(psxId) + "'");
		} catch (Exception e) {
			e.printStackTrace();

		}

		return receivedMessage;

	}

}
