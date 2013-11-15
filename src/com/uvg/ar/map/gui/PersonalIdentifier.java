package com.uvg.ar.map.gui;

import com.uvg.ar.map.gps.GPSUtilities;

import android.graphics.Canvas;

public class PersonalIdentifier extends Identifier{
	
	// the draw method which draws the corresponding frame
	public void draw(Canvas canvas) {
		// where to draw the sprite
		canvas.drawCircle(GPSUtilities.getXFromCoordinates(getLatitude(), getLongitude()), 
				GPSUtilities.getYFromCoordinates(getLatitude(), getLongitude()), getRadius(), getPaint());
	}
	
	public void update(){
		updatePaint();
	}
}