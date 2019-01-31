package com.example.pchrp.newdashboard.activity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.pchrp.newdashboard.Dao.bankdao.BankItemColleationDao;
import com.example.pchrp.newdashboard.Dao.bankdao.BankItemDao;
import com.example.pchrp.newdashboard.Dao.bankdao.BankItemKrungthaiDao;
import com.example.pchrp.newdashboard.Dao.objectdao.ObjectItemDao;
import com.example.pchrp.newdashboard.R;
import com.example.pchrp.newdashboard.manager.Contextor;
import com.example.pchrp.newdashboard.manager.DashBoradManager;
import com.example.pchrp.newdashboard.util.SharedPrefDateManager;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CreditActivity extends AppCompatActivity {
    BarChart barChart;
    Toolbar toolbar;
    TextView tvcreditall,
            tvamaxt, tvamaxk,
            tvjcbt, tvjcbk,
            tvmastert, tvmasterk,
            tvunipayt, tvunipayk,
            tvvisat, tvvisak;

    Double creditall,
            amaxt = 0.0, amaxk = 0.0,
            jcbt = 0.0, jcbk = 0.0,
            mastert = 0.0, masterk = 0.0,
            unipayt = 0.0, unipayk = 0.0,
            visat = 0.0, visak = 0.0;

    String creditalls,
            amaxts, amaxks,
            jcbts, jcbks,
            masterts, masterks,
            unipayts, unipayks,
            visats, visaks;
//    //วันปัจจุบัน
//    String st =" ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
        barChart = findViewById(R.id.barchart);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        DecimalFormat formatter = new DecimalFormat("#,###,###.00");
        String date = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate();

        toolbar = findViewById(R.id.tbCredit);
        toolbar.setTitle("รายรับบัตรเครดิต");
        toolbar.setSubtitle(date);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tvcreditall = (TextView) findViewById(R.id.tvcreditall);
        tvamaxt = (TextView) findViewById(R.id.tvamaxt);
        tvjcbt = (TextView) findViewById(R.id.tvjcbt);
        tvmastert = (TextView) findViewById(R.id.tvmastert);
        tvunipayt = (TextView) findViewById(R.id.tvunipayt);
        tvvisat = (TextView) findViewById(R.id.tvvisat);
        tvamaxk = (TextView) findViewById(R.id.tvamaxk);
        tvjcbk = (TextView) findViewById(R.id.tvjcbk);
        tvmasterk = (TextView) findViewById(R.id.tvmasterk);
        tvunipayk = (TextView) findViewById(R.id.tvunipayk);
        tvvisak = (TextView) findViewById(R.id.tvvisak);

        // ตัวแปร เก็บค่า ธนาคาร 1
        BankItemColleationDao B1 = DashBoradManager.getInstance().getDao().getObject().getIncomeByCreditCardList().get(0);
        BankItemColleationDao B2 = DashBoradManager.getInstance().getDao().getObject().getIncomeByCreditCardList().get(1);

        /// ตัวอย่าง
        creditall = DashBoradManager.getInstance().getDao().getObject().getCreditCardPayments(); // ค่าบัตรเครดิต


        amaxt = B1.getAmax();
        amaxk = B2.getAmax();

        jcbt = B1.getJcb();
        jcbk = B2.getJcb();

        mastert = B1.getMaster();
        masterk = B2.getMaster();

        unipayt = B1.getUnipay();
        unipayk = B2.getUnipay();

        visat = B1.getVisa();
        visak = B2.getVisa();

        creditalls = formatter.format(creditall);
        amaxts = formatter.format(amaxt);
        amaxks = formatter.format(amaxk);
        jcbts = formatter.format(jcbt);
        jcbks = formatter.format(jcbk);
        masterts = formatter.format(mastert);
        masterks = formatter.format(masterk);
        unipayts = formatter.format(unipayt);
        unipayks = formatter.format(unipayk);
        visats = formatter.format(visat);
        visaks = formatter.format(visak);


        setTextAndColor();

        BarDataSet barDataSet1 = new BarDataSet(bar_B1(), "ธนาคารธนชาต");
        barDataSet1.setColors(Color.rgb(243, 112, 35));
        BarDataSet barDataSet2 = new BarDataSet(bar_B2(), "ธนาคารกรุงเทพ");
        barDataSet2.setColors(Color.rgb(0, 28, 122));

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

        //set Label Center
        float barSpace = 0.05f;
        float groupSpace = 0.66f;
        data.setBarWidth(0.12f);
        //(barwidth + barspace) * no of bars + groupspace = 1

        barChart.getXAxis().setAxisMinimum(0);
        barChart.getXAxis().setAxisMaximum(0 + barChart.getBarData().getGroupWidth(groupSpace, barSpace) * 5);
        barChart.getAxisLeft().setAxisMinimum(0);
        barChart.groupBars(0, groupSpace, barSpace);


        // Hide grid lines
        barChart.getAxisLeft().setEnabled(false);
        barChart.getAxisRight().setEnabled(false);
        // Hide graph description
        barChart.getDescription().setEnabled(false);
        // Hide graph legend
        barChart.getLegend().setEnabled(false);

        barChart.invalidate();


    }


    private void setTextAndColor() {
        tvcreditall.setText(creditalls);

        tvamaxt.setText(amaxts);
        if (amaxt > 0) {
            tvamaxt.setTextColor(Color.parseColor("#4CAF50"));
        }
        tvjcbt.setText(jcbts);
        if (jcbt > 0) {
            tvjcbt.setTextColor(Color.parseColor("#4CAF50"));
        }
        tvmastert.setText(masterts);
        if (mastert > 0) {
            tvmastert.setTextColor(Color.parseColor("#4CAF50"));
        }
        tvvisat.setText(visats);
        if (visat > 0) {
            tvvisat.setTextColor(Color.parseColor("#4CAF50"));
        }
        tvunipayt.setText(unipayts);
        if (unipayt > 0) {
            tvunipayt.setTextColor(Color.parseColor("#4CAF50"));
        }

        tvamaxk.setText(amaxks);
        if (amaxk > 0) {
            tvamaxk.setTextColor(Color.parseColor("#4CAF50"));
        }
        tvjcbk.setText(jcbks);
        if (jcbk > 0) {
            tvjcbk.setTextColor(Color.parseColor("#4CAF50"));
        }
        tvmasterk.setText(masterks);
        if (masterk > 0) {
            tvmasterk.setTextColor(Color.parseColor("#4CAF50"));
        }
        tvvisak.setText(visaks);
        if (visak > 0) {
            tvvisak.setTextColor(Color.parseColor("#4CAF50"));
        }
        tvunipayk.setText(unipayks);
        if (unipayk > 0) {
            tvunipayk.setTextColor(Color.parseColor("#4CAF50"));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    //Bank-T(ธนาคารธนชาต)
    private ArrayList<BarEntry> bar_B1() {
        ArrayList<BarEntry> barBnk1 = new ArrayList<>();
        barBnk1.add(new BarEntry(1, amaxt.longValue()));
        barBnk1.add(new BarEntry(2, jcbt.longValue()));
        barBnk1.add(new BarEntry(3, mastert.longValue()));
        barBnk1.add(new BarEntry(4, unipayt.longValue()));
        barBnk1.add(new BarEntry(5, visat.longValue()));
        return barBnk1;
    }

    //BBL(ธนาคารกรุงเทพ)
    private ArrayList<BarEntry> bar_B2() {
        ArrayList<BarEntry> barBnk2 = new ArrayList<>();
        barBnk2.add(new BarEntry(1, amaxk.longValue()));
        barBnk2.add(new BarEntry(2, jcbk.longValue()));
        barBnk2.add(new BarEntry(3, masterk.longValue()));
        barBnk2.add(new BarEntry(4, unipayk.longValue()));
        barBnk2.add(new BarEntry(5, visak.longValue()));
        return barBnk2;
    }

}
