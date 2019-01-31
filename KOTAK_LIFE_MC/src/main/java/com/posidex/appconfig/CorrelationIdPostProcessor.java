package com.posidex.appconfig;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.jms.core.MessagePostProcessor;

public class CorrelationIdPostProcessor implements MessagePostProcessor {

	private final String correlationId;

	public CorrelationIdPostProcessor(final String correlationId) {
		this.correlationId = correlationId;
	}

	@Override
	public Message postProcessMessage(final Message message)
			throws JMSException {
		message.setJMSCorrelationID(correlationId);
		return message;
}

}
