package com.hdw.android.dashboard.fragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hdw.android.dashboard.Dao.DashBoardDao;
import com.hdw.android.dashboard.Dao.objectdao.ObjectItemDao;
import com.hdw.android.dashboard.R;
import com.hdw.android.dashboard.activity.BillActivity;
import com.hdw.android.dashboard.activity.RealIncomeActivity;
import com.hdw.android.dashboard.manager.Contextor;
import com.hdw.android.dashboard.manager.DashBoradManager;
import com.hdw.android.dashboard.manager.http.HttpManager;
import com.hdw.android.dashboard.util.SharedPrefDateManager;
import com.razerdp.widget.animatedpieview.AnimatedPieView;
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig;
import com.razerdp.widget.animatedpieview.data.SimplePieInfo;

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

public class FragmentBill extends Fragment implements View.OnClickListener {

    AnimatedPieView mAnimatedPieView;
    AnimatedPieViewConfig config;
    BillActivity billActivity = new BillActivity();


    ProgressDialog progress;
    Toolbar toolbar;

    String tincomebill, tserivceDrinkCharge, tmemberCharge, tserviceCharge,
            tproductPrice, tfoodPrice, topenMemberAccount, tserviceDringQty, tpax;

    TextView tvincomebill, tvserivceDrinkCharge, tvmemberCharge, tvserviceCharge,
            tvproductPrice, tvfoodPrice, tvopenMemberAccount, tvserviceDringQty, tvpax;

    Double serivceDrinkCharge, memberCharge, foodPrice, productPrice, serviceCharge, incomebill;

    ObjectItemDao ODao;
    String date;
     Button btncalendarbill;

    public FragmentBill() {
        super();
    }

    public static FragmentBill newInstance() {
        FragmentBill fragment = new FragmentBill();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_bill_income, container, false);
        initInstances(rootView);
        return rootView;

    }

    private void initInstances(View rootView) {
        toolbar = rootView.findViewById(R.id.tbBill);
        btncalendarbill = (Button)rootView.findViewById(R.id.btncalendarbill);
        mAnimatedPieView = rootView.findViewById(R.id.drew2);
        tvincomebill = (TextView) rootView.findViewById(R.id.tvincomebill);
        tvmemberCharge = (TextView) rootView.findViewById(R.id.tvmemberCharge);
        tvfoodPrice = (TextView) rootView.findViewById(R.id.tvfoodPrice);
        tvserivceDrinkCharge = (TextView) rootView.findViewById(R.id.tvserivceDrinkCharge);
        tvserviceCharge = (TextView) rootView.findViewById(R.id.tvserviceCharge);
        tvserviceDringQty = (TextView) rootView.findViewById(R.id.tvserviceDringQty);
        tvproductPrice = (TextView) rootView.findViewById(R.id.tvproductPrice);
        tvpax = (TextView) rootView.findViewById(R.id.tvpax);
        tvopenMemberAccount = (TextView) rootView.findViewById(R.id.tvopenMemberAccount);

        btncalendarbill.setOnClickListener(this);

    }

    private void setTextView(ObjectItemDao ODao) {

        DecimalFormat formatter = new DecimalFormat("#,###,###.00");
        DecimalFormat formatt = new DecimalFormat("#,###,###");
        tincomebill = formatter.format(ODao.getIncome());
        tserivceDrinkCharge = formatter.format(ODao.getSerivceDrinkCharge());
        tmemberCharge = formatter.format(ODao.getMemberCharge());
        tserviceCharge = formatter.format(ODao.getServiceCharge());
        tproductPrice = formatter.format(ODao.getProductPrice());
        tfoodPrice = formatter.format(ODao.getFoodPrice());
        topenMemberAccount = formatt.format(ODao.getOpenMemberAccount());
        tserviceDringQty = formatt.format(ODao.getServiceDringQty());
        tpax = formatt.format(ODao.getPax());

        tvincomebill.setText(tincomebill);
        tvmemberCharge.setText(tmemberCharge);
        tvfoodPrice.setText(tfoodPrice);
        tvserviceDringQty.setText(tserviceDringQty);
        tvserviceCharge.setText(tserviceCharge);
        tvserivceDrinkCharge.setText(tserivceDrinkCharge);
        tvproductPrice.setText(tproductPrice);
        tvpax.setText(tpax);
        tvopenMemberAccount.setText(topenMemberAccount);
    }

    private void DrawPie() {

        serivceDrinkCharge = ODao.getSerivceDrinkCharge();
        memberCharge = ODao.getMemberCharge();
        foodPrice = ODao.getFoodPrice();
        productPrice = ODao.getProductPrice();
        serviceCharge = ODao.getServiceCharge();

        config = new AnimatedPieViewConfig();
        config.startAngle(-90)// Starting angle offset
                .addData(new SimplePieInfo(productPrice, Color.parseColor("#FF7902"), "ค่าสินค้า"))
                .addData(new SimplePieInfo(serivceDrinkCharge, Color.parseColor("#8F47EA"), "ค่าดื่ม"))//Data (bean that implements the IPieInfo interface)
                .addData(new SimplePieInfo(foodPrice, Color.parseColor("#FB285E"), "ค่าอาหาร"))
                .addData(new SimplePieInfo(memberCharge, Color.parseColor("#0780AF"), "ค่า Member"))
                .addData(new SimplePieInfo(serviceCharge, Color.parseColor("#057BFF"), "ค่าบริการ")).drawText(true).duration(2000).textSize(30);
        mAnimatedPieView.applyConfig(config);
        mAnimatedPieView.start();
    }

    @Override
    public void onStart() {
        super.onStart();
        date = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getKeyDateFull();
        billActivity = (BillActivity) getActivity();
        billActivity.setSupportActionBar(toolbar);
        billActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        billActivity.getSupportActionBar().setTitle("รายรับตามบิล");
        billActivity.getSupportActionBar().setSubtitle(date);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        toolbar.setSubtitleTextColor(Color.parseColor("#FFFFFF"));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billActivity.finish();
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            billActivity.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        showProgress();
        reqAPI(SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate());
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
                if(v == btncalendarbill){

                DatePickerDialog dialog = new DatePickerDialog(getContext(),new DatePickerDialog.OnDateSetListener() {

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
                    billActivity.getSupportActionBar().setSubtitle(date);

                    reqAPI(SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate());

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
                    if(DashBoradManager.getInstance().getDao() == null || DashBoradManager.getInstance().getDao().getObject() == null){
                        Toast.makeText(Contextor.getInstance().getContext(),"ไม่มีข้อมูลที่จะแสดงผล",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        ODao =  DashBoradManager.getInstance().getDao().getObject();
                    }

                    try {
                        DrawPie();
                    }catch (Exception e){
                        Toast.makeText(Contextor.getInstance().getContext(),"ไม่มีข้อมูลที่จะแสดงผล",Toast.LENGTH_SHORT).show();
                    }

                    try {
                        setTextView(ODao);
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
        progress = new ProgressDialog(getContext());
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
    }
}