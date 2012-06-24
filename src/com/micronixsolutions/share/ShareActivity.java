package com.micronixsolutions.share;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class ShareActivity extends Activity {
	private static final String TAG = "JCShare";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	// Get intent, action and MIME type
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if (type.startsWith("image/")) {
            	Uri fileUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
            	Log.d(TAG, fileUri.toString());
            }
        }
        
        //Setup the views and stuff
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}