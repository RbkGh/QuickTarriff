package com.swiftpot.android.tariffplanner.services;/**
 * Created by Rodney on 10-Apr-16.
 */

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created by Ace Programmer Rbk<rodney@swiftpot.com> on 10-Apr-16
 * 8:31 PM
 */
public class CustomGcmListenerService extends GcmListenerService {
    private  final String TAG = this.getClass().getName();
    @Override
    public void onMessageReceived(String from, Bundle data) {
        String message = data.getString("message");
        Log.d(TAG, "From: " + from);
        Log.d(TAG, "Message: " + message);

        if (from.startsWith("/topics/")) {
            // message received from some topic.
        } else {
            // normal downstream message.
        }

    }
}
