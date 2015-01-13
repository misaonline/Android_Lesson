package com.example;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

	public static final String TAG = "Example";
	
	private Button mButton_NextPage = null;
	private Button mButton_Service = null;
	
	private ServiceConnection mConnection = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG,"onCreate");
        
        initView();
    }

    private void initView()
    {
    	mButton_NextPage = (Button)findViewById(R.id.button_nextpage);
    	mButton_NextPage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, NextPage.class);
				
				MainActivity.this.startActivity(intent);
			}
		});
    	
    	mButton_Service = (Button)findViewById(R.id.button_service);
    	mButton_Service.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, SelfService.class);
				
				
				//方法二
				MainActivity.this.startService(intent);
				
				//方法一
				/*mConnection = new ServiceConnection(){

					@Override
					public void onServiceConnected(ComponentName name,
							IBinder service) {
						Log.e(MainActivity.TAG, service.toString());
					}

					@Override
					public void onServiceDisconnected(ComponentName name) {
						// TODO Auto-generated method stub
						
					}
					
				};
				MainActivity.this.bindService(intent, mConnection, Context.BIND_AUTO_CREATE);*/
				
			}
		});
    }
    
    public void onStart()
    {
    	super.onStart();
    	
    	Log.e(TAG,"onStart");
    }
    
    public void onResume()
    {
    	super.onResume();
    	
    	Log.e(TAG,"onResume");
    }
    
    public void onPause()
    {
    	super.onPause();
    	
    	Log.e(TAG,"onPause");
    }
    
    public void onRestart()
    {
    	super.onRestart();
    	
    	Log.e(TAG,"onRestart");
    }
    
    public void onDestroy()
    {
    	super.onDestroy();
    	
    	//MainActivity.this.unbindService(mConnection);
    	
    	Log.e(TAG,"onDestroy");
    }
    
    private void readContacts()
    {
    	String[] args = {ContactsContract.Contacts.DISPLAY_NAME,ContactsContract.Contacts.HAS_PHONE_NUMBER};
    	Uri uri = ContactsContract.Contacts.CONTENT_URI;
    	Cursor cursor = MainActivity.this.getContentResolver().query(uri, args, null, null, null);
    	while(cursor.moveToNext())
    	{
    		String name = cursor.getString(cursor.getColumnIndex(args[0]));
    		String hasPhone = cursor.getString(cursor.getColumnIndex(args[1]));
    		
    		Log.e("Example", "Name = " + name + " HasPhone = " + hasPhone);
    		
    	}
    }
    
    private void craeteDB()
    {
    	SelfSqlite dbHelper = SelfSqlite.getInstance(this);
    	
    	String sql = "INSERT INTO USER(NAME) VALUES(‘Lesson’)";
    	dbHelper.execSQL(sql);
    	
    	
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
