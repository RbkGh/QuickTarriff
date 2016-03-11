package com.swiftpot.android.tariffplanner;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;

import com.swiftpot.android.tariffplanner.adapters.CoverFlowAdapter;
import com.swiftpot.android.tariffplanner.dataobjects.ApplianceItem;

import java.util.ArrayList;
import java.util.Collection;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeActivityFragment extends Fragment {

    private FeatureCoverFlow coverFlow;
    private CoverFlowAdapter adapter;
    CheckBox checkBox;
    private ArrayList<ApplianceItem> applianceItems;
    public HomeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        coverFlow = (FeatureCoverFlow) view.findViewById(R.id.coverflow);
        coverFlow.setShouldRepeat(true);

        checkBox = (CheckBox) view.findViewById(R.id.checkBox);

        setupData();

        adapter = new CoverFlowAdapter((AppCompatActivity)getActivity(), applianceItems);


        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(onScrollListener());
        coverFlow.setOnItemSelectedListener(onItemSelectedListener());




        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void setupData(){
        applianceItems = new ArrayList<>();

        applianceItems.add(new ApplianceItem(R.mipmap.ic_tv,"One",R.id.checkBox));
        applianceItems.add(new ApplianceItem(R.mipmap.bulb_red, "Two",R.id.checkBox));
        applianceItems.add(new ApplianceItem(R.mipmap.ic_tv,"Three",R.id.checkBox));
        applianceItems.add(new ApplianceItem(R.mipmap.bulb_red, "Four",R.id.checkBox));
        applianceItems.add(new ApplianceItem(R.mipmap.ic_tv,"Five",R.id.checkBox));
        applianceItems.add(new ApplianceItem(R.mipmap.bulb_red, "Six",R.id.checkBox));
    }

    private FeatureCoverFlow.OnScrollPositionListener onScrollListener() {
        return new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                Log.v("MainActiivty", "position: " + position);
            }

            @Override
            public void onScrolling() {
                Log.i("MainActivity", "scrolling");
            }
        };
    }

    private FeatureCoverFlow.OnItemSelectedListener onItemSelectedListener(){
        return new FeatureCoverFlow.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            CheckBox checkBox1 =(CheckBox)adapterView.getSelectedView().findViewById(R.id.checkBox);
                checkBox1.toggle();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
    };
}
