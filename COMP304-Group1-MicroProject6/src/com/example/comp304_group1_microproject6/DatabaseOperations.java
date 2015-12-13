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
			+ TableInfo.USER_NAME + " TEXT," + TableInfo.USER_PASS + " TEXT," + TableInfo.SCORE1 + " INTEGER," + TableInfo.SCORE2 + " INTEGER);";

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
	
	public boolean duplicateAccount(DatabaseOperations dop, String name)
	{
		SQLiteDatabase SQ = dop.getWritableDatabase();
		String[] columns = new String[]{ TableInfo.USER_NAME };
		Cursor CR = SQ.query(TableInfo.TABLE_NAME, columns, TableInfo.USER_NAME + "='" + name+ "'", null, null, null, null);
		
		if (CR.getCount() > 0)
			return true;
		else
			return false;
	}

	public void putInformation(DatabaseOperations dop, String name, String pass) {
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(TableInfo.USER_NAME, name);
		cv.put(TableInfo.USER_PASS, pass);
		cv.put(TableInfo.SCORE1, 0);
		cv.put(TableInfo.SCORE2, 0);
		long k = SQ.insert(TableInfo.TABLE_NAME, null, cv);
		Log.d("Database operations", "One raw inserted.");
	};
	
	public void updateInformation(DatabaseOperations dop, String name, int score1, int score2)
	{
		SQLiteDatabase SQ = dop.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(TableInfo.USER_NAME, name);
		cv.put(TableInfo.SCORE1, score1);
		cv.put(TableInfo.SCORE2, score2);
		long k = SQ.update(TableInfo.TABLE_NAME, cv, TableInfo.USER_NAME + "='" + name+"'", null);
		Log.d("Database operations", "One raw inserted.");
	}

	public Cursor getInformation(DatabaseOperations dop) {
		SQLiteDatabase SQ = dop.getReadableDatabase();
		String[] coloumns = { TableInfo.USER_NAME, TableInfo.USER_PASS, TableInfo.SCORE1, TableInfo.SCORE2 };
		Cursor CR = SQ.query(TableInfo.TABLE_NAME, coloumns, null, null, null,
				null, null);
		return CR;
	}

}
