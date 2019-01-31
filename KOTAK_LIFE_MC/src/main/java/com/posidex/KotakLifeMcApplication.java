package com.posidex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages = { "com.posidex"})
public class KotakLifeMcApplication extends SpringBootServletInitializer {

	
	
	
	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(KotakLifeMcApplication.class);
	    }

	    public static void main(String[] args) {
			SpringApplication.run(KotakLifeMcApplication.class, args);
		}

	}
	
	
	
	

