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


2.post request body creating using Org.json
3. post request body creation using POJO class
4.post request body creation using external json file data


*/
public class SendPostRequiestUsingHashMap {

	// 1.post request body creation using Hashmap
	
	
	String id;
	
	@Test(priority = 1)
	public void postUsingHashMap() {
		
		HashMap data = new HashMap();
		
		//post data
		data.put("name","Ramana");
		data.put("location","Manchester");
		data.put("phone","98765");
		
		String courseArr[]= {"java","python"};
		data.put("courses",courseArr);
		
		id=given()
			.contentType("Application/json")
			.body(data)

		.when()
			.post("http://localhost:3000/students")
			.jsonPath().getString("id");
		/*
		.then()
			.statusCode(201)
			.body("name",equalTo("Ramana"))
			.body("location",equalTo("Manchester"))
			.body("courses[0]",equalTo("java"))
			.body("courses[1]",equalTo("python"))
			.header("Content-type","application/json")
			.log().all();
		*/
	
	
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






















