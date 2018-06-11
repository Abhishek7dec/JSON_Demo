package com.att.consume.util.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.att.consume.constant.Constant;
import com.att.consume.restServices.ConsumeRestCall;

public class UtilHelper {

	/** method is used for the getting the value from the properties file.
	 * @return String
	 */
	public static String getRestURL() {
		String restURL = null;
		Properties prop = new Properties();
		InputStream input = null;

		try {
			StringBuffer userDir= new StringBuffer(System.getProperty(Constant.USER_DIR));
			input = new FileInputStream(userDir.append(Constant.CONFIG_FILE_LOCATION).toString());
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			restURL = prop.getProperty(Constant.RESTURL);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return restURL;
	}
	/**
	 * this method is used for creating the object of the ConsumeRestCall class method and calling the REST call and 
	 * then storing the value in String
	 * @return JSONObject
	 */
	public static JSONObject getRestCallinJSON() {
		JSONParser parser = new JSONParser();
		Object obj;
		JSONObject object = null;
		try {
			
			ConsumeRestCall consumeRestCall = ConsumeRestCall.getInstance();
			String response = consumeRestCall.getRestCallResponse();
			obj = parser.parse(response);
			object = (JSONObject)obj;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return object;
	}
	/**
	 * this method used for performing the operation as adding the all element and adding the all element
	 * @param str
	 */
	public static void performAddOperaton(String str) {
		str=str.substring(Constant.ONE, str.length()-Constant.ONE);
		Integer total = 0;
		String[] items = str.split(",");
		List<String> itemList = Arrays.asList(items);
		System.out.println("Count of the Integer valus from numbers array::--->"+itemList.size());
		StringUtils.stripAll(items);
		for (int i = Constant.ZERO; i < items.length; i++) {
			//System.out.println(items[i].toString());
			total += Integer.parseInt(items[i].trim());
		}
		System.out.println("total addition value from numbers array ::-->"+total);
	}
	
	/**
	 * For each document display all of the keys of the JSON in standard out
	 * @return
	 */
	public static List fatchingOnlyKeyfromJSONResponse() {
		
		JSONObject response = UtilHelper.getRestCallinJSON();
		JSONArray array = (JSONArray) response.get(Constant.ARRAY_JSON);
			Iterator<Object> iterator = array.iterator();
			List<String> keyList=new ArrayList<>();
			while(iterator.hasNext()){
			    JSONObject jsonObject = (JSONObject) iterator.next();
			    for(Object key : jsonObject.keySet()){
			    	keyList.add(key.toString());
			    }
			}
		return keyList;
		
	}
	
	/**
	 * Display the total of the integers that were summed for the execution
	 * @return
	 */
	public static String getTotalOfInteger(){
		JSONObject response = UtilHelper.getRestCallinJSON();
		JSONArray array = (JSONArray) response.get(Constant.ARRAY_JSON);
		Iterator<Object> iterator = array.iterator();
		Object list=new Object();
		while(iterator.hasNext()){
		    JSONObject jsonObject = (JSONObject) iterator.next();
		    for(Object key : jsonObject.keySet()){
		    	if(key.toString().equals(Constant.NUMBERS)) {
		    		list =jsonObject.get(Constant.NUMBERS);
		    		
		    	}
		    }
		}
		UtilHelper.performAddOperaton(list.toString());
		return null;
	}
}
