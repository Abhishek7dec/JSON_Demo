package com.att.json.response.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.att.json.response.CustomizeException.CustomException;
import com.att.json.response.Services.JsonCURDService;

/**
 * Controller class of the rest request
 * @author abhis
 *
 */
@RestController
public class JsonCURDController {
	
	private static Logger logger = LogManager.getLogger(JsonCURDController.class);
	
	@Autowired
	JsonCURDService jsonService;
	
	/**
	 * GET is the default method so no need to add signature with RequestMapping annotation
	 * @return
	 * @throws CustomException
	 */
	@RequestMapping("/jsonExample")
	public String getJSONResponse() throws CustomException{
		logger.debug("Starting the getJSONResponse() method of class JsonOperationApplication");
		return jsonService.getAllJsonResponse().build().toString();
	}
}
