package com.uvg.ar.map.gps;

public class GPSUtilities {
		    
	public static final double leftBottomLatitude = 14.6058361;
	public static final double leftBottomLongitude = 90.4877361;
	
	public static final double rightTopLatitude = 14.6035611;
	public static final double rightTopLongitude = 90.4910806;
	
	//public static final double height = ;
	
	private static final double gar8Lat = 14.6053528;
	private static final double gar8Lon = 90.4878;
	private static final int gar8X = 33;
	private static final int gar8Y = 614;

	private static final double parLat = 14.6057111;
	private static final double parLon = 90.4888167;
	private static final int parX = 464;
	private static final int parY = 870;

	public static final int Xtot = 1344;
	public static final int Ytot = 918;



	public static float getYFromCoordinates(double lat, double lon, float height, float width){
		float Y = (float)(((((lat-gar8Lat)*(gar8Y-parY))/(gar8Lat-parLat))+gar8Y)*(height/Ytot));
		return Y;
	}

	public static float getXFromCoordinates(double lat, double lon, float height, float width){
		float X = (float)((((lon-gar8Lon)*(gar8X-parX))/(gar8Lon-parLon))+gar8X)*(width/Xtot);
		return X;
	}

	public static double getLatitudeFromCoordinates(float X, float Y, float height, float width){
		double y = Y*(Ytot/height);
		double LAT = (double)(((y-gar8Y)*(gar8Lat-parLat))/(gar8Y-parY))+gar8Lat;
		return LAT;
	}

	public static double getLongitudeFromCoordinates(float X, float Y, float height, float width){
		double x = X*(Xtot/width);
		double LON = (double)(((x-gar8X)*(gar8Lon-parLon))/(gar8X-parX))+gar8Lon;
		return LON;
	}
	
}
