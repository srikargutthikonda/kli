package com.posidex.appconfig;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.posidex.prime.exception.PosidexException;


@Configuration
@ComponentScan("com.posidex")
@EnableTransactionManagement
public class DBconfiguration {
	private static Logger logger = LogManager.getLogger(DBconfiguration.class);
	
	@Autowired
	private Environment env;

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public DataSource dataSource() throws  PosidexException {
		BasicDataSource dataSource = null;
		// DriverManagerDataSource dataSource=null;
		try {
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class"));
			dataSource.setUrl(env.getProperty("spring.datasource.url"));
			dataSource.setUsername(env.getProperty("spring.datasource.username"));
			dataSource.setPassword(env.getProperty("spring.datasource.password"));

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("while getting datasource got an exception:" + e.getMessage());
		}

		return dataSource;
	}

}
