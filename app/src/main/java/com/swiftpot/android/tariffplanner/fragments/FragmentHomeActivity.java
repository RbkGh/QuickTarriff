package com.swiftpot.android.tariffplanner.fragments;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
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
import com.swiftpot.android.tariffplanner.R;
import com.swiftpot.android.tariffplanner.adapters.CoverFlowAdapter;
import com.swiftpot.android.tariffplanner.dataobjects.ApplianceItem;
import com.swiftpot.android.tariffplanner.dataobjects.ApplianceItemDetailed;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;
import xyz.hanks.library.SmallBang;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentHomeActivity extends Fragment {


    ButtonFloat fabNext;
    private FeatureCoverFlow coverFlow;
    private CoverFlowAdapter adapter;
    CheckBox checkBox;
    private ArrayList<ApplianceItem> applianceItems;
    private ArrayList<ApplianceItemDetailed> applianceItemDetailedArrayList = new ArrayList<>(0) ;


    public FragmentHomeActivity() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //return
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        coverFlow = (FeatureCoverFlow) rootView.findViewById(R.id.coverflow);
        fabNext = (ButtonFloat) rootView.findViewById(R.id.fabNext);


        checkBox = (CheckBox) rootView.findViewById(R.id.checkBox);
        Log.v("FragmentSound", "Initializing sounds...");
        final MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), R.raw.fb_pop);

        setupData();

        adapter = new CoverFlowAdapter((AppCompatActivity) getActivity(), applianceItems);

        fabNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("ClickAlert", "Button Clicked:::::");

                SmallBang smallBang = SmallBang.attach2Window(getActivity());
                smallBang.bang(fabNext);
                Log.v(getTag(), "Playing sound...");

                mediaPlayer.start();

                checkApplianceChoice(view);


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

        applianceItems.add(new ApplianceItem(R.mipmap.ic_tv, "Tv", checkBox));
        applianceItems.add(new ApplianceItem(R.mipmap.bulb_red, "Bulb", checkBox));
        applianceItems.add(new ApplianceItem(R.mipmap.ic_launcher_fan, "Fan", checkBox));
        applianceItems.add(new ApplianceItem(R.mipmap.ic_launcher, "Washing Machine", checkBox));
//        applianceItems.add(new ApplianceItem(R.mipmap.ic_tv, "Five", checkBox));
//        applianceItems.add(new ApplianceItem(R.mipmap.ic_launcher_fan, "Six", checkBox));
    }

    private void checkApplianceChoice(View view){

    //for(ApplianceItem applianceItem : coverFlow.getAdapter().getItem())
    for(int i =0;i <= coverFlow.getAdapter().getCount()-1;i++){
        ApplianceItem applianceItem = (ApplianceItem)coverFlow.getAdapter().getItem(i);
        ApplianceItemDetailed applianceItemDetailed = new ApplianceItemDetailed(applianceItem.getImageSource(),applianceItem.getName());
        if((applianceItem.getItemCheckedState()) == (ApplianceItem.ItemCheckedState.ITEM_CHECKED_STATE)){
            applianceItemDetailedArrayList.add(applianceItemDetailed);
        }else{
            //do nothing
        }
    }

        try {
            if(applianceItemDetailedArrayList.equals(null) || applianceItemDetailedArrayList.isEmpty()){
                Snackbar.make(view,"Select At Least One",Snackbar.LENGTH_SHORT).show();
            }else{
                FragmentDetailedAppliance fragmentDetailedAppliance = new FragmentDetailedAppliance();
                Bundle bundleForFragment = new Bundle();
                //bundleForFragment.putP
                Log.i("AppItemArrayCount", "Number of Items = " + applianceItemDetailedArrayList.size());
                bundleForFragment.putParcelableArrayList("detailedApplianceFragment", applianceItemDetailedArrayList);
                fragmentDetailedAppliance.setArguments(bundleForFragment);
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()

                        .replace(R.id.content, fragmentDetailedAppliance)
                        .addToBackStack(null)
                        .commit();
            }
        }catch(NullPointerException npe){
            Snackbar.make(view,"Select At Least One",Snackbar.LENGTH_SHORT).show();
        }

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
                fabNext.startAnimation(in);

                ApplianceItem applianceItemInOnItemSelect = (ApplianceItem)adapterView.getAdapter().getItem(i);
                //ApplianceItemDetailed applianceItemDetailed =
                //        new ApplianceItemDetailed(applianceItemInOnItemSelect.getImageSource(), applianceItemInOnItemSelect.getName());
                if (checkBox1.isChecked()){
                        applianceItemInOnItemSelect.setItemCheckedState(ApplianceItem.ItemCheckedState.ITEM_CHECKED_STATE);

                   }else{
                    applianceItemInOnItemSelect.setItemCheckedState(ApplianceItem.ItemCheckedState.ITEM_UNCHECKED_STATE);
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
    }

    /**
     * Called when the fragment is visible to the user and actively running.
     * This is generally
     *
     * Activity's lifecycle.
     */
    @Override
    public void onResume() {
        super.onResume();
        applianceItemDetailedArrayList.clear();
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

    }
}
