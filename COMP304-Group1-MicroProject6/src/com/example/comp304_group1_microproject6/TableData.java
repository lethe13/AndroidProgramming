package com.example.comp304_group1_microproject6;

import android.provider.BaseColumns;

public class TableData {
	public TableData() {
	}

	public static abstract class TableInfo implements BaseColumns {
		public static final String USER_NAME = "user_name";
		public static final String USER_PASS = "user_pass";
		public static final String SCORE1 = "0";
		public static final String SCORE2 = "0";
		public static final String DATABASE_NAME = "user_info";
		public static final String TABLE_NAME = "reg_info";
		 
	}
}