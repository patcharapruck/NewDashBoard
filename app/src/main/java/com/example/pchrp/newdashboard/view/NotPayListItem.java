package com.example.pchrp.newdashboard.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.pchrp.newdashboard.R;
import com.inthecheesefactory.thecheeselibrary.view.BaseCustomViewGroup;
import com.inthecheesefactory.thecheeselibrary.view.state.BundleSavedState;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class NotPayListItem extends BaseCustomViewGroup {

    TextView tvNpyId,tvNpyBill,tvNpyRoom,tvNpySale,tvNpyMonny;

    public NotPayListItem(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public NotPayListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public NotPayListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public NotPayListItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.customview_notpay, this);
    }

    private void initInstances() {
        tvNpyId = (TextView)findViewById(R.id.tvPpyId);
        tvNpyBill = (TextView)findViewById(R.id.tvPpyBill);
        tvNpyRoom = (TextView)findViewById(R.id.tvPpyRoom);
        tvNpySale = (TextView)findViewById(R.id.tvPpySale);
        tvNpyMonny = (TextView)findViewById(R.id.tvPpyMonny);


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

    public void setNotPayId(String NotpayId){
        tvNpyId.setText(NotpayId);
    }

    public void setNotPayBill(String NotpayBill){
        tvNpyBill.setText(NotpayBill);
    }

    public void setNotPayRoom(String NotpayRoom){
        tvNpyRoom.setText(NotpayRoom);
    }

    public void setNotPaySale(String NotpaySaleId , String NotpaySaleName){
        tvNpySale.setText(NotpaySaleId+":"+NotpaySaleName);
    }

    public void setNotPayMoney(Double NotpayMoney){
        tvNpyMonny.setText(NotpayMoney.toString());
    }

}
