package com.uvg.ar.map;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.uvg.ar.R;
import com.uvg.ar.Wikitude;
import com.uvg.ar.posts.CloudDb;
import com.uvg.ar.posts.Post;
import com.uvg.ar.posts.PostCreation;
import com.uvg.ar.posts.PostList;
import com.uvg.ar.posts.PostUtilities;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MapActivity extends Activity implements LocationListener{
	
	public static int height, width = 0;
	
	private LocationManager locationManager;
	private Location currentLocation;
	
	private Post[] posts;
	
	private CloudDb cloud; 
	
	Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.map_layout);
		
		context = this;
		
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        
        // Define the criteria how to select the location provider -> use
        // default
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        String provider = locationManager.getBestProvider(criteria, false);
        currentLocation = locationManager.getLastKnownLocation(provider);

        // Initialize the location fields
        if (currentLocation != null) {
        	Toast.makeText(this, "Provider " + provider + " has been selected." , Toast.LENGTH_SHORT).show();
        	onLocationChanged(currentLocation);
        } else {
        	Toast.makeText(this, "Provider " + provider + " has been selected but isn't working." , Toast.LENGTH_SHORT).show();
    		Toast.makeText(this, "Latitude: not found" , Toast.LENGTH_SHORT).show();
    		Toast.makeText(this, "Longitude: not found" , Toast.LENGTH_SHORT).show();
        }
        
        Parse.initialize(this, "7hp7x3kMxG3U5Aj4ENNbNd4ZLM2LjvVN1RCuqBkE" , "v432l6b5K519naWd6NN8q9NPdFCrwwQSUsccD8vR");
		ParseFacebookUtils.initialize("1375889272652938");        
        
		ParseFacebookUtils.logIn(this, new LogInCallback() {
			  @Override
			  public void done(ParseUser user, ParseException err) {
			    if (user == null) {
			    	Toast.makeText(context, "Uh oh. The user cancelled the Facebook login." , Toast.LENGTH_LONG).show();
			    } else if (user.isNew()) {
			    	Toast.makeText(context, "User signed up and logged in through Facebook!" , Toast.LENGTH_LONG).show();
			    } else {
			    	Toast.makeText(context, "User logged in through Facebook!" , Toast.LENGTH_LONG).show();
			    }
			  }
		});
		
        cloud = new CloudDb();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		  super.onActivityResult(requestCode, resultCode, data);
		  ParseFacebookUtils.finishAuthentication(requestCode, resultCode, data);
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "Latitude: "+  String.valueOf(location.getLatitude()) , Toast.LENGTH_SHORT).show();
		Toast.makeText(this, "Longitude: "+  String.valueOf(location.getLongitude()) , Toast.LENGTH_SHORT).show();
		Log.d("Latitude", String.valueOf(location.getLatitude()));
		Log.d("Longitude", String.valueOf(location.getLongitude()));
		//mainPanel.update(location);
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		//mainPanel.setOnline(false);
		Toast.makeText(this, "Provider disabled" , Toast.LENGTH_LONG).show();
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		//mainPanel.setOnline(true);
		Toast.makeText(this, "Provider enabled" , Toast.LENGTH_LONG).show();
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
	
	public void viewPosts(View v){
		Intent i = new Intent(this, PostList.class);
        startActivity(i);
	}
	
	public void refreshPosts(View v){
		posts = PostUtilities.listToPosts(cloud.downloadPosts());
		Toast.makeText(this, "General posts: "+String.valueOf(posts.length) , Toast.LENGTH_SHORT).show();
		posts = PostUtilities.listToPosts(cloud.downloadPosts(ParseUser.getCurrentUser().getObjectId()));
		Toast.makeText(this, "My posts: "+String.valueOf(posts.length) , Toast.LENGTH_SHORT).show();
	}
	
	public void goToWikitude(View v){
		Intent i = new Intent(this, Wikitude.class);
        startActivity(i);
	}
	
	public void newPost(View v){
		Intent i = new Intent(this, PostCreation.class);
		if(currentLocation != null){
			i.putExtra("latitude", currentLocation.getLatitude());
			i.putExtra("longitude", currentLocation.getLongitude());
			i.putExtra("altitude", currentLocation.getAltitude());
		}
        startActivity(i);
	}
}
