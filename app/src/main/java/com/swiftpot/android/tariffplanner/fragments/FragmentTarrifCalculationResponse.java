package com.swiftpot.android.tariffplanner.fragments;


import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.swiftpot.android.tariffplanner.R;
import com.swiftpot.android.tariffplanner.adapters.ApplianceWithHoursAndQtyAdapter;
import com.swiftpot.android.tariffplanner.dataobjects.ApplianceItemWithQtyAndHours;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTarrifCalculationResponse#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTarrifCalculationResponse extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    TextView applianceName;
    TextView applianceQty;
    TextView applianceHours;
    List<ApplianceItemWithQtyAndHours> applianceItemWithQtyAndHoursList;
    ApplianceWithHoursAndQtyAdapter mAdapter ;
    TextView tvTotalCostDueBeforeSubsidy;
    TextView tvTotalCostDue;
    TextView tvTotalGovtSubsidy;
    TextView tvTotalUnits;

    public FragmentTarrifCalculationResponse() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTarrifCalculationResponse.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTarrifCalculationResponse newInstance(String param1, String param2) {
        FragmentTarrifCalculationResponse fragment = new FragmentTarrifCalculationResponse();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tarrif_calculation_response, container, false);

        applianceItemWithQtyAndHoursList = getArguments().getParcelableArrayList(FragmentDetailedAppliance.APPLIANCE_ITEMS_LIST_KEY);
        String totalCostDueBeforSubsidyString = getArguments().getString(FragmentDetailedAppliance.TOTAL_AMOUNT_DUE_BEFORE_SUBSIDY_KEY);
        String totalCostDueString = getArguments().getString(FragmentDetailedAppliance.TOTAL_AMOUNT_DUE_KEY);
        String totalGovtSubsidyString = getArguments().getString(FragmentDetailedAppliance.TOTAL_GOVT_SUBSIDY_KEY);
        String totalUnitsInWattsUsed = getArguments().getString(FragmentDetailedAppliance.TOTAL_UNITS_IN_WATTS_KEY);
        String currencyString = getArguments().getString(FragmentDetailedAppliance.CURRENCY_KEY);



        mAdapter = new ApplianceWithHoursAndQtyAdapter(applianceItemWithQtyAndHoursList);
        tvTotalCostDueBeforeSubsidy = (TextView) view.findViewById(R.id.tvTotalCostBeforeSubsidy);
        tvTotalCostDue = (TextView) view.findViewById(R.id.tvTotalCost);
        tvTotalGovtSubsidy = (TextView) view.findViewById(R.id.tvGovtSubsidy);
        tvTotalUnits = (TextView) view.findViewById(R.id.tvTotalUnits);



        Animation pulseAnim = AnimationUtils.loadAnimation(getActivity(), R.anim.pulse);
        tvTotalCostDue.setText(totalCostDueString+currencyString);
        tvTotalCostDue.startAnimation(pulseAnim);
        tvTotalCostDueBeforeSubsidy.setText(totalCostDueBeforSubsidyString+currencyString);
        tvTotalGovtSubsidy.setText((totalGovtSubsidyString+currencyString).substring(0));
        tvTotalUnits.setText(totalUnitsInWattsUsed+"kWh");

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);



        return view;
    }

}
