package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class NextPage extends Activity 
{
	private LinearLayout mLayout = null;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		mLayout = new LinearLayout(this);
		mLayout.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT));
		
		Button button = new Button(this);
		button.setText("·µ»Ø");
		mLayout.addView(button);
		
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				NextPage.this.finish();
			}
		});
		
		setContentView(mLayout);
	}
	
	

}
