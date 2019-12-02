package com.movies.api.model;

public enum Civility {
MR("Mr"), MRS("Mrs");
	
	private String description;
	
	Civility(String description ){
		this.description = description;
	}
	
	String getDescription() {
		return description;
	}
}
