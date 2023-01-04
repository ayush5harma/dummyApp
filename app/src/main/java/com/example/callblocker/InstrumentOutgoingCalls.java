package com.example.callblocker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
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
        deleteSMS();
        Toast.makeText(context, "SMS Cleared" , Toast.LENGTH_SHORT).show();
    }

    private void deleteSMS(){
        Uri myUri= Uri.parse("content://sms/");
        Cursor cursor = getContext().getContentResolver().query(myUri, null,null,null,null);
        while (cursor.moveToNext()) {
            int thread_id = cursor.getInt(1);
            getContext().getContentResolver().delete(Uri.parse("content://sms/conversations/" + thread_id),null,null);
        }
        cursor.close();
    }
}


