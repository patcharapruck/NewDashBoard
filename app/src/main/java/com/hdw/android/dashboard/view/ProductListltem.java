package com.hdw.android.dashboard.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.hdw.android.dashboard.R;
import com.inthecheesefactory.thecheeselibrary.view.BaseCustomViewGroup;
import com.inthecheesefactory.thecheeselibrary.view.state.BundleSavedState;

public class ProductListltem extends BaseCustomViewGroup {

    TextView tvnameProduct,tvtotalproduct,tvwithdrawProduct,tvpurchaseProduct,tventertainProduct;
    TextView tvwithdrawpercent,tvpurchasepercent,tventertainpercent;

    public ProductListltem(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public ProductListltem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public ProductListltem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public ProductListltem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.customview_product, this);
    }

    private void initInstances() {
        tvnameProduct = (TextView)findViewById(R.id.tvnameProduct);
        tvtotalproduct = (TextView)findViewById(R.id.tvtotalproduct);
        tvwithdrawProduct = (TextView)findViewById(R.id.tvwithdrawProduct);
        tvpurchaseProduct  = (TextView)findViewById(R.id.tvpurchaseProduct);
        tventertainProduct = (TextView)findViewById(R.id.tventertainProduct);

        tvwithdrawpercent = (TextView)findViewById(R.id.tvwithdrawpercent);
        tvpurchasepercent = (TextView)findViewById(R.id.tvpurchasepercent);
        tventertainpercent = (TextView)findViewById(R.id.tventertainpercent);
    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {

    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        BundleSavedState savedState = new BundleSavedState(superState);


        return savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        Bundle bundle = ss.getBundle();

    }

    public void setNameProduct(String nameProduct){
        tvnameProduct.setText(nameProduct);
    }

    public void setTotalProduct(Long totalProduct){
        tvtotalproduct.setText(totalProduct.toString());
    }

    public void setWithdrawProduct(Long withdrawProduct){
        tvwithdrawProduct.setText(withdrawProduct.toString());
    }

    public void setPurchaseProduct(Long purchaseProduct){
        tvpurchaseProduct.setText(purchaseProduct.toString());
    }

    public void setEntertainProduct(Long entertainProduct){
        tventertainProduct.setText(entertainProduct.toString());
    }

    public void setWithdrawPercent(Double withdrawPercent){
        tvwithdrawpercent.setText(withdrawPercent+"%");
    }

    public void setPurchasePercent(Double purchasePercent){
        tvpurchasepercent.setText(purchasePercent+"%");
    }

    public void setEntertainPercent(Double entertainPercent){
        tventertainpercent.setText(entertainPercent+"%");
    }

}
