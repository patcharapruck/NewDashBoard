package com.hdw.android.dashboard.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.hdw.android.dashboard.Dao.NotPayItemColleationDao;
import com.hdw.android.dashboard.Dao.PayItemColleationDao;
import com.hdw.android.dashboard.R;
import com.hdw.android.dashboard.fragment.FragmentNotPay;
import com.hdw.android.dashboard.fragment.FragmentPay;
import com.hdw.android.dashboard.manager.Contextor;
import com.hdw.android.dashboard.manager.PayManager;
import com.hdw.android.dashboard.manager.http.HttpManager;
import com.hdw.android.dashboard.manager.NotPayManager;
import com.hdw.android.dashboard.util.SharedPrefDateManager;
import com.hdw.android.dashboard.util.SharedPrefDatePayManager;

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

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    Toolbar toolbar;
    TextView tvPay,tvNotPay,tvAll;
    Long num = 0L,num2=0L,num3=0L;
    String date;
    TabLayout tabLayout;

    Button btncalendarpayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        initInstances();
    }

    private void initInstances() {

        toolbar = findViewById(R.id.tbPayment);
        btncalendarpayment = findViewById(R.id.btncalendarpayment);
        tvPay = (TextView)findViewById(R.id.tvPay);
        tvNotPay = (TextView)findViewById(R.id.tvNotPay);
        tvAll = (TextView)findViewById(R.id.tvAll);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        reqAPIpay(SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getKeyDatePay());
        reqAPInotpay(SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getKeyDatePay());

    }

    private void reqAPInotpay(String date) {
        final Context mcontext = Contextor.getInstance().getContext();
        String nn = "{\"criteria\":{\"sql-obj-command\":\"f:documentStatus.id = 22 and " +
                "(f:salesShift.openDate >= '"+date+" 00:00:00' AND f:salesShift.openDate <= '"+date+" 23:59:59')\"}," +
                "\"property\":[\"memberAccount->customerMemberAccount\",\"sales->employee\",\"place\",\"transactionPaymentList\",\"documentStatus\",\"salesShift\"]," +
                "\"pagination\":{},\"orderBy\":{\"InvoiceDocument-id\":\"DESC\"}}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),nn);
        Call<NotPayItemColleationDao> call = HttpManager.getInstance().getService().loadAPINotPay(requestBody);
        call.enqueue(new Callback<NotPayItemColleationDao>() {
            @Override
            public void onResponse(Call<NotPayItemColleationDao> call, Response<NotPayItemColleationDao> response) {
                if(response.isSuccessful()){
                    NotPayItemColleationDao dao = response.body();
                    NotPayManager.getInstance().setNotpayItemColleationDao(dao);

                    SharedPrefDatePayManager.getInstance(Contextor.getInstance().getContext())
                            .saveNotPay(dao.getPagination().getTotalItem());
                }else {
                    Toast.makeText(mcontext,"เกิดข้อผิดพลาด",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<NotPayItemColleationDao> call, Throwable t) {
                Toast.makeText(mcontext,"ไม่สามารถเชื่อมต่อได้",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void reqAPIpay(String date) {
        final Context mcontext = Contextor.getInstance().getContext();
        String nn = "{\"criteria\":{\"sql-obj-command\":\"f:documentStatus.id = 21 and " +
                "(f:salesShift.openDate >= '"+date+" 00:00:00' AND f:salesShift.openDate <= '"+date+" 23:59:59')\"}," +
                "\"property\":[\"memberAccount->customerMemberAccount\",\"sales->employee\",\"place\",\"transactionPaymentList\",\"documentStatus\",\"salesShift\"]," +
                "\"pagination\":{},\"orderBy\":{\"InvoiceDocument-id\":\"DESC\"}}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),nn);
        Call<PayItemColleationDao> call = HttpManager.getInstance().getService().loadAPIPay(requestBody);
        call.enqueue(new Callback<PayItemColleationDao>() {
            @Override
            public void onResponse(Call<PayItemColleationDao> call, Response<PayItemColleationDao> response) {
                if(response.isSuccessful()){
                    PayItemColleationDao dao = response.body();
                    PayManager.getInstance().setPayItemColleationDao(dao);

                    SharedPrefDatePayManager.getInstance(Contextor.getInstance().getContext())
                            .savePay(dao.getPagination().getTotalItem());
                }else {
                    Toast.makeText(mcontext,"เกิดข้อผิดพลาด",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<PayItemColleationDao> call, Throwable t) {
                Toast.makeText(mcontext,"ไม่สามารถเชื่อมต่อได้",Toast.LENGTH_LONG).show();
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

    @Override
    public void onClick(View v) {
        if(v == btncalendarpayment){
            DatePickerDialog dialog = new DatePickerDialog(PaymentActivity.this,new DatePickerDialog.OnDateSetListener() {
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


                    date = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getKeyDateFull();
                    toolbar.setSubtitle(date);
                    reqAPIpay(datecalendat2);
                    reqAPInotpay(datecalendat2);


                   // PaymentActivity.this.recreate();
//                    SharedPrefDatePayManager.getInstance(Contextor.getInstance().getContext())
//                            .savePay(PayManager.getInstance().getPayItemColleationDao().getPagination().getTotalItem());
//

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

//        num2 = SharedPrefDatePayManager.getInstance(Contextor.getInstance().getContext()).getPay();
//        num3 = SharedPrefDatePayManager.getInstance(Contextor.getInstance().getContext()).getNotPay();
//        num = num2+num3;
//
//        tvPay.setText(num2.toString());
//        tvNotPay.setText(num3.toString());
//        tvAll.setText(num.toString());

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FragmentPay();
                default:
                    return new FragmentNotPay();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        date = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getKeyDateFull();

        toolbar.setTitle("สถานะชำระเงินปัจจุบัน");
        toolbar.setSubtitle(date);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        toolbar.setSubtitleTextColor(Color.parseColor("#FFFFFF"));
        btncalendarpayment.setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        num2 = SharedPrefDatePayManager.getInstance(Contextor.getInstance().getContext()).getPay();
        num3 = SharedPrefDatePayManager.getInstance(Contextor.getInstance().getContext()).getNotPay();
        num = num2+num3;

        tvPay.setText(num2.toString());
        tvNotPay.setText(num3.toString());
        tvAll.setText(num.toString());

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}