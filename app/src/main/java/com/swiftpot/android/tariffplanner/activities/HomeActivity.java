package com.swiftpot.android.tariffplanner.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.swiftpot.android.tariffplanner.R;
import com.swiftpot.android.tariffplanner.fragments.FragmentHomeActivity;

public class HomeActivity extends AppCompatActivity {
    int isAvailableCode ;
    static final int REQUEST_CODE_RECOVER_PLAY_SERVICES = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //check and act accordingly to presence of google play services
        checkGoogleServicesPresenceAndAct();

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
        checkGoogleServicesPresenceAndAct();
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

    public void checkGoogleServicesPresenceAndAct(){
        if(isServicesPresent()){
            //do nothing and continue exectution as its present already
        }else{
            if (GoogleApiAvailability.getInstance().isUserResolvableError(isAvailableCode)) {
                showErrorDialog(isAvailableCode);

            } else {
                Toast.makeText(this, "This device is not supported.Install Google Play Services", Toast.LENGTH_LONG).show();
                finish();
            }

        }
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
