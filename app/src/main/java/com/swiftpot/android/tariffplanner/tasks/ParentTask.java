package com.swiftpot.android.tariffplanner.tasks;/**
 * Created by Rodney on 19-Mar-16.
 */

import android.content.Context;
import android.os.AsyncTask;
import com.swiftpot.android.tariffplanner.customwidgets.CustomProgDialog;


/**
 * Created by Ace Programmer Rbk<rodney@swiftpot.com> on 19-Mar-16
 * 8:56 AM
 */
public class ParentTask extends AsyncTask {

    Context context;
    String dialogMessage;
    CustomProgDialog progressDialog ;


    public ParentTask(){}

    ParentTask(Context context,String dialogMessage){
        this.context = context;
        this.dialogMessage = dialogMessage;

    }

    @Override
    protected void onPreExecute() {
        //super.onPreExecute();
        progressDialog =  new CustomProgDialog(context,dialogMessage);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

    }

    @Override
    protected Object doInBackground(Object[] objects) {
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        //super.onPostExecute(o);
        progressDialog.dismiss();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        //progressDialog.dismiss();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getDialogMessage() {
        return dialogMessage;
    }

    public void setDialogMessage(String dialogMessage) {
        this.dialogMessage = dialogMessage;
    }

    public CustomProgDialog getProgressDialog() {
        return progressDialog;
    }

    public void setProgressDialog(CustomProgDialog progressDialog) {
        this.progressDialog = progressDialog;
    }
}
