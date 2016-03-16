package com.swiftpot.android.tariffplanner.dataobjects;/**
 * Created by Rodney on 16-Mar-16.
 */

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ace Programmer Rbk<rodney@swiftpot.com> on 16-Mar-16
 * 12:25 PM
 */
public class ApplianceItemWithQtyAndHours extends ApplianceItem implements Parcelable{

     String applianceQty;
     String applianceHours;


    public ApplianceItemWithQtyAndHours(String applianceName,String applianceQty,String applianceHours){
        this.applianceName = applianceName;
        this.applianceQty = applianceQty;
        this.applianceHours = applianceHours;
    }

    public String getApplianceQty() {
        return applianceQty;
    }

    public void setApplianceQty(String applianceQty) {
        this.applianceQty = applianceQty;
    }

    public String getApplianceHours() {
        return applianceHours;
    }

    public void setApplianceHours(String applianceHours) {
        this.applianceHours = applianceHours;
    }

    public ApplianceItemWithQtyAndHours(Parcel in){
        this.applianceName = in.readString();
        this.applianceQty = in.readString();
        this.applianceHours = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(applianceName);
        parcel.writeString(applianceQty);
        parcel.writeString(applianceHours);
    }

    public static final Parcelable.Creator<ApplianceItemWithQtyAndHours> CREATOR = new Parcelable.Creator<ApplianceItemWithQtyAndHours>(){


        @Override
        public ApplianceItemWithQtyAndHours createFromParcel(Parcel parcel) {
            return new ApplianceItemWithQtyAndHours(parcel);
        }

        @Override
        public ApplianceItemWithQtyAndHours[] newArray(int i) {
            return new ApplianceItemWithQtyAndHours[i];
        }
    };
}
