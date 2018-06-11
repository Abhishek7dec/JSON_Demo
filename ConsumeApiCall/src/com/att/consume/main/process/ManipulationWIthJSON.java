package com.att.consume.main.process;
import com.att.consume.util.helper.UtilHelper;
import java.util.List;
/**
 * This is the main class where we are executing all the business logic
 * @author abhis
 *
 */
public class ManipulationWIthJSON {
	
	
	
	
	
	public static void main(String[] args) {
		//All the key from JSON response
		List listofKey = UtilHelper.fatchingOnlyKeyfromJSONResponse();
		System.out.println("LIST OF KEYS::--"+listofKey);
		//total of the integers that were summed for the execution
		 UtilHelper.getTotalOfInteger();
	}
}