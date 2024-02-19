package com.shopperstack.pojos;


public class PetStore_Petinfo 
{
	private Integer id;
	private PetStore_Category category;
	private String name;
	private String[] photoUrls;
	private Object[] tags;
	private String status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public PetStore_Category  getCategory() {
		return category;
	}
	public void setCategory(PetStore_Category  category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(String[] photoUrls) {
		this.photoUrls = photoUrls;
	}
	public Object[] getTags() {
		return tags;
	}
	public void setTags(Object[] tags) {
		this.tags = tags;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
