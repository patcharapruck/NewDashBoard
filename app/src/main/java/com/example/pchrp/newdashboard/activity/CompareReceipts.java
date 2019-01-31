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
import android.widget.Button;
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
import com.example.pchrp.newdashboard.util.SharedPrefDateManager;
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

public class CompareReceipts extends AppCompatActivity{

    LineChart lineChart;
    LineData lineData;
    Button sp2, sp3;
    Toolbar toolbar;
    ArrayList<Float> income;
    ArrayList<Float> revenue;

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
        Call<CompareDao> call = HttpManager.getInstance().getService().loadAPIcompare(requestBody);
        call.enqueue(new Callback<CompareDao>() {

            @Override
            public void onResponse(Call<CompareDao> call, Response<CompareDao> response) {
                if(response.isSuccessful()){
                    CompareDao dao = response.body();
                    CompareManager.getInstance().setCompareDao(dao);
                    setListData();
                    Toast.makeText(mcontext,dao.getObject().get(2).getCashPayments().toString(),Toast.LENGTH_SHORT).show();
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
        this.size = Dao.getObject().size();
        income = new ArrayList<Float>(size);
        revenue = new ArrayList<Float>(size);

        for(int i=0;i<size;i++){

            float a = valueCashPayments(i);
            float b = valueCreditCardPayments(i);
            float c = valueCreditPayments(i);
            float Sum = a + b + c;

            income.add(valueTotal(i));
            revenue.add(Sum);
        }

        ChartCompare();
    }

    private float valueTotal(int i) {
        float Total;
        try {
            Total = Dao.getObject().get(i).getTotalIncome();
        } catch (NullPointerException e) {
            return 0f;
        }
        return Total;
    }

    private float valueCreditPayments(int i) {
        float CreditPayments;
        try {
            CreditPayments = Dao.getObject().get(i).getCreditPayments();
        } catch (NullPointerException e) {
            return 0f;
        }
        return CreditPayments;
    }

    private float valueCreditCardPayments(int i) {
        float CreditCardPayments;
        try {
            CreditCardPayments = Dao.getObject().get(i).getCreditCardPayments();
        } catch (NullPointerException e) {
            return 0f;
        }
        return CreditCardPayments;
    }

    private float valueCashPayments(int i) {
        float CashPayments;
        try {
            CashPayments = Dao.getObject().get(i).getCashPayments();
        } catch (NullPointerException e) {
            return 0f;
        }
        return CashPayments;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void ChartCompare(){

        sp2 = findViewById(R.id.datestart);
        sp3 = findViewById(R.id.datestop);

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
        for(int i=0;i<6;i++){
            dataVals.add(new Entry(i,revenue.get(i)));
        }
        return dataVals;
    }
    private ArrayList<Entry> dataValues2(){
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        for(int i=0;i<size;i++){
            dataVals.add(new Entry(i,income.get(i)));
        }
        return dataVals;
    }
    private void InitInstant() {
        String date = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate();

        teqAPICompare();
        toolbar = findViewById(R.id.tbCompare);
        toolbar.setTitle("เปรียบเทียบรายรับ");
        toolbar.setSubtitle(date);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    }
}
