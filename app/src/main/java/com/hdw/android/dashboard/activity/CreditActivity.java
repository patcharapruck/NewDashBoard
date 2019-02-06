package com.hdw.android.dashboard.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.hdw.android.dashboard.Dao.DashBoardDao;
import com.hdw.android.dashboard.Dao.bankdao.BankItemColleationDao;
import com.hdw.android.dashboard.R;
import com.hdw.android.dashboard.manager.Contextor;
import com.hdw.android.dashboard.manager.DashBoradManager;
import com.hdw.android.dashboard.manager.http.HttpManager;
import com.hdw.android.dashboard.util.SharedPrefDateManager;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreditActivity extends AppCompatActivity implements View.OnClickListener {
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
    Button btncalendarCredit;

    DecimalFormat formatter;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        initInstances();

        // ตัวแปร เก็บค่า ธนาคาร 1
    }

    private void initInstances() {
        barChart = findViewById(R.id.barchart);
        toolbar = findViewById(R.id.tbCredit);

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

        btncalendarCredit = (Button) findViewById(R.id.btncalendarCredit);
        btncalendarCredit.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        formatter = new DecimalFormat("#,###,###.00");
        date = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate();
        toolbar.setTitle("รายรับบัตรเครดิต");
        toolbar.setSubtitle(date);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        reqAPI(SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate());

    }

    private void reqAPI(String date) {

        final Context mcontext = Contextor.getInstance().getContext();
        String nn = "{\"property\":[],\"criteria\":{\"sql-obj-command\":\"( tb_sales_shift.open_date >= '"+date+" 00:00:00' AND tb_sales_shift.open_date <= '"+date+" 23:59:59')\",\"summary-date\":\"*\"},\"orderBy\":{\"InvoiceDocument-id\":\"desc\"},\"pagination\":{}}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),nn);
        Call<DashBoardDao> call = HttpManager.getInstance().getService().loadAPI(requestBody);
        call.enqueue(new Callback<DashBoardDao>() {

            @Override
            public void onResponse(Call<DashBoardDao> call, Response<DashBoardDao> response) {
                if(response.isSuccessful()){
                    DashBoardDao dao = response.body();
                    DashBoradManager.getInstance().setDao(dao);

                    try {
                        setTextViewCredit();
                    }catch (Exception e){
                        Toast.makeText(Contextor.getInstance().getContext(),"ไม่มีข้อมูลที่จะแสดงผล",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(mcontext,"เกิดข้อผิดพลาด",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<DashBoardDao> call, Throwable t) {
                Toast.makeText(mcontext,"ไม่สามารถเชื่อมต่อกับข้อมูลได้",Toast.LENGTH_LONG).show();
            }
        });


    }

    private void setTextViewCredit() {

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

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
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

    @Override
    public void onClick(View v) {

        if (v ==  btncalendarCredit){

            DatePickerDialog dialog = new DatePickerDialog(CreditActivity.this,new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    month++;
                    String mm = ""+month;
                    String dd = ""+dayOfMonth;

                    if (month<10){
                        mm = "0"+month;
                    }
                    if (dayOfMonth < 10){
                        dd = "0"+dayOfMonth;
                    }
                    String datecalendat;
                    datecalendat = year+ "/" + mm + "/" +dd;

                    SharedPrefDateManager.getInstance(Contextor.getInstance().getContext())
                            .saveDatereq(datecalendat);

                    SharedPrefDateManager.getInstance(Contextor.getInstance().getContext())
                            .saveDateCalendar(dayOfMonth,month,year);


                    date = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate();
                    toolbar.setSubtitle(date);

                    reqAPI(SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate());
                    //CreditActivity.this.recreate();

                }
            },SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getYear()
                    ,SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getMonth()-1
                    ,SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getDateofMonth());

            Calendar c = Calendar.getInstance(Locale.ENGLISH);
            c.add(Calendar.DATE,-1);
            Date date = c.getTime();
            dialog.getDatePicker().setMaxDate(date.getTime());
            Date d = null;
            String oldDateString = "2019/01/06";

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
            try {
                d = sdf.parse(oldDateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            dialog.show();
            dialog.getDatePicker().setMinDate(d.getTime());
            dialog.getDatePicker().setMaxDate(date.getTime());

        }
    }
}
