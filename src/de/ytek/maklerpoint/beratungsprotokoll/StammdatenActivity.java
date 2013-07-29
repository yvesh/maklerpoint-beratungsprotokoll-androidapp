package de.ytek.maklerpoint.beratungsprotokoll;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import de.ytek.maklerpoint.beratungsprotokoll.contracts.BeratungsProtokollContract;
import de.ytek.maklerpoint.beratungsprotokoll.daten.StammDaten;
import de.ytek.maklerpoint.beratungsprotokoll.db.BeratungsProtokollDbHelper;
import de.ytek.maklerpoint.beratungsprotokoll.db.StammDatenSQLTools;

public class StammdatenActivity extends FragmentActivity implements
		ActionBar.OnNavigationListener {

	private static final String TAG = "StammdatenActivity";
	
	/**
	 * The serialization (saved instance state) Bundle key representing the
	 * current dropdown position.
	 */
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";

	public static final String[] FIRMEN_RECHTSFORMEN_SHORT = new String[] {
			"e. K.", "e. Kfm.", "e. Kfr.", "Einzelunternehmen", "OHG", "GbR",
			"EWIV", "KG", "GmbH", "UG (haftungsbeschränkt)", "AG", "SE",
			"VVaG", "eG", "SCE", "eGmbH", "eGmuH", "KGaA", "GmbH & Co. KG",
			"AG & Co. Kg", "GmbH & Co. KGaA", "AG & Co. KGaA", "Ltd.", "e.V.",
			"KdöR", "AdöR" };

	public static final String[] FIRMEN_RECHTSFORMEN = new String[] {
			"Eingetragener Kaufmann",
			"Eingetragener Kaufmann",
			"Eingetragener Kauffrau",
			"Einzelunternehmen",
			"Offene Handelsgesellschaft",
			"Gesellschaft bürgerlichen Rechts",
			"Europäische wirtschaftliche Interessenvereinigung",
			"Kommanditgesellschaft",
			"Gesellschaft mit beschränkter Haftung",
			"Unternehmergesellschaft (haftungsbeschränkt)",
			"Aktiengesellschaft",
			"Europäische Gesellschaft (Societas Europaea)",
			"Versicherungsverein auf Gegenseitigkeit",
			"eingetragene Genossenschaft",
			"Europäische Genossenschaft (Societas Cooperativa Europaea)",
			"eingetragene Genossenschaft mit beschränkter Haftung (veraltet)",
			"eingetragene Genossenschaft mit unbeschränkter Haftung (veraltet)",
			"Kommanditgesellschaft auf Aktien",
			"Kommanditgesellschaft mit einer Gesellschaft mit beschränkter Haftung als Komplementärin",
			"Kommanditgesellschaft mit einer Aktiengesellschaft als Komplementärin",
			"Kommanditgesellschaft auf Aktien mit einer Gesellschaft mit beschränkter Haftung als Komplementärin",
			"Kommanditgesellschaft auf Aktien mit einer Aktiengesellschaft als Komplementärin",
			"Englische Limited", "Eintegtragener Verein",
			"Körperschaft des öffentlichen Rechts",
			"Anstalt des öffentlichen Rechts" };

	public static final String[] BERATER_TYPEN = { "Versicherungsmakler",
			"Versicherungsberater", "Versicherungsvertretter für ein VU",
			"Mehrfirmenvertretter" };

	public static final String[] IHK_STATUS = new String[] { "Vorhanden",
			"Beantragt", "Nicht vorhanden" };
	
	public static int stammdatenId = -1;
	public static StammDaten sd = null;
	

	Spinner spinnerRechtsform;
	Spinner spinnerBeratertypen;
	Spinner spinnerIHKStatus;

	EditText fieldFirmenname;
	EditText fieldZusatz;
	EditText fieldStreet;
	
	EditText fieldPLZ;
	EditText fieldOrt;
	EditText fieldLand;
	EditText fieldSteuernummer;
	EditText fieldUSTId;
	EditText fieldVHaftpflicht;
	
	CheckBox checkBeteiligungenVU;
	CheckBox checkBeteiligungenMAK;
	
	EditText fieldIHKStelle;
	EditText fieldIHKNummer;
	EditText fieldIHKAbweichungen;
	
	CheckBox check34c;
	CheckBox check34d;
	
	EditText fieldBriefkopf;
	EditText fieldPhone;
	EditText fieldMobile;
	EditText fieldFax;
	EditText fieldEmail;
	EditText fieldWebsite;
	EditText fieldCustom1;
	EditText fieldCustom2;
	EditText fieldCustom3;	
	
	BeratungsProtokollDbHelper mDbHelper;
	SQLiteDatabase db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stammdaten);

		mDbHelper = new BeratungsProtokollDbHelper(this); // Should be moved in a background thread intent / worker
		db = mDbHelper.getWritableDatabase();
		
		// Design activity

		this.fieldFirmenname = (EditText) findViewById(R.id.field_firmenname);
		this.fieldZusatz = (EditText) findViewById(R.id.field_zusatz);
		this.fieldStreet = (EditText) findViewById(R.id.field_street);
		this.fieldPLZ = (EditText) findViewById(R.id.field_plz);
		this.fieldOrt = (EditText) findViewById(R.id.field_ort);
		this.fieldLand = (EditText) findViewById(R.id.field_land);
		this.fieldSteuernummer = (EditText) findViewById(R.id.field_steuernummer);
		this.fieldUSTId = (EditText) findViewById(R.id.field_ustid);
		this.fieldVHaftpflicht = (EditText) findViewById(R.id.field_vhaftpflicht);
		
		this.checkBeteiligungenVU = (CheckBox) findViewById(R.id.check_beteiligungenVU);
		this.checkBeteiligungenMAK = (CheckBox) findViewById(R.id.check_beteiligungenMAK);
		
		this.fieldIHKStelle = (EditText) findViewById(R.id.field_ihkstelle);
		this.fieldIHKNummer = (EditText) findViewById(R.id.field_ihknummer);
		this.fieldIHKAbweichungen = (EditText) findViewById(R.id.field_ihkabweichungen);
		
		this.check34c = (CheckBox) findViewById(R.id.check_34c);
		this.check34d = (CheckBox) findViewById(R.id.check_34d);
		
		this.fieldBriefkopf = (EditText) findViewById(R.id.field_briefkopf);
		this.fieldPhone = (EditText) findViewById(R.id.field_phone);
		this.fieldMobile = (EditText) findViewById(R.id.field_mobile);
		this.fieldFax = (EditText) findViewById(R.id.field_fax);
		this.fieldEmail = (EditText) findViewById(R.id.field_email);
		this.fieldWebsite = (EditText) findViewById(R.id.field_website);
		this.fieldCustom1 = (EditText) findViewById(R.id.field_custom1);
		this.fieldCustom2 = (EditText) findViewById(R.id.field_custom2);
		this.fieldCustom3 = (EditText) findViewById(R.id.field_custom3);

		// Spinner Data
		// Rechtsform
		spinnerRechtsform = (Spinner) findViewById(R.id.spinner_rechtsform);

		ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(
				this, android.R.layout.simple_spinner_item,
				StammdatenActivity.FIRMEN_RECHTSFORMEN_SHORT);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerRechtsform.setAdapter(adapter);

		// Beratertyp
		spinnerBeratertypen = (Spinner) findViewById(R.id.spinner_beratertyp);

		ArrayAdapter<CharSequence> adapterBerater = new ArrayAdapter<CharSequence>(
				this, android.R.layout.simple_spinner_item,
				StammdatenActivity.BERATER_TYPEN);
		// Specify the layout to use when the list of choices appears
		adapterBerater
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerBeratertypen.setAdapter(adapterBerater);

		// Beratertyp
		spinnerIHKStatus = (Spinner) findViewById(R.id.spinner_ihkstatus);

		ArrayAdapter<CharSequence> adapterIHKStatus = new ArrayAdapter<CharSequence>(
				this, android.R.layout.simple_spinner_item,
				StammdatenActivity.BERATER_TYPEN);
		// Specify the layout to use when the list of choices appears
		adapterIHKStatus
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerIHKStatus.setAdapter(adapterIHKStatus);

		// Load Data out of the database
		
		sd = StammDatenSQLTools.getStammDaten(db);
		
		if(sd != null) {
			stammdatenId = sd.get_id(); // should be 1
			Log.i(TAG, "Loaded Stammdaten out of database - id: " + stammdatenId);
			
			this.fieldFirmenname.setText(sd.get_firmenName());
			this.fieldZusatz.setText(sd.get_zusatz());
			this.fieldStreet.setText(sd.get_strasse());
			this.fieldPLZ.setText(sd.get_plz());
			
			this.fieldOrt.setText(sd.get_ort());
			this.fieldLand.setText(sd.get_land());
			this.fieldSteuernummer.setText(sd.get_steuerNummer());
			this.fieldUSTId.setText(sd.get_ustNummer());
			this.fieldVHaftpflicht.setText(sd.get_vermoegensHaftpflicht());
			
			this.checkBeteiligungenVU.setChecked(sd.is_beteiligungenVU());
			this.checkBeteiligungenMAK.setChecked(sd.is_beteiligungenMAK());
			
			this.fieldIHKStelle.setText(sd.get_ihkName());
			this.fieldIHKNummer.setText(sd.get_ihkRegistriernummer());
			this.fieldIHKAbweichungen.setText(sd.get_ihkAbweichungen());
			
			this.check34c.setChecked(sd.is_34c());
			this.check34d.setChecked(sd.is_34d());

			this.fieldBriefkopf.setText(sd.get_briefkopf());
			this.fieldPhone.setText(sd.get_telefon());
			this.fieldMobile.setText(sd.get_mobil());
			this.fieldFax.setText(sd.get_fax());
			this.fieldEmail.setText(sd.get_email());
			this.fieldWebsite.setText(sd.get_website());
			this.fieldCustom1.setText(sd.get_custom1());
			this.fieldCustom2.setText(sd.get_custom2());
			this.fieldCustom3.setText(sd.get_custom3());
		} else {
			// Set defaults
			// We have none atm
			Log.i(TAG, "No saved Stammdaten creating empty new - " + stammdatenId);
		}

		// Load Preferences

		// Set up the action bar to show a dropdown list.
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

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

	
	@Override
	public void onPause() {
	    super.onPause();  // Always call the superclass method first

	    //saveForm(); moved to onStop();
	}
	
	@Override
	protected void onStop() {
	    super.onStop();  // Always call the superclass method first
	    
	    // Save our Form
	    saveForm();
	}
	
	
	
	public void saveForm() {
		Log.i(TAG, "Saving / Updating Stammdaten");
		ContentValues vals = new ContentValues();
		
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_FIRMENNAME, this.fieldFirmenname.getText().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_ZUSATZ, this.fieldZusatz.getText().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_RECHTSFORM, this.spinnerRechtsform.getSelectedItem().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_STREET, this.fieldStreet.getText().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_PLZ, this.fieldPLZ.getText().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_ORT, this.fieldOrt.getText().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_LAND, this.fieldLand.getText().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_BERATERTYP, this.spinnerBeratertypen.getSelectedItem().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_STEUERNUMMER, this.fieldSteuernummer.getText().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_USTID, this.fieldUSTId.getText().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_VHAFTPFLICHT, this.fieldVHaftpflicht.getText().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_BETEILIGUNGENVU, this.checkBeteiligungenVU.isChecked());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_BETEILIGUNGENMAK, this.checkBeteiligungenMAK.isChecked());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_IHKSTATUS, this.spinnerIHKStatus.getSelectedItem().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_IHKSTELLE, this.fieldIHKStelle.getText().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_IHKNUMMER, this.fieldIHKNummer.getText().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_IHKABWEICHUNGEN, this.fieldIHKAbweichungen.getText().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_34C, this.check34c.isChecked());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_34D, this.check34d.isChecked());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_BRIEFKOPF, this.fieldBriefkopf.getText().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_PHONE, this.fieldPhone.getText().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_MOBILE, this.fieldMobile.getText().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_FAX, this.fieldFax.getText().toString());	
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_EMAIL, this.fieldEmail.getText().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_WEBSITE, this.fieldWebsite.getText().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_CUSTOM1, this.fieldCustom1.getText().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_CUSTOM2, this.fieldCustom2.getText().toString());
		vals.put(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_CUSTOM3, this.fieldCustom3.getText().toString());

		if(stammdatenId == -1) {
			// Create if not loaded / in database
			long id = StammDatenSQLTools.saveStammdaten(db, vals);
			
			if(id == -1) {
				// Failed saving Stammdaten
				Log.e(StammdatenActivity.TAG, "Failed saving StammDaten Object!!");
			}
			
			// load sd
			stammdatenId = (int) id;
		} else {
			//    Stammdaten
			vals.put(BeratungsProtokollContract.StammDatenEntry._ID, StammdatenActivity.stammdatenId); // Add id on update
			StammDatenSQLTools.updateStammdaten(db, vals);
		}
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
		getMenuInflater().inflate(R.menu.stammdaten, menu);
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
					R.layout.fragment_stammdaten_dummy, container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			dummyTextView.setText(Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER)));
			return rootView;
		}
	}

}
