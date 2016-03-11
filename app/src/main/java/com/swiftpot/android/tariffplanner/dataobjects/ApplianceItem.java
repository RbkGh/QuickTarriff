package com.swiftpot.android.tariffplanner.dataobjects;/**
 * Created by Rodney on 11-Mar-16.
 */

/**
 * Created by Ace Programmer Rbk<rodney@swiftpot.com> on 11-Mar-16
 * 12:32 AM
 */
public class ApplianceItem {

        int imageSource;
        String name;

        public ApplianceItem(int imageSource, String name){
        this.imageSource = imageSource;
            this.name = name;

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
}
