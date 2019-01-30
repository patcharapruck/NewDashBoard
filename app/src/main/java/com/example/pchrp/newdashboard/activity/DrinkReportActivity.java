package com.example.pchrp.newdashboard.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.pchrp.newdashboard.R;
import com.example.pchrp.newdashboard.manager.Contextor;
import com.example.pchrp.newdashboard.util.SharedPrefDateManager;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class DrinkReportActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_report);
        String date = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate();

        toolbar = findViewById(R.id.tbDrinkReport);
        toolbar.setTitle("รายงานการใช้เครื่องดื่ม");
        toolbar.setSubtitle(date);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final TableView<String[]> tableView =(TableView) findViewById(R.id.tableView);
        tableView.setColumnCount(2);
        tableView.setHeaderBackgroundColor(Color.parseColor("#F6FDF7"));
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this,drinkHeader));
        tableView.setDataAdapter(new SimpleTableDataAdapter(this,drinkData));

        tableView.addDataClickListener(new TableDataClickListener<String[]>() {
            @Override
            public void onDataClicked(int rowIndex, String[] clickedData) {
//                Collections.sort();
            }
        });

    }



    String[] drinkHeader={"ชื่อสินค้า","จำนวนที่ขาย"};
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


}
