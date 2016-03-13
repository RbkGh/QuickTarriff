package com.swiftpot.android.tariffplanner.fragments;


import android.graphics.Movie;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.swiftpot.android.tariffplanner.R;
import com.swiftpot.android.tariffplanner.adapters.ApplianceRecyclerViewAdapter;
import com.swiftpot.android.tariffplanner.dataobjects.ApplianceItem;
import com.swiftpot.android.tariffplanner.dataobjects.ApplianceItemDetailed;

import java.util.ArrayList;
import java.util.List;


public class FragmentDetailedApplianceInfo extends Fragment {
    private List<ApplianceItemDetailed> applianceItemDetailedList = new ArrayList<>();
    private ApplianceRecyclerViewAdapter mAdapter;
    private RecyclerView recyclerView;
    public FragmentDetailedApplianceInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detailed_appliance_info, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        loadDataForRecyclerView();

        mAdapter = new ApplianceRecyclerViewAdapter(applianceItemDetailedList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        return view;
    }

    private void loadDataForRecyclerView(){
        applianceItemDetailedList.add(new ApplianceItemDetailed(R.mipmap.ic_tv, "One"));
        applianceItemDetailedList.add(new ApplianceItemDetailed(R.mipmap.bulb_red, "One"));
        applianceItemDetailedList.add(new ApplianceItemDetailed(R.mipmap.ic_tv, "One"));

    }
}
