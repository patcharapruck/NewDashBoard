package com.hdw.android.dashboard.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hdw.android.dashboard.Dao.objectdao.ObjectItemDao;
import com.hdw.android.dashboard.R;
import com.hdw.android.dashboard.activity.DrinkActivity;
import com.hdw.android.dashboard.manager.DashBoradManager;

import java.util.ArrayList;
import com.hdw.android.dashboard.manager.Contextor;
import com.hdw.android.dashboard.util.SharedPrefDateManager;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class FragmentDrinkReport extends Fragment {

    Toolbar toolbar;

    ObjectItemDao Odao;
    int size;

    ArrayList<Long> totalAllProduct;
    ArrayList<String> nameProduct;
    ArrayList<Long> indexProduct;
    String[] drinkHeader={"ลำดับ","ชื่อสินค้า","จำนวนที่ขาย"};
    String[][] drinkData;

    public static FragmentDrinkReport newInstance() {
        FragmentDrinkReport fragment = new FragmentDrinkReport();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentDrinkReport() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_drink_report, container, false);

        try {
            initInstances(rootView);
        }catch (Exception e){
            Toast.makeText(Contextor.getInstance().getContext(),"ไม่มีข้อมูลที่จะแสดงผล",Toast.LENGTH_SHORT).show();
        }

        String date = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate();

        toolbar = rootView.findViewById(R.id.tbDrinkReport);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setTitle("รายงานปริมาณเครื่องดื่ม");
        activity.getSupportActionBar().setSubtitle(date);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getContext(), DrinkActivity.class));
                getActivity().finish();
            }
        });


        return rootView;
    }

    private void initInstances(View rootView) {


        Odao = DashBoradManager.getInstance().getDao().getObject();
        this.size = Odao.getSummaryUseProductList().size();
        drinkData = new String[size][3];

         indexProduct = new ArrayList<>(size);
        nameProduct = new ArrayList<>(size);
        totalAllProduct = new ArrayList<>(size);

        for(int i=0;i<size;i++){
            String name = getnameProduct(i);
            Long total = gettotalProduct(i);
            int j= 1+i;

            indexProduct.add((long) j);

            nameProduct.add(name);
            totalAllProduct.add(total);
        }

        for (int i=0;i<size;i++){
            drinkData[i][0]=indexProduct.get(i).toString();
            drinkData[i][1] = nameProduct.get(i);
            drinkData[i][2] = totalAllProduct.get(i).toString();
        }


        final TableView<String[]> tableView =(TableView)rootView.findViewById(R.id.tableView);
        tableView.setColumnCount(3);
        tableView.setHeaderBackgroundColor(Color.parseColor("#F6FDF7"));
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(getContext(),drinkHeader));
        tableView.setDataAdapter(new SimpleTableDataAdapter(getContext(),drinkData));

    }

    private Long gettotalProduct(int i) {
        Long total;
        try {
            total = DashBoradManager.getInstance().getDao().getObject().getSummaryUseProductList().get(i).getTotalAll();
        } catch (NullPointerException e) {
            return 0L;
        }
        return total;
    }

    private String getnameProduct(int i) {
        String name;
        try {
            name = DashBoradManager.getInstance().getDao().getObject().getSummaryUseProductList().get(i).getProduct().getProductNameEn();
        } catch (NullPointerException e) {
            return "";
        }
        return name;
    }


}
