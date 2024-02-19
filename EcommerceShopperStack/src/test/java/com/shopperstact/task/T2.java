package com.shopperstact.task;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class T2 
{
	@Test
	public void getAllBrandsData()
	{
		RestAssured.given()
					.when()
					.get(" https://automationexercise.com/api/productsList")
					.then()
					.log().all();
		}

}
