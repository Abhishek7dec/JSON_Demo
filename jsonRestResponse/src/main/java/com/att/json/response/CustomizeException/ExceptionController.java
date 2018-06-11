package com.att.json.response.CustomizeException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.att.json.response.Entity.JsonEntity;
import com.att.json.response.controller.JsonCURDController;

@ControllerAdvice
public class ExceptionController {
	
	private static Logger logger = LogManager.getLogger(JsonCURDController.class);
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> handleException(CustomException customException){
		logger.debug("Starting the handleException() method of class ExceptionController");
		return new ResponseEntity<>(customException.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
