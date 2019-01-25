package com.example.pchrp.newdashboard.activity;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pchrp.newdashboard.R;
import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;
import java.util.List;

public class CompareReceipts extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    LineChart lineChart;
    Spinner sp1, sp2, sp3;

    ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_receipts);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        lineChart = (LineChart) findViewById(R.id.lineChart);

        sp1 = (Spinner) findViewById(R.id.item);
        sp2 = (Spinner) findViewById(R.id.dateStart);
        sp3 = (Spinner) findViewById(R.id.dateStop);

     InitInstant();

    }

    private void InitInstant() {
        ArrayAdapter<CharSequence>adapter =  ArrayAdapter.createFromResource(this,
                R.array.menu,
                R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence>adapter1 =  ArrayAdapter.createFromResource(this,
                R.array.datestart,
                R.layout.support_simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        sp2.setAdapter(adapter1);
        sp2.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence>adapter2 =  ArrayAdapter.createFromResource(this,
                R.array.datestop,
                R.layout.support_simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        sp3.setAdapter(adapter2);
        sp3.setOnItemSelectedListener(this);
    }

    private void chartCompare(){


            }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
