package com.hdw.android.dashboard.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hdw.android.dashboard.Dao.payment.PayItemDao;
import com.hdw.android.dashboard.manager.PayManager;
import com.hdw.android.dashboard.view.PaymentListItem;

public class PayMentAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        if(PayManager.getInstance().getPayItemColleationDao() == null)
            return 0;
        if (PayManager.getInstance().getPayItemColleationDao().getObject() == null)
            return 0;
        return PayManager.getInstance().getPayItemColleationDao().getObject().size();
    }

    @Override
    public Object getItem(int position) {
        return PayManager.getInstance().getPayItemColleationDao().getObject().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PaymentListItem item;
        if(convertView != null){
            item = (PaymentListItem) convertView;
        }else{
            item = new PaymentListItem(parent.getContext());
        }

        PayItemDao dao = (PayItemDao) getItem(position);

        try {
            item.setPayId(dao.getInvoiceCode());
        }catch (NullPointerException e){
            item.setPayId("null");
        }
        try {
            item.setPayBill(dao.getCustomerNam());
        }catch (NullPointerException e){
            item.setPayBill("null");
        }
        try {
            item.setPayRoom(dao.getPlace().getPlaceType());
        }catch (NullPointerException e){
            item.setPayRoom("null");
        }
        try {
            item.setPaySale(dao.getSales().getEmployeeCode(),dao.getSales().getNickName());
        }catch (NullPointerException e){
            item.setPaySale("00","null");
        }
        try {
            item.setPayMoney(dao.getTotalPrice());
        }catch (NullPointerException e){
            item.setPayMoney(0d);
        }

        return item;
    }
}
