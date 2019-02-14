package com.hdw.android.dashboard.activity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
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
import com.hdw.android.dashboard.Dao.objectdao.ObjectItemDao;
import com.hdw.android.dashboard.R;
import com.hdw.android.dashboard.manager.Contextor;
import com.hdw.android.dashboard.manager.DashBoradManager;
import com.hdw.android.dashboard.manager.http.HttpManager;
import com.hdw.android.dashboard.util.SharedPrefDateManager;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RealIncomeActivity extends AppCompatActivity implements View.OnClickListener {

    ObjectItemDao ODao;

    TextView tvincome, tvcashPayments, tvcreditPayments, tvrevenue, tvmemberDebitPayments, tventertainPayments, tvunpaid, tvtotalServiceCharge,tvcredit;

    Double income, cashPayments, creditPayments, revenue, creditCardPayments, memberDebitPayments, entertainPayments, unpaid, totalServiceCharge;

    String vincome, vcashPayments, vcreditPayments, vrevenue, vcreditCardPayments, vmemberDebitPayments, ventertainPayments, vunpaid, vtotalServiceCharge;

    Toolbar toolbar;
    ProgressDialog progress;
    Button btncalendarrevenue;

    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_income);

        initInstances();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void initInstances() {

        toolbar = findViewById(R.id.tbIncome);
        btncalendarrevenue = (Button) findViewById(R.id.btncalendarrevenue);
        tvincome = (TextView) findViewById(R.id.tvincome);
        tvcashPayments = (TextView) findViewById(R.id.tvcashPayments);
        tvcredit = (TextView) findViewById(R.id.tvcredit);
        tvcreditPayments = (TextView) findViewById(R.id.tvcreditPayments);
        tvrevenue = (TextView) findViewById(R.id.tvrevenue);
        tvmemberDebitPayments = (TextView) findViewById(R.id.tvmemberDebitPayments);
        tventertainPayments = (TextView) findViewById(R.id.tventertainPayments);
        tvunpaid = (TextView) findViewById(R.id.tvunpaid);
        tvtotalServiceCharge = (TextView) findViewById(R.id.tvtotalServiceCharge);

    }

    private void setTextViewIncome() {

        DecimalFormat formatter = new DecimalFormat("#,###,##0.00");

        ODao = DashBoradManager.getInstance().getDao().getObject();
        income = ODao.getIncome();
        cashPayments = ODao.getCashPayments();
        creditPayments = ODao.getCreditPayments();
        revenue = ODao.getRevenue();
        creditCardPayments = ODao.getCreditCardPayments();
        memberDebitPayments = ODao.getMemberDebitPayments();
        entertainPayments = ODao.getEntertainPayments();
        unpaid = ODao.getUnpaid();
        totalServiceCharge = ODao.getTotalServiceCharge();



        vincome = formatter.format(income);
        vcashPayments = formatter.format(cashPayments);
        vcreditPayments = formatter.format(creditPayments);
        vrevenue = formatter.format(revenue);
        vcreditCardPayments = formatter.format(creditCardPayments);
        vmemberDebitPayments = formatter.format(memberDebitPayments);
        ventertainPayments = formatter.format(entertainPayments);
        vunpaid = formatter.format(unpaid);
        vtotalServiceCharge = formatter.format(totalServiceCharge);



        tvincome.setText(vincome);
        tvcashPayments.setText(vcashPayments);
        tvcredit.setText(vcreditPayments);
        tvcreditPayments.setText(vcreditCardPayments);
        tvrevenue.setText(vrevenue);
        tvmemberDebitPayments.setText(vmemberDebitPayments);
        tventertainPayments.setText(ventertainPayments);
        tvunpaid.setText(vunpaid);
        tvtotalServiceCharge.setText(vtotalServiceCharge);

    }

    @Override
    protected void onStart() {
        super.onStart();
        date = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getKeyDateFull();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        toolbar.setTitle("รายรับจริง");
        toolbar.setSubtitle(date);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        toolbar.setSubtitleTextColor(Color.parseColor("#FFFFFF"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btncalendarrevenue.setOnClickListener(this);
        setTextViewIncome();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showProgress();
        reqAPI(SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate());
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onClick(View v) {
        if(v == btncalendarrevenue){
            DatePickerDialog dialog = new DatePickerDialog(RealIncomeActivity.this,new DatePickerDialog.OnDateSetListener() {
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
                    String datecalendat, datecalendat2;
                    String fulldate;
                    datecalendat = year+ "/" + mm + "/" +dd;
                    datecalendat2 = year+ "-" + mm + "-" +dd;
                    fulldate = dd+ "/" + mm + "/" +year;

                    SharedPrefDateManager.getInstance(Contextor.getInstance().getContext())
                            .saveDatereq(datecalendat,datecalendat2);

                    SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).saveDateFull(fulldate);

                    SharedPrefDateManager.getInstance(Contextor.getInstance().getContext())
                            .saveDateCalendar(dayOfMonth,month,year);

                    progress.show();
                    date = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getKeyDateFull();
                    toolbar.setSubtitle(date);
                    reqAPI(SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate());
                    //RealIncomeActivity.this.recreate();

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

    public void reqAPI(String date) {

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
                    progress.dismiss();
                    try {
                        setTextViewIncome();
                    }catch (Exception e){
                        Toast.makeText(Contextor.getInstance().getContext(),"ไม่มีข้อมูลที่จะแสดงผล",Toast.LENGTH_SHORT).show();
                    }

                }else {
                    progress.dismiss();
                    Toast.makeText(mcontext,"เกิดข้อผิดพลาด",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<DashBoardDao> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(mcontext,"ไม่สามารถเชื่อมต่อกับข้อมูลได้",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showProgress() {
        progress = new ProgressDialog(RealIncomeActivity.this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
    }
}
