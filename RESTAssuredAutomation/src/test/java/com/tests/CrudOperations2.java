package com.tests;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

/**
 * @author prasadkondeti
 *
 */


public class CrudOperations2 {
	
	@Test
	public void GetScenario() {
		
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users/2").
			
		then().
			statusCode(200).
			body("data.last_name ",equalTo("Weaver"));
		
	
		
		
		
			
	}

}
