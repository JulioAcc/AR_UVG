package com.uvg.ar.posts;

import java.util.List;

import com.parse.ParseObject;

public class PostUtilities {

	public static Post[] listToPosts(List<ParseObject> list){
		Post[] posts = new Post[list.size()];
		for(int i = 0; i < list.size(); i++){
			Post post = new Post();
			ParseObject obj = list.get(i);
			post.setId(obj.getObjectId());
			post.setUserId(obj.getString(Post.USER_ID_TOKEN));
			post.setLatitude(obj.getDouble(Post.LATITUDE_TOKEN));
			post.setLongitude(obj.getDouble(Post.LONGITUDE_TOKEN));
			post.setAltitude(obj.getDouble(Post.ALTITUDE_TOKEN));
			post.setTitle(obj.getString(Post.TITLE_TOKEN));
			post.setContent(obj.getString(Post.CONTENT_TOKEN));
			posts[i] = post;
		}
		return posts;
	}
	
}
