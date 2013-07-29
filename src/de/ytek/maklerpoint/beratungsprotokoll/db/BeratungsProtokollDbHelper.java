package de.ytek.maklerpoint.beratungsprotokoll.db;

import de.ytek.maklerpoint.beratungsprotokoll.contracts.BeratungsProtokollContract;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BeratungsProtokollDbHelper extends SQLiteOpenHelper {
	
	private static final String TAG = "BeratungsProtokollDbHelper";
	
	 public static final int DATABASE_VERSION = 2; // Increase every change
	 public static final String DATABASE_NAME = "BeratungsProtokoll.db";

	public BeratungsProtokollDbHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i(TAG, "Creating database tables");
		db.execSQL(BeratungsProtokollContract.SQL_CREATE_ENTRIES);
	}
	
	
	// TODO Fix this, use ALTER instead of DROP
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(BeratungsProtokollContract.SQL_DELETE_ENTRIES);
        onCreate(db);
        Log.w(TAG, "Warning upgrading database (deleting complete database)");
	}	

}
