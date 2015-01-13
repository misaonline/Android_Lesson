package com.example;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class SelfService extends Service 
{

	public void onCreate()
	{
		Log.e(MainActivity.TAG, "Service create");
	}
	
	public void onStart(Intent intent,int id)
	{
		Log.e("Example", "onStart");
	}
	
	@Override
	public IBinder onBind(Intent arg0) 
	{
		Log.e("Example", "onBind");
		return new SelfBinder();
	}
	
	public class SelfBinder extends Binder
	{
		public SelfService getService()
		{
			return SelfService.this;
		}
	}

	public void onDestroy()
	{
		Log.e("Example", "onDestroy");
	}
	
	
}
