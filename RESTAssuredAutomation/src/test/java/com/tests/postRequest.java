
package com.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

/**
 * @author prasadkondeti
 *
 */
public class postRequest {
	
	@Test
	public void testPostRequest() {
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		/*RestAssured.given().body("{\n"
				+ "    \"name\": \"morpheus\",\n"
				+ "    \"job\": \"leader\"\n"
				+ "}").post().then().log().all().assertThat().statusCode(201); */
		
		//Other way using String and json 
		
		String json = " {\n"
				+ "    \"name\": \"Prasad\",\n"
				+ "    \"job\": \"Software\"\n"
				+ "} ";
		
		RestAssured.
		given().
			body("json").post().
			then().
			log().
			all().
			assertThat().
			statusCode(201);
		
	}

}
