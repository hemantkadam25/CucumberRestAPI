package parallel;
import java.io.IOException;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import methods.PlaceAPI;


public class StepDefinations extends Base {
	
	public PlaceAPI placeAPI = new PlaceAPI();	
	
	@Given("I load {string}")
	public void i_load(String expectedBaseURI) throws IOException {
	    
		RestAssured.baseURI=getConfigValue(expectedBaseURI);		
	}
		
	@Given("I load add place payload with {string}, {string}, {string}, {string}, {string}, {string}")
	public void i_load_add_place_payload_with(String name, String address, String phone_number, String accuracy, String website, String language) {
	    
		placeAPI.setPayload(name, address, phone_number, accuracy, website, language);
	}

	@When("I call add place api with post http method")
	public void i_call_add_place_api_with_post_http_method() throws IOException {
	    
		placeAPI.addPlace();		
	}

	
	@Then("I get status code as {int} in response")
	public void i_get_status_code_as_in_response(int statusCode) {	    
	
		Assert.assertEquals(getResponse().getStatusCode(), statusCode);		
	}

	@And("I get {string} as {string} in response")
	public void i_get_as_in_response(String key, String value) {		
		
		getVerifyStringValue(getResponse().asString(), key, value);
	}

	@And("I get {string} in response")
	public void i_get_in_response(String key) {
		
		getVerifyString(getResponse().asString(), key); 		
	}
	
	

	//********Get place API*********
	
	@When("I call get place api with get http method")
	public void i_call_get_place_api_with_get_http_method() throws IOException {
	    
		placeAPI.getPlace();		
	}
	
	
	
	//********Delete place API*********

	@When("I call delete place api with post http method")
	public void i_call_delete_place_api_with_post_http_method() throws IOException {
		placeAPI.deletePlace();		
	}
	
	@And("I verify {string} as {string} in response")
	public void i_verify_as_in_response(String key, String value) {
		getVerifyStringValue(getResponse().asString(), key, value);
	}
	
	//********Update place API*********
	
	@When("I call update place api with {string} request")
	public void i_call_update_place_api_with_request(String updateAddress) throws IOException {
		
		placeAPI.updatePlace(updateAddress);	    
	}
		
	
	@And("I verify {string} is updated to {string} using get place api")
	public void i_verify_is_updated_to_using_get_place_api(String expectedKey, String expectedValue) throws IOException {
	   
		placeAPI.getVerifyValueUsingGetPlaceAPI(expectedKey, expectedValue);
	}

	
	
	
}

	

	

	