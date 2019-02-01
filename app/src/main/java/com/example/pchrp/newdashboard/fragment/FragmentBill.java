package com.example.pchrp.newdashboard.fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pchrp.newdashboard.Dao.DashBoardDao;
import com.example.pchrp.newdashboard.Dao.objectdao.ObjectItemDao;
import com.example.pchrp.newdashboard.R;
import com.example.pchrp.newdashboard.activity.MainActivity;
import com.example.pchrp.newdashboard.manager.Contextor;
import com.example.pchrp.newdashboard.manager.DashBoradManager;
import com.example.pchrp.newdashboard.manager.http.HttpManager;
import com.example.pchrp.newdashboard.util.SharedPrefDateManager;
import com.razerdp.widget.animatedpieview.AnimatedPieView;
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig;
import com.razerdp.widget.animatedpieview.data.SimplePieInfo;

import java.text.DecimalFormat;
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

    String tincomebill, tserivceDrinkCharge, tmemberCharge, tserviceCharge,
            tproductPrice, tfoodPrice, topenMemberAccount, tserviceDringQty, tpax;

    TextView tvincomebill, tvserivceDrinkCharge, tvmemberCharge, tvserviceCharge,
            tvproductPrice, tvfoodPrice, tvopenMemberAccount, tvserviceDringQty, tvpax;

    Double serivceDrinkCharge, memberCharge, foodPrice, productPrice, serviceCharge, incomebill;

    ObjectItemDao ODao;

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
                .addData(new SimplePieInfo(serivceDrinkCharge, Color.parseColor("#C0FF8C"), "ค่าดื่ม"))//Data (bean that implements the IPieInfo interface)
                .addData(new SimplePieInfo(memberCharge, Color.parseColor("#FF8C9D"), "ค่า Member"))
                .addData(new SimplePieInfo(foodPrice + productPrice + serviceCharge, Color.parseColor("#FFF78C"), "ค่าบริการต่างๆ")).drawText(true).duration(2000).textSize(20);
        mAnimatedPieView.applyConfig(config);
        mAnimatedPieView.start();
    }

    @Override
    public void onStart() {
        super.onStart();

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
        reqAPI(SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate());
        ODao = reqAPI(SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate());
        DrawPie();
        setTextView(ODao);
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
                    String datecalendat;
                    datecalendat = year+ "/" + mm + "/" +dd;

                    SharedPrefDateManager.getInstance(Contextor.getInstance().getContext())
                            .saveDatereq(datecalendat);

                    SharedPrefDateManager.getInstance(Contextor.getInstance().getContext())
                            .saveDateCalendar(dayOfMonth,month,year);

                }
            },SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getYear()
                    ,SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getMonth()
                    ,SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getDateofMonth());

            Calendar c = Calendar.getInstance(Locale.ENGLISH);
            c.add(Calendar.DATE,-1);
            Date date = c.getTime();
            dialog.getDatePicker().setMaxDate(date.getTime());
            dialog.show();

        }
    }

    public ObjectItemDao reqAPI(String date) {

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
                }else {
                    Toast.makeText(mcontext,"เกิดข้อผิดพลาด",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<DashBoardDao> call, Throwable t) {
                Toast.makeText(mcontext,"ไม่สามารถเชื่อมต่อกับข้อมูลได้",Toast.LENGTH_LONG).show();
            }
        });

        return DashBoradManager.getInstance().getDao().getObject();
    }
}