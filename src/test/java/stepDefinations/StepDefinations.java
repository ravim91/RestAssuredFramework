package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.location;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.ApiResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinations extends Utils {
	
	RequestSpecification reqspec;
	ResponseSpecification resSpec;
	Response response ;
	static String place_Id;
	TestDataBuild data = new TestDataBuild();
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
	   //RestAssured.baseURI= "https://rahulshettyacademy.com";
		
		reqspec = given().log().all().spec(requestSpecification()).
				body(data.AddPlacePayload(name, language, address));
	}
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String methods) {
	    // Write code here that turns the phrase above into concrete actions
		ApiResources apires=ApiResources.valueOf(resource);
		resSpec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(methods.equalsIgnoreCase("POST"))
		response = reqspec.when().post(apires.getresource());
		else if(methods.equalsIgnoreCase("GET"))
		response = reqspec.when().get(apires.getresource());
		else if(methods.equalsIgnoreCase("POST"))
		response = reqspec.when().post(apires.getresource());
		
		//		then().spec(resSpec).extract().response();
	}
	@Then("the API call got success with status coce {int}")
	public void the_api_call_got_success_with_status_coce(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(response.getStatusCode(),200);
		
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String value) {
	    // Write code here that turns the phrase above into concrete actions
	   
	    assertEquals(getJsonPath(response,keyValue),value);
	}
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
		
		place_Id= getJsonPath(response,"place_id");
	    // prepare request spec
		reqspec = given().log().all().spec(requestSpecification()).queryParam("place_id", place_Id);
		user_calls_with_http_request(resource,"GET");
		String actualName= getJsonPath(response,"name");
		assertEquals(actualName,expectedName);
	}
	
	@Given("Delete Place payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    reqspec = given().spec(requestSpecification()).body(data.DeletePlacePayload(place_Id));
	}

}
