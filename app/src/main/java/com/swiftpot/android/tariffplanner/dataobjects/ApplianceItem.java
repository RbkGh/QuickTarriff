package com.swiftpot.android.tariffplanner.dataobjects;


import android.widget.CheckBox;

/**
 * Created by Ace Programmer Rbk<rodney@swiftpot.com> on 11-Mar-16
 * 12:32 AM
 */
public class ApplianceItem {

        int imageSource;
        String name;
        CheckBox checkBoxId;
        ItemCheckedState itemCheckedState;


        public ApplianceItem(){}
    public ApplianceItem(int imageSource, String name){
        this.imageSource = imageSource;
        this.name = name;


    }
        public ApplianceItem(int imageSource, String name,CheckBox checkBoxId){
        this.imageSource = imageSource;
            this.name = name;
            this.checkBoxId = checkBoxId;

        }

    public ApplianceItem(int imageSource, String name,ItemCheckedState itemCheckedState) {
        this.imageSource = imageSource;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CheckBox getCheckBoxId() {
        return checkBoxId;
    }

    public void setCheckBoxId(CheckBox checkBoxId) {
        this.checkBoxId = checkBoxId;
    }

    public enum ItemCheckedState{

         ITEM_CHECKED_STATE,
         ITEM_UNCHECKED_STATE;
    }
}
