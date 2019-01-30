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

public class CompareReceipts extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    LineChart lineChart;
    LineData lineData;
    Spinner sp1, sp2, sp3;
 Toolbar toolbar;

    ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_receipts);

        teqAPICompare();
        toolbar = findViewById(R.id.tbCompare);
        toolbar.setTitle("เปรียบเทียบรายรับ");
        toolbar.setSubtitle(" day / month / year ");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        ChartCompare();
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void ChartCompare(){
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
       // Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
