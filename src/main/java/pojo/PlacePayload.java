package pojo;

import java.util.List;

public class PlacePayload {	
	
	private Location location;
	private int accuracy;
	private String name;
	private String phone_number;
	private String address;
	private List<String> types;
	private String website;
	private String language;
	
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> typesList) {
		this.types = typesList;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	

	
		
	
	public String addPlacePayload() {
		
		String addPlacePayload = "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "";
		
		return addPlacePayload;
		
	}
	
	public String deletePlacePayload(String place_id) {
		String deletePlacePayload = "{\r\n"
				+ "    \"place_id\":\""+place_id+"\"\r\n"
				+ "}";
		
		return deletePlacePayload;
	}
	
	public String updatePlacePayload(String place_id, String updateAddress) {
		String updatePlacePayload = "{\r\n"
				+ "\"place_id\":\""+place_id+"\",\r\n"
				+ "\"address\":\""+updateAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}";
		
		return updatePlacePayload;
	}

}
