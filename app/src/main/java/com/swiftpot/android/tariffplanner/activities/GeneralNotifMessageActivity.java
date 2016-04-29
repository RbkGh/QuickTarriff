package com.swiftpot.android.tariffplanner.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        final String notifMsg = extras.getString(CustomStrings.FULL_NOTIF_MSG);
        TextView tvNotifMsgFull = (TextView) findViewById(R.id.tvNotifMsgFull);

        tvNotifMsgFull.setText(notifMsg);

        Button btnShareNotifMsg = (Button) findViewById(R.id.btnShareNotifMsg);
        assert btnShareNotifMsg != null;
        btnShareNotifMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, notifMsg);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
    }
}
