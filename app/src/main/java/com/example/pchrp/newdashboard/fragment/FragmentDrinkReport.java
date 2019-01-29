package com.example.pchrp.newdashboard.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pchrp.newdashboard.R;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDrinkReport extends Fragment {


    String[] drinkHeader={"ลำดับ","ชื่อสินค้า","จำนวนที่ขาย"};
    String[][] drinkData={
            {"1","J.W. BLACK","106"},
            {"2","J.W. BLUE","68"},
            {"3","J.W. GOLD","10"},
            {"4","J.W. SWING","5"},
            {"1","J.W. BLACK","106"},
            {"2","J.W. BLUE","68"},
            {"3","J.W. GOLD","10"},
            {"4","J.W. SWING","5"},
            {"1","J.W. BLACK","106"},
            {"2","J.W. BLUE","68"},
            {"3","J.W. GOLD","10"},
            {"4","J.W. SWING","5"},
            {"1","J.W. BLACK","106"},
            {"2","J.W. BLUE","68"},
            {"3","J.W. GOLD","10"},
            {"4","J.W. SWING","5"}

    };

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
        return rootView;
    }

    private void initInstances(View rootView) {
        final TableView<String[]> tableView =(TableView)rootView.findViewById(R.id.tableView);
        tableView.setColumnCount(3);
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



}
