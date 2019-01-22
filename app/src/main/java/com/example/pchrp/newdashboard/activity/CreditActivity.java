package com.example.pchrp.newdashboard.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pchrp.newdashboard.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class CreditActivity extends AppCompatActivity {
BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
        barChart = findViewById(R.id.barchart);


        BarDataSet barDataSet1 = new BarDataSet(bar_B1(), "ธนาคารธนชาต");
        barDataSet1.setColors(Color.rgb(243,112,35));
        BarDataSet barDataSet2 = new BarDataSet(bar_B2(), "ธานคารกรุงเทพ");
        barDataSet2.setColors(Color.rgb(0,28,122));

        BarData data = new BarData(barDataSet1, barDataSet2);
        barChart.setData(data);

        String[] creditName = new String[]{"A-MAX ", " JCB ", "MASTER", "UNIPAY", "VISA"};
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(creditName));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);

        barChart.setDragEnabled(true);
        barChart.setVisibleXRangeMaximum(3);

        float barSpace = 0.05f;
        float groupSpace = 0.66f;
        data.setBarWidth(0.12f);
        //set Label Center
        //(barwidth + barspace) * no of bars + groupspace = 1

        barChart.getXAxis().setAxisMinimum(0);
        barChart.getXAxis().setAxisMaximum(0+barChart.getBarData().getGroupWidth(groupSpace,barSpace)*5);
        barChart.getAxisLeft().setAxisMinimum(0);

        barChart.groupBars(0,groupSpace,barSpace);
        barChart.invalidate();


    }
    private ArrayList<BarEntry> bar_B1(){
        ArrayList<BarEntry> barBnk1 = new ArrayList<>();
        barBnk1.add(new BarEntry(1, 0.00f));
        barBnk1.add(new BarEntry(2, 0.00f));
        barBnk1.add(new BarEntry(3, 176690.00f));
        barBnk1.add(new BarEntry(4, 0.00f));
        barBnk1.add(new BarEntry(5, 716770.00f));
        return barBnk1;
    }

    //BBL(ธนาคารกรุงเทพ)
    private ArrayList<BarEntry> bar_B2(){
        ArrayList<BarEntry> barBnk2 = new ArrayList<>();
        barBnk2.add(new BarEntry(1, 0.00f));
        barBnk2.add(new BarEntry(2, 0.00f));
        barBnk2.add(new BarEntry(3, 176690.00f));
        barBnk2.add(new BarEntry(4, 0.00f));
        barBnk2.add(new BarEntry(5, 716770.00f));
        return barBnk2;
    }

}
