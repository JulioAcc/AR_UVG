package com.uvg.ar.posts;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.uvg.ar.R;
import com.uvg.ar.map.MapActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PostCreation extends Activity {

	CloudDb cloud;
	
	Context context;
	
	private SaveCallback callback;
	
	private double longitude, latitude, altitude;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.post_creation);
		
		context = this;
		
		Bundle bundle = getIntent().getExtras();
		/*latitude = bundle.getDouble("latitude");
		longitude = bundle.getDouble("longitude");
		altitude = bundle.getDouble("altitude");*/
		
		latitude = 55.501231;
		longitude = 12.12313;
		altitude = 12.23421;
		
		cloud = new CloudDb();
		
		callback = new SaveCallback(){

			@Override
			public void done(ParseException e) {
				// TODO Auto-generated method stub
				
				if( e == null){
					Toast.makeText(context, "The post was succesfully uploaded." , Toast.LENGTH_LONG).show();
					Intent i = new Intent(context, MapActivity.class);
			        startActivity(i);
				}else{
					Toast.makeText(context, "There was a problem with the upload. Please, try again." , Toast.LENGTH_LONG).show();
				}
			}
			
		};
		
	
	}
	
	public void cancelUpload(View v){
		Intent i = new Intent(this, MapActivity.class);
        startActivity(i);
	}
	
	public void uploadPost(View v){
		Post post = new Post();
		post.setUserId(ParseUser.getCurrentUser().getObjectId());
		post.setLatitude(latitude);
		post.setLongitude(longitude);
		post.setAltitude(altitude);
		post.setTitle(((EditText)this.findViewById(R.id.edit_title)).getText().toString());
		post.setContent(((EditText)this.findViewById(R.id.edit_content)).getText().toString());
		cloud.uploadPost(post, callback);
		Toast.makeText(context, "Post is being uploaded. Please wait." , Toast.LENGTH_LONG).show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}
	
}
