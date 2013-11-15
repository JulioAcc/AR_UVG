package com.uvg.ar;

import com.uvg.ar.posts.Post;

import android.app.Activity;
import android.os.Bundle;

public class Wikitude extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.post_creation);
		
		Post[] posts = null;
		
		for(int i = 0 ; i < posts.length; i++){
			
		}
	
	}
	
	private void callJavaScript(final String methodName, final String[] arguments) {
		final StringBuilder argumentsString = new StringBuilder("");
		for (int i= 0; i<arguments.length; i++) {
			argumentsString.append(arguments[i]);
			if (i<arguments.length-1) {
				argumentsString.append(", ");
			}
		}
		
		/*if (this.architectView!=null) {
			final String js = ( methodName + "( " + argumentsString.toString() + " );" );
			this.architectView.callJavascript(js);
		}*/
	}
}
