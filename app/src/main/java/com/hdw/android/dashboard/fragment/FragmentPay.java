package com.hdw.android.dashboard.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.hdw.android.dashboard.Dao.PayItemColleationDao;
import com.hdw.android.dashboard.R;
import com.hdw.android.dashboard.adapter.PayMentAdapter;
import com.hdw.android.dashboard.manager.Contextor;
import com.hdw.android.dashboard.manager.PayManager;
import com.hdw.android.dashboard.manager.http.HttpManager;
import com.hdw.android.dashboard.util.SharedPrefDatePayManager;

import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentPay extends Fragment implements View.OnClickListener {

    ListView listViewPay;
    PayMentAdapter payMentAdapter;

    Spinner spintypepay;
    String typeSearch = "";
    String DataSearch = "";

    EditText edSearchPay;
    CardView cardsearchpay;

    private ArrayList<String> mTypeSearch = new ArrayList<String>();

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
        spintypepay = (Spinner) rootView.findViewById(R.id.spintypepay);
        edSearchPay = (EditText) rootView.findViewById(R.id.edSearchPay);
        cardsearchpay = (CardView) rootView.findViewById(R.id.cardsearchpay);

        createTypeSearchData();

        final ArrayAdapter<String> adapterPaySearch = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, mTypeSearch);
        spintypepay.setAdapter(adapterPaySearch);

        spintypepay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(mTypeSearch.get(position).equals("เลชที่เอกสาร")){
                    typeSearch = "InvoiceDocument-invoiceCode";
                }else if (mTypeSearch.get(position).equals("ชื่อหัวบิล")){
                    typeSearch = "InvoiceDocument-customerName";
                }else if (mTypeSearch.get(position).equals("Table/Room")){
                    typeSearch = "Place-placeCode";
                }else if (mTypeSearch.get(position).equals("รหัส Sale")){
                    typeSearch = "Employee-employeeCode";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void createTypeSearchData() {
        mTypeSearch.add("เลชที่เอกสาร");
        mTypeSearch.add("ชื่อหัวบิล");
        mTypeSearch.add("Table/Room");
        mTypeSearch.add("รหัส Sale");
    }


    @Override
    public void onStart() {
        super.onStart();
        reqAPIpay();
        cardsearchpay.setOnClickListener(this);

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        payMentAdapter = new PayMentAdapter();
        listViewPay.setAdapter(payMentAdapter);
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

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
                    payMentAdapter.notifyDataSetChanged();
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

    @Override
    public void onClick(View v) {

        if (v == cardsearchpay){
            DataSearch = edSearchPay.getText().toString();

            Searchreq(typeSearch,DataSearch);
        }
    }

    private void Searchreq(String typeSearch, String dataSearch) {
        final Context mcontext = Contextor.getInstance().getContext();
        String nn = "{\"criteria\":{\""+typeSearch+"\":\""+dataSearch+"\",\"sql-obj-command\":\"f:documentStatus.id = 21 and f:salesShift.isOpening = 1\"},\"property\":[\"memberAccount->customerMemberAccount\",\"sales->employee\",\"place\",\"transactionPaymentList\",\"documentStatus\",\"salesShift\"],\"pagination\":{},\"orderBy\":{\"InvoiceDocument-id\":\"DESC\"}}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),nn);
        Call<PayItemColleationDao> call = HttpManager.getInstance().getService().loadAPIPay(requestBody);
        call.enqueue(new Callback<PayItemColleationDao>() {
            @Override
            public void onResponse(Call<PayItemColleationDao> call, Response<PayItemColleationDao> response) {
                if(response.isSuccessful()){
                    PayItemColleationDao dao = response.body();
                    PayManager.getInstance().setPayItemColleationDao(dao);
                    payMentAdapter.notifyDataSetChanged();
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
