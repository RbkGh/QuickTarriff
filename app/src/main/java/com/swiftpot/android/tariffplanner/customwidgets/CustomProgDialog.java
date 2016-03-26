package com.swiftpot.android.tariffplanner.customwidgets;/**
 * Created by Rodney on 26-Mar-16.
 */

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.gc.materialdesign.widgets.ProgressDialog;
import com.swiftpot.android.tariffplanner.R;

/**
 * Created by Ace Programmer Rbk<rodney@swiftpot.com> on 26-Mar-16
 * 3:08 PM
 */
public class CustomProgDialog extends ProgressDialog {
    public CustomProgDialog(Context context, String title) {
        super(context, title);
    }
//override to allow setCancelledOnTouch outside to work as it doesnt work by default for materialdesign lib
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout backView = (RelativeLayout) findViewById(R.id.dialog_rootView);
        backView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }
}
