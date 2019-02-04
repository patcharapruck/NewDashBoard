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

import java.text.DecimalFormat;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class PaymentListItem extends BaseCustomViewGroup {

    TextView tvPpyId,tvPpyBill,tvPpyRoom,tvPpySale,tvPpyMonny;
    String tPpyMonny;

    public PaymentListItem(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public PaymentListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public PaymentListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public PaymentListItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {

        inflate(getContext(), R.layout.customview_payment, this);

    }

    private void initInstances() {
        tvPpyId = (TextView)findViewById(R.id.tvPpyId);
        tvPpyBill = (TextView)findViewById(R.id.tvPpyBill);
        tvPpyRoom = (TextView)findViewById(R.id.tvPpyRoom);
        tvPpySale = (TextView)findViewById(R.id.tvPpySale);
        tvPpyMonny = (TextView)findViewById(R.id.tvPpyMonny);




    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        /*
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.StyleableName,
                defStyleAttr, defStyleRes);

        try {

        } finally {
            a.recycle();
        }
        */
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        BundleSavedState savedState = new BundleSavedState(superState);
        // Save Instance State(s) here to the 'savedState.getBundle()'
        // for example,
        // savedState.getBundle().putString("key", value);

        return savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        Bundle bundle = ss.getBundle();
        // Restore State from bundle here
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setPayId(String payId){
        tvPpyId.setText(payId);
    }

    public void setPayBill(String payBill){
        tvPpyBill.setText(payBill);
    }

    public void setPayRoom(String payRoom){
        tvPpyRoom.setText(payRoom);
    }

    public void setPaySale(String paySaleId , String paySaleName){
        tvPpySale.setText(paySaleId+":"+paySaleName);
    }

    public void setPayMoney(Double payMoney){
        DecimalFormat formatter = new DecimalFormat("#,###,###.00");
        tPpyMonny = formatter.format(payMoney);
        tvPpyMonny.setText(tPpyMonny);
    }
}
