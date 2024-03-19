/**
 * 
 */
package com.tests;

import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * @author prasadkondeti
 *
 */
public class PostRequest2 {

	@Test
	public void testPostRequest2() {

		// https://reqres.in/api/users

		JSONObject body = new JSONObject();
		body.put("name", "Venkat");
		body.put("job", "Manager");

		// Get Response

		Response response = RestAssured.given().contentType(ContentType.JSON).
				body(body.toString()).post("https://reqres.in/api/users");
		
		response.print();
		
		Assert.assertEquals(response.statusCode(), 201);
		
	}

}
