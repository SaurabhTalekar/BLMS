package com.comcast.crm.generic.fileuility;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	
	public String getDataFromJsonFile(String key) throws Throwable, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("./TestData/appCommondataJson.json"));
		JSONObject map = (JSONObject)obj;
		String data = (String) map.get(key);
		return data; 
		
	}

}
