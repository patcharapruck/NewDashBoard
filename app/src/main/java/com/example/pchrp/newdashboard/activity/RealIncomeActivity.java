package com.example.pchrp.newdashboard.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.pchrp.newdashboard.R;
import com.example.pchrp.newdashboard.manager.DashBoradManager;

public class RealIncomeActivity extends AppCompatActivity {


    TextView tvincome,tvcashPayments,tvcreditPayments,tvrevenue,tvcreditCardPayments
            ,tvmemberDebitPayments,tventertainPayments,tvunpaid,tvtotalServiceCharge,tvtotal,tvcredit,tvbill;

    Double income,cashPayments,creditPayments,revenue,creditCardPayments
            ,memberDebitPayments,entertainPayments,unpaid,totalServiceCharge;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_income);
    toolbar = findViewById(R.id.tbIncome);
    toolbar.setTitle("รายรับจริง");
    toolbar.setSubtitle("วัน เดือน ปี");
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

        tvincome = (TextView)findViewById(R.id.tvincome);
        tvcashPayments = (TextView)findViewById(R.id.tvcashPayments);
        tvcredit = (TextView)findViewById(R.id.tvcredit);
        tvcreditPayments = (TextView)findViewById(R.id.tvcreditPayments);
        tvrevenue = (TextView)findViewById(R.id.tvrevenue);
        tvcreditCardPayments = (TextView)findViewById(R.id.tvcreditCardPayments);
        tvmemberDebitPayments = (TextView)findViewById(R.id.tvmemberDebitPayments);
        tventertainPayments = (TextView)findViewById(R.id.tventertainPayments);
        tvunpaid = (TextView)findViewById(R.id.tvunpaid);
        tvtotalServiceCharge = (TextView)findViewById(R.id.tvtotalServiceCharge);
        tvtotal = (TextView)findViewById(R.id.tvtotal);
        tvbill = (TextView)findViewById(R.id.tvbill);

        income = DashBoradManager.getInstance().getDao().getIncome();
        cashPayments = DashBoradManager.getInstance().getDao().getCashPayments();
        creditPayments = DashBoradManager.getInstance().getDao().getCreditPayments();
        revenue = DashBoradManager.getInstance().getDao().getRevenue();
        creditCardPayments = DashBoradManager.getInstance().getDao().getCreditCardPayments();
        memberDebitPayments = DashBoradManager.getInstance().getDao().getMemberDebitPayments();
        entertainPayments = DashBoradManager.getInstance().getDao().getEntertainPayments();
        unpaid = DashBoradManager.getInstance().getDao().getUnpaid();
        totalServiceCharge = DashBoradManager.getInstance().getDao().getTotalServiceCharge();
//        total =  DashBoradManager.getInstance().getDao().getIncome();
//        credit = DashBoradManager.getInstance().getDao().getCreditPayments();



        tvincome.setText(income.toString());
        tvcashPayments.setText(cashPayments.toString());
        tvcredit.setText(creditPayments.toString());
        tvcreditPayments.setText(creditPayments.toString());
        tvrevenue.setText(revenue.toString());
        tvcreditCardPayments.setText(creditCardPayments.toString());
        tvmemberDebitPayments.setText(memberDebitPayments.toString());
        tventertainPayments.setText(entertainPayments.toString());
        tvunpaid.setText(unpaid.toString());
        tvtotalServiceCharge.setText(totalServiceCharge.toString());
        tvtotal.setText(revenue.toString());
        tvbill.setText(income.toString());

    }
}
