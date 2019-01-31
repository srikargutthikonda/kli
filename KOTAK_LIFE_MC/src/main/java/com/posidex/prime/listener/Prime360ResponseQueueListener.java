package com.posidex.prime.listener;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class Prime360ResponseQueueListener {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Environment environment;
	
	/*@JmsListener(destination = "PSX_NSP_PM_RESP_QUEUE")
	//@SendTo("outbound.queue")
	public String receiveMessage(final javax.jms.Message jsonMessage) throws JMSException {
//		String messageData = null;
		environment.getProperty("res.queue");
		System.out.println("Received message " + jsonMessage.toString());
		String response = null;
		MessageConverter messageConverter = new SimpleMessageConverter();
		System.out.println("converted message ::: "+messageConverter.fromMessage(jsonMessage));
		
		
		TextMessage textMessage = (TextMessage)jsonMessage;
		messageData = textMessage.getText();
		System.out.println("messageData:: "+messageData);
		if(jsonMessage instanceof TextMessage) {
			TextMessage textMessage = (TextMessage)jsonMessage;
			messageData = textMessage.getText();
			System.out.println("messageData:: "+messageData);
			Map map = new Gson().fromJson(messageData, Map.class);
			response  = "Hello " + map.get("name");
		}
		return response;
	}*/
	

}
