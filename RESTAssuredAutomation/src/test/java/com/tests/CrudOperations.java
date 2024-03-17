/**
 * 
 */
package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


/**
 * @author prasadkondeti
 *
 */


public class CrudOperations {
	
	@Test
	public void test_page() {
		Response res= get("https://reqres.in/api/users?page=2");
	
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		System.out.println(res.getBody().asString());
		System.out.println(res.getStatusLine());
		System.out.println(res.getHeader("content-type"));
		
		//Status code validation
		int statusCode= res.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	
	@Test
	public void test_users() {
		Response res= get("https://reqres.in/api/users/2");
	
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		System.out.println(res.getBody().asString());
		System.out.println(res.getStatusLine());
		System.out.println(res.getHeader("content-type"));
		
		//Status code validation
		int statusCode= res.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	
	@Test
	public void test_GetReq() {
		
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[5].id",equalTo(12));
		
	}

}
