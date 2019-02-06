package com.hdw.android.dashboard.activity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.hdw.android.dashboard.R;
import com.hdw.android.dashboard.manager.Contextor;
import com.hdw.android.dashboard.util.SharedPrefDateManager;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class DrinkReportActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_report);
        String date = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate();

//        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        toolbar = findViewById(R.id.tbDrinkReport);
        toolbar.setTitle("รายงานการใช้เครื่องดื่ม");
        toolbar.setSubtitle(date);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        toolbar.setSubtitleTextColor(Color.parseColor("#FFFFFF"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final TableView<String[]> tableView =(TableView) findViewById(R.id.tableView);
        tableView.setColumnCount(3);
        tableView.setHeaderBackgroundColor(Color.parseColor("#F6FDF7"));
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this,drinkHeader));
        tableView.setDataAdapter(new SimpleTableDataAdapter(this,drinkData));

    }



    String[] drinkHeader={"ลำดับ","ชื่อสินค้า","จำนวนที่ขาย"};
    String[][] drinkData={
            {"1","J.W. BLACK","106"},
            {"2","J.W. BLUE","68"},
            {"3","J.W. GOLD","10"},
            {"4","J.W. SWING","5"}

    };


}
