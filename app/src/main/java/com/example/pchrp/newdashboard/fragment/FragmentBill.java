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

import java.text.DecimalFormat;

public class FragmentBill extends Fragment {

    AnimatedPieView mAnimatedPieView;
    AnimatedPieViewConfig config;

    String tincomebill, tserivceDrinkCharge, tmemberCharge, tserviceCharge,
            tproductPrice, tfoodPrice, topenMemberAccount, tserviceDringQty, tpax;

    TextView tvincomebill, tvserivceDrinkCharge, tvmemberCharge, tvserviceCharge,
            tvproductPrice, tvfoodPrice, tvopenMemberAccount, tvserviceDringQty, tvpax;

    Double serivceDrinkCharge, memberCharge, foodPrice, productPrice, serviceCharge, incomebill;

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
        tvincomebill = (TextView) rootView.findViewById(R.id.tvincomebill);
        tvmemberCharge = (TextView) rootView.findViewById(R.id.tvmemberCharge);
        tvfoodPrice = (TextView) rootView.findViewById(R.id.tvfoodPrice);
        tvserivceDrinkCharge = (TextView) rootView.findViewById(R.id.tvserivceDrinkCharge);
        tvserviceCharge = (TextView) rootView.findViewById(R.id.tvserviceCharge);
        tvserviceDringQty = (TextView) rootView.findViewById(R.id.tvserviceDringQty);
        tvproductPrice = (TextView) rootView.findViewById(R.id.tvproductPrice);
        tvpax = (TextView) rootView.findViewById(R.id.tvpax);
        tvopenMemberAccount = (TextView) rootView.findViewById(R.id.tvopenMemberAccount);

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
        tvserviceCharge.setText(tmemberCharge);
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
        ODao = DashBoradManager.getInstance().getDao().getObject();

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
        DrawPie();
        setTextView(ODao);
    }
}