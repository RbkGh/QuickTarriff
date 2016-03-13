package com.swiftpot.android.tariffplanner.dataobjects;


/**
 * Created by Ace Programmer Rbk<rodney@swiftpot.com> on 11-Mar-16
 * 12:32 AM
 */
public class ApplianceItem {

        int imageSource;
        String name;
        int checkBoxId;

        public ApplianceItem(){}
    public ApplianceItem(int imageSource, String name){
        this.imageSource = imageSource;
        this.name = name;


    }
        public ApplianceItem(int imageSource, String name,int checkBoxId){
        this.imageSource = imageSource;
            this.name = name;
            this.checkBoxId = checkBoxId;

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

    public int getCheckBoxId() {
        return checkBoxId;
    }

    public void setCheckBoxId(int checkBoxId) {
        this.checkBoxId = checkBoxId;
    }
}
