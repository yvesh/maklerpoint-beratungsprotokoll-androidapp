package de.ytek.maklerpoint.beratungsprotokoll.db;

import de.ytek.maklerpoint.beratungsprotokoll.contracts.BeratungsProtokollContract;
import de.ytek.maklerpoint.beratungsprotokoll.daten.StammDaten;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class StammDatenSQLTools {

	private StammDatenSQLTools(){};
	
	public static final String[] PROJECTION = {
		BeratungsProtokollContract.StammDatenEntry._ID,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_FIRMENNAME,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_ZUSATZ,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_RECHTSFORM,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_STREET,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_PLZ,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_ORT,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_LAND,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_BERATERTYP,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_STEUERNUMMER,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_USTID,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_VHAFTPFLICHT,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_BETEILIGUNGENVU,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_BETEILIGUNGENMAK,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_IHKSTATUS,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_IHKSTELLE,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_IHKNUMMER,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_IHKABWEICHUNGEN,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_34C,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_34D,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_BRIEFKOPF,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_PHONE,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_MOBILE,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_FAX,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_EMAIL,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_WEBSITE,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_CUSTOM1,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_CUSTOM2,
		BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_CUSTOM3,
	};
	
	public static Cursor getCursor(SQLiteDatabase db, String selection, String[] selectionArgs, String sortOrder){
		// SQL Query
		
		Cursor c = db.query(
				BeratungsProtokollContract.StammDatenEntry.TABLE_NAME,
				StammDatenSQLTools.PROJECTION,
				selection,
				selectionArgs,
				null,
				null,
				sortOrder
					
		);
		
		return c;
	}
	
	
	public static StammDaten getStammDaten(SQLiteDatabase db){
		StammDaten sd = null;
		
		Cursor c = StammDatenSQLTools.getCursor(db, null, null, null);
		
		boolean hasEntries = c.moveToFirst();
		
		if(hasEntries) {
			// Load the data
			sd = new StammDaten();
			sd.set_id(c.getInt(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry._ID)));
			sd.set_firmenName(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_FIRMENNAME)));
			sd.set_zusatz(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_ZUSATZ)));
			sd.set_firmenRechtsform(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_RECHTSFORM)));
			sd.set_strasse(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_STREET)));
			sd.set_plz(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_PLZ)));
			sd.set_ort(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_ORT)));
			sd.set_land(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_LAND)));
			sd.set_beraterTyp(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_BERATERTYP)));
			sd.set_steuerNummer(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_STEUERNUMMER)));
			sd.set_ustNummer(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_USTID)));
			sd.set_vermoegensHaftpflicht(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_VHAFTPFLICHT)));
			sd.set_beteiligungenVU(StammDatenSQLTools.getBoolean(c.getInt(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_BETEILIGUNGENVU))));
			sd.set_beteiligungenMAK(StammDatenSQLTools.getBoolean(c.getInt(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_BETEILIGUNGENMAK))));
			sd.set_ihkStatus(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_IHKSTATUS)));
			sd.set_ihkName(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_IHKSTELLE)));
			sd.set_ihkRegistriernummer(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_IHKNUMMER)));
			sd.set_ihkAbweichungen(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_IHKABWEICHUNGEN)));
			sd.set_34c(StammDatenSQLTools.getBoolean(c.getInt(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_34C))));
			sd.set_34d(StammDatenSQLTools.getBoolean(c.getInt(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_34D))));
			sd.set_briefkopf(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_BRIEFKOPF)));
			sd.set_telefon(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_PHONE)));
			sd.set_mobil(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_MOBILE)));
			sd.set_fax(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_FAX)));
			sd.set_email(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_EMAIL)));
			sd.set_website(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_WEBSITE)));
			sd.set_custom1(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_CUSTOM1)));
			sd.set_custom2(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_CUSTOM2)));
			sd.set_custom3(c.getString(c.getColumnIndexOrThrow(BeratungsProtokollContract.StammDatenEntry.COLUMN_NAME_CUSTOM3)));			
		}
		
		return sd;		
	}
	
	public static Boolean getBoolean(int t) {
		if(t == 0) 
			return false;
		else
			return true;
	}
	
	/**
	 * Not implemented yet!!!
	 * @param db
	 * @param sd
	 * @return
	 */
	public static StammDaten saveStammdaten(SQLiteDatabase db, StammDaten sd){

		return sd;
	}
	
	/**
	 * Should be called only once!
	 * @param db
	 * @param val
	 * @return
	 */
	public static long saveStammdaten(SQLiteDatabase db, ContentValues val){
		long newId = -1; // Will be 1, because after we are going only to update these
		
		newId = db.insert(
				BeratungsProtokollContract.StammDatenEntry.TABLE_NAME,
				null,
		        val);
		
		return newId; 
	}
	
	/**
	 * We always update the first entry, currently only one StammDaten per APP!
	 * @param db
	 * @param val
	 * @return
	 */
	public static boolean updateStammdaten(SQLiteDatabase db, ContentValues val){
		String selection = BeratungsProtokollContract.StammDatenEntry._ID + " LIKE ?";
		String[] selectionArgs = { String.valueOf(1) };
		
		int count = db.update(
				BeratungsProtokollContract.StammDatenEntry.TABLE_NAME,
			    val,
			    selection,
			    selectionArgs);
		
		return true;
	}
	
	
}
