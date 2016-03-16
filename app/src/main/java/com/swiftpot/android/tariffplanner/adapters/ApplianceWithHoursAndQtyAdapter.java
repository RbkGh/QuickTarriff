package com.swiftpot.android.tariffplanner.adapters;/**
 * Created by Rodney on 16-Mar-16.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.swiftpot.android.tariffplanner.R;
import com.swiftpot.android.tariffplanner.dataobjects.ApplianceItemWithQtyAndHours;

import java.util.List;

/**
 * Created by Ace Programmer Rbk<rodney@swiftpot.com> on 16-Mar-16
 * 12:18 PM
 */
public class ApplianceWithHoursAndQtyAdapter extends RecyclerView.Adapter<ApplianceWithHoursAndQtyAdapter.MyViewHolder>{

    List<ApplianceItemWithQtyAndHours> applianceItemWithQtyAndHoursList;

    public ApplianceWithHoursAndQtyAdapter(List<ApplianceItemWithQtyAndHours> applianceItemWithQtyAndHoursList){
        this.applianceItemWithQtyAndHoursList = applianceItemWithQtyAndHoursList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_appliance_list_final, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ApplianceItemWithQtyAndHours applianceItemWithQtyAndHours = applianceItemWithQtyAndHoursList.get(position);
        holder.applianceName.setText(applianceItemWithQtyAndHours.getApplianceName());
        holder.applianceQty.setText(applianceItemWithQtyAndHours.getApplianceQty());
        holder.applianceHours.setText(applianceItemWithQtyAndHours.getApplianceHours());

    }



     public ApplianceItemWithQtyAndHours getItemAt(int i){
        return applianceItemWithQtyAndHoursList.get(i);
    }

    @Override
    public int getItemCount() {
        return applianceItemWithQtyAndHoursList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView applianceName;
        TextView applianceQty;
        TextView applianceHours;

        public MyViewHolder(View view){

            super(view);
            applianceName = (TextView) view.findViewById(R.id.applianceName);
            applianceQty = (TextView) view.findViewById(R.id.applianceQty);
            applianceHours = (TextView) view.findViewById(R.id.applianceHours);
        }
    }
}
