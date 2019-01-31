package com.posidex.appconfig;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import com.posidex.prime.enginerequest.Prime360CommonTable;
import com.posidex.prime.enginerequest.Prime360Request;
import com.posidex.prime.enginerequest.Prime360RequestInfo;


@Configuration
public class SpringJMSConfig {

	@Autowired
	private Environment env;

	
	//private static Random rand = new Random();

	
//  ActiveMQ configuration
	   
	@Bean
	public CachingConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(env.getProperty("spring.activemq.broker.url")); 
	    connectionFactory.setPassword(env.getProperty("spring.activemq.user"));
	    connectionFactory.setUserName(env.getProperty("spring.activemq.password"));
		CachingConnectionFactory ccf = new CachingConnectionFactory();
		ccf.setTargetConnectionFactory(connectionFactory);
		ccf.setSessionCacheSize(10);
		// connectionFactory.setTrustedPackages();
		return ccf;
	}

	
	
	
	
	public JmsTemplate jmsTemplate() {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		// template.setDefaultDestinationName(ORDER_QUEUE);
		return template;
	}
	
	
	public Prime360Request prime360Request() {
		return new Prime360Request();
	}

	public Prime360CommonTable prime360CommonTable() {
		return new Prime360CommonTable();
	}
	
	public Prime360RequestInfo prime360RequestInfo() {
		return new Prime360RequestInfo();
	}
	
	
	
	


	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	    factory.setConnectionFactory(connectionFactory());
	    factory.setConcurrency("1-1");
	    return factory;
	}

    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

   
	
	
	
	
	
	
}
