package com.swiftpot.android.tariffplanner.dataobjects;


import android.widget.CheckBox;

/**
 * Created by Ace Programmer Rbk<rodney@swiftpot.com> on 11-Mar-16
 * 12:32 AM
 */
public class ApplianceItem {

        int imageSource;
        String applianceName;
        CheckBox checkBoxId;
        ItemCheckedState itemCheckedState;
        Double powerInWatts;

    public ApplianceItem(){}

    public ApplianceItem(String applianceName){
        this.applianceName = applianceName;
    }

    public ApplianceItem(int imageSource, String applianceName){
        this.imageSource = imageSource;
        this.applianceName = applianceName;


    }
        public ApplianceItem(int imageSource, String applianceName,CheckBox checkBoxId){
        this.imageSource = imageSource;
            this.applianceName = applianceName;
            this.checkBoxId = checkBoxId;

        }
    public ApplianceItem(int imageSource, String applianceName,Double powerInWatts){
        this.imageSource = imageSource;
        this.applianceName = applianceName;
        this.powerInWatts = powerInWatts;

    }

    public ApplianceItem(int imageSource, String applianceName,ItemCheckedState itemCheckedState) {
        this.imageSource = imageSource;
        this.applianceName = applianceName;
        this.itemCheckedState = itemCheckedState;
    }

    public ItemCheckedState getItemCheckedState() {
        return itemCheckedState;
    }

    public void setItemCheckedState(ItemCheckedState itemCheckedState) {
        this.itemCheckedState = itemCheckedState;
    }

    public int getImageSource() {
        return imageSource;
    }

    public void setImageSource(int imageSource) {
        this.imageSource = imageSource;
    }

    public String getApplianceName() {
        return applianceName;
    }

    public void setApplianceName(String applianceName) {
        this.applianceName = applianceName;
    }

    public CheckBox getCheckBoxId() {
        return checkBoxId;
    }

    public void setCheckBoxId(CheckBox checkBoxId) {
        this.checkBoxId = checkBoxId;
    }

    public Double getPowerInWatts() {
        return powerInWatts;
    }

    public void setPowerInWatts(Double powerInWatts) {
        this.powerInWatts = powerInWatts;
    }

    public enum ItemCheckedState{

         ITEM_CHECKED_STATE,
         ITEM_UNCHECKED_STATE;
    }
}
