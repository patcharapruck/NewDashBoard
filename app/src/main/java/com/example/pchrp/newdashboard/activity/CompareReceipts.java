package com.example.pchrp.newdashboard.activity;

import android.content.Context;
import android.content.Entity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pchrp.newdashboard.Dao.CompareDao;
import com.example.pchrp.newdashboard.Dao.DashBoardDao;
import com.example.pchrp.newdashboard.Dao.objectdao.ObjectItemDao;
import com.example.pchrp.newdashboard.Dao.objectdao.ObjectListItemDao;
import com.example.pchrp.newdashboard.R;
import com.example.pchrp.newdashboard.manager.CompareManager;
import com.example.pchrp.newdashboard.manager.Contextor;
import com.example.pchrp.newdashboard.manager.DashBoradManager;
import com.example.pchrp.newdashboard.manager.http.HttpManager;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompareReceipts extends AppCompatActivity  {

    LineChart lineChart;
    LineData lineData;
    Toolbar toolbar;
    ArrayList<Double> income;
    ArrayList<Double> revenue;

    int size;
    CompareDao Dao;

    ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_receipts);
        InitInstant();
    }

    private void teqAPICompare() {
        final Context mcontext = Contextor.getInstance().getContext();
        String nn = "{\"property\":[],\"criteria\":{\"opening\":false,\"sql-obj-command\":\"( tb_sales_shift.open_date >= '2019-01-23 00:00:00' AND tb_sales_shift.open_date <= '2019-01-28 23:59:59')\"},\"orderBy\":{},\"pagination\":{}}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),nn);
        Log.v("https",nn);
        Call<CompareDao> call = HttpManager.getInstance().getService().loadAPIcompare(requestBody);
        call.enqueue(new Callback<CompareDao>() {

            @Override
            public void onResponse(Call<CompareDao> call, Response<CompareDao> response) {
                if(response.isSuccessful()){
                    CompareDao dao = response.body();
                    CompareManager.getInstance().setCompareDao(dao);
                    setListData();
                }else {
                    try {
                        Toast.makeText(mcontext,response.errorBody().string(),Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<CompareDao> call, Throwable t) {
                Toast.makeText(mcontext,t.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }

    private void setListData() {
        Dao = CompareManager.getInstance().getCompareDao();

        System.out.println("Dao");
        this.size = Dao.getObject().size();
        income = new ArrayList<Double>(size);
        revenue = new ArrayList<Double>(size);
        for(int i=0;i<size;i++){

            Double Sum = Dao.getObject().get(i).getCashPayments()
                    +Dao.getObject().get(i).getCreditCardPayments()
                    +Dao.getObject().get(i).getCreditPayments();
            income.add(Dao.getObject().get(i).getTotalIncome());
            revenue.add(Sum);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void ChartCompare(){

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

    }
    private ArrayList<Entry> dataValues1(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        ArrayList<Double> t1 = new ArrayList<Double>(5);
        t1.add(1200D);
        t1.add(1300D);
        t1.add(1400D);
        t1.add(1500D);
        t1.add(1600D);
       // t1.add(1700);
        for(int i=0;i<size;i++){
            dataVals.add(new Entry(i,t1.get(i).floatValue()));
        }
        return dataVals;
    }
    private ArrayList<Entry> dataValues2(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        ArrayList<Float> t1 = new ArrayList<Float>(5);
        t1.add(1000f);
        t1.add(1100f);
        t1.add(1200f);
        t1.add(1300f);
        t1.add(1400f);
       // t1.add(1500f);
        for(int i=0;i<5;i++){
            dataVals.add(new Entry(i,t1.get(i)));
        }
        return dataVals;
    }
    private void InitInstant() {

        teqAPICompare();
        toolbar = findViewById(R.id.tbCompare);
        toolbar.setTitle("เปรียบเทียบรายรับ");
        toolbar.setSubtitle(" day / month / year ");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ChartCompare();
    }
}
