package com.example.pchrp.newdashboard.activity;

import android.content.Entity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pchrp.newdashboard.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class CompareReceipts extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    LineChart lineChart;
    LineData lineData;
    Spinner sp1, sp2, sp3;

    ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_receipts);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
          sp1 = findViewById(R.id.item);
        sp2 = findViewById(R.id.dateStart);
        sp3 = findViewById(R.id.dateStop);

        lineChart = (LineChart) findViewById(R.id.lineChart);



        LineDataSet lineDataSet = new LineDataSet(dataValues1(),"รายรับจริง");
        lineDataSet.setColor(Color.parseColor("#2567EB"));
        LineDataSet lineDataSet1 = new LineDataSet(dataValues2(),"รายรับตามบิล");
        lineDataSet.setColor(Color.parseColor("#008712"));

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet);
        ArrayList<ILineDataSet> dataSets1 = new ArrayList<>();
        dataSets1.add(lineDataSet1);




        LineData data = new LineData(lineDataSet,lineDataSet1);

        lineChart.setData(data);
        lineChart.invalidate();


        InitInstant();



    }

    private ArrayList<Entry> dataValues1(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0,20));
        dataVals.add(new Entry(1,24));
        dataVals.add(new Entry(2,25));
        dataVals.add(new Entry(3,26));
        dataVals.add(new Entry(4,20));

        return dataVals;
    }

    private ArrayList<Entry> dataValues2(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0,20));
        dataVals.add(new Entry(1,34));
        dataVals.add(new Entry(2,35));
        dataVals.add(new Entry(3,36));
        dataVals.add(new Entry(4,30));

        return dataVals;
    }


    private void InitInstant() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.menu,R.layout.support_simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(this);



        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.datestart,
                R.layout.support_simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        sp2.setAdapter(adapter1);
        sp2.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.datestop,
                R.layout.support_simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        sp3.setAdapter(adapter2);
        sp3.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
