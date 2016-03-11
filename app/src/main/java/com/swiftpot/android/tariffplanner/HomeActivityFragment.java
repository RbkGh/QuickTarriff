package com.swiftpot.android.tariffplanner;

import android.animation.Animator;
import android.app.Activity;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Toast;

import com.swiftpot.android.tariffplanner.adapters.CoverFlowAdapter;
import com.swiftpot.android.tariffplanner.dataobjects.ApplianceItem;

import java.util.ArrayList;
import java.util.Collection;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeActivityFragment extends Fragment {

    CoordinatorLayout coordinatorLayout;
    FloatingActionButton fabNext;
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
        fabNext = (FloatingActionButton) rootView.findViewById(R.id.fabNext);
        coordinatorLayout = (CoordinatorLayout)rootView.findViewById(R.id.coordinatorLayout);

        checkBox = (CheckBox) rootView.findViewById(R.id.checkBox);

        setupData();

        adapter = new CoverFlowAdapter((AppCompatActivity)getActivity(), applianceItems);

        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(getParentFragment().getView(), "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Toast.makeText(getActivity().getApplicationContext(),"Clicked!!",Toast.LENGTH_LONG).show();
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
                fabNext.setVisibility(View.VISIBLE);
            }

            @Override
            public void onScrolling() {
                Log.i("MainActivity", "scrolling");
                fabNext.setVisibility(View.GONE);

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
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

    }
}