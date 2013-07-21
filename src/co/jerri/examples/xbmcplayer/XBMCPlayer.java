package co.jerri.examples.xbmcplayer;


import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import co.jerri.examples.xbmcplayer.Connector;

import android.util.Log;

import java.lang.String;


public class XBMCPlayer extends Activity
{

	private static final String TAG = "XBMCPlayer";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        playIntent();
        setContentView(R.layout.main);
    }

    public void playIntent()
    {
    	Intent intent = getIntent();
        if (intent == null) {
        	return;
        }

        String url = intent.getStringExtra(Intent.EXTRA_TEXT);
        if(url == null) {
        	Log.v(TAG, "Intent but no url");
        	return;
        }
        Log.d(TAG, "playing: " + url);
		new Connector().execute(url);
	    Log.d(TAG, "yay");
	}
}
