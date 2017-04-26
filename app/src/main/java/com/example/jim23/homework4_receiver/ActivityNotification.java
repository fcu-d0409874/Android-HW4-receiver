package com.example.jim23.homework4_receiver;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import lincyu.chapter7_broadcastreceiver.R;

public class ActivityNotification extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fake);

		String msg  = ActivityNotification.this.getIntent().getStringExtra("KEY_name");

		TextView hi = (TextView)findViewById(R.id.greeting);
		hi.setText("Hello "+msg);
		hi.setTextColor(Color.GRAY);
		hi.setTextSize(20);


		TextView tv = (TextView)findViewById(R.id.hello);
		tv.setText("Greeting");
		tv.setTextColor(Color.BLACK);
		tv.setTextSize(20);

	}
}
