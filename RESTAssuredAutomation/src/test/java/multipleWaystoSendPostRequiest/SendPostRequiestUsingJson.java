package multipleWaystoSendPostRequiest;


import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;

import java.util.HashMap;

/*
Different ways to create POST Request body

3. post request body creation using POJO class
4.post request body creation using external json file data


*/
public class SendPostRequiestUsingJson {

//2.post request body creating using Org.json
	
	
	String id;

	
	@Test(priority = 1)
	public void testPostUsingJson() {
		
		
		JSONObject data = new JSONObject();
		
		data.put("name","Lathasri");
		data.put("locatio","India");
		data.put("phone","999888666");
		
		String courseArr[] = {"javascript","typescript"};
		data.put("courses",courseArr);
		
		id=given()
			.contentType("Application/json")
			.body(data.toString())
		
		
		.when()
			.post("http://localhost:3000/students")
			.jsonPath().getString("id");
		
		//.then()	
		//	.statusCode(201)
		//	.body("name",equalTo("Lathasri"));
			
		
	}


	//delete record
	@Test(priority = 2)
	public void testDelete() {
		
		given()
		
		.when()
			.delete("http://localhost:3000/students/"+id)
			
		.then()
			.statusCode(200);
		
	}
	
	
	
}






















