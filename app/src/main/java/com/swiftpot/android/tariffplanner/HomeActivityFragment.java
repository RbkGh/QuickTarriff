package com.swiftpot.android.tariffplanner;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.CheckBox;

import com.gc.materialdesign.views.ButtonFloat;
import com.swiftpot.android.tariffplanner.adapters.CoverFlowAdapter;
import com.swiftpot.android.tariffplanner.dataobjects.ApplianceItem;
import com.swiftpot.android.tariffplanner.fragments.FragmentDetailedAppliance;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeActivityFragment extends Fragment {


    ButtonFloat fabNext;
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
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        coverFlow = (FeatureCoverFlow) rootView.findViewById(R.id.coverflow);
        fabNext = (ButtonFloat) rootView.findViewById(R.id.fabNext);


        checkBox = (CheckBox) rootView.findViewById(R.id.checkBox);

        setupData();

        adapter = new CoverFlowAdapter((AppCompatActivity) getActivity(), applianceItems);

        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("ClickAlert", "Button Clicked:::::");

                FragmentDetailedAppliance fragmentDetailedAppliance = new FragmentDetailedAppliance();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, fragmentDetailedAppliance)
                        .addToBackStack(null)
                        .commit();
            }
        });
        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(onScrollListener());
        coverFlow.setOnItemSelectedListener(onItemSelectedListener());


        return rootView;
    }

    @Override
    public void onViewCreated(View viewMain, Bundle savedInstanceState) {
        super.onViewCreated(viewMain, savedInstanceState);

    }

    private void setupData() {
        applianceItems = new ArrayList<>();

        applianceItems.add(new ApplianceItem(R.mipmap.ic_tv, "One", R.id.checkBox));
        applianceItems.add(new ApplianceItem(R.mipmap.bulb_red, "Two", R.id.checkBox));
        applianceItems.add(new ApplianceItem(R.mipmap.ic_tv, "Three", R.id.checkBox));
        applianceItems.add(new ApplianceItem(R.mipmap.bulb_red, "Four", R.id.checkBox));
        applianceItems.add(new ApplianceItem(R.mipmap.ic_tv, "Five", R.id.checkBox));
        applianceItems.add(new ApplianceItem(R.mipmap.bulb_red, "Six", R.id.checkBox));
    }


    private FeatureCoverFlow.OnScrollPositionListener onScrollListener() {

        return new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                Log.v("MainActiivty", "position: " + position);


                Animation in = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_in);
                fabNext.startAnimation(in);
                fabNext.setVisibility(View.VISIBLE);
            }

            @Override
            public void onScrolling() {
                Log.i("MainActivity", "scrolling");

                Animation in = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_out);
                in.setDuration(200);
                fabNext.startAnimation(in);
                fabNext.setVisibility(View.GONE);

            }
        };
    }


    private FeatureCoverFlow.OnItemSelectedListener onItemSelectedListener() {
        return new FeatureCoverFlow.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                CheckBox checkBox1 = (CheckBox) adapterView.getSelectedView().findViewById(R.id.checkBox);
                checkBox1.toggle();
                Animation in = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce);
                //in.setAnimationListener(getContext());
                fabNext.startAnimation(in);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

    }
}
