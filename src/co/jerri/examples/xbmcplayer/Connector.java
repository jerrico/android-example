package co.jerri.examples.xbmcplayer;

import java.net.HttpURLConnection;
import java.io.BufferedInputStream;
import java.net.URL;

import android.util.Log;
import android.os.AsyncTask;

import java.lang.String;


public class Connector extends AsyncTask<String, Void, Void> {

	private static final String TAG = "XBMCPlayerConnector";
	private static final String BASEPATH = "/jsonrpc?request={\"jsonrpc\":\"2.0\",\"id\":\"1\",\"method\":\"Player.Open\",\"params\":{\"item\":{\"file\":\"%s\"}}}";

    protected Void doInBackground(String... urls) {

        String url = urls[0];

		HttpURLConnection urlConnection;

		try {
	    	URL requestUrl = new URL("http", "192.168.178.29", 8080, String.format(BASEPATH, url));
	    	urlConnection = (HttpURLConnection) requestUrl.openConnection();
	    	Log.d(TAG, requestUrl.toString());
		} catch (java.io.IOException enf) {
		   	Log.e(TAG, "formation of URL failed");
		   	return null;
		}

	    try {    
		    BufferedInputStream in = new BufferedInputStream(urlConnection.getInputStream());
		} catch (java.io.IOException enf) {
		   	Log.e(TAG, "connection failed: %s".format(enf.toString()));
		} finally {
		    urlConnection.disconnect();
	   	}
	   	return null;
    }
}