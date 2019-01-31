package com.posidex.appconfig;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Import({ })
@PropertySource({"classpath:application.properties","classpath:static_sql_quries.properties",
		"classpath:WSResources.properties","classpath:spring_jmsconfig.properties"})
public class ApplicationConfiguration {

}
