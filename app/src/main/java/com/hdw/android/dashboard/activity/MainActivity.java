package com.hdw.android.dashboard.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hdw.android.dashboard.Dao.DashBoardDao;
import com.hdw.android.dashboard.Dao.NotPayItemColleationDao;
import com.hdw.android.dashboard.Dao.PayItemColleationDao;
import com.hdw.android.dashboard.R;
import com.hdw.android.dashboard.manager.Contextor;
import com.hdw.android.dashboard.manager.DashBoradManager;
import com.hdw.android.dashboard.manager.NotPayManager;
import com.hdw.android.dashboard.manager.PayManager;
import com.hdw.android.dashboard.manager.http.HttpManager;
import com.hdw.android.dashboard.util.SharedPrefDateManager;
import com.hdw.android.dashboard.util.SharedPrefDatePayManager;
import com.hdw.android.dashboard.util.SharedPrefManager;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


        CardView cv_bill,Cv_pay,Cv_drink,Cv_real,Cv_credit,Cv_graph;
        TextView menutextbill,menupay,menudrink,menureal,menucredit,menugraph;
        ImageView imgbill,imgpay,imgdrink,imgreal,imgcredit,imggraph;
        Button mainImgDate;

        TextView logout;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            initInstances();
        }

        private void initInstances() {

            getDateTime();

            cv_bill = (CardView)findViewById(R.id.Cv_bill);
            Cv_pay = (CardView)findViewById(R.id.Cv_pay);
            Cv_drink = (CardView)findViewById(R.id.Cv_drink);
            Cv_real = (CardView)findViewById(R.id.Cv_real);
            Cv_credit = (CardView)findViewById(R.id.Cv_credit);
            Cv_graph = (CardView)findViewById(R.id.Cv_graph);


            logout = (TextView)findViewById(R.id.logout);
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
            mainImgDate = (Button) findViewById(R.id.mainImgDate);

            setClickfuntion();

        }

    private void setClickfuntion() {

        mainImgDate.setOnClickListener(this);
        cv_bill.setOnClickListener(this);
        Cv_pay.setOnClickListener(this);
        Cv_drink.setOnClickListener(this);
        Cv_real.setOnClickListener(this);
        Cv_credit.setOnClickListener(this);
        Cv_graph.setOnClickListener(this);


        logout.setOnClickListener(this);
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


    private void getDateTime() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        DateFormat dateFormatth = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        Calendar calendartoday = Calendar.getInstance();

        calendar.setTime(date);
        calendartoday.setTime(date);

        calendar.add(Calendar.DATE,-1);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH)+1;
        int year = calendar.get(Calendar.YEAR);

        String formatDateTime = dateFormat.format(calendar.getTime());
        String formatDateTime2 = dateFormat2.format(calendar.getTime());
        String formatDateTimetoday = dateFormat.format(calendartoday.getTime());
        String formatDategeneral = dateFormatth.format(calendar.getTime());

        SharedPrefDateManager.getInstance(Contextor.getInstance().getContext())
                .saveDatereq(formatDateTime,formatDateTime2);

        SharedPrefDateManager.getInstance(Contextor.getInstance().getContext())
                .saveDateMax(formatDateTimetoday);

        SharedPrefDateManager.getInstance(Contextor.getInstance().getContext())
                .saveDateFull(formatDategeneral);

        SharedPrefDateManager.getInstance(Contextor.getInstance().getContext())
                .saveDateCalendar(day,month,year);
    }

    public void reqAPI(String date) {

        final Context mcontext = Contextor.getInstance().getContext();
        String nn = "{\"property\":[],\"criteria\":{\"sql-obj-command\":\"( tb_sales_shift.open_date >= '"+date+" 00:00:00' AND tb_sales_shift.open_date <= '"+date+" 23:59:59')\",\"summary-date\":\"*\"},\"orderBy\":{\"InvoiceDocument-id\":\"desc\"},\"pagination\":{}}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),nn);
        Call<DashBoardDao> call = HttpManager.getInstance().getService().loadAPI(requestBody);
        call.enqueue(new Callback<DashBoardDao>() {

            @Override
            public void onResponse(Call<DashBoardDao> call, Response<DashBoardDao> response) {

               String aa = String.valueOf(response.raw().code());

                if(response.isSuccessful()){
                    DashBoardDao dao = response.body();
                    DashBoradManager.getInstance().setDao(dao);
                }else {
                    if(response.code() == 403){
                        SharedPrefManager.getInstance(Contextor.getInstance().getContext()).logout();
                        SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).logoutDate();
                        SharedPrefDatePayManager.getInstance(Contextor.getInstance().getContext()).logoutPay();

                        Toast.makeText(Contextor.getInstance().getContext(),aa,Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this,LogInActivity.class);
                        mcontext.startActivity(intent);
                        finish();

                    }else{
                        Toast.makeText(mcontext,"เกิดข้อผิดพลาด",Toast.LENGTH_LONG).show();
                    }
                }
            }
            @Override
            public void onFailure(Call<DashBoardDao> call, Throwable t) {

                Toast.makeText(mcontext,"ไม่สามารถเชื่อมต่อกับข้อมูลได้",Toast.LENGTH_LONG).show();

            }
        });
    }


    @Override
        public void onClick(View v) {
            //บิล
            if (v==cv_bill||v==menutextbill||v==imgbill){
                Intent intent = new Intent(MainActivity.this,BillActivity.class);
                this.startActivity(intent);
                //this.finish();
            }
            //ยฟั
            if (v==Cv_pay||v==menupay||v==imgpay){
                Intent intent = new Intent(MainActivity.this,PaymentActivity.class);
                this.startActivity(intent);
                //this.finish();
            }

            if (v==Cv_drink||v==menudrink||v==imgdrink){
                Intent intent = new Intent(MainActivity.this,DrinkActivity.class);
                this.startActivity(intent);

            }

            if (v==Cv_real||v==menureal||v==imgreal){
                Intent intent = new Intent(MainActivity.this,RealIncomeActivity.class);
                this.startActivity(intent);
            }
            if (v==Cv_credit||v==menucredit||v==imgcredit){
                Intent intent = new Intent(MainActivity.this,CreditActivity.class);
                this.startActivity(intent);
            }
            if (v==Cv_graph|v==menugraph||v==imggraph){
                Intent intent = new Intent(MainActivity.this,CompareReceipts.class);
                this.startActivity(intent);

            }
            if(v == mainImgDate){

                int day = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getDateofMonth();
                int month = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getMonth();
                int year = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getYear();

                final DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,new DatePickerDialog.OnDateSetListener() {
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
                        mainImgDate.setText(dd+ "/" + mm + "/" +year);
                        datecalendat = year+ "/" + mm + "/" +dd;
                        datecalendat2 = year+ "-" + mm + "-" +dd;
                        fulldate = dd+ "/" + mm + "/" +year;

                        SharedPrefDateManager.getInstance(Contextor.getInstance().getContext())
                                .saveDatereq(datecalendat,datecalendat2);

                        SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).saveDateFull(fulldate);

                        reqAPI(SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate());

                        SharedPrefDateManager.getInstance(Contextor.getInstance().getContext())
                                .saveDateCalendar(dayOfMonth,month,year);

                    }
                },year,month-1,day);

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

            if (v == logout){
                SharedPrefManager.getInstance(Contextor.getInstance().getContext()).logout();
                SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).logoutDate();
                SharedPrefDatePayManager.getInstance(Contextor.getInstance().getContext()).logoutPay();

                Intent intent = new Intent(MainActivity.this,LogInActivity.class);
                this.startActivity(intent);
                finish();
            }
        }

    @Override
    protected void onStart() {
        super.onStart();
        reqAPIpay();
        reqAPInotpay();
        mainImgDate.setText(SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getKeyDateFull());
        reqAPI(SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate());
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
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
}