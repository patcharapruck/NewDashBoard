package com.example.pchrp.newdashboard.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pchrp.newdashboard.Dao.DashBoardDao;
import com.example.pchrp.newdashboard.Dao.PayItemColleationDao;
import com.example.pchrp.newdashboard.R;
import com.example.pchrp.newdashboard.adapter.PayMentAdapter;
import com.example.pchrp.newdashboard.manager.Contextor;
import com.example.pchrp.newdashboard.manager.DashBoradManager;
import com.example.pchrp.newdashboard.manager.PayManager;
import com.example.pchrp.newdashboard.manager.http.HttpManager;
import com.example.pchrp.newdashboard.util.SharedPrefDatePayManager;

import org.json.JSONStringer;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
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
        reqAPIpay();

    }


    @Override
    public void onStart() {
        super.onStart();
        payMentAdapter = new PayMentAdapter();
        listViewPay.setAdapter(payMentAdapter);
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

    private void reqAPIpay() {
        final Context mcontext = Contextor.getInstance().getContext();
        String nn = "{\"criteria\":{\"sql-obj-command\":\"f:documentStatus.id = 21 and f:salesShift.isOpening = 1\"},\"property\":[\"memberAccount->customerMemberAccount\",\"sales->employee\",\"place\",\"transactionPaymentList\",\"documentStatus\",\"salesShift\"],\"pagination\":{},\"orderBy\":{\"InvoiceDocument-id\":\"DESC\"}}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),nn);
        Call<PayItemColleationDao> call = HttpManager.getInstance().getService().loadAPIPay(requestBody);
        call.enqueue(new Callback<PayItemColleationDao>() {
            @Override
            public void onResponse(Call<PayItemColleationDao> call, Response<PayItemColleationDao> response) {
                if(response.isSuccessful()){
                    PayItemColleationDao dao = response.body();
                    PayManager.getInstance().setPayItemColleationDao(dao);
                    listViewPay.deferNotifyDataSetChanged();
                    SharedPrefDatePayManager.getInstance(Contextor.getInstance().getContext())
                            .savePay(dao.getPagination().getTotalItem());
                }else {
                    Toast.makeText(mcontext,"เกิดข้อผิดพลาด",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PayItemColleationDao> call, Throwable t) {
                Toast.makeText(mcontext,"ไม่สามารถเชื่อมต่อได้",Toast.LENGTH_LONG).show();
            }
        });
    }
}
