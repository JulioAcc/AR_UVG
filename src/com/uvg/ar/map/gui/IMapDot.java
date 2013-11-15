package com.uvg.ar.map.gui;

import android.graphics.Canvas;

public interface IMapDot {

	public static final String TAG = IMapDot.class.getSimpleName();
	
	public void draw(Canvas canvas);
		
	public void update(double latitude, double longitude);
		
	public void update();

	public double getLatitude();

	public void setLatitude(double latitude);

	public double getLongitude();

	public void setLongitude(double longitude);

	public float getRadius();
	
	public void setRadius(float radius);
	
}
