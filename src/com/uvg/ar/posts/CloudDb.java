package com.uvg.ar.posts;

import java.util.List;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.uvg.ar.posts.Post;

public class CloudDb {
		
	List<ParseObject> list;

	public void uploadPost(Post post, SaveCallback callback){
		ParseObject postObj = new ParseObject(Post.POST_TOKEN);
		postObj.put(Post.USER_ID_TOKEN, post.getUserId());
		postObj.put(Post.TITLE_TOKEN, post.getTitle());
		postObj.put(Post.CONTENT_TOKEN, post.getContent());
		postObj.put(Post.LATITUDE_TOKEN, post.getLatitude());
		postObj.put(Post.LONGITUDE_TOKEN, post.getLongitude());
		postObj.put(Post.ALTITUDE_TOKEN, post.getAltitude());
		
		postObj.saveEventually(callback);
	}
	
	public void uploadPost(Post post){
		ParseObject postObj = new ParseObject(Post.POST_TOKEN);
		postObj.put(Post.USER_ID_TOKEN, post.getUserId());
		postObj.put(Post.TITLE_TOKEN, post.getTitle());
		postObj.put(Post.CONTENT_TOKEN, post.getContent());
		postObj.put(Post.LATITUDE_TOKEN, post.getLatitude());
		postObj.put(Post.LONGITUDE_TOKEN, post.getLongitude());
		postObj.put(Post.ALTITUDE_TOKEN, post.getAltitude());
		
		postObj.saveEventually();
	}
	
	public List<ParseObject> downloadPosts(String userId){
		list = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery(Post.POST_TOKEN);
		query.whereEqualTo(Post.USER_ID_TOKEN, userId);
		query.findInBackground(new FindCallback<ParseObject>() {
	
			@Override
			public void done(List<ParseObject> tempList, ParseException e) {
				// TODO Auto-generated method stub
				 if (e == null) {
					 list = tempList;
			     } else {
			    	 Log.d("score", "Error: " + e.getMessage());
			     }
			}
		});
		
		return list;
	}
	
	public List<ParseObject> downloadPosts(){
		list = null;
		ParseQuery<ParseObject> query = ParseQuery.getQuery(Post.POST_TOKEN);
		query.findInBackground(new FindCallback<ParseObject>() {
	
			@Override
			public void done(List<ParseObject> tempList, ParseException e) {
				// TODO Auto-generated method stub
				 if (e == null) {
					 list = tempList;
			     } else {
			    	 Log.d("score", "Error: " + e.getMessage());
			     }
			}
		});
		
		return list;
	}
	
}
