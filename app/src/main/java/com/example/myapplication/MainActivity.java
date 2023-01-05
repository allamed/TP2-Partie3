package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button Button;

    BatteryLow receiver = new BatteryLow();
    IntentFilter filter = new IntentFilter();

    ThirdReceiver receiver1 = new ThirdReceiver();
    IntentFilter filter1 = new IntentFilter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button = (Button) findViewById(R.id.button);

        Button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent("FAKE_EVENT_INFO");
                        sendBroadcast(intent);

                    }
                }
        );


        filter.addAction(Intent.ACTION_BATTERY_LOW);
        filter.addAction(TelephonyManager.ACTION_PHONE_STATE_CHANGED);


    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, filter);
        registerReceiver(receiver1, filter1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
        unregisterReceiver(receiver1);
    }



}