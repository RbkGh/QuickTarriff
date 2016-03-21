package com.swiftpot.android.tariffplanner.tasks;/**
 * Created by Rodney on 19-Mar-16.
 */

import android.content.Context;
import android.util.Log;

import com.swiftpot.android.tariffplanner.calculation.model.TarriffCalculationRequestPayload;
import com.swiftpot.android.tariffplanner.calculation.impl.TarriffMainCalculatorRenderer;

/**
 * Created by Ace Programmer Rbk<rodney@swiftpot.com> on 19-Mar-16
 * 9:16 AM
 */
public class TarriffCalculatorTask extends ParentTask {

    TarriffCalculationRequestPayload tarriffRequestPayload;
    public TarriffCalculatorTask(TarriffCalculationRequestPayload tarriffRequestPayload,Context context,String dialogMessage){
        this.tarriffRequestPayload = tarriffRequestPayload;
        this.context = context;
        this.dialogMessage = dialogMessage;
    }
    @Override
    protected Object doInBackground(Object[] objects) {
        TarriffMainCalculatorRenderer tarriffCalculator = new TarriffMainCalculatorRenderer(tarriffRequestPayload,context);
        tarriffCalculator.calculateTarriff();
        Log.i(getClass().getName(), "Total Cost =" + tarriffCalculator.getTotalCostDue());
        Log.i(getClass().getName(),"Total Govt Subsidy = "+tarriffCalculator.getGovtSubsidyAmount());
        Log.i(getClass().getName(),"Total Units = "+tarriffCalculator.getTotalUnits());
        Log.i(getClass().getName(),"Currency = "+tarriffCalculator.getCurrency());
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            Log.i(getClass().getName(),"Interrupted..");
        }

        return super.doInBackground(objects);
    }
}
