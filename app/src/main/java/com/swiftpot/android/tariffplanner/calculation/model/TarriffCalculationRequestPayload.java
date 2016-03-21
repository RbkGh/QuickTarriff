package com.swiftpot.android.tariffplanner.calculation.model;

import java.util.List;

/**
 * @author Ace Programmer Rbk
 *         <Rodney Kwabena Boachie at rbk.unlimited@gmail.com> on
 *         17-Mar-16
 */
public class TarriffCalculationRequestPayload {

    List<ApplianceItem> applianceItemList;

    public List<ApplianceItem> getApplianceItemList() {
        return applianceItemList;
    }

    public void setApplianceItemList(List<ApplianceItem> applianceItemList) {
        this.applianceItemList = applianceItemList;
    }


}
