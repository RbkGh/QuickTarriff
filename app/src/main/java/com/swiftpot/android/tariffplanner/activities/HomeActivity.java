package com.swiftpot.android.tariffplanner.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.swiftpot.android.tariffplanner.R;
import com.swiftpot.android.tariffplanner.fragments.FragmentHomeActivity;
import com.swiftpot.android.tariffplanner.services.QuickStartPreferences;
import com.swiftpot.android.tariffplanner.services.RegistrationIntentService;

public class HomeActivity extends AppCompatActivity {
    int isAvailableCode ;
    static final int REQUEST_CODE_RECOVER_PLAY_SERVICES = 1001;
    private boolean isReceiverRegistered;
    private BroadcastReceiver mRegistrationBroadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mRegistrationBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                //mRegistrationProgressBar.setVisibility(ProgressBar.GONE);
                SharedPreferences sharedPreferences =
                        PreferenceManager.getDefaultSharedPreferences(context);
                boolean sentToken = sharedPreferences
                        .getBoolean(QuickStartPreferences.SENT_TOKEN_TO_SERVER, false);
                if (sentToken) {
                    //use for update of ui incase you wanna update ui for user
                    //mInformationTextView.setText(getString(R.string.gcm_send_message));
                    Toast.makeText(context,"Token Sent =D ",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(context,"Token Not Sent :-(",Toast.LENGTH_LONG).show();
                    //mInformationTextView.setText(getString(R.string.token_error_message));
                }
            }
        };

        // Registering BroadcastReceiver
        registerReceiver();

        if (checkGoogleServicesPresenceAndAct()) {
            // Start IntentService to register this application with GCM.
            Intent intent = new Intent(this, RegistrationIntentService.class);
            startService(intent);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //setup default view by setting simple fragment
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.add(R.id.content, new FragmentHomeActivity());
        tx.commit();



    }

    @Override
    protected void onResume() {
        super.onResume();
        //check again in OnResume
        //checkGoogleServicesPresenceAndAct();
        registerReceiver();

    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mRegistrationBroadcastReceiver);
        isReceiverRegistered = false;
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    private void registerReceiver(){
        if(!isReceiverRegistered) {
            LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
                    new IntentFilter(QuickStartPreferences.REGISTRATION_COMPLETE));
            isReceiverRegistered = true;
        }
    }
    /**
     * Check the device to make sure it has the Google Play Services APK. If
     * it doesn't, display a dialog that allows users to download the APK from
     * the Google Play Store or enable it in the device's system settings.
     */
    public boolean checkGoogleServicesPresenceAndAct(){
        boolean isServicePresent = false;
        if(isServicesPresent()){
            //do nothing and continue execution as its present already
            isServicePresent = true;
        }else{
            if (GoogleApiAvailability.getInstance().isUserResolvableError(isAvailableCode)) {
                showErrorDialog(isAvailableCode);

            } else {
                Toast.makeText(this, "This device is not supported.Install Google Play Services", Toast.LENGTH_LONG).show();
                finish();
            }
            //isServicePresent = false; //unneccessary since isServicePresent is already false
        }

        return isServicePresent;
    }

    public void showErrorDialog(int errorCode){
        GoogleApiAvailability.getInstance().getErrorDialog(this,errorCode,REQUEST_CODE_RECOVER_PLAY_SERVICES).show();
    }
    public boolean isServicesPresent(){
        boolean serviceStatus = false;

         isAvailableCode = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);

        if(isAvailableCode == ConnectionResult.SUCCESS){
            serviceStatus = true;
        }
        else{
            //serviceStatus is already false
        }

        return serviceStatus;
    }
}
