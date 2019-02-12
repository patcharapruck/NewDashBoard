package com.hdw.android.dashboard.fragment;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.hdw.android.dashboard.Dao.DashBoardDao;
import com.hdw.android.dashboard.Dao.objectdao.ObjectItemDao;
import com.hdw.android.dashboard.Dao.product.ProductSortDao;
import com.hdw.android.dashboard.adapter.ProductListAdapter;
import com.hdw.android.dashboard.manager.Contextor;
import com.hdw.android.dashboard.manager.DashBoradManager;
import com.hdw.android.dashboard.manager.ProductManager;
import com.hdw.android.dashboard.manager.http.HttpManager;
import com.hdw.android.dashboard.util.SharedPrefDateManager;
import com.hdw.android.dashboard.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentDrink extends Fragment implements View.OnClickListener {

    TextView tvtotalpd, tventertainpd, tvpurchasepd, tvwithdrawpd;
   // Button btndrink;
    Toolbar toolbar;
    ArrayList<String> nameProduct;
    ArrayList<Long> totalAllProduct;
    ArrayList<Long> entertainProduct;
    ArrayList<Long> purchaseProduct;
    ArrayList<Long> withdrawProduct;
    ObjectItemDao Odao;
    int size;
    String date;

    ListView listProduct;
    ProductListAdapter productlistAdapter;

    AppCompatActivity activity;

    Button btncalendardrink;

    public FragmentDrink() {
        super();
    }

    public static FragmentDrink newInstance() {
        FragmentDrink fragment = new FragmentDrink();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_drink, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {

        toolbar = (Toolbar) rootView.findViewById(R.id.tbDrink);
        btncalendardrink = (Button)rootView.findViewById(R.id.btncalendardrink);
        btncalendardrink.setOnClickListener(this);

        tvtotalpd = (TextView) rootView.findViewById(R.id.tvtotalpd);
        tventertainpd = (TextView) rootView.findViewById(R.id.tventertainpd);
        tvpurchasepd = (TextView) rootView.findViewById(R.id.tvpurchasepd);
        tvwithdrawpd = (TextView) rootView.findViewById(R.id.tvwithdrawpd);

        listProduct = (ListView) rootView.findViewById(R.id.listProduct);

        //btndrink.setOnClickListener(this);
    }


    private Long getWithdraw(int i) {
        Long withdraw;
        try {
            withdraw = DashBoradManager.getInstance().getDao().getObject().getSummaryUseProductList().get(i).getWithdrawUse();
        } catch (NullPointerException e) {
            return 0L;
        }
        return withdraw;
    }

    private Long getPurchase(int i) {
        Long purchase;
        try {
            purchase = DashBoradManager.getInstance().getDao().getObject().getSummaryUseProductList().get(i).getPurchaseAmount();
        } catch (NullPointerException e) {
            return 0L;
        }
        return purchase;
    }

    private Long getEntertain(int i) {
        Long enter;
        try {
            enter = DashBoradManager.getInstance().getDao().getObject().getSummaryUseProductList().get(i).getEntertainAmount();
        } catch (NullPointerException e) {
            return 0L;
        }
        return enter;
    }

    private Long gettotalProduct(int i) {
        Long total;
        try {
            total = DashBoradManager.getInstance().getDao().getObject().getSummaryUseProductList().get(i).getTotalAll();
        } catch (NullPointerException e) {
            return 0L;
        }
        return total;
    }

    private String getnameProduct(int i) {
        String name;
        try {
            name = DashBoradManager.getInstance().getDao().getObject().getSummaryUseProductList().get(i).getProduct().getProductNameEn();
        } catch (NullPointerException e) {
            return "";
        }
        return name;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void setViewDrink() {


        nameProduct = new ArrayList<>(size);
        totalAllProduct = new ArrayList<>(size);
        entertainProduct = new ArrayList<>(size);
        purchaseProduct = new ArrayList<>(size);
        withdrawProduct = new ArrayList<>(size);

        String[] Sortname = new String[size];
        Long[] Sorttotal = new Long[size];
        Long[] Sortentertain = new Long[size];
        Long[] Sortpurchase = new Long[size];
        Long[] Sortwithdraw = new Long[size];


        for (int i = 0; i < size; i++) {
            String name = getnameProduct(i);
            Long total = gettotalProduct(i);
            Long entertain = getEntertain(i);
            Long purchase = getPurchase(i);
            Long withdraw = getWithdraw(i);

            nameProduct.add(name);
            totalAllProduct.add(total);
            entertainProduct.add(entertain);
            purchaseProduct.add(purchase);
            withdrawProduct.add(withdraw);
        }

        Sortname = nameProduct.toArray(new String[0]);
        Sorttotal = totalAllProduct.toArray(new Long[0]);
        Sortentertain = entertainProduct.toArray(new Long[0]);
        Sortpurchase = purchaseProduct.toArray(new Long[0]);
        Sortwithdraw = withdrawProduct.toArray(new Long[0]);

        Long tt,ent,pur,with;
        String np;
        for(int i=0;i<size;i++){
            for (int j=0;j<size-i-1;j++){
                if(Sorttotal[j+1]>Sorttotal[j]){
                    tt = Sorttotal[j];
                    np = Sortname[j];
                    ent = Sortentertain[j];
                    pur = Sortpurchase[j];
                    with = Sortwithdraw[j];

                    Sorttotal[j] = Sorttotal[j+1];
                    Sortname[j] = Sortname[j+1];
                    Sortentertain[j] = Sortentertain[j+1];
                    Sortpurchase[j] = Sortpurchase[j+1];
                    Sortwithdraw[j] = Sortwithdraw[j+1];

                    Sorttotal[j+1] = tt;
                    Sortname[j+1] = np;
                    Sortentertain[j+1] = ent;
                    Sortpurchase[j+1] = pur;
                    Sortwithdraw[j+1] = with;
                }
            }
        }

        ProductSortDao productSortDao = new ProductSortDao();
        productSortDao.setNameProductSort(Sortname);
        productSortDao.setTotalAllProductSort(Sorttotal);
        productSortDao.setEntertainProductSort(Sortentertain);
        productSortDao.setPurchaseProductSort(Sortpurchase);
        productSortDao.setWithdrawProductSort(Sortwithdraw);

        ProductManager.getInstance().setProductSortDao(productSortDao);

        productlistAdapter  = new ProductListAdapter();
        listProduct.setAdapter(productlistAdapter);

//        for(int i=0;i<size;i++){
//            System.out.println(Sortname[i]);
//        }



        Long sumtotal = 0L, sumentertain = 0L, sumpurchase = 0L, sumwithdraw = 0L;
        for (int i = 0; i < size; i++) {
            sumtotal = sumtotal + totalAllProduct.get(i);
            sumentertain = sumentertain + entertainProduct.get(i);
            sumpurchase = sumpurchase + purchaseProduct.get(i);
            sumwithdraw = sumwithdraw + withdrawProduct.get(i);
        }

        tvtotalpd.setText(sumtotal.toString());
        if (sumtotal > 0) {
            tvtotalpd.setTextColor(Color.parseColor("#62BB47"));
        }
        tventertainpd.setText(sumentertain.toString());
        if (sumentertain > 0) {
            tventertainpd.setTextColor(Color.parseColor("#19237E"));
        }
        tvpurchasepd.setText(sumpurchase.toString());
        if (sumpurchase > 0) {
            tvpurchasepd.setTextColor(Color.parseColor("#19237E"));
        }
        tvwithdrawpd.setText(sumwithdraw.toString());
        if (sumwithdraw > 0) {
            tvwithdrawpd.setTextColor(Color.parseColor("#19237E"));
        }

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

    @Override
    public void onResume() {
        super.onResume();
        date = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getKeyDateFull();

        reqAPI(SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate());
        activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setTitle("ปริมาณเครื่องดื่ม");
        activity.getSupportActionBar().setSubtitle(date);
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        toolbar.setSubtitleTextColor(Color.parseColor("#FFFFFF"));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }

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
                   // productlistAdapter.notifyDataSetChanged();

                    try {
                        Odao = DashBoradManager.getInstance().getDao().getObject();
                    }catch (Exception e){
                        Toast.makeText(Contextor.getInstance().getContext(),"ไม่มีข้อมูลที่จะแสดงผล",Toast.LENGTH_SHORT).show();
                    }

                    try {
                        size = Odao.getSummaryUseProductList().size();
                    }catch (Exception e){
                        Toast.makeText(Contextor.getInstance().getContext(),"ไม่มีข้อมูลที่จะแสดงผล",Toast.LENGTH_SHORT).show();
                    }

                    try {
                        setViewDrink();
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

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }


    @Override
    public void onClick(View v) {

        if(v == btncalendardrink){
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
                    String fulldate;
                    datecalendat = year+ "/" + mm + "/" +dd;
                    fulldate = dd+ "/" + mm + "/" +year;

                    SharedPrefDateManager.getInstance(Contextor.getInstance().getContext())
                            .saveDatereq(datecalendat);

                    SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).saveDateFull(fulldate);

                    SharedPrefDateManager.getInstance(Contextor.getInstance().getContext())
                            .saveDateCalendar(dayOfMonth,month,year);

                    date = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getKeyDateFull();
                    reqAPI(SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate());
                    activity.getSupportActionBar().setSubtitle(date);

                   // getActivity().recreate();

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
