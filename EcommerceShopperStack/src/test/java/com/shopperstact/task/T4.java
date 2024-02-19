package com.shopperstact.task;

import org.testng.annotations.Test;

import com.shopperstack.pojos.Reqres_CreateUser_PojoData;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class T4 
{
	@Test
	public void createUser()
	{
		Reqres_CreateUser_PojoData data=new Reqres_CreateUser_PojoData();
		data.setName("Anvesh");
		data.setRole("TestLead");
		RestAssured.given()
					.contentType(ContentType.JSON)
					.body(data)
					.when()
					.post("https://reqres.in/api/users")
					.then().log().all();
	}

}
