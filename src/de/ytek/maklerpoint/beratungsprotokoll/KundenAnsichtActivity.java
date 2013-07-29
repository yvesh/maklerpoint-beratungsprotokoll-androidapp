package de.ytek.maklerpoint.beratungsprotokoll;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import de.ytek.maklerpoint.beratungsprotokoll.defines.Anreden;

public class KundenAnsichtActivity extends FragmentActivity implements
		ActionBar.OnNavigationListener {

	/**
	 * The serialization (saved instance state) Bundle key representing the
	 * current dropdown position.
	 */
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

	private static final String TAG = "KundenAnsichtActivity";
	
	Spinner spinnerAnreden;
	EditText fieldKundenNr;
	EditText fieldTitel;
	EditText fieldVorname;
	EditText fieldNachname;
	EditText fieldFirma;
	EditText fieldStrasse;
	EditText fieldPLZ;
	EditText fieldOrt;
	EditText fieldLand;
	EditText fieldGeburtsdatum;
	EditText fieldCommunication1;
	EditText fieldCommunication2;
	EditText fieldCommunication3;
	EditText fieldCommunication4;
	EditText fieldCustom1;
	EditText fieldCustom2;
	EditText fieldCustom3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kunden_ansicht);

		// Set up the action bar to show a dropdown list.
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
	
		// Load fields
		this.fieldKundenNr = (EditText) findViewById(R.id.field_kundenNr);
		this.fieldTitel = (EditText) findViewById(R.id.field_titel);
		this.fieldVorname = (EditText) findViewById(R.id.field_vorname);
		this.fieldNachname = (EditText) findViewById(R.id.field_nachname);
		this.fieldFirma = (EditText) findViewById(R.id.field_firma);
		this.fieldStrasse = (EditText) findViewById(R.id.field_strasse);
		this.fieldPLZ = (EditText) findViewById(R.id.field_kplz);
		this.fieldOrt = (EditText) findViewById(R.id.field_kort);
		this.fieldLand = (EditText) findViewById(R.id.field_kland);
		this.fieldGeburtsdatum = (EditText) findViewById(R.id.field_geburtsdatum);
		this.fieldCommunication1 = (EditText) findViewById(R.id.field_communication1);
		this.fieldCommunication2 = (EditText) findViewById(R.id.field_communication2);
		this.fieldCommunication3 = (EditText) findViewById(R.id.field_communication3);
		this.fieldCommunication4 = (EditText) findViewById(R.id.field_communication4);
		this.fieldCustom1 = (EditText) findViewById(R.id.field_custom1);
		this.fieldCustom2 = (EditText) findViewById(R.id.field_custom2);
		this.fieldCustom3 = (EditText) findViewById(R.id.field_custom3);
		
		// Initialisiere Spinner
		spinnerAnreden = (Spinner) findViewById(R.id.spinner_anrede);

		ArrayAdapter<CharSequence> adapterAnreden = new ArrayAdapter<CharSequence>(
				this, android.R.layout.simple_spinner_item,
				Anreden.ANREDEN);
		// Specify the layout to use when the list of choices appears
		adapterAnreden.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerAnreden.setAdapter(adapterAnreden);
		
		
		Intent intent = getIntent();
		String kunden_id = intent.getStringExtra(KundenActivity.KUNDEN_ID);
				
		// Load customer details
		
		if(kunden_id.isEmpty()) {
			Log.i(KundenAnsichtActivity.TAG, "Neuer Kunde");
		} else {
			Log.i(KundenAnsichtActivity.TAG, "Lade Kunde mit id " + kunden_id);
		}
				
		
		// Set up the dropdown list navigation in the action bar.
		actionBar.setListNavigationCallbacks(
		// Specify a SpinnerAdapter to populate the dropdown list.
				new ArrayAdapter<String>(getActionBarThemedContextCompat(),
						android.R.layout.simple_list_item_1,
						android.R.id.text1, new String[] {
								getString(R.string.title_section1),
								getString(R.string.title_section2),
								getString(R.string.title_section3), }), this);
	}

	/**
	 * Backward-compatible version of {@link ActionBar#getThemedContext()} that
	 * simply returns the {@link android.app.Activity} if
	 * <code>getThemedContext</code> is unavailable.
	 */
	@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
	private Context getActionBarThemedContextCompat() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
			return getActionBar().getThemedContext();
		} else {
			return this;
		}
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		// Restore the previously serialized current dropdown position.
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// Serialize the current dropdown position.
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
				.getSelectedNavigationIndex());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.kunden_ansicht, menu);
		return true;
	}

	@Override
	public boolean onNavigationItemSelected(int position, long id) {
		// When the given dropdown item is selected, show its contents in the
		// container view.
		Fragment fragment = new DummySectionFragment();
		Bundle args = new Bundle();
		args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
		fragment.setArguments(args);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.container, fragment).commit();
		return true;
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_kunden_ansicht_dummy, container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			dummyTextView.setText(Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER)));
			return rootView;
		}
	}

}
