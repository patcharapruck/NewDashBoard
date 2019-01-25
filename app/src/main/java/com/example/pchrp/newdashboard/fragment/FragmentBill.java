package com.example.pchrp.newdashboard.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pchrp.newdashboard.Dao.object.ObjectItemDao;
import com.example.pchrp.newdashboard.R;
import com.example.pchrp.newdashboard.manager.DashBoradManager;
import com.razerdp.widget.animatedpieview.AnimatedPieView;
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig;
import com.razerdp.widget.animatedpieview.data.SimplePieInfo;

public class FragmentBill extends Fragment {

    AnimatedPieView mAnimatedPieView;
    AnimatedPieViewConfig config;



    TextView tvincomebill,tvserivceDrinkCharge,tvmemberCharge,tvserviceCharge,tvproductPrice
            ,tvfoodPrice,tvopenMemberAccount,tvserviceDringQty,tvpax;

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


        mAnimatedPieView = rootView.findViewById(R.id.drew2);
        DrawPie();

        tvincomebill = (TextView)rootView.findViewById(R.id.tvincomebill);
        tvmemberCharge  = (TextView)rootView.findViewById(R.id.tvmemberCharge);
        tvfoodPrice = (TextView)rootView.findViewById(R.id.tvfoodPrice);
        tvserivceDrinkCharge = (TextView)rootView.findViewById(R.id.tvserivceDrinkCharge);
        tvserviceCharge = (TextView)rootView.findViewById(R.id.tvserviceCharge);
        tvserviceDringQty = (TextView)rootView.findViewById(R.id.tvserviceDringQty);
        tvproductPrice = (TextView)rootView.findViewById(R.id.tvproductPrice);
        tvpax = (TextView)rootView.findViewById(R.id.tvpax);
        tvopenMemberAccount = (TextView)rootView.findViewById(R.id.tvopenMemberAccount);

        tvincomebill.setText(DashBoradManager.getInstance().getDao().getIncome().toString());
        tvmemberCharge.setText(DashBoradManager.getInstance().getDao().getMemberCharge().toString());
        tvfoodPrice.setText(DashBoradManager.getInstance().getDao().getFoodPrice().toString());
        tvserviceDringQty.setText(DashBoradManager.getInstance().getDao().getServiceDringQty().toString());
        tvserviceCharge.setText(DashBoradManager.getInstance().getDao().getServiceCharge().toString());
        tvserivceDrinkCharge.setText(DashBoradManager.getInstance().getDao().getSerivceDrinkCharge().toString());
        tvproductPrice.setText(DashBoradManager.getInstance().getDao().getProductPrice().toString());
        tvpax.setText(DashBoradManager.getInstance().getDao().getPax().toString());
        tvopenMemberAccount.setText(DashBoradManager.getInstance().getDao().getOpenMemberAccount().toString());
    }

    private void DrawPie() {

        config = new AnimatedPieViewConfig();
        config.startAngle(-90)// Starting angle offset
                .addData(new SimplePieInfo(DashBoradManager.getInstance().getDao().getSerivceDrinkCharge(), Color.parseColor("#C0FF8C"), "ค่าดื่ม"))//Data (bean that implements the IPieInfo interface)
                .addData(new SimplePieInfo(DashBoradManager.getInstance().getDao().getMemberCharge(), Color.parseColor("#FF8C9D"), "ค่า Member"))
                .addData(new SimplePieInfo(90000.00f+12260.00f+51072.00f, Color.parseColor("#FFF78C"), "ค่าบริการ")).drawText(true).duration(2000).textSize(20);
        //.addData(new SimplePieInfo(12260.00f, Color.parseColor("#8BEAFE"), "ค่าสินค้า/เครื่องดื่ม"))
        //.addData(new SimplePieInfo(51072.00f, Color.parseColor("#FFD08C"), "ค่าอาหาร"))// draw pie animation duration

// The following two sentences can be replace directly 'mAnimatedPieView.start (config); '
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
}