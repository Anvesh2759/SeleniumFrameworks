package com.shopperstack.shoppertask;

import java.util.HashMap;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.shopperstack.pojos.ShopperLogin;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestShopperLogin 
{
	String userid;
	String jwttoken;
	String productid_01;
	String productid_02;
	String itemid;
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
		int size = responsebody.jsonPath().getInt("data.size()");
		/*for(int a=0;a<size-1;a++)
		{
			String productid = responsebody.jsonPath().getString("data["+a+"].productId");
			String title = responsebody.jsonPath().getString("data["+a+"].title");
			System.out.println(productid+"  -  "+title);
		}*/
		productid_01=responsebody.jsonPath().getString("data[0].productId");
		productid_02=responsebody.jsonPath().getString("data[1].productId");
		System.out.println("Product id is -"+productid_01);
	}
	@Test(priority =3)
	public void addProductToWishList()
	{
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("productId",productid_01);
		map.put("quantity", 1);
		Response responsebody = RestAssured.given()
					.contentType(ContentType.JSON)
					.header("Authorization", "Bearer "+jwttoken+"")
					.pathParam("shopperid", userid)
					.body(map)
					.when()
					.post("https://www.shoppersstack.com/shopping/shoppers/{shopperid}/wishlist");
		itemid=responsebody.jsonPath().getString("data.itemId");
		System.out.println("Item Id is -"+itemid);
		}
	
	@Test(priority = 4)
	public void viewProductInWishList()
	{
		Response responsebody = RestAssured.given()
				.header("Authorization", "Bearer "+jwttoken+"")
				.pathParam("shopperid", userid)
				.when()
				.get("https://www.shoppersstack.com/shopping/shoppers/{shopperid}/wishlist");
		int wishlistcount = responsebody.jsonPath().getInt("data.size()");
		System.out.println("Total products in Wishlist "+wishlistcount);
	}
	@Test(priority = 5)
	public void deleteProductFromWishList()
	{
		Response responsebody = RestAssured.given()
				.header("Authorization", "Bearer "+jwttoken+"")
				.pathParam("shopperid", userid)
				.pathParam("productid", productid_01)
				.when()
				.delete("https://www.shoppersstack.com/shopping/shoppers/{shopperid}/wishlist/{productid}");
		responsebody.then().assertThat().statusCode(204);
		System.out.println("Product Deleted from Wishlist");
	}
	
	
}
