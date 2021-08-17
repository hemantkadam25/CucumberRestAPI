package methods;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.restassured.internal.http.Status;
import io.restassured.response.Response;
import parallel.Base;
import pojo.Location;
import pojo.PlacePayload;


public class PlaceAPI extends Base {
	
	public static String placeId1;
	
	PlacePayload addPlacePayload1 = new PlacePayload();	
	
public PlacePayload setPayload(String name, String address, String phone_number, String accuracy, String website, String language) {
		
		Location location = new Location();
		location.setLat(-25.383494);
		location.setLng(30.427362);		
		addPlacePayload1.setLocation(location);
		
		addPlacePayload1.setAccuracy(100);		
		addPlacePayload1.setName(name);
		addPlacePayload1.setPhone_number("(+91) 983 893 3937");
		addPlacePayload1.setAddress(address);
		
		List<String> typesList = new ArrayList<String>();
		typesList.add(0, "Jungle park");
		typesList.add(1, "Shoe shop");		
		addPlacePayload1.setTypes(typesList);
		addPlacePayload1.setWebsite("http://www.google.com");
		addPlacePayload1.setLanguage("English");
		
		return addPlacePayload1;		
	}
	
	public void addPlace() throws IOException {
		
		Response response = given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(addPlacePayload1)
		.when().post(getConfigValue("AddPlaceBasePath"))
		.then()
		.extract().response();		
		setResponse(response);
	}
	
	public String getPlaceID() throws IOException {
		
		addPlace();	
		String placeId = getStringValue(getResponse().asString(), "place_id");
		return placeId;		
	}	
	
    public void getPlace () throws IOException {
	
    	String placeId = getPlaceID();	
	    Response response = given().queryParam("key", "qaclick123").queryParam("place_id", placeId)
			.header("Content-Type", "application/json")
			.when().get(getConfigValue("GetPlaceBasePath"))
			.then()
			.extract().response();	
	       	setResponse(response);			
	}
    
    
     public void deletePlace () throws IOException {
	
    	String placeId = getPlaceID();	
	    Response response = given().queryParam("key", "qaclick123")
			.header("Content-Type", "application/json")
			.body(addPlacePayload1.deletePlacePayload(placeId))
			.when().post(getConfigValue("DeletePlaceBasePath"))
			.then()
			.extract().response();	
	         setResponse(response);				
	}
   
   public void updatePlace (String updateAddress) throws IOException {
		
	   placeId1 = getPlaceID();		
	   Response response = given().queryParam("key", "qaclick123").queryParam("place_id", placeId1)
				.header("Content-Type", "application/json")
				.body(addPlacePayload1.updatePlacePayload(placeId1, updateAddress))
				.when().put(getConfigValue("UpdatePlaceBasePath"))
				.then()
				.extract().response();			
		         setResponse(response);		     			
		}
   
   public void getVerifyValueUsingGetPlaceAPI () throws IOException { 
   	
	   Response response = given().queryParam("key", "qaclick123").queryParam("place_id", placeId1)
	   			.header("Content-Type", "application/json")
	   			.when().get(getConfigValue("GetPlaceBasePath"))
	   			.then()
	   			.extract().response();	   
	            setResponse(response);	 
	              			
	   	}
   
   


	

}
