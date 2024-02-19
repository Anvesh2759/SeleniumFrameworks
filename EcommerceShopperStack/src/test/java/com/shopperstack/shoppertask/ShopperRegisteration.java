package com.shopperstack.shoppertask;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.shopperstack.pojos.CreateUser;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ShopperRegisteration 
{
	String userid;
	@Test
	public void createUser()
	{
		Response responsebody = given()
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "  \"city\": \"pune\",\r\n"
				+ "  \"country\": \"India\",\r\n"
				+ "  \"email\": \"tester17@gmail.com\",\r\n"
				+ "  \"firstName\": \"Anvesh\",\r\n"
				+ "  \"gender\": \"MALE\",\r\n"
				+ "  \"lastName\": \"kumar\",\r\n"
				+ "  \"password\": \"tester17@123\",\r\n"
				+ "  \"phone\": 7884654351,\r\n"
				+ "  \"state\": \"Maharastra\",\r\n"
				+ "  \"zoneId\": \"ALPHA\"\r\n"
				+ "}")
		.when()
		.post("https://www.shoppersstack.com/shopping/shoppers?zoneId=ALPHA");
		responsebody.then().log().all();
		//get data from responsebody
		userid=responsebody.jsonPath().getString("data.userId");
		System.out.println(userid);	
	}





}












