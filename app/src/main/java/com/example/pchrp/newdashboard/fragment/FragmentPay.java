package com.example.pchrp.newdashboard.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pchrp.newdashboard.Dao.PayItemColleationDao;
import com.example.pchrp.newdashboard.R;
import com.example.pchrp.newdashboard.adapter.PayMentAdapter;
import com.example.pchrp.newdashboard.manager.http.HttpManager;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPay extends Fragment {

    ListView listViewPay;
    PayMentAdapter payMentAdapter;

    public FragmentPay() {
        super();
    }

    public static FragmentPay newInstance() {
        FragmentPay fragment = new FragmentPay();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_pay, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {

        listViewPay = (ListView) rootView.findViewById(R.id.list_pay);
        payMentAdapter = new PayMentAdapter();
        listViewPay.setAdapter(payMentAdapter);

        Call<PayItemColleationDao> call = HttpManager.getInstance().getService().loadlist();
        call.enqueue(new Callback<PayItemColleationDao>() {

            @Override
            public void onResponse(Call<PayItemColleationDao> call, Response<PayItemColleationDao> response) {

                if(response.isSuccessful()){
                    PayItemColleationDao dao = response.body();
                    Toast.makeText(getActivity(),dao.getData().get(0).getCaption(),Toast.LENGTH_SHORT).show();
                }else {
                    try {
                        Toast.makeText(getActivity(),response.errorBody().string(),Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<PayItemColleationDao> call, Throwable t) {
                Toast.makeText(getActivity(),t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }
}
