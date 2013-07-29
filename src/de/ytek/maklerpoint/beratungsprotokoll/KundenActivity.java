package de.ytek.maklerpoint.beratungsprotokoll;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class KundenActivity extends Activity {

    public final static String KUNDEN_ID = "de.ytek.maklerpoint.beratungsprotokoll.KUNDENID";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Intent intent = getIntent();
		//String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		
		setContentView(R.layout.activity_kunden);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.kunden, menu);
		return true;
	}

}
