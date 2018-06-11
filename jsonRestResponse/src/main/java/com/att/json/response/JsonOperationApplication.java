package com.att.json.response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.att.json.response.controller.JsonCURDController;

@SpringBootApplication
public class JsonOperationApplication {

	private static Logger logger = LogManager.getLogger(JsonCURDController.class);
	
	public static void main(String[] args) {
		logger.debug("Starting the main method of class JsonOperationApplication");
		SpringApplication.run(JsonOperationApplication.class, args);
		logger.debug("Ending the main method of class JsonOperationApplication");
	}
}
