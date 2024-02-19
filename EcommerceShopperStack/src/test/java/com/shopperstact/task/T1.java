package com.shopperstact.task;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class T1
{
	@Test
	public void createUser()
	{
		//simple data
		HashMap<String, String> m1=new HashMap<String, String>();
		m1.put("name", "Anvesh");
		m1.put("job", "lead");
		RestAssured.given()
					.contentType(ContentType.JSON)
					.body(m1)
					.when()
					.post("https://reqres.in/api/users")
					.then().log().all();
		
		
		
		
		
		
		
	}

}
