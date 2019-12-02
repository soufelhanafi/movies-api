package com.movies.api.model;

public enum Genre {
	ACTION("action"),ADVENTURE("adventure"),ANIMATION("animation"),COMEDY("comedy"),CRIME("crime"),
	DRAMA("drama"),HISTORICAL("historical"),HORROR("horror"),MUSICAL("musical"),SCIFIC("science fiction"),WAR("war"),WESTERN("western");
	
	private String title;
	
	Genre(String title){
		this.title = title;
	}
	
	String getTitle() {
		return title;
	}
}
