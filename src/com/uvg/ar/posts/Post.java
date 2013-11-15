package com.uvg.ar.posts;

import android.location.Location;

public class Post {

	public static final String POST_TOKEN = "post";

	public static final String USER_ID_TOKEN = "user_id";
	
	public static final String TITLE_TOKEN = "title";
	public static final String CONTENT_TOKEN = "content";
	
	public static final String LATITUDE_TOKEN = "latitude";
	public static final String LONGITUDE_TOKEN = "longitude";
	public static final String ALTITUDE_TOKEN = "altitude";
	
	private String id, user_id;
	private double longitude, latitude, altitude;
	private String title, content;
	
	public Post(String id, String user_id, Location location, String title, String content){
		this.id = id;
		this.user_id = user_id;
		this.longitude = location.getLongitude();
		this.latitude = location.getLatitude();
		this.altitude = location.getAltitude();
		this.title = title;
		this.content = content;
	}
	
	public Post(){
		this.id = null;
		this.user_id = null;
		this.longitude = 0;
		this.latitude = 0;
		this.altitude = 0;
		this.title = null;
		this.content = null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return user_id;
	}

	public void setUserId(String user_id) {
		this.user_id = user_id;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
