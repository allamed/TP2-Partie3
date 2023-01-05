package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import java.util.Date;

public class ThirdReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        String callState =
                intent.getExtras().getString(TelephonyManager.EXTRA_STATE);
        String number = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER); //TO DO: xxx
// utilisez TelephonyManager pour obtenir le numéro appelant en tant qu’extra
        if(callState.equals(TelephonyManager.EXTRA_STATE_RINGING)){
//appel entrant
            Date callStartTime = new Date();
            String callDetails = "Incoming call from " + number + " at " + callStartTime;
            Toast.makeText(context, callDetails, Toast.LENGTH_SHORT).show();
        }

        throw new UnsupportedOperationException("Not yet implemented");
    }
}