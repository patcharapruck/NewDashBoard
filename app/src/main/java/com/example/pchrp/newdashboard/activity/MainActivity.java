package com.example.pchrp.newdashboard.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pchrp.newdashboard.Dao.DashBoardDao;
import com.example.pchrp.newdashboard.R;
import com.example.pchrp.newdashboard.manager.Contextor;
import com.example.pchrp.newdashboard.manager.DashBoradManager;
import com.example.pchrp.newdashboard.manager.http.HttpManager;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


        CardView cv_bill,Cv_pay,Cv_drink,Cv_real,Cv_credit,Cv_graph;
        CardView cv_in_bill,cv_in_pay,cv_in_drink,cv_in_real,cv_in_credit,cv_in_graph;
        TextView menutextbill,menupay,menudrink,menureal,menucredit,menugraph;
        ImageView imgbill,imgpay,imgdrink,imgreal,imgcredit,imggraph;

        TextView tvmaindate;
        ImageView mainImgDate;

        String DateMain="";



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            initInstances();
        }

        private void initInstances() {

            DateMain = getDateTime();

            cv_bill = (CardView)findViewById(R.id.Cv_bill);
            Cv_pay = (CardView)findViewById(R.id.Cv_pay);
            Cv_drink = (CardView)findViewById(R.id.Cv_drink);
            Cv_real = (CardView)findViewById(R.id.Cv_real);
            Cv_credit = (CardView)findViewById(R.id.Cv_credit);
            Cv_graph = (CardView)findViewById(R.id.Cv_graph);

            cv_in_bill = (CardView)findViewById(R.id.cv_in_bill);
            cv_in_pay = (CardView)findViewById(R.id.cv_in_pay);
            cv_in_drink = (CardView)findViewById(R.id.cv_in_drink);
            cv_in_real = (CardView)findViewById(R.id.cv_in_real);
            cv_in_credit = (CardView)findViewById(R.id.cv_in_credit);
            cv_in_graph = (CardView)findViewById(R.id.cv_in_graph);

            menutextbill = (TextView)findViewById(R.id.menutextbill);
            menupay = (TextView)findViewById(R.id.menupay);
            menudrink = (TextView)findViewById(R.id.menudrink);
            menureal = (TextView)findViewById(R.id.menureal);
            menucredit = (TextView)findViewById(R.id.menucredit);
            menugraph = (TextView)findViewById(R.id.menugraph);

            imgbill = (ImageView)findViewById(R.id.imgbill);
            imgpay = (ImageView)findViewById(R.id.imgpay);
            imgdrink = (ImageView)findViewById(R.id.imgdrink);
            imgreal = (ImageView)findViewById(R.id.imgreal);
            imgcredit = (ImageView)findViewById(R.id.imgcredit);
            imggraph = (ImageView)findViewById(R.id.imggraph);

            tvmaindate = (TextView)findViewById(R.id.tvmaindate);
            mainImgDate = (ImageView)findViewById(R.id.mainImgDate);

            tvmaindate.setText(DateMain);

            reqAPI();

            cv_bill.setOnClickListener(this);
            Cv_pay.setOnClickListener(this);
            Cv_drink.setOnClickListener(this);
            Cv_real.setOnClickListener(this);
            Cv_credit.setOnClickListener(this);
            Cv_graph.setOnClickListener(this);

            cv_in_bill.setOnClickListener(this);
            cv_in_pay.setOnClickListener(this);
            cv_in_drink.setOnClickListener(this);
            cv_in_real.setOnClickListener(this);
            cv_in_credit.setOnClickListener(this);
            cv_in_graph.setOnClickListener(this);

            menutextbill.setOnClickListener(this);
            menupay.setOnClickListener(this);
            menudrink.setOnClickListener(this);
            menureal.setOnClickListener(this);
            menucredit.setOnClickListener(this);
            menugraph.setOnClickListener(this);

            imgbill.setOnClickListener(this);
            imgpay.setOnClickListener(this);
            imgdrink.setOnClickListener(this);
            imgreal.setOnClickListener(this);
            imgcredit.setOnClickListener(this);
            imggraph.setOnClickListener(this);
        }


    private String getDateTime() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH);
        Date date = new Date();
        String formatDateTime = dateFormat.format(date);

        return formatDateTime;
    }

    private void reqAPI() {

        final Context mcontext = Contextor.getInstance().getContext();
        String nn = "{\"property\":[],\"criteria\":{\"sql-obj-command\":\"( tb_sales_shift.open_date >= '2019-01-23 00:00:00' AND tb_sales_shift.open_date <= '2019-01-23 23:59:59')\",\"summary-date\":\"*\"},\"orderBy\":{\"InvoiceDocument-id\":\"desc\"},\"pagination\":{}}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),nn);
        Log.v("https",nn);
        Call<DashBoardDao> call = HttpManager.getInstance().getService().loadAPI(requestBody);
        call.enqueue(new Callback<DashBoardDao>() {

            @Override
            public void onResponse(Call<DashBoardDao> call, Response<DashBoardDao> response) {
                if(response.isSuccessful()){
                    DashBoardDao dao = response.body();
                    DashBoradManager.getInstance().setDao(dao);
                    Toast.makeText(mcontext,dao.getObject().getIncome().toString(),Toast.LENGTH_SHORT).show();
                }else {
                    try {
                        Toast.makeText(mcontext,"aaaa"+response.errorBody().string(),Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(Call<DashBoardDao> call, Throwable t) {
                Toast.makeText(mcontext,"sssss"+t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
        public void onClick(View v) {
            //บิล
            if (v==cv_bill||v==cv_in_bill||v==menutextbill||v==imgbill){
                Intent intent = new Intent(MainActivity.this,BillActivity.class);
                this.startActivity(intent);
                //this.finish();
            }
            //ยฟั
            if (v==Cv_pay||v==cv_in_pay||v==menupay||v==imgpay){
                Intent intent = new Intent(MainActivity.this,PaymentActivity.class);
                this.startActivity(intent);
                //this.finish();
            }

            if (v==Cv_drink||v==cv_in_drink||v==menudrink||v==imgdrink){
                Intent intent = new Intent(MainActivity.this,DrinkActivity.class);
                this.startActivity(intent);

            }

            if (v==Cv_real||v==cv_in_real||v==menureal||v==imgreal){
                Intent intent = new Intent(MainActivity.this,RealIncomeActivity.class);
                this.startActivity(intent);
            }
            if (v==Cv_credit||v==cv_in_credit||v==menucredit||v==imgcredit){
                Intent intent = new Intent(MainActivity.this,CreditActivity.class);
                this.startActivity(intent);
            }
            if (v==Cv_graph||v==cv_in_graph||v==menugraph||v==imggraph){
                Intent intent = new Intent(MainActivity.this,CompareReceipts.class);
                this.startActivity(intent);

            }
        }
    }