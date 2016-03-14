package com.swiftpot.android.tariffplanner.adapters;/**
 * Created by Rodney on 12-Mar-16.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.swiftpot.android.tariffplanner.R;
import com.swiftpot.android.tariffplanner.dataobjects.ApplianceItemDetailed;

import java.util.List;

/**
 * Created by Ace Programmer Rbk<rodney@swiftpot.com> on 12-Mar-16
 * 10:57 PM
 */
public class ApplianceRecyclerViewAdapter  extends RecyclerView.Adapter<ApplianceRecyclerViewAdapter.MyViewHolder>{
    NumberPicker numberPickerQty;
    NumberPicker numberPickerHours;

    private List<ApplianceItemDetailed> applianceItemDetailedList;

    public ApplianceRecyclerViewAdapter(List<ApplianceItemDetailed> applianceItemDetailedList){
        this.applianceItemDetailedList = applianceItemDetailedList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_appliance_with_qty, parent, false);

        numberPickerQty = (NumberPicker) itemView.findViewById(R.id.numberPickerQty);
        numberPickerHours = (NumberPicker) itemView.findViewById(R.id.numberPickerHours);

        numberPickerQty.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        numberPickerQty.setMinValue(0);
        numberPickerQty.setMaxValue(10);
        numberPickerQty.setWrapSelectorWheel(true);

        numberPickerHours.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        numberPickerHours.setMinValue(0);
        numberPickerHours.setMaxValue(10);
        numberPickerHours.setWrapSelectorWheel(true);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ApplianceItemDetailed applianceItemDetailedSingle = applianceItemDetailedList.get(position);
        holder.imgVwApplianceImage.setImageResource(applianceItemDetailedSingle.getImageSource());
        holder.tvApplianceName.setText(applianceItemDetailedSingle.getName());
    }


    @Override
    public int getItemCount() {
        return applianceItemDetailedList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgVwApplianceImage;
        public TextView tvApplianceName;

        public MyViewHolder(View view){
            super(view);
            imgVwApplianceImage = (ImageView) view.findViewById(R.id.imageAppliance);
            tvApplianceName = (TextView) view.findViewById(R.id.tvApplianceName);
        }
    }
}
