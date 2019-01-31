package com.example.pchrp.newdashboard.activity;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.pchrp.newdashboard.Dao.objectdao.ObjectItemDao;
import com.example.pchrp.newdashboard.R;
import com.example.pchrp.newdashboard.manager.Contextor;
import com.example.pchrp.newdashboard.manager.DashBoradManager;
import com.example.pchrp.newdashboard.util.SharedPrefDateManager;

import java.text.DecimalFormat;

public class RealIncomeActivity extends AppCompatActivity {

    ObjectItemDao ODao;

    TextView tvincome, tvcashPayments, tvcreditPayments, tvrevenue, tvcreditCardPayments, tvmemberDebitPayments, tventertainPayments, tvunpaid, tvtotalServiceCharge,
            tvtotal, tvcredit, tvbill;

    Double income, cashPayments, creditPayments, revenue, creditCardPayments, memberDebitPayments, entertainPayments, unpaid, totalServiceCharge;

    String vincome, vcashPayments, vcreditPayments, vrevenue, vcreditCardPayments, vmemberDebitPayments, ventertainPayments, vunpaid, vtotalServiceCharge,
            vtotal, vcredit, vbill;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_income);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        String date = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate();

        toolbar = findViewById(R.id.tbIncome);
        toolbar.setTitle("รายรับจริง");
        toolbar.setSubtitle(date);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

        tvincome = (TextView) findViewById(R.id.tvincome);
        tvcashPayments = (TextView) findViewById(R.id.tvcashPayments);
        tvcredit = (TextView) findViewById(R.id.tvcredit);
        tvcreditPayments = (TextView) findViewById(R.id.tvcreditPayments);
        tvrevenue = (TextView) findViewById(R.id.tvrevenue);
        tvcreditCardPayments = (TextView) findViewById(R.id.tvcreditCardPayments);
        tvmemberDebitPayments = (TextView) findViewById(R.id.tvmemberDebitPayments);
        tventertainPayments = (TextView) findViewById(R.id.tventertainPayments);
        tvunpaid = (TextView) findViewById(R.id.tvunpaid);
        tvtotalServiceCharge = (TextView) findViewById(R.id.tvtotalServiceCharge);
        tvtotal = (TextView) findViewById(R.id.tvtotal);
        tvbill = (TextView) findViewById(R.id.tvbill);

        setTextViewIncome();

    }

    private void setTextViewIncome() {

        DecimalFormat formatter = new DecimalFormat("#,###,###.00");

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
        tvcreditCardPayments.setText(vcreditCardPayments);
        tvmemberDebitPayments.setText(vmemberDebitPayments);
        tventertainPayments.setText(ventertainPayments);
        tvunpaid.setText(vunpaid);
        tvtotalServiceCharge.setText(vtotalServiceCharge);
        tvtotal.setText(vrevenue);
        tvbill.setText(vincome);
    }
}
