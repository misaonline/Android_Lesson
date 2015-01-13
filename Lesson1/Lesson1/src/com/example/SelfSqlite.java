package com.example;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SelfSqlite  extends SQLiteOpenHelper
{
	public static final String DB_NAME = "Example";
	public static final int DB_VERSION = 1;
	
	private SQLiteDatabase mDB = null;
	private static SelfSqlite mInstance = null;
	
	public SelfSqlite(Context context)
	{
		super(context,DB_NAME,null,DB_VERSION);
	}

	public SelfSqlite(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//´´½¨±í
		mDB = db;
		String sql = "CREATE TABLE USER(ID PRIMARY KEY AUTOINCREMENT,NAME TEXT)";
		db.execSQL(sql);
	}

	public static SelfSqlite getInstance(Context context)
	{
		if(mInstance == null)
		{
			mInstance = new SelfSqlite(context);
		}
		
		return mInstance;
	}
	
	public void execSQL(String sql)
	{
		if(mDB == null)
		{
			mDB = getWritableDatabase();
		}
		mDB.execSQL(sql);
		
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
}
