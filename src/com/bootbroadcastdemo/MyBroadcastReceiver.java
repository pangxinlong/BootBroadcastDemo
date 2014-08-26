package com.bootbroadcastdemo;


import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

	private static final String SYSTEM_BOOT = Intent.ACTION_BOOT_COMPLETED;

	@SuppressLint("InlinedApi")
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.e("MainActivity", "接收系统静态注册广播消息");
		String msg = intent.getAction(); 
		Intent myintent = null;
		if (msg.equals(SYSTEM_BOOT)) {
			try {
				myintent = new Intent(context,com.bootbroadcastdemo.MainActivity.class);
				myintent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
				context.startActivity(myintent);
				Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
			} catch (Exception e) {
				Log.e("!!!!!!!!!!!!!!!!!!!!intent"+ intent, "!!!!!!!!!!!!!!!!!!!!!!"
						+ context);
			}
		}
	}
}
