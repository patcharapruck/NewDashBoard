package com.example.pchrp.newdashboard.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pchrp.newdashboard.R;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class DrinkReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_report);

        final TableView<String[]> tableView =(TableView) findViewById(R.id.tableView);
        tableView.setColumnCount(3);
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


}
