package com.example.tickerwatchlistmanager2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;

public class SMSReceiver extends BroadcastReceiver {

    //extract message from the sms as string and add to bundle
    //create intent to main activity
    //set intent action as intent.action_send
    //put bindle with the sms as extra to intent
    //set flags
    @Override
    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();

        if(intent.getAction().equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)){

            Intent myIntent = new Intent(context, MainActivity.class);
            myIntent.setAction(Intent.ACTION_SEND);
            myIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if(bundle != null){
                Object[] pdusObj = (Object[]) bundle.get("pdus");
                String format = bundle.getString("format").toString();

                for(int i=0; i<pdusObj.length; i++){
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i], format);
                    String message = currentMessage.getDisplayMessageBody();
                    Log.i("SMS", message);
                    myIntent.putExtra("sms", message);
                }
            }
            context.startActivity(myIntent);
        }
    }
}