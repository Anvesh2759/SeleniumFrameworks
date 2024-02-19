package com.shopperstack.shoppertask;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.shopperstack.pojos.AddProduct;
import com.shopperstack.pojos.ShopperLogin;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestShopperCart 
{
	String userid;
	String jwttoken;
	Integer productid;
	short itemid;
	@Test(priority = 1)
	public void loginToApp()
	{
		ShopperLogin logindata=new ShopperLogin("tester11@gmail.com", "Tester11@123", "SHOPPER");
		Response responsebody = RestAssured.given()
					.contentType(ContentType.JSON)
					.body(logindata)
					.when()
					.post("https://www.shoppersstack.com/shopping/users/login");
		userid=responsebody.jsonPath().getString("data.userId");
		jwttoken=responsebody.jsonPath().getString("data.jwtToken");
		System.out.println("UserID is "+userid);
		
		responsebody.then().assertThat().statusCode(200);
		responsebody.then().assertThat().body("data.firstName", Matchers.equalTo("Anvesh"));	
	}
	@Test(priority = 2)
	public void viewPorductDetails()
	{
		Response responsebody = RestAssured.given()
					.header("Authorization", "Bearer "+jwttoken+"")
					.when()
					.get("https://www.shoppersstack.com/shopping/products?zoneId=ALPHA");
		responsebody.then().assertThat().statusCode(200);
		String id=responsebody.jsonPath().getString("data[3].productId");
		productid=Integer.parseInt(id);
		System.out.println(productid);
	}
	@Test(priority = 3)
	public void addProductToCart()
	{
		AddProduct productdetails=new AddProduct(productid, 1);
		Response responsebody = RestAssured.given()
					.header("Authorization","Bearer "+jwttoken+"")
					.contentType(ContentType.JSON)
					.pathParam("shopperId", userid)
					.body(productdetails)
					.when()
					.post("https://www.shoppersstack.com/shopping/shoppers/{shopperId}/carts");
				itemid=responsebody.jsonPath().getShort("data.itemId");
	}
	
	
	@Test(priority = 5)
	public void viewCartProducts()
	{
		RestAssured.given()
					.header("Authorization","Bearer "+jwttoken+"")
					.pathParam("shopperId", userid)
					.when()
					.get("https://www.shoppersstack.com/shopping/shoppers/{shopperId}/carts")
					.then().log().all();
	}
	
	@Test(priority = 4)
	public void updateCartDetails()
	{
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put("productId", productid);
		map.put("quantity", 2);
		RestAssured.given()
		.header("Authorization","Bearer "+jwttoken+"")
		.contentType(ContentType.JSON)
		.pathParam("shopperId", userid)
		.pathParam("itemId",itemid)
		.body(map)
		.when()
		.put("https://www.shoppersstack.com/shopping/shoppers/{shopperId}/carts/{itemId}")
		.then().log().all();
	}
	
	
	
	
	
	
	
	
	
}
