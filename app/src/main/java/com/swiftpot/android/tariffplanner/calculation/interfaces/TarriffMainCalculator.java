package com.swiftpot.android.tariffplanner.calculation.interfaces;

import com.swiftpot.android.tariffplanner.calculation.model.TarriffCalculationResponePayload;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at rbk.unlimited@gmail.com> on
 *         17-Mar-16
 */
public interface TarriffMainCalculator {

    double getTotalUnits();

    double getGovtSubsidyAmount();

    double getTotalCostDue();

    String getCurrency();

    TarriffCalculationResponePayload getFullResponsePayload();
}
