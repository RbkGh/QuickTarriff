package com.swiftpot.android.tariffplanner.fragments;


import android.content.Context;
import android.graphics.Movie;
import android.os.Bundle;

import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonRectangle;
import com.swiftpot.android.tariffplanner.R;
import com.swiftpot.android.tariffplanner.adapters.ApplianceRecyclerViewAdapter;
import com.swiftpot.android.tariffplanner.dataobjects.ApplianceItemDetailed;
import com.swiftpot.android.tariffplanner.recyclers.decoration.DividerItemDecoration;
import com.swiftpot.android.tariffplanner.recyclers.listeners.RecyclerTouchListener;

import java.util.ArrayList;
import java.util.List;

import xyz.hanks.library.SmallBang;


public class FragmentDetailedAppliance extends Fragment {
    private List<ApplianceItemDetailed> applianceItemDetailedList = new ArrayList<>();
    private ApplianceRecyclerViewAdapter mAdapter;
    private RecyclerView recyclerView;
    private ButtonRectangle buttonCalculate;
    private Vibrator myVibrator;
    private Animation animationSlideIn;
    public FragmentDetailedAppliance() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detailed_appliance_info, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        myVibrator = (Vibrator)getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        buttonCalculate = (ButtonRectangle) view.findViewById(R.id.buttonCalculate);


        loadDataForRecyclerView();

        mAdapter = new ApplianceRecyclerViewAdapter(applianceItemDetailedList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        animationSlideIn = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),
                R.anim.slide_up);
        recyclerView.addOnItemTouchListener(new ApplianceDetailedRecyclerTouchListener(getActivity(),
                recyclerView,
                new ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        ApplianceItemDetailed applianceItemDetailed = applianceItemDetailedList.get(position);
                        Log.i("Recyc Item", "Recycler Item Clicked");
                        Toast.makeText(getActivity(), applianceItemDetailed.getName() + " is selected!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }));

        buttonCalculate.startAnimation(animationSlideIn);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myVibrator.vibrate(50);
            }
        });

        return view;
    }


    private void loadDataForRecyclerView(){
        applianceItemDetailedList.add(new ApplianceItemDetailed(R.mipmap.ic_tv, "One"));
        applianceItemDetailedList.add(new ApplianceItemDetailed(R.mipmap.bulb_red, "One"));
        applianceItemDetailedList.add(new ApplianceItemDetailed(R.mipmap.ic_tv, "One"));

    }




    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }


    public class ApplianceDetailedRecyclerTouchListener implements RecyclerView.OnItemTouchListener{

        private GestureDetector gestureDetector;
        private FragmentDetailedAppliance.ClickListener clickListener;
        public ApplianceDetailedRecyclerTouchListener(Context context, final RecyclerView recyclerView, final FragmentDetailedAppliance.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }
        /**
         * Silently observe and/or take over touch events sent to the RecyclerView
         * before they are handled by either the RecyclerView itself or its child views.
         * <p/>
         * <p>The onInterceptTouchEvent methods of each attached OnItemTouchListener will be run
         * in the order in which each listener was added, before any other touch processing
         * by the RecyclerView itself or child views occurs.</p>
         *
         * @param rv
         * @param e  MotionEvent describing the touch event. All coordinates are in
         *           the RecyclerView's coordinate system.
         * @return true if this OnItemTouchListener wishes to begin intercepting touch events, false
         * to continue with the current behavior and continue observing future events in
         * the gesture.
         */
        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            return false;
        }

        /**
         * Process a touch event as part of a gesture that was claimed by returning true from
         * a previous call to {@link #onInterceptTouchEvent}.
         *
         * @param rv
         * @param e  MotionEvent describing the touch event. All coordinates are in
         */
        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        /**
         * Called when a child of RecyclerView does not want RecyclerView and its ancestors to
         * intercept touch events with
         * {@link ViewGroup#onInterceptTouchEvent(MotionEvent)}.
         *
         * @param disallowIntercept True if the child does not want the parent to
         *                          intercept touch events.
         * @see
         */
        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
