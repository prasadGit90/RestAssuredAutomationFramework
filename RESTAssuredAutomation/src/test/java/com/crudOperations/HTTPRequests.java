package com.crudOperations;

import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import java.util.HashMap;

import javax.management.InvalidApplicationException;
import io.restassured.http.ContentType;




/**
 * @author prasadkondeti
 *
 */


/*
 prerequisits 
 Given()
 content type,set cookies,add auth,add param,set headers info etc
 
 When()
 
 get ,post ,put ,delete,
 
 then()
 
 Validation status code ,extract response, extract headers and coockies and response body
 
 */


public class HTTPRequests {
	
	
	//global variable for update and delete ID 
	
	int id;

	@Test(priority = 1)
	public void getSingleUser() 
	
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
			
		
	}
	
	@Test(priority = 2)
	public void createUser() {
		
		HashMap data= new HashMap();
		
		data.put("name","Prasad");
		data.put("job","Software");
		
		id=given()
			.contentType("Application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		
		//.then()
		//	.statusCode(201)
		//	.log().all();
		
	}
	
	@Test(priority = 3,dependsOnMethods = {"createUser"})
	public void updateUser() {

		HashMap data= new HashMap();
		data.put("name","James");
		data.put("job","AutomationEngineer");
		
		given()
			.contentType("Application/json")
			.body(data)
		.when()
			.put("https://reqres.in/api/users/"+id)
			
		
		.then()
			.statusCode(200)
			.log().all();
		
		
	}
	@Test(priority = 4)
	public void deleteUser() {
		
		
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
		
			.statusCode(204)
			.log().all();
		
		
	}
	
	

}
