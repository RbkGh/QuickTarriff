package com.swiftpot.android.tariffplanner.dataobjects;/**
 * Created by Rodney on 12-Mar-16.
 */

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ace Programmer Rbk<rodney@swiftpot.com> on 12-Mar-16
 * 10:53 PM
 */
public class ApplianceItemDetailed extends ApplianceItem implements Parcelable{

    public ApplianceItemDetailed(){}

    public ApplianceItemDetailed(int imageSource, String name) {

        super(imageSource, name);
    }

    public ApplianceItemDetailed(int imageSource, String name,Double powerInWatts) {

        super(imageSource, name,powerInWatts);
    }

    /**
     * Retrieving ApplicanceItemDetailed data from Parcel object
     * This constructor is invoked by the method createFromParcel(Parcel source) of
     * the object CREATOR
     **/
    private ApplianceItemDetailed(Parcel in){
        this.imageSource = in.readInt();
        this.applianceName = in.readString();
        this.powerInWatts = in.readDouble();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(imageSource);
        parcel.writeString(applianceName);
        parcel.writeDouble(powerInWatts);
    }

    public static final Parcelable.Creator<ApplianceItemDetailed> CREATOR = new Parcelable.Creator<ApplianceItemDetailed>(){
        @Override
        public ApplianceItemDetailed createFromParcel(Parcel parcel) {
            return new ApplianceItemDetailed(parcel);
        }

        @Override
        public ApplianceItemDetailed[] newArray(int i) {
            return new ApplianceItemDetailed[i];
        }
    };
}
