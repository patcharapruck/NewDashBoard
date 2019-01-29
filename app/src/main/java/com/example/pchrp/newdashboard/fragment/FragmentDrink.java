package com.example.pchrp.newdashboard.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pchrp.newdashboard.Dao.objectdao.ObjectItemDao;
import com.example.pchrp.newdashboard.R;
import com.example.pchrp.newdashboard.manager.DashBoradManager;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDrink extends Fragment implements View.OnClickListener {

    TextView tvtotalpd,tventertainpd,tvpurchasepd,tvwithdrawpd;
    Button btndrink;

    ArrayList<String> nameProduct;
    ArrayList<Long> totalAllProduct;
    ArrayList<Long> entertainProduct;
    ArrayList<Long> purchaseProduct;
    ArrayList<Long> withdrawProduct;
    ObjectItemDao Odao;
    int size;

    public FragmentDrink() {
        super();
    }

    public static FragmentDrink newInstance() {
        FragmentDrink fragment = new FragmentDrink();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    BarChart hbarChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_drink, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        Odao =  DashBoradManager.getInstance().getDao().getObject();
        this.size = Odao.getSummaryUseProductList().size();

        nameProduct = new ArrayList<>(size);
        totalAllProduct = new ArrayList<>(size);
        entertainProduct = new ArrayList<>(size);
        purchaseProduct = new ArrayList<>(size);
        withdrawProduct = new ArrayList<>(size);

        tvtotalpd = (TextView)rootView.findViewById(R.id.tvtotalpd);
        tventertainpd = (TextView)rootView.findViewById(R.id.tventertainpd);
        tvpurchasepd = (TextView)rootView.findViewById(R.id.tvpurchasepd);
        tvwithdrawpd = (TextView)rootView.findViewById(R.id.tvwithdrawpd);
        btndrink = (Button)rootView.findViewById(R.id.btndrink);

        btndrink.setOnClickListener(this);

        for(int i=0;i<size;i++){
            String name =  getnameProduct(i);
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

        Long sumtotal=0L,sumentertain=0L,sumpurchase=0L,sumwithdraw=0L;
        for (int i=0;i<size;i++){
            sumtotal = sumtotal + totalAllProduct.get(i);
            sumentertain = sumentertain + entertainProduct.get(i);
            sumpurchase = sumpurchase + purchaseProduct.get(i);
            sumwithdraw = sumwithdraw + withdrawProduct.get(i);
        }

        tvtotalpd.setText(sumtotal.toString());
        if (sumtotal > 0){
            tvtotalpd.setTextColor(Color.parseColor("#62BB47"));
        }
        tventertainpd.setText(sumentertain.toString());
        if (sumentertain > 0){
            tventertainpd.setTextColor(Color.parseColor("#62BB47"));
        }
        tvpurchasepd.setText(sumpurchase.toString());
        if (sumpurchase > 0){
            tvpurchasepd.setTextColor(Color.parseColor("#62BB47"));
        }
        tvwithdrawpd.setText(sumwithdraw.toString());
        if (sumwithdraw > 0){
            tvwithdrawpd.setTextColor(Color.parseColor("#62BB47"));
        }

        // Init 'View' instance(s) with rootView.findViewById here
        hbarChart = (BarChart) rootView.findViewById(R.id.Hbarchart);

        BarDataSet dataSet1 = new BarDataSet(withdrawUse(), "");
        dataSet1.setColors(Color.parseColor("#0097A7"));
        BarDataSet dataSet2 = new BarDataSet(purchaseAmount(), "");
        dataSet2.setColors(Color.parseColor("#0277BD"));
        BarDataSet dataSet3 = new BarDataSet(entertainAmount(), "");
        dataSet3.setColors(Color.parseColor("#00695C"));

        BarData data = new BarData(dataSet1, dataSet2, dataSet3);
        hbarChart.setData(data);

        String[] creditName = new String[]{"J.W.BLACK", "J.W.BLACK",
                "J.W.BLACK", "J.W.BLACK", "J.W.BLACK"};

        YAxis rightYAxis = hbarChart.getAxisRight();
        rightYAxis.setEnabled(false);
        rightYAxis.setValueFormatter(new IndexAxisValueFormatter(creditName));
        rightYAxis.setCenterAxisLabels(true);
        rightYAxis.setGranularity(1);
        rightYAxis.setGranularityEnabled(true);


        hbarChart.setDragEnabled(true);
        hbarChart.setVisibleXRangeMaximum(3);

        float barSpace = 0.05f;
        float groupSpace = 0.66f;
        data.setBarWidth(0.12f);

        hbarChart.groupBars(0, groupSpace, barSpace);
        hbarChart.invalidate();


    }

    private Long getWithdraw(int i) {
        Long withdraw;
        try {
            withdraw  = DashBoradManager.getInstance().getDao().getObject().getSummaryUseProductList().get(i).getWithdrawUse();
        }catch (NullPointerException e){
            return 0L;
        }
        return withdraw;
    }

    private Long getPurchase(int i) {
        Long purchase;
        try {
            purchase  = DashBoradManager.getInstance().getDao().getObject().getSummaryUseProductList().get(i).getPurchaseAmount();
        }catch (NullPointerException e){
            return 0L;
        }
        return purchase;
    }

    private Long getEntertain(int i) {
        Long enter;
        try {
            enter  = DashBoradManager.getInstance().getDao().getObject().getSummaryUseProductList().get(i).getEntertainAmount();
        }catch (NullPointerException e){
            return 0L;
        }
        return enter;
    }

    private Long gettotalProduct(int i) {
        Long total;
        try {
            total  = DashBoradManager.getInstance().getDao().getObject().getSummaryUseProductList().get(i).getTotalAll();
        }catch (NullPointerException e){
            return 0L;
        }
        return total;
    }

    private String getnameProduct(int i) {
        String name;
        try {
           name  = DashBoradManager.getInstance().getDao().getObject().getSummaryUseProductList().get(i).getProduct().getProductNameEn();
        }catch (NullPointerException e){
            return "";
        }
        return name;
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

    //เบิกใช้
    private ArrayList<BarEntry> withdrawUse() {
        ArrayList<BarEntry> barBnk1 = new ArrayList<>();

        for(int i=0;i<size;i++){
            barBnk1.add(new BarEntry(i, withdrawProduct.get(i)));
        }
        return barBnk1;
    }

    //ซื้อ
    private ArrayList<BarEntry> purchaseAmount() {
        ArrayList<BarEntry> barBnk2 = new ArrayList<>();

        for(int i=0;i<size;i++){
            barBnk2.add(new BarEntry(i, purchaseProduct.get(i)));
        }
        return barBnk2;
    }

    //Entertain
    private ArrayList<BarEntry> entertainAmount() {
        ArrayList<BarEntry> barBnk2 = new ArrayList<>();

        for(int i=0;i<size;i++){
            barBnk2.add(new BarEntry(i, entertainProduct.get(i)));
        }
        return barBnk2;
    }

    @Override
    public void onClick(View v) {
        if(v == btndrink){
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_drink,FragmentDrinkReport.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

        }

        return super.onOptionsItemSelected(item);
    }
}
