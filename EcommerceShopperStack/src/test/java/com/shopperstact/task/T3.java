package com.shopperstact.task;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class T3 
{
	@Test
	public void addPet()
	{
		HashMap<String, Object> categorydata=new HashMap<String, Object>();
		categorydata.put("id", 1);
		categorydata.put("name","Shitzu");
		
		String[] urls= {"http://www.google.com"};
		
		HashMap<String, Object> tag=new HashMap<String, Object>();
		tag.put("id", 1);
		tag.put("name", "Dog");
		Object[] tagdata= {tag};
		
		HashMap<String, Object> data=new HashMap<String, Object>();
		data.put("id", 1);
		data.put("category", categorydata);
		data.put("name", "Subhu");
		data.put("photoUrls", urls);
		data.put("tags", tagdata);
		data.put("status", "available");
		
		RestAssured.given()
					.contentType(ContentType.JSON)
					.body(data)
					.when()
					.post("https://petstore.swagger.io/v2/pet")
					.then().log().all();
					
		
		
		
		
		
		
		
		
		
		
		
	}

}
