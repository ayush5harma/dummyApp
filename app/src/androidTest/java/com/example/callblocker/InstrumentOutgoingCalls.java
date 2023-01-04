package com.example.callblocker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class InstrumentOutgoingCalls extends BroadcastReceiver {
    String number;
    @Override
    public void onReceive(Context context, Intent intent)
    {
        number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        Log.d("12280", "calledNumber is-->> " + number);
        setResultData(null);
        Toast.makeText(context, "Outgoing Call Blocked" , Toast.LENGTH_SHORT).show();
    }
}


