package com.hdw.android.dashboard.util;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;

public class MyFormatCredit implements IValueFormatter {

    private DecimalFormat mFormat;

    public  MyFormatCredit(){
        mFormat = new DecimalFormat("###,###,##0.00");
    }

    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
        return mFormat.format(value)+"%";
    }
}
