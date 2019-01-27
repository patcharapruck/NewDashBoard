package com.example.pchrp.newdashboard.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.pchrp.newdashboard.Dao.bankdao.BankItemDao;
import com.example.pchrp.newdashboard.Dao.bankdao.BankItemKrungthaiDao;
import com.example.pchrp.newdashboard.Dao.objectdao.ObjectItemDao;
import com.example.pchrp.newdashboard.R;
import com.example.pchrp.newdashboard.manager.DashBoradManager;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class CreditActivity extends AppCompatActivity {
    BarChart barChart;

    TextView tvcreditall,tvamaxt,tvamaxk,tvjcbt,tvjcbk,tvmastert,tvmasterk,tvunipayt,tvunipayk,tvvisat,tvvisak;
    Double creditall,amaxt,amaxk,jcbt,jcbk,mastert,masterk,unipayt,unipayk,visat,visak;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
        barChart = findViewById(R.id.barchart);


        tvcreditall = (TextView) findViewById(R.id.tvcreditall);
        tvamaxt  = (TextView) findViewById(R.id.tvamaxt);
        tvjcbt = (TextView) findViewById(R.id.tvjcbt);
        tvmastert = (TextView) findViewById(R.id.tvmastert);
        tvunipayt = (TextView) findViewById(R.id.tvunipayt);
        tvvisat = (TextView) findViewById(R.id.tvvisat);
        tvamaxk = (TextView) findViewById(R.id.tvamaxk);
        tvjcbk = (TextView) findViewById(R.id.tvjcbk);
        tvmasterk = (TextView) findViewById(R.id.tvmasterk);
        tvunipayk = (TextView) findViewById(R.id.tvunipayk);
        tvvisak = (TextView) findViewById(R.id.tvvisak);


        creditall=DashBoradManager.getInstance().getDao().getCreditCardPayments();
        amaxt=DashBoradManager.getInstance().getDao().getIncomeByCreditCardList().get(0).getAmax();
        jcbt=DashBoradManager.getInstance().getDao().getIncomeByCreditCardList().get(0).getJcb();
        mastert=DashBoradManager.getInstance().getDao().getIncomeByCreditCardList().get(0).getMaster();
        visat=DashBoradManager.getInstance().getDao().getIncomeByCreditCardList().get(0).getVisa();
        unipayt=DashBoradManager.getInstance().getDao().getIncomeByCreditCardList().get(0).getUnipay();
        amaxk=DashBoradManager.getInstance().getDao().getIncomeByCreditCardList().get(1).getAmax();
        jcbk=DashBoradManager.getInstance().getDao().getIncomeByCreditCardList().get(1).getJcb();
        masterk=DashBoradManager.getInstance().getDao().getIncomeByCreditCardList().get(1).getMaster();
        visak=DashBoradManager.getInstance().getDao().getIncomeByCreditCardList().get(1).getVisa();
        unipayk=DashBoradManager.getInstance().getDao().getIncomeByCreditCardList().get(1).getUnipay();


        tvcreditall.setText(creditall.toString());

        tvamaxt.setText(amaxt.toString());
        if(amaxt>0){
            tvamaxt.setTextColor(Color.parseColor("#4CAF50"));
        }
        tvjcbt.setText(jcbt.toString());
        if(jcbt>0){
            tvjcbt.setTextColor(Color.parseColor("#4CAF50"));
        }
        tvmastert.setText(mastert.toString());
        if(mastert>0){
            tvmastert.setTextColor(Color.parseColor("#4CAF50"));
        }
        tvvisat.setText(visat.toString());
        if(visat>0){
            tvvisat.setTextColor(Color.parseColor("#4CAF50"));
        }
        tvunipayt.setText(unipayt.toString());
        if(unipayt>0){
            tvunipayt.setTextColor(Color.parseColor("#4CAF50"));
        }

        tvamaxk.setText(amaxk.toString());
        if(amaxk>0){
            tvamaxk.setTextColor(Color.parseColor("#4CAF50"));
        }
        tvjcbk.setText(jcbk.toString());
        if(jcbk>0){
            tvjcbk.setTextColor(Color.parseColor("#4CAF50"));
        }
        tvmasterk.setText(masterk.toString());
        if(masterk>0){
            tvmasterk.setTextColor(Color.parseColor("#4CAF50"));
        }
        tvvisak.setText(visak.toString());
        if(visak>0){
            tvvisak.setTextColor(Color.parseColor("#4CAF50"));
        }
        tvunipayk.setText(unipayk.toString());
        if(unipayk>0){
            tvunipayk.setTextColor(Color.parseColor("#4CAF50"));
        }

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
        barBnk1.add(new BarEntry(1,amaxt.longValue()));
        barBnk1.add(new BarEntry(2,jcbt.longValue()));
        barBnk1.add(new BarEntry(3,mastert.longValue()));
        barBnk1.add(new BarEntry(4,unipayt.longValue()));
        barBnk1.add(new BarEntry(5, visat.longValue()));
        return barBnk1;
    }

    //BBL(ธนาคารกรุงเทพ)
    private ArrayList<BarEntry> bar_B2(){
        ArrayList<BarEntry> barBnk2 = new ArrayList<>();
        barBnk2.add(new BarEntry(1, amaxk.longValue()));
        barBnk2.add(new BarEntry(2, jcbk.longValue()));
        barBnk2.add(new BarEntry(3, masterk.longValue()));
        barBnk2.add(new BarEntry(4, unipayk.longValue()));
        barBnk2.add(new BarEntry(5, visak.longValue()));
        return barBnk2;
    }

}
