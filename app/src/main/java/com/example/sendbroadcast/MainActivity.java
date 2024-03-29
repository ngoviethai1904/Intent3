package com.example.sendbroadcast;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    BroadcastReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureReceiver();
    }
    public void broadcastIntent(View view)
    {
        Intent intent = new Intent();
        intent.setAction("com.example.sendbroadcast;");
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }
    private void configureReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.sendbroadcast;");
        filter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        receiver = new MyReceiver();
        registerReceiver(receiver, filter);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
