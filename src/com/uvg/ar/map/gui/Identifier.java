package com.uvg.ar.map.gui;

public abstract class Identifier extends MapDot{

	private boolean online, alphaIncreasing;
	
	private int flashingIntensity;
	
	public Identifier(){
		online = true;
		flashingIntensity = 0;
		alphaIncreasing = true;
	}

	private void flash(){
		if(flashingIntensity > 255){
			flashingIntensity = 0;
			alphaIncreasing = !alphaIncreasing;
		}else{
			flashingIntensity++;
		}
	}
	
	protected void updatePaint(){
		flash();
		if(online)
			getPaint().setARGB(getPaint().getAlpha(), 255, 0, 0);
		else
			getPaint().setARGB(getPaint().getAlpha(), 255, 255, 255);
		
		if(alphaIncreasing)
			getPaint().setAlpha(flashingIntensity);
		else
			getPaint().setAlpha(255-flashingIntensity);
	}
	
	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public boolean isAlphaIncreasing() {
		return alphaIncreasing;
	}

	public void setAlphaIncreasing(boolean alphaIncreasing) {
		this.alphaIncreasing = alphaIncreasing;
	}

	public int getFlashingIntensity() {
		return flashingIntensity;
	}

	public void setFlashingIntensity(int flashingIntensity) {
		this.flashingIntensity = flashingIntensity;
	}
}
