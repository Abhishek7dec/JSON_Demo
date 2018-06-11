package com.att.consume.restServices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.att.consume.constant.Constant;
import com.att.consume.util.helper.UtilHelper;
/**
 * This class is used for the calling the rest call.
 * @author abhis
 *
 */
public class ConsumeRestCall {
	
	String restCallResponse;
	private static ConsumeRestCall instance = null;
	
	private ConsumeRestCall() {
	      // private cunstructor
	   }
	
	public static ConsumeRestCall getInstance() {
	      if(instance == null) {
	         instance = new ConsumeRestCall();
	      }
	      return instance;
	   }
	
	/**
	 * Getting the response from the rest api and storing in the string.
	 * @return String
	 */
	public String getRestCallResponse() {
		
		URL url = null;
		HttpURLConnection conn = null;
		if(null!=restCallResponse) {
			return restCallResponse;
		}

		try {
			url = new URL(UtilHelper.getRestURL());
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(Constant.GET);
			conn.setRequestProperty(Constant.ACCEPT, Constant.APPLICATION_JSON);
			if (conn.getResponseCode() == Constant.TWO_HUN) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

				while ((restCallResponse = br.readLine()) != null) {
					return restCallResponse;
				}

			} else {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			conn.disconnect();
		}
		return null;
	}
}
