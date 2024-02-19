package com.shopperstact.task;

import org.testng.annotations.Test;

import com.shopperstack.pojos.PetStoreTags;
import com.shopperstack.pojos.PetStore_Category;
import com.shopperstack.pojos.PetStore_Petinfo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class T5 
{
	@Test
	public void addPetInfo()
	{
		PetStore_Category category=new PetStore_Category();
		category.setId(1);
		category.setName("Shitzu");
		PetStore_Petinfo data=new PetStore_Petinfo();
		data.setId(1);
		data.setCategory(category);
		data.setName("Subhu");
		String[] url= {"http://www.google.com"};
		data.setPhotoUrls(url);
		PetStoreTags tags=new PetStoreTags();
		tags.setId(1);
		tags.setName("Male");
		Object[] tagdata= {tags};
		data.setTags(tagdata);
		data.setStatus("available");
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.body(data)
		.when()
		.post("https://petstore.swagger.io/v2/pet")
		.then().log().all();
		
		
	}

}
