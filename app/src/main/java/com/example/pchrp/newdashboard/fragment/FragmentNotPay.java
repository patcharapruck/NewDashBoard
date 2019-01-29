package com.example.pchrp.newdashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.pchrp.newdashboard.R;
import com.example.pchrp.newdashboard.adapter.NotPayAdapter;
import com.example.pchrp.newdashboard.view.NotPayListItem;

public class FragmentNotPay extends Fragment {

    ListView listNotpay;
    NotPayAdapter notPayAdapter;

    public FragmentNotPay() {
        super();
    }

    public static FragmentNotPay newInstance() {
        FragmentNotPay fragment = new FragmentNotPay();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_not_pay, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        listNotpay = (ListView)rootView.findViewById(R.id.list_notpay);
        notPayAdapter = new NotPayAdapter();
        listNotpay.setAdapter(notPayAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
        }
    }
}
