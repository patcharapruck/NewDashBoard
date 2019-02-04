package com.example.pchrp.newdashboard.fragment;


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
import android.widget.TextView;
import android.widget.Toast;

import com.example.pchrp.newdashboard.Dao.DashBoardDao;
import com.example.pchrp.newdashboard.Dao.objectdao.ObjectItemDao;
import com.example.pchrp.newdashboard.R;
import com.example.pchrp.newdashboard.activity.DrinkActivity;
import com.example.pchrp.newdashboard.activity.MainActivity;
import com.example.pchrp.newdashboard.activity.RealIncomeActivity;
import com.example.pchrp.newdashboard.manager.Contextor;
import com.example.pchrp.newdashboard.manager.DashBoradManager;
import com.example.pchrp.newdashboard.manager.http.HttpManager;
import com.example.pchrp.newdashboard.util.SharedPrefDateManager;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDrink extends Fragment implements View.OnClickListener {

    TextView tvtotalpd, tventertainpd, tvpurchasepd, tvwithdrawpd;
    Button btndrink;
    Toolbar toolbar;
    ArrayList<String> nameProduct;
    ArrayList<Long> totalAllProduct;
    ArrayList<Long> entertainProduct;
    ArrayList<Long> purchaseProduct;
    ArrayList<Long> withdrawProduct;
    ObjectItemDao Odao;
    int size;
    String date;

    AppCompatActivity activity;

    Button btncalendardrink;

    HorizontalBarChart barChart;

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
        btndrink = (Button) rootView.findViewById(R.id.btndrink);

        btndrink.setOnClickListener(this);
        barChart = rootView.findViewById(R.id.Hbarchart);
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
            tventertainpd.setTextColor(Color.parseColor("#62BB47"));
        }
        tvpurchasepd.setText(sumpurchase.toString());
        if (sumpurchase > 0) {
            tvpurchasepd.setTextColor(Color.parseColor("#62BB47"));
        }
        tvwithdrawpd.setText(sumwithdraw.toString());
        if (sumwithdraw > 0) {
            tvwithdrawpd.setTextColor(Color.parseColor("#62BB47"));
        }

        BarDataSet Set1 = new BarDataSet(withdrawUse(), "เบิกใช้");
        Set1.setColors(Color.parseColor("#0097A7"));
        BarDataSet Set2 = new BarDataSet(purchaseAmount(), "ซื้อ");
        Set2.setColors(Color.parseColor("#0277BD"));
        BarDataSet Set3 = new BarDataSet(entertainAmount(), "Entertrain");
        Set3.setColors(Color.parseColor("#00695C"));
        Set1.setDrawValues(true);
        Set2.setDrawValues(true);
        Set3.setDrawValues(true);

        BarData data = new BarData(Set1, Set2, Set3);
        barChart.setData(data);
        data.setValueTextSize(15f);


        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(nameProduct));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);
        xAxis.setTextSize(10f);
        xAxis.setLabelRotationAngle(90);

        barChart.setDragEnabled(true);
        barChart.setVisibleXRangeMaximum(2);

        //set Label Center
        float groupSpace = 0.5f;
        float barSpace = 0f;
        float barWidth = 0.20f;
        data.setBarWidth(barWidth);
        //(barwidth + barspace) * no of bars + groupspace = 1

        barChart.getAxisLeft().setAxisMinimum(0);
        barChart.groupBars(0, groupSpace, barSpace);
        barChart.setDrawValueAboveBar(true);
        // Hide grid lines
        barChart.getAxisLeft().setEnabled(false);
        barChart.getAxisRight().setEnabled(false);
        // Hide graph description
        barChart.getDescription().setEnabled(false);
        // Hide graph legend
        barChart.getLegend().setEnabled(false);
        barChart.invalidate();

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
        date = SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate();
        Odao = DashBoradManager.getInstance().getDao().getObject();
        this.size = Odao.getSummaryUseProductList().size();
        setViewDrink();
        reqAPI(SharedPrefDateManager.getInstance(Contextor.getInstance().getContext()).getreqDate());
        activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setTitle("ปริมาณเครื่องดื่ม");
        activity.getSupportActionBar().setSubtitle(date);
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

    //เบิกใช้
    private ArrayList<BarEntry> withdrawUse() {
        ArrayList<BarEntry> barBnk1 = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            barBnk1.add(new BarEntry(i, withdrawProduct.get(i)));
        }
        return barBnk1;
    }

    //ซื้อ
    private ArrayList<BarEntry> purchaseAmount() {
        ArrayList<BarEntry> barBnk2 = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            barBnk2.add(new BarEntry(i, purchaseProduct.get(i)));
        }
        return barBnk2;
    }

    //Entertain
    private ArrayList<BarEntry> entertainAmount() {
        ArrayList<BarEntry> barBnk2 = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            barBnk2.add(new BarEntry(i, entertainProduct.get(i)));
        }
        return barBnk2;
    }

    @Override
    public void onClick(View v) {
        if (v == btndrink) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_drink, FragmentDrinkReport.newInstance())
                    .addToBackStack(null)
                    .commit();
        }

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
                    datecalendat = year+ "/" + mm + "/" +dd;

                    SharedPrefDateManager.getInstance(Contextor.getInstance().getContext())
                            .saveDatereq(datecalendat);

                    SharedPrefDateManager.getInstance(Contextor.getInstance().getContext())
                            .saveDateCalendar(dayOfMonth,month,year);



                    getActivity().recreate();

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
}
