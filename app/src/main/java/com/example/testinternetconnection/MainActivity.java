package com.example.testinternetconnection;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Button btnCheck = (Button) findViewById(R.id.Check);
		btnCheck.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				isInternetOn();
			}

			
		});
	}

	protected boolean isInternetOn() {

		ConnectivityManager connec = (ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
		
		//check for network connections
		if(connec.getNetworkInfo(0).getState()== android.net.NetworkInfo.State.CONNECTED||
				connec.getNetworkInfo(0).getState()== android.net.NetworkInfo.State.CONNECTING||	
				connec.getNetworkInfo(1).getState()== android.net.NetworkInfo.State.CONNECTING||
				connec.getNetworkInfo(1).getState()== android.net.NetworkInfo.State.CONNECTED){
			
			Toast.makeText(this, "Connected", Toast.LENGTH_LONG).show();
			return true;
		}else if (connec.getNetworkInfo(0).getState()== android.net.NetworkInfo.State.DISCONNECTED||
				connec.getNetworkInfo(1).getState()== android.net.NetworkInfo.State.DISCONNECTED){
			Toast.makeText(this, "Not Connected", Toast.LENGTH_LONG).show();
			return false;
		}
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	

}
