package com.example.comp304_group1_microproject6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.comp304_group1_microproject6.TableData.TableInfo;

public class DatabaseOperations extends SQLiteOpenHelper {

	public static final int database_version = 1;
	public String CREATE_QUERY = "CREATE TABLE	" + TableInfo.TABLE_NAME + "("
			+ TableInfo.USER_NAME + " TEXT," + TableInfo.USER_PASS + " TEXT," + TableInfo.SCORE1 + " TEXT," + TableInfo.SCORE2 + " TEXT);";

	public DatabaseOperations(Context context) {
		super(context, TableInfo.DATABASE_NAME, null, database_version);
		Log.d("Database operations", "Database created.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		arg0.execSQL(CREATE_QUERY);
		Log.d("Database operations", "Table created.");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	public void putInformation(DatabaseOperations dop, String name, String pass) {
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(TableInfo.USER_NAME, name);
		cv.put(TableInfo.USER_PASS, pass);
		long k = SQ.insert(TableInfo.TABLE_NAME, null, cv);
		Log.d("Database operations", "One raw inserted.");
	};

	public Cursor getInformayion(DatabaseOperations dop) {
		SQLiteDatabase SQ = dop.getReadableDatabase();
		String[] coloumns = { TableInfo.USER_NAME, TableInfo.USER_PASS, TableInfo.SCORE1, TableInfo.SCORE2 };
		Cursor CR = SQ.query(TableInfo.TABLE_NAME, coloumns, null, null, null,
				null, null);
		return CR;
	}

}
