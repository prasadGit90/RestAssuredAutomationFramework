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


//Different ways to create POST Request body

public class SendPostRequiestUsingPojo {

//	3. post request body creation using POJO class

	String id;
	@Test(priority = 1)
	public void testPostUsingPOJO()
	
	{
		Pojo_PostRequest data = new Pojo_PostRequest();
		
		data.setName("Subbu");
		data.setLocation("England");
		data.setPhone("4267826587");
		String corsesArr[]= {"C#","java"};
		data.setCourses(corsesArr);

		
	id=given()
			.contentType("Application/json")
			.body(data)
		
		
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






















