/**
 * 
 */
package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.*;
import io.restassured.response.Response;


/**
 * @author prasadkondeti
 *
 */


public class CrudOperations {
	
	@Test
	public void test_1() {
		Response res=RestAssured.get("https://reqres.in/api/users?page=2");
	
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
	public void test_2() {
		Response res=RestAssured.get("https://reqres.in/api/users/2");
	
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		System.out.println(res.getBody().asString());
		System.out.println(res.getStatusLine());
		System.out.println(res.getHeader("content-type"));
		
		//Status code validation
		int statusCode= res.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

}
