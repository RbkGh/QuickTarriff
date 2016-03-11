package com.swiftpot.android.tariffplanner;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    private ArrayList<ApplianceItem> applianceItems;
    public HomeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        coverFlow = (FeatureCoverFlow) view.findViewById(R.id.coverflow);
        setupData();
        adapter = new CoverFlowAdapter(getContext(), applianceItems);

        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(onScrollListener());

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void setupData(){
        applianceItems = new ArrayList<>();

        ApplianceItem applianceItemOne = new ApplianceItem(R.mipmap.ic_tv,"");
        ApplianceItem applianceItemTwo = new ApplianceItem(R.mipmap.bulb_red,"");
       // ApplianceItem applianceItemThree = new ApplianceItem(R.mipmap.ic_launcher,"");
       // ApplianceItem applianceItemFour = new ApplianceItem(R.mipmap.ic_launcher,"");

        applianceItems.add(applianceItemOne);
        applianceItems.add(applianceItemTwo);
        //applianceItems.add(applianceItemThree);
        //applianceItems.add(applianceItemFour);
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
}
