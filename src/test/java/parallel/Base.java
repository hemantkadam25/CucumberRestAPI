package parallel;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Base {

	
	public static ThreadLocal<Response> threadLocalResponse = new ThreadLocal<Response>();	
	public static ThreadLocal<Logger> threadLocalLog = new ThreadLocal<Logger>();
	
	public void initialization() throws IOException  {

		threadLocalLog.set(Logger.getLogger(Base.class.getName()));		
	}
	
	public static synchronized Logger getLog() {
		return threadLocalLog.get();
	}
	
	
	public static synchronized void setResponse(Response response) {
		threadLocalResponse.set(response);
	}
	
	
	public static synchronized Response getResponse() {
		return threadLocalResponse.get();
	}
		
	public String getConfigValue(String configValue) throws IOException {
		
		String projectPath = System.getProperty("user.dir");
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(projectPath + "\\src\\main\\java\\configFiles\\config.properties");
		properties.load(fileInputStream);
		return properties.getProperty(configValue);
	}
	
	public void getVerifyStringValue(String response, String key, String value) {
		
		JsonPath jsonpath = new JsonPath(response);
		Assert.assertEquals(jsonpath.getString(key), value);		
	}
	
	public void getVerifyString(String response, String key) {
		
		JSONObject jsonObject = new JSONObject(response);
		Assert.assertTrue(jsonObject.has(key));
		
	}
	
   public String getStringValue(String response, String key) {
		
	   JsonPath jsonpath = new JsonPath(response);
	   return jsonpath.getString(key);		
		
	}
	
	


}
