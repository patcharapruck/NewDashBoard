package com.hdw.android.dashboard.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hdw.android.dashboard.Dao.notpayment.NotPayItemDao;
import com.hdw.android.dashboard.manager.NotPayManager;
import com.hdw.android.dashboard.view.NotPayListItem;

public class NotPayAdapter extends BaseAdapter {
    @Override
    public int getCount() {

        if(NotPayManager.getInstance().getNotpayItemColleationDao() == null)
            return 0;
        if (NotPayManager.getInstance().getNotpayItemColleationDao().getObject() == null)
            return 0;
        return NotPayManager.getInstance().getNotpayItemColleationDao().getObject().size();
    }

    @Override
    public Object getItem(int position) {

        return NotPayManager.getInstance().getNotpayItemColleationDao().getObject().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NotPayListItem item;
        if(convertView != null){
            item = (NotPayListItem) convertView;
        }else{
            item = new NotPayListItem(parent.getContext());
        }

        NotPayItemDao dao1 = (NotPayItemDao) getItem(position);

        try {
            item.setNotPayId(dao1.getInvoiceCode());
        }catch (NullPointerException e){
            item.setNotPayId("null");
        }
        try {
            item.setNotPayBill(dao1.getCustomerName());
        }catch (NullPointerException e){
            item.setNotPayBill("null");
        }
        try {
            item.setNotPayRoom(dao1.getPlace().getPlaceCode());
        }catch (NullPointerException e){
            item.setNotPayRoom("null");
        }
        try {
            item.setNotPaySale(dao1.getSales().getEmployeeCode(),dao1.getSales().getNickName());
        }catch (NullPointerException e){
            item.setNotPaySale("00","null");
        }
        try {
            item.setNotPayMoney(dao1.getTotalPrice());
        }catch (NullPointerException e){
            item.setNotPayMoney(0d);
        }

        return item;
    }
}
