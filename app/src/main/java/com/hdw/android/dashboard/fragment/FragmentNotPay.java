package com.hdw.android.dashboard.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.hdw.android.dashboard.Dao.NotPayItemColleationDao;
import com.hdw.android.dashboard.R;
import com.hdw.android.dashboard.adapter.NotPayAdapter;
import com.hdw.android.dashboard.manager.Contextor;
import com.hdw.android.dashboard.manager.NotPayManager;
import com.hdw.android.dashboard.manager.http.HttpManager;
import com.hdw.android.dashboard.util.SharedPrefDatePayManager;

import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentNotPay extends Fragment implements View.OnClickListener {

    ListView listNotpay;
    NotPayAdapter notPayAdapter;

    Spinner spintypeNot;
    String typeSearch = "";
    String DataSearch = "";

    EditText edSearchNot;
    CardView cardsearchNot;
    ImageView icon_searchNot;

    private ArrayList<String> mTypeSearch = new ArrayList<String>();

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

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        // Init 'View' instance(s) with rootView.findViewById here
        listNotpay = (ListView)rootView.findViewById(R.id.list_notpay);
        spintypeNot = (Spinner) rootView.findViewById(R.id.spintypeNot);
        edSearchNot = (EditText) rootView.findViewById(R.id.edSearchNot);
        cardsearchNot = (CardView) rootView.findViewById(R.id.cardsearchNot);
        icon_searchNot = (ImageView) rootView.findViewById(R.id.icon_searchNot);

        createTypeSearchData();

        final ArrayAdapter<String> adapterNotSearch = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_item, mTypeSearch);
        spintypeNot.setAdapter(adapterNotSearch);

        spintypeNot.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
    public void onResume() {
        super.onResume();
        notPayAdapter = new NotPayAdapter();
        listNotpay.setAdapter(notPayAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        reqAPInotpay();
        cardsearchNot.setOnClickListener(this);
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


    private void reqAPInotpay() {

        final Context mcontext = Contextor.getInstance().getContext();
        String nn = "{\"criteria\":{\"sql-obj-command\":\"f:documentStatus.id = 22 and f:salesShift.isOpening = 1 \"},\"property\":[\"memberAccount->customerMemberAccount\",\"sales->employee\",\"place\",\"transactionPaymentList\",\"documentStatus\",\"salesShift\"],\"pagination\":{},\"orderBy\":{\"InvoiceDocument-id\":\"DESC\"}}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),nn);
        Call<NotPayItemColleationDao> call = HttpManager.getInstance().getService().loadAPINotPay(requestBody);
        call.enqueue(new Callback<NotPayItemColleationDao>() {
            @Override
            public void onResponse(Call<NotPayItemColleationDao> call, Response<NotPayItemColleationDao> response) {
                if(response.isSuccessful()){
                    NotPayItemColleationDao dao = response.body();
                    NotPayManager.getInstance().setNotpayItemColleationDao(dao);
                    notPayAdapter.notifyDataSetChanged();
                    SharedPrefDatePayManager.getInstance(Contextor.getInstance().getContext())
                            .saveNotPay(dao.getPagination().getTotalItem());
                }else {
                    Toast.makeText(mcontext,"เกิดข้อผิดพลาด",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<NotPayItemColleationDao> call, Throwable t) {
                Toast.makeText(mcontext,"ไม่สามารถเชื่อมต่อได้",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v == cardsearchNot || v == icon_searchNot){
            DataSearch = edSearchNot.getText().toString();

            SearchNotreq(typeSearch,DataSearch);
        }
    }

    private void SearchNotreq(String typeSearch, String dataSearch) {
        final Context mcontext = Contextor.getInstance().getContext();
        String nn = "{\"criteria\":{\""+typeSearch+"\":\""+dataSearch+"\",\"sql-obj-command\":\"f:documentStatus.id = 22 and f:salesShift.isOpening = 1\"},\"property\":[\"memberAccount->customerMemberAccount\",\"sales->employee\",\"place\",\"transactionPaymentList\",\"documentStatus\",\"salesShift\"],\"pagination\":{},\"orderBy\":{\"InvoiceDocument-id\":\"DESC\"}}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),nn);
        Call<NotPayItemColleationDao> call = HttpManager.getInstance().getService().loadAPINotPay(requestBody);
        call.enqueue(new Callback<NotPayItemColleationDao>() {
            @Override
            public void onResponse(Call<NotPayItemColleationDao> call, Response<NotPayItemColleationDao> response) {
                if(response.isSuccessful()){
                    NotPayItemColleationDao dao = response.body();
                    NotPayManager.getInstance().setNotpayItemColleationDao(dao);
                    notPayAdapter.notifyDataSetChanged();
                    SharedPrefDatePayManager.getInstance(Contextor.getInstance().getContext())
                            .saveNotPay(dao.getPagination().getTotalItem());
                }else {
                    Toast.makeText(mcontext,"เกิดข้อผิดพลาด",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<NotPayItemColleationDao> call, Throwable t) {
                Toast.makeText(mcontext,"ไม่สามารถเชื่อมต่อได้",Toast.LENGTH_LONG).show();
            }
        });
    }
}
