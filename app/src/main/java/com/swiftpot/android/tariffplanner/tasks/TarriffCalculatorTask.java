package com.swiftpot.android.tariffplanner.tasks;/**
 * Created by Rodney on 19-Mar-16.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.swiftpot.android.tariffplanner.calculation.model.TarriffCalculationRequestPayload;
import com.swiftpot.android.tariffplanner.calculation.impl.TarriffMainCalculatorRenderer;
import com.swiftpot.android.tariffplanner.dataobjects.ApplianceItemWithQtyAndHours;
import com.swiftpot.android.tariffplanner.fragments.FragmentDetailedAppliance;
import com.swiftpot.android.tariffplanner.fragments.FragmentTarrifCalculationResponse;

import java.util.ArrayList;

/**
 * Created by Ace Programmer Rbk<rodney@swiftpot.com> on 19-Mar-16
 * 9:16 AM
 */
public class TarriffCalculatorTask extends ParentTask {
    ArrayList<ApplianceItemWithQtyAndHours> applianceItemWithQtyAndHoursList;
    TarriffMainCalculatorRenderer tarriffCalculator;
    TarriffCalculationRequestPayload tarriffRequestPayload;
    FragmentManager fm;
    public TarriffCalculatorTask(TarriffCalculationRequestPayload tarriffRequestPayload,
                                 Context context,
                                 String dialogMessage,
                                 FragmentManager fm,
                                 ArrayList<ApplianceItemWithQtyAndHours> applianceItemWithQtyAndHoursList){
        super(context,dialogMessage);
        this.tarriffRequestPayload = tarriffRequestPayload;
        this.fm = fm;
        this.applianceItemWithQtyAndHoursList = applianceItemWithQtyAndHoursList;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        tarriffCalculator = new TarriffMainCalculatorRenderer(tarriffRequestPayload,context);
        tarriffCalculator.calculateTarriff();
        Log.i(getClass().getName(), "Total Cost =" + tarriffCalculator.getTotalCostDue());
        Log.i(getClass().getName(),"Total Govt Subsidy = "+tarriffCalculator.getGovtSubsidyAmount());
        Log.i(getClass().getName(),"Total Units = "+tarriffCalculator.getTotalUnits());
        Log.i(getClass().getName(),"Currency = "+tarriffCalculator.getCurrency());
        return super.doInBackground(objects);
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        Bundle bundleForFragment = new Bundle();
        bundleForFragment.putString(FragmentDetailedAppliance.TOTAL_AMOUNT_DUE_BEFORE_SUBSIDY_KEY, String.valueOf(tarriffCalculator.getTotalCostDueBeforeSubsidy()));
        bundleForFragment.putString(FragmentDetailedAppliance.TOTAL_UNITS_IN_WATTS_KEY, String.valueOf(tarriffCalculator.getTotalUnits()));
        bundleForFragment.putString(FragmentDetailedAppliance.TOTAL_GOVT_SUBSIDY_KEY,tarriffCalculator.getGovtSubsidyAmount());
        bundleForFragment.putString(FragmentDetailedAppliance.TOTAL_AMOUNT_DUE_KEY,tarriffCalculator.getTotalCostDue());
        bundleForFragment.putString(FragmentDetailedAppliance.CURRENCY_KEY,tarriffCalculator.getCurrency());
        bundleForFragment.putParcelableArrayList(FragmentDetailedAppliance.APPLIANCE_ITEMS_LIST_KEY, applianceItemWithQtyAndHoursList);


        FragmentTarrifCalculationResponse fragmentTarrifCalculationResponse = new FragmentTarrifCalculationResponse();
        fragmentTarrifCalculationResponse.setArguments(bundleForFragment);
        fragmentTarrifCalculationResponse.show(fm, "Dialog");
    }
}
