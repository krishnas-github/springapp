package com.mycompany.springapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableCaching
@EnableTransactionManagement
public class SpringappApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringappApplication.class);

	public static void main(String[] args) {
		LOGGER.info("hello world info");
		LOGGER.warn("hello world warn");
		LOGGER.error("hello world error");
		LOGGER.debug("hello world debug");

		SpringApplication.run(SpringappApplication.class, args);
	}

}
