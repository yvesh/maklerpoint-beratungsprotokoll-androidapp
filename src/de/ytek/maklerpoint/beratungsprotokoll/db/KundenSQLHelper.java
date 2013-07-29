package de.ytek.maklerpoint.beratungsprotokoll.db;

import java.util.ArrayList;
import java.util.List;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import de.ytek.maklerpoint.beratungsprotokoll.daten.KundenObj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class KundenSQLHelper extends SQLiteAssetHelper {

	// the zip file must be testdb.zip
	// inside the zip file there must be a testdb-v1.db or testdb-v2.db
	// sqlitehelper dependencies. Please read documentation
	// the zip file must be under assets > databases folder
	private static final String DATABASE_NAME = " BeratungsProtokoll"; // TODO: update the
															// database name to
															// be your database
	private static final int DATABASE_VERSION = 1;

	private static final String KUNDEN_TABLE_NAME = "kunden"; // table name

	// column names
	private static final String ID = "id";
	private static final String BETREUERID = "betreuerId";
	private static final String KUNDENNR = "kundenNr";
	private static final String ANREDE = "anrede";
	private static final String TITEL = "titel";
	private static final String FIRMA = "firma";
	private static final String VORNAME = "vorname";
	private static final String NACHNAME = "nachname";
	private static final String ZUSATZ = "zusatz";
	private static final String STRASSE = "strasse";
	private static final String PLZ = "plz";
	private static final String ORT = "ort";
	private static final String LAND = "land";
	private static final String GEBURTSDATUM = "geburtsdatum";
	private static final String COMMUNICATION1 = "communication1";
	private static final String COMMUNICATION2 = "communication2";
	private static final String COMMUNICATION3 = "communication3";
	private static final String COMMUNICATION4 = "communication4";
	private static final String COMMUNICTION1_TYP = "communiction1_typ";
	private static final String COMMUNICTION2_TYP = "communiction2_typ";
	private static final String COMMUNICTION3_TYP = "communiction3_typ";
	private static final String COMMUNICTION4_TYP = "communiction4_typ";
	private static final String CUSTOM1 = "custom1";
	private static final String CUSTOM2 = "custom2";
	private static final String CUSTOM3 = "custom3";
	private static final String STATUS = "status";

	private static final String[]   = { ID, BETREUERID,
			KUNDENNR, ANREDE, TITEL, FIRMA, VORNAME, NACHNAME, ZUSATZ, STRASSE,
			PLZ, ORT, LAND, GEBURTSDATUM, COMMUNICATION1, COMMUNICATION2,
			COMMUNICATION3, COMMUNICATION4, COMMUNICTION1_TYP,
			COMMUNICTION2_TYP, COMMUNICTION3_TYP, COMMUNICTION4_TYP, CUSTOM1,
			CUSTOM2, CUSTOM3, STATUS };

	public KundenSQLHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// CRUD for kunden

	public boolean insertkunden(KundenObj entry) {
		if (entry != null) {
			SQLiteDatabase db = this.getWritableDatabase();
			ContentValues values = new ContentValues();

			values.put(ID, entry.getId());
			values.put(BETREUERID, entry.getBetreuerId());
			values.put(KUNDENNR, entry.getKundenNr());
			values.put(ANREDE, entry.getAnrede());
			values.put(TITEL, entry.getTitel());
			values.put(FIRMA, entry.getFirma());
			values.put(VORNAME, entry.getVorname());
			values.put(NACHNAME, entry.getNachname());
			values.put(ZUSATZ, entry.getZusatz());
			values.put(STRASSE, entry.getStrasse());
			values.put(PLZ, entry.getPlz());
			values.put(ORT, entry.getOrt());
			values.put(LAND, entry.getLand());
			values.put(GEBURTSDATUM, entry.getGeburtsdatum());
			values.put(COMMUNICATION1, entry.getCommunication1());
			values.put(COMMUNICATION2, entry.getCommunication2());
			values.put(COMMUNICATION3, entry.getCommunication3());
			values.put(COMMUNICATION4, entry.getCommunication4());
			values.put(COMMUNICTION1_TYP, entry.getCommuniction1_typ());
			values.put(COMMUNICTION2_TYP, entry.getCommuniction2_typ());
			values.put(COMMUNICTION3_TYP, entry.getCommuniction3_typ());
			values.put(COMMUNICTION4_TYP, entry.getCommuniction4_typ());
			values.put(CUSTOM1, entry.getCustom1());
			values.put(CUSTOM2, entry.getCustom2());
			values.put(CUSTOM3, entry.getCustom3());
			values.put(STATUS, entry.getStatus());

			return (db.insert(KUNDEN_TABLE_NAME, null, values) != -1);
		}

		return false;
	}

	public boolean updatekunden(KundenObj entry) {
		if (entry == null)
			return false;

		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();

		values.put(ID, entry.getId());
		values.put(BETREUERID, entry.getBetreuerId());
		values.put(KUNDENNR, entry.getKundenNr());
		values.put(ANREDE, entry.getAnrede());
		values.put(TITEL, entry.getTitel());
		values.put(FIRMA, entry.getFirma());
		values.put(VORNAME, entry.getVorname());
		values.put(NACHNAME, entry.getNachname());
		values.put(ZUSATZ, entry.getZusatz());
		values.put(STRASSE, entry.getStrasse());
		values.put(PLZ, entry.getPlz());
		values.put(ORT, entry.getOrt());
		values.put(LAND, entry.getLand());
		values.put(GEBURTSDATUM, entry.getGeburtsdatum());
		values.put(COMMUNICATION1, entry.getCommunication1());
		values.put(COMMUNICATION2, entry.getCommunication2());
		values.put(COMMUNICATION3, entry.getCommunication3());
		values.put(COMMUNICATION4, entry.getCommunication4());
		values.put(COMMUNICTION1_TYP, entry.getCommuniction1_typ());
		values.put(COMMUNICTION2_TYP, entry.getCommuniction2_typ());
		values.put(COMMUNICTION3_TYP, entry.getCommuniction3_typ());
		values.put(COMMUNICTION4_TYP, entry.getCommuniction4_typ());
		values.put(CUSTOM1, entry.getCustom1());
		values.put(CUSTOM2, entry.getCustom2());
		values.put(CUSTOM3, entry.getCustom3());
		values.put(STATUS, entry.getStatus());

		db.update(KUNDEN_TABLE_NAME, values, "id = ?",
				new String[] { String.valueOf(entry.getId()) });

		return true;
	}

	// check primary key, insert if not exist, update if exist
	public boolean savekunden(KundenObj entry) {
		if (entry == null)
			return false;

		boolean isExist = this.iskundenExist(entry.getId());

		if (isExist)
			return updatekunden(entry);
		else
			return insertkunden(entry);

	}

	// deletion
	public int deleteAllkundens() {
		SQLiteDatabase db = this.getWritableDatabase();
		int noOfRowsAffected = db.delete(KUNDEN_TABLE_NAME, null, null);
		return noOfRowsAffected;
	}

	public int deletekundenByPK(int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		int noOfRowsAffected = db.delete(KUNDEN_TABLE_NAME, "id = ?",
				new String[] { String.valueOf(id) });
		return noOfRowsAffected;
	}

	private List<KundenObj> processkundenCursor(Cursor c) {
		List<KundenObj> results = new ArrayList<KundenObj>();

		int numRows = c.getCount();
		c.moveToFirst();

		for (int i = 0; i < numRows; i++) {

			KundenObj entry = new KundenObj();

			int id = c.getInt(0);
			entry.setId(id);
			int betreuerId = c.getInt(1);
			entry.setBetreuerId(betreuerId);
			String kundenNr = c.getString(2);
			entry.setKundenNr(kundenNr);
			String anrede = c.getString(3);
			entry.setAnrede(anrede);
			String titel = c.getString(4);
			entry.setTitel(titel);
			String firma = c.getString(5);
			entry.setFirma(firma);
			String vorname = c.getString(6);
			entry.setVorname(vorname);
			String nachname = c.getString(7);
			entry.setNachname(nachname);
			String zusatz = c.getString(8);
			entry.setZusatz(zusatz);
			String strasse = c.getString(9);
			entry.setStrasse(strasse);
			String plz = c.getString(10);
			entry.setPlz(plz);
			String ort = c.getString(11);
			entry.setOrt(ort);
			String land = c.getString(12);
			entry.setLand(land);
			String geburtsdatum = c.getString(13);
			entry.setGeburtsdatum(geburtsdatum);
			String communication1 = c.getString(14);
			entry.setCommunication1(communication1);
			String communication2 = c.getString(15);
			entry.setCommunication2(communication2);
			String communication3 = c.getString(16);
			entry.setCommunication3(communication3);
			String communication4 = c.getString(17);
			entry.setCommunication4(communication4);
			int communiction1_typ = c.getInt(18);
			entry.setCommuniction1_typ(communiction1_typ);
			int communiction2_typ = c.getInt(19);
			entry.setCommuniction2_typ(communiction2_typ);
			int communiction3_typ = c.getInt(20);
			entry.setCommuniction3_typ(communiction3_typ);
			int communiction4_typ = c.getInt(21);
			entry.setCommuniction4_typ(communiction4_typ);
			String custom1 = c.getString(22);
			entry.setCustom1(custom1);
			String custom2 = c.getString(23);
			entry.setCustom2(custom2);
			String custom3 = c.getString(24);
			entry.setCustom3(custom3);
			int status = c.getInt(25);
			entry.setStatus(status);

			results.add(entry);

			c.moveToNext();
		}

		c.close();

		return results;
	}

	public List<KundenObj> findAllkundens() {
		SQLiteDatabase db = getReadableDatabase();

		Cursor c = db.query(KUNDEN_TABLE_NAME, KUNDEN_TABLE_COLUMNS, null,
				null, // where arguments
				null, null, null // groupby, having, orderby
				);

		return processkundenCursor(c);

	}

	public KundenObj findkundenByPK(int id) {

		SQLiteDatabase db = getReadableDatabase();

		Cursor c = db.query(KUNDEN_TABLE_NAME, KUNDEN_TABLE_COLUMNS, "id = ?",
				new String[] { String.valueOf(id) }, // where arguments
				null, null, null // groupby, having, orderby
				);

		List<KundenObj> results = processkundenCursor(c);
		if (results == null || results.size() == 0)
			return null;
		else
			return results.get(0);
	}

	public boolean iskundenExist(int id) {
		KundenObj entry = findkundenByPK(id);
		return (entry != null);
	}

}