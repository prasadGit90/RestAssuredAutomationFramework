package parcingJsonResponseday4;

import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class parsingJSONResponse {

	@Test
	public void testJsonResponse() {
		
		//approch1
		
		given()
			.contentType("application/json")
		
		
		.when()
			.get("http://localhost:3000/store")
		
		.then()
			.statusCode(200)
			.header("content-Type","application/json")
			.body("book[1].title",equalTo("Sword of Honour"));
			
	}	
		/*	
			//Aproch2
		Response res = given()
			.contentType("ontentType.JSON")
			
		.when()
		.get("http://localhost:3000/store");
		
		Assert.assertEquals(res.getStatusCode(),200);  //validartion1
		Assert.assertEquals(res.header("Content-Type"),"applicaiton/json");
		
		String bookname=res.jsonPath().get("book[1].title").toString();
		Assert.assertEquals(bookname,"Sword of Honour");
		
	}
	*/
}
