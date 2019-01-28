package com.example.pchrp.newdashboard.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pchrp.newdashboard.Dao.DashBoardDao;
import com.example.pchrp.newdashboard.Dao.objectdao.ObjectItemDao;
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

    Double serivceDrinkCharge,memberCharge,foodPrice,productPrice,serviceCharge,incomebill;
    Long pax,serviceDringQty,memberaccount;

    ObjectItemDao ODao;

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
        this.ODao = DashBoradManager.getInstance().getDao().getObject();

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

        setTextView(ODao);
    }

    private void setTextView(ObjectItemDao ODao) {

        tvincomebill.setText(ODao.getIncome().toString());
        tvmemberCharge.setText(ODao.getMemberCharge().toString());
        tvfoodPrice.setText(ODao.getFoodPrice().toString());
        tvserviceDringQty.setText(ODao.getServiceDringQty().toString());
        tvserviceCharge.setText(ODao.getServiceCharge().toString());
        tvserivceDrinkCharge.setText(ODao.getSerivceDrinkCharge().toString());
        tvproductPrice.setText(ODao.getProductPrice().toString());
        tvpax.setText(ODao.getPax().toString());
        tvopenMemberAccount.setText(ODao.getOpenMemberAccount().toString());
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
                .addData(new SimplePieInfo(foodPrice+productPrice+serviceCharge, Color.parseColor("#FFF78C"), "ค่าบริการ")).drawText(true).duration(2000).textSize(20);
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