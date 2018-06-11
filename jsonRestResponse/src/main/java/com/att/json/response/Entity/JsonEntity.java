package com.att.json.response.Entity;

import java.util.Arrays;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

public class JsonEntity {
	
	

	//Static initializer block
	public JsonObjectBuilder getAllJsonResponse() {
		
		  JsonArrayBuilder arrayBuilder;
		//array of key-value pairs
         arrayBuilder = Json.createArrayBuilder();
         int[] numbers = {1,1,2,3,5,8,13};
        // create each key-value pair as seperate object and add it to the array also need to define all the key as constants 
         //FIRST POINT :: The rest endpoint will emit an array of JSON documents, each JSON document will be a complete flat (non nested) record.
         arrayBuilder.add(Json.createObjectBuilder().add("key1", "java").add("key2", "j2ee").add("key3", "Spring").build());
         arrayBuilder.add(Json.createObjectBuilder().add("key4", "spring boot").add("key5", "microservices").add("key6", "struts").build());
         //THIRD POINT :: There will be a json array of integers with the key of "numbers", 
         //sum all of the integers and display the sum on standard out, add that sum to a running total for the program
         arrayBuilder.add(Json.createObjectBuilder().add("numbers",Arrays.toString(numbers)).build());
         JsonArray contactsArr = arrayBuilder.build();
         // add contacts array object
         JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
         jsonBuilder.add("ArrayJSON", contactsArr);
         return jsonBuilder;
         
	}
	
	

}
