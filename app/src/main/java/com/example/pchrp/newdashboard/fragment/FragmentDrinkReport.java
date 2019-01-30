package com.example.pchrp.newdashboard.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pchrp.newdashboard.Dao.objectdao.ObjectItemDao;
import com.example.pchrp.newdashboard.R;
import com.example.pchrp.newdashboard.activity.DrinkActivity;
import com.example.pchrp.newdashboard.activity.MainActivity;
import com.example.pchrp.newdashboard.manager.DashBoradManager;

import java.util.ArrayList;
import com.example.pchrp.newdashboard.manager.Contextor;
import com.example.pchrp.newdashboard.util.SharedPrefDateManager;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDrinkReport extends Fragment {

    Toolbar toolbar;

    ObjectItemDao Odao;
    int size;

    ArrayList<Long> totalAllProduct;
    ArrayList<String> nameProduct;

    String[] drinkHeader={"ชื่อสินค้า","จำนวนที่ขาย"};
    String[][] drinkData;
//            ={
//            {"1","J.W. BLACK","106"},
//            {"2","J.W. BLUE","68"},
//            {"3","J.W. GOLD","10"},
//            {"4","J.W. SWING","5"},
//            {"1","J.W. BLACK","106"},
//            {"2","J.W. BLUE","68"},
//            {"3","J.W. GOLD","10"},
//            {"4","J.W. SWING","5"},
//            {"1","J.W. BLACK","106"},
//            {"2","J.W. BLUE","68"},
//            {"3","J.W. GOLD","10"},
//            {"4","J.W. SWING","5"},
//            {"1","J.W. BLACK","106"},
//            {"2","J.W. BLUE","68"},
//            {"3","J.W. GOLD","10"},
//            {"4","J.W. SWING","5"}
//
//    };

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
        initInstances(rootView);
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
        drinkData = new String[size][2];

        nameProduct = new ArrayList<>(size);
        totalAllProduct = new ArrayList<>(size);

        for(int i=0;i<size;i++){
            String name = getnameProduct(i);
            Long total = gettotalProduct(i);

            nameProduct.add(name);
            totalAllProduct.add(total);
        }

        for (int i=0;i<size;i++){
            drinkData[i][0] = nameProduct.get(i);
            drinkData[i][1] = totalAllProduct.get(i).toString();
        }


        final TableView<String[]> tableView =(TableView)rootView.findViewById(R.id.tableView);
        tableView.setColumnCount(2);
        tableView.setHeaderBackgroundColor(Color.parseColor("#F6FDF7"));
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(getContext(),drinkHeader));
        tableView.setDataAdapter(new SimpleTableDataAdapter(getContext(),drinkData));
        tableView.addDataClickListener(new TableDataClickListener<String[]>() {
            @Override
            public void onDataClicked(int rowIndex, String[] clickedData) {
//                Collections.sort();
            }
        });

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
