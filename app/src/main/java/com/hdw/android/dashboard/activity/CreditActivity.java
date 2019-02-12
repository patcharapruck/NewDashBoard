package com.hdw.android.dashboard.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Paint;
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
import com.hdw.android.dashboard.util.MyFormatCredit;
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
    BarChart chart;
    Toolbar toolbar;
    TextView tvcreditall,
            tvamaxt, tvamaxk,
            tvjcbt, tvjcbk,
            tvmastert, tvmasterk,
            tvunipayt, tvunipayk,
            tvvisat, tvvisak,
            tvtotalt, tvtotalk;

    Double creditall,
            amaxt = 0.0, amaxk = 0.0,
            jcbt = 0.0, jcbk = 0.0,
            mastert = 0.0, masterk = 0.0,
            unipayt = 0.0, unipayk = 0.0,
            visat = 0.0, visak = 0.0,
            totalt = 0.0, totalk = 0.0;

    String creditalls,
            amaxts, amaxks,
            jcbts, jcbks,
            masterts, masterks,
            unipayts, unipayks,
            visats, visaks,
            totalts,totalks;
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
        chart = findViewById(R.id.barchart);
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

        tvtotalt = (TextView) findViewById(R.id.tvtotalt);
        tvtotalk = (TextView) findViewById(R.id.tvtotalk);

        btncalendarCredit = (Button) findViewById(R.id.btncalendarCredit);
        btncalendarCredit.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        formatter = new DecimalFormat("#,###,##0.00");
        date = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getKeyDateFull();
        toolbar.setTitle("รายรับบัตรเครดิต");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        toolbar.setSubtitleTextColor(Color.parseColor("#FFFFFF"));
        toolbar.setSubtitle(date);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        reqAPI(SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate());

    }

    // ReqAPI
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

        // ข้อมูล 2 ธนาคาร
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

        totalt = amaxt+jcbt+mastert+unipayt+visat;
        totalk = amaxk+jcbk+masterk+unipayk+visak;

        // setformat #,###,##0.00
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

        totalts = formatter.format(totalt);
        totalks = formatter.format(totalk);

        setTextAndColor();

        chart.setMaxVisibleValueCount(40);
        setData(5);
    }

    private void setData(int count) {

        ArrayList<BarEntry> values = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            float val1 = bar_B1().get(i);
            float val2 = bar_B2().get(i);
            values.add(new BarEntry(i, new float[]{val2, val1}));
        }


        BarDataSet set1;

        set1 = new BarDataSet(values,"Credit");
        set1.setDrawIcons(false);
        set1.setColors(Color.parseColor("#001B7A"),Color.parseColor("#f37023"));
        set1.setValueTextColor(Color.BLACK);
        set1.setStackLabels(new String[]{"ธนาคารธนาชาต","ธนาคารกรุพเทพ"});

        BarData data = new BarData(set1);
        data.setValueFormatter(new MyFormatCredit());

        String[] creditName = new String[]{"A-MAX", "JCB", "MASTER", "UNIPAY", "VISA"};
        XAxis xAxis = chart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(creditName));
        xAxis.setCenterAxisLabels(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);


        data.setBarWidth(0.5f);
        // Hide grid lines
        chart.getAxisLeft().setEnabled(false);
        chart.getAxisRight().setEnabled(false);
        // Hide graph description
        chart.getDescription().setEnabled(false);
        // Hide graph legend
        chart.getLegend().setEnabled(false);
        chart.setData(data);
        chart.setFitBars(true);
        chart.animateY(2000);
        chart.invalidate();

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
        else{
            tvamaxt.setTextColor(Color.parseColor("#FF0000"));
        }
        tvjcbt.setText(jcbts);
        if (jcbt > 0) {
            tvjcbt.setTextColor(Color.parseColor("#4CAF50"));
        }
        else {
            tvjcbt.setTextColor(Color.parseColor("#FF0000"));
        }
        tvmastert.setText(masterts);
        if (mastert > 0) {
            tvmastert.setTextColor(Color.parseColor("#4CAF50"));
        }
        else{
            tvmastert.setTextColor(Color.parseColor("#FF0000"));
        }
        tvvisat.setText(visats);
        if (visat > 0) {
            tvvisat.setTextColor(Color.parseColor("#4CAF50"));
        }
        else{
            tvvisat.setTextColor(Color.parseColor("#FF0000"));
        }
        tvunipayt.setText(unipayts);
        if (unipayt > 0) {
            tvunipayt.setTextColor(Color.parseColor("#4CAF50"));
        }
        else{
            tvunipayt.setTextColor(Color.parseColor("#FF0000"));
        }

        tvamaxk.setText(amaxks);
        if (amaxk > 0) {
            tvamaxk.setTextColor(Color.parseColor("#4CAF50"));
        }
        else{
            tvamaxk.setTextColor(Color.parseColor("#FF0000"));
        }
        tvjcbk.setText(jcbks);
        if (jcbk > 0) {
            tvjcbk.setTextColor(Color.parseColor("#4CAF50"));
        }
        else{
            tvjcbk.setTextColor(Color.parseColor("#FF0000"));
        }
        tvmasterk.setText(masterks);
        if (masterk > 0) {
            tvmasterk.setTextColor(Color.parseColor("#4CAF50"));
        }
        else{
            tvmasterk.setTextColor(Color.parseColor("#FF0000"));
        }
        tvvisak.setText(visaks);
        if (visak > 0) {
            tvvisak.setTextColor(Color.parseColor("#4CAF50"));
        }
        else{
            tvvisak.setTextColor(Color.parseColor("#FF0000"));
        }
        tvunipayk.setText(unipayks);
        if (unipayk > 0) {
            tvunipayk.setTextColor(Color.parseColor("#4CAF50"));
        }
        else{
            tvunipayk.setTextColor(Color.parseColor("#FF0000"));
        }

        tvtotalt.setText(totalts);
        tvtotalt.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
//        if (totalt > 0) {
//            tvtotalt.setTextColor(Color.parseColor("#4CAF50"));
//        }
//        else{
//            tvtotalt.setTextColor(Color.parseColor("#FF0000"));
//        }

        tvtotalk.setText(totalks);
        tvtotalk.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
//        if (totalk > 0) {
//            tvtotalk.setTextColor(Color.parseColor("#4CAF50"));
//        }
//        else{
//            tvtotalk.setTextColor(Color.parseColor("#FF0000"));
//        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    //Bank-T(ธนาคารธนชาต)
    private ArrayList<Float> bar_B1() {
        ArrayList<Float> barBnk1 = new ArrayList<>();
        barBnk1.add(0, (float) ((amaxt/creditall)*100));
        barBnk1.add(1, (float) ((jcbt/creditall)*100));
        barBnk1.add(2, (float) ((mastert/creditall)*100));
        barBnk1.add(3, (float) ((unipayt/creditall)*100));
        barBnk1.add(4, (float) ((visat/creditall)*100));

//        barBnk1.add(0, amaxt.floatValue());
//        barBnk1.add(1, jcbt.floatValue());
//        barBnk1.add(2, mastert.floatValue());
//        barBnk1.add(3, unipayt.floatValue());
//        barBnk1.add(4, visat.floatValue());

        //full
//        barBnk1.add(0, (float) ((amaxt/(amaxt+amaxk))*100));
//        barBnk1.add(1, (float) ((jcbt/(jcbt+jcbk))*100));
//        barBnk1.add(2, (float) ((mastert/(mastert+masterk))*100));
//        barBnk1.add(3, (float) ((unipayt/(unipayt+unipayk))*100));
//        barBnk1.add(4, (float) ((visat/(visat+visak))*100));

        return barBnk1;
    }

    //BBL(ธนาคารกรุงเทพ)
    private ArrayList<Float> bar_B2() {
        ArrayList<Float> barBnk2 = new ArrayList<>();

        barBnk2.add(0, (float) ((amaxk/creditall)*100));
        barBnk2.add(1, (float) ((jcbk/creditall)*100));
        barBnk2.add(2, (float) ((masterk/creditall)*100));
        barBnk2.add(3, (float) ((unipayk/creditall)*100));
        barBnk2.add(4, (float) ((visak/creditall)*100));

//        barBnk2.add(0, amaxk.floatValue());
//        barBnk2.add(1, jcbk.floatValue());
//        barBnk2.add(2, masterk.floatValue());
//        barBnk2.add(3, unipayk.floatValue());
//        barBnk2.add(4, visak.floatValue());

        //full
//        barBnk2.add(0, (float) ((amaxk/(amaxt+amaxk))*100));
//        barBnk2.add(1, (float) ((jcbk/(jcbt+jcbk))*100));
//        barBnk2.add(2, (float) ((masterk/(mastert+masterk))*100));
//        barBnk2.add(3, (float) ((unipayk/(unipayt+unipayk))*100));
//        barBnk2.add(4, (float) ((visak/(visat+visak))*100));

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
                    String fulldate;
                    datecalendat = year+ "/" + mm + "/" +dd;
                    fulldate = dd+ "/" + mm + "/" +year;

                    SharedPrefDateManager.getInstance(Contextor.getInstance().getContext())
                            .saveDatereq(datecalendat);

                    SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).saveDateFull(fulldate);

                    SharedPrefDateManager.getInstance(Contextor.getInstance().getContext())
                            .saveDateCalendar(dayOfMonth,month,year);


                    date = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getKeyDateFull();
                    toolbar.setSubtitle(date);

                    reqAPI(SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate());
                    //CreditActivity.this.recreate();

                }
            },SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getYear()
                    ,SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getMonth()-1
                    ,SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getDateofMonth());

            Date date = null;
            Date d = null;
            String oldDateString = "2019/01/06";
            String NewDateString = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getKeyDate();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
            try {
                d = sdf.parse(oldDateString);
                date = sdf.parse(NewDateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            dialog.show();
            dialog.getDatePicker().setMinDate(d.getTime());
            dialog.getDatePicker().setMaxDate(date.getTime());

        }
    }
}
