package com.example.pchrp.newdashboard.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pchrp.newdashboard.Dao.NotPayItemColleationDao;
import com.example.pchrp.newdashboard.Dao.PayItemColleationDao;
import com.example.pchrp.newdashboard.R;
import com.example.pchrp.newdashboard.fragment.FragmentNotPay;
import com.example.pchrp.newdashboard.fragment.FragmentPay;
import com.example.pchrp.newdashboard.manager.Contextor;
import com.example.pchrp.newdashboard.manager.PayManager;
import com.example.pchrp.newdashboard.manager.http.HttpManager;
import com.example.pchrp.newdashboard.manager.http.NotPayManager;
import com.example.pchrp.newdashboard.util.SharedPrefDateManager;
import com.razerdp.widget.animatedpieview.AnimatedPieView;
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig;
import com.razerdp.widget.animatedpieview.data.SimplePieInfo;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    Toolbar toolbar;

    TextView tvPay,tvNotPay,tvAll;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        initInstances();
        reqAPIpay();
        reqAPInotpay();

    }

    private void initInstances() {

        String date = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate();
        toolbar = findViewById(R.id.tbPayment);
        toolbar.setTitle("สถานะชำระเงินปัจจุบัน");
        toolbar.setSubtitle(date);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvPay = (TextView)findViewById(R.id.tvPay);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }

    private void reqAPInotpay() {

        final Context mcontext = Contextor.getInstance().getContext();
        String nn = "{\"criteria\":{\"sql-obj-command\":\"f:documentStatus.id = 22 and f:salesShift.isOpening = 1 \"},\"property\":[\"memberAccount->customerMemberAccount\",\"sales->employee\",\"place\",\"transactionPaymentList\",\"documentStatus\",\"salesShift\"],\"pagination\":{},\"orderBy\":{\"InvoiceDocument-id\":\"DESC\"}}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),nn);
        Call<NotPayItemColleationDao> call = HttpManager.getInstance().getService().loadAPINotPay(requestBody);
        call.enqueue(new Callback<NotPayItemColleationDao>() {
            @Override
            public void onResponse(Call<NotPayItemColleationDao> call, Response<NotPayItemColleationDao> response) {
                if(response.isSuccessful()){
                    NotPayItemColleationDao dao = response.body();
                    NotPayManager.getInstance().setPayItemColleationDao(dao);
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
    private void reqAPIpay() {
        final Context mcontext = Contextor.getInstance().getContext();
        String nn = "{\"criteria\":{\"sql-obj-command\":\"f:documentStatus.id = 21 and f:salesShift.isOpening = 1\"},\"property\":[\"memberAccount->customerMemberAccount\",\"sales->employee\",\"place\",\"transactionPaymentList\",\"documentStatus\",\"salesShift\"],\"pagination\":{},\"orderBy\":{\"InvoiceDocument-id\":\"DESC\"}}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),nn);
        Call<PayItemColleationDao> call = HttpManager.getInstance().getService().loadAPIPay(requestBody);
        call.enqueue(new Callback<PayItemColleationDao>() {
            @Override
            public void onResponse(Call<PayItemColleationDao> call, Response<PayItemColleationDao> response) {
                if(response.isSuccessful()){
                    PayItemColleationDao dao = response.body();
                    PayManager.getInstance().setPayItemColleationDao(dao);
                    tvPay.setText(PayManager.getInstance().getPayItemColleationDao().getPagination().getTotalItem().toString());
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
}