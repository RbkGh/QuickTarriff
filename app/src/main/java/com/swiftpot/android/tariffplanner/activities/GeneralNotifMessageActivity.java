package com.swiftpot.android.tariffplanner.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.swiftpot.android.tariffplanner.R;
import com.swiftpot.android.tariffplanner.extras.CustomStrings;
import com.swiftpot.android.tariffplanner.services.CustomGcmListenerService;

public class GeneralNotifMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_notif_message);

        Bundle extras = getIntent().getExtras();

        String notifMsg = extras.getString(CustomStrings.FULL_NOTIF_MSG);
        TextView tvNotifMsgFull = (TextView) findViewById(R.id.tvNotifMsgFull);

        tvNotifMsgFull.setText(notifMsg);
    }
}
