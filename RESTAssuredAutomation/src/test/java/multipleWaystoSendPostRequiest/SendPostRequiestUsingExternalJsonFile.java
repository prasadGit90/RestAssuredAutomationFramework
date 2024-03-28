package multipleWaystoSendPostRequiest;

import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;



//3. post request body creation using External json file

public class SendPostRequiestUsingExternalJsonFile {

	String id;
	@Test(priority = 1)
	public void testPostUsingExternalJsonFile() throws FileNotFoundException
	
	{
		File f =new File("/Users/prasadkondeti/git/RestAssuredAutomationFramework/RESTAssuredAutomation/body.json");
		
		FileReader fr= new FileReader(f);
		
		JSONTokener jt=new JSONTokener(fr);
		
		JSONObject data = new JSONObject(jt);
		
		
		
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






















