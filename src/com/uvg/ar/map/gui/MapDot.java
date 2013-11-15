package com.uvg.ar.map.gui;

import android.graphics.Paint;

public abstract class MapDot implements IMapDot{

	private double latitude, longitude;
	
	private float radius;
	
	private Paint paint;
	
	public MapDot(){
		this.latitude = 0;
		this.longitude = 0;
		
		this.radius = 6;
		
		paint = new Paint();
		paint.setARGB(0, 255, 0, 0);
	}
	
	@Override
	public void update(double latitude, double longitude) {
		// TODO Auto-generated method stub
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}
	
}
