package de.ytek.maklerpoint.beratungsprotokoll.contracts;

import android.provider.BaseColumns;

public final class BeratungsProtokollContract {
	
	public BeratungsProtokollContract() {}
	
	public static final String TEXT_TYPE = " TEXT";
	public static final String INT_TYPE = " INTEGER";
	public static final String COMMA_SEP = ",";
	
	public static final String SQL_CREATE_ENTRIES =
		    "CREATE TABLE " + StammDatenEntry.TABLE_NAME + " (" +
		    		StammDatenEntry._ID + " INTEGER PRIMARY KEY," +
		    		StammDatenEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
		    		StammDatenEntry.COLUMN_NAME_FIRMENNAME + TEXT_TYPE + COMMA_SEP +
		    		StammDatenEntry.COLUMN_NAME_ZUSATZ + TEXT_TYPE + COMMA_SEP +
		    		StammDatenEntry.COLUMN_NAME_RECHTSFORM + TEXT_TYPE + COMMA_SEP +
		    		StammDatenEntry.COLUMN_NAME_STREET + TEXT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_PLZ + TEXT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_ORT + TEXT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_LAND + TEXT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_BERATERTYP + TEXT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_STEUERNUMMER + TEXT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_USTID + TEXT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_VHAFTPFLICHT + TEXT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_BETEILIGUNGENVU + INT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_BETEILIGUNGENMAK + INT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_IHKSTATUS + TEXT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_IHKSTELLE + TEXT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_IHKNUMMER + TEXT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_IHKABWEICHUNGEN + TEXT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_34C + INT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_34D + INT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_BRIEFKOPF + TEXT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_PHONE + TEXT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_MOBILE + TEXT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_FAX + TEXT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_EMAIL + TEXT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_WEBSITE + TEXT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_CUSTOM1 + TEXT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_CUSTOM2 + TEXT_TYPE + COMMA_SEP +
				    StammDatenEntry.COLUMN_NAME_CUSTOM3 + TEXT_TYPE +
		" )";
	
	public static final String SQL_DELETE_ENTRIES =
		    "DROP TABLE IF EXISTS " + StammDatenEntry.TABLE_NAME;
	
	
	
	/* Inner class that defines the table contents */
    public static abstract class StammDatenEntry implements BaseColumns {
    	public static final String TABLE_NAME = "stammdaten";
    	public static final String COLUMN_NAME_ENTRY_ID = "id";
    	public static final String COLUMN_NAME_FIRMENNAME = "firmenname";
    	public static final String COLUMN_NAME_ZUSATZ = "zusatz";
    	public static final String COLUMN_NAME_RECHTSFORM = "rechtsform";
    	public static final String COLUMN_NAME_STREET = "strasse";
    	public static final String COLUMN_NAME_PLZ = "plz";
    	public static final String COLUMN_NAME_ORT = "ort";
    	public static final String COLUMN_NAME_LAND = "land";
    	public static final String COLUMN_NAME_BERATERTYP = "beratertyp";
    	public static final String COLUMN_NAME_STEUERNUMMER = "steuernummer";
    	public static final String COLUMN_NAME_USTID = "ustid";
    	public static final String COLUMN_NAME_VHAFTPFLICHT = "vhaftpflicht";
    	public static final String COLUMN_NAME_BETEILIGUNGENVU = "beteiligungenvu";
    	public static final String COLUMN_NAME_BETEILIGUNGENMAK = "beteiligungenmak";
    	public static final String COLUMN_NAME_IHKSTATUS = "ihkstatus";
    	public static final String COLUMN_NAME_IHKSTELLE = "ihkstelle";
    	public static final String COLUMN_NAME_IHKNUMMER = "ihknummer";
    	public static final String COLUMN_NAME_IHKABWEICHUNGEN = "ihkabweichungen";
    	public static final String COLUMN_NAME_34C = "h34c";
    	public static final String COLUMN_NAME_34D = "h34d";
    	public static final String COLUMN_NAME_BRIEFKOPF = "briefkopf";
    	public static final String COLUMN_NAME_PHONE = "phone";
    	public static final String COLUMN_NAME_MOBILE = "mobile";
    	public static final String COLUMN_NAME_FAX = "fax";
    	public static final String COLUMN_NAME_EMAIL = "email";
    	public static final String COLUMN_NAME_WEBSITE = "website";
    	public static final String COLUMN_NAME_CUSTOM1 = "custom1";
    	public static final String COLUMN_NAME_CUSTOM2 = "custom2";
    	public static final String COLUMN_NAME_CUSTOM3 = "custom3";
    }
    
    
}
