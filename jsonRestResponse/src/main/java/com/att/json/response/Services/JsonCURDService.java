package com.att.json.response.Services;

import javax.json.JsonObjectBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.att.json.response.Entity.JsonEntity;
import com.att.json.response.controller.JsonCURDController;

/**
 * Service class is providing the implementation of the CURD operation
 * and here we can extend the Repository DAO for DB access
 * @author abhis
 *
 */
@Service
public class JsonCURDService {
	
	private static Logger logger = LogManager.getLogger(JsonCURDController.class);
	/**
	 * 
	 * @return JsonObjectBuilder
	 */
	public JsonObjectBuilder getAllJsonResponse(){
		logger.debug("Starting the getAllJsonResponse() method of class JsonCURDService");
		JsonEntity entity=new JsonEntity();
		return entity.getAllJsonResponse();
	}
}
