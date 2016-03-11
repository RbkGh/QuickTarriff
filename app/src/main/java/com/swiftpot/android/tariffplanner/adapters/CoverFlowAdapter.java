package com.swiftpot.android.tariffplanner.adapters;/**
 * Created by Rodney on 11-Mar-16.
 */

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.swiftpot.android.tariffplanner.R;
import com.swiftpot.android.tariffplanner.dataobjects.ApplianceItem;

import java.util.ArrayList;

/**
 * Created by Ace Programmer Rbk<rodney@swiftpot.com> on 11-Mar-16
 * 12:37 AM
 */
public class CoverFlowAdapter extends BaseAdapter {

    private ArrayList<ApplianceItem> data;
    private Context activity;

    public CoverFlowAdapter(Context context, ArrayList<ApplianceItem> objects) {
        this.activity = context;
        this.data = objects;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public ApplianceItem getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)activity.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
                    //(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_appliance_list, null, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.applianceImage.setImageResource(data.get(position).getImageSource());
        viewHolder.applianceName.setText(data.get(position).getName());

        convertView.setOnClickListener(onClickListener(position));

        return convertView;
    }

    private View.OnClickListener onClickListener(final int position) {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                final Dialog dialog = new Dialog(activity);
//                dialog.setContentView(R.layout.dialog_game_info);
//                dialog.setCancelable(true); // dimiss when touching outside
//                dialog.setTitle("Game Details");

//                TextView text = (TextView) dialog.findViewById(R.id.name);
//                text.setText(getItem(position).getName());
//                ImageView image = (ImageView) dialog.findViewById(R.id.image);
//                image.setImageResource(getItem(position).getImageSource());

                //dialog.show();
            }
        };
    }


    private static class ViewHolder {
        private TextView applianceName;
        private ImageView applianceImage;

        public ViewHolder(View v) {
            applianceImage = (ImageView) v.findViewById(R.id.image);
            applianceName = (TextView) v.findViewById(R.id.name);
        }
    }
}
