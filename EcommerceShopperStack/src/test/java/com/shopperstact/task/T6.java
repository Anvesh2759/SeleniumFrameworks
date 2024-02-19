package com.shopperstact.task;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class T6 
{
	@Test
	public void createUser()
	{
		JSONObject obj=new JSONObject();
		obj.put("name", "Anvesh");
		obj.put("job", "Sr.Software Engineer");
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.body(obj.toString())
		.when()
		.post("https://reqres.in/api/users")
		.then().log().all();
		
		
		
		
		
	}

}
