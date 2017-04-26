package com.example.jim23.homework4_receiver;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;

import lincyu.chapter7_broadcastreceiver.R;


public class BR_Notification extends BroadcastReceiver {

	static int id = 70000;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		String msg = intent.getStringExtra("KEY_MSG");
		Intent newintent = new Intent();
		newintent.setClass(context, ActivityNotification.class);


		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, newintent, 0);
		Notification notify = newNotification(context, pendingIntent,
				"HELLO",msg);
		String name="00";
		newintent.putExtra("KEY_name",name);
		NotificationManager notificationManager =(NotificationManager)context.
				getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManager.notify(id++, notify);
	}

	@SuppressLint("NewApi")
	private Notification newNotification(
	        Context context, PendingIntent pi,
            String title, String msg) {
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle(title);
        builder.setContentText(msg);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pi);
        builder.setTicker(msg);
        builder.setWhen(System.currentTimeMillis());
        Notification notify = builder.build();
        return notify;
    }
}
