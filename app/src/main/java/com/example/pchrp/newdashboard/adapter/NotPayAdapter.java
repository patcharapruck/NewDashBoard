package com.example.pchrp.newdashboard.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.pchrp.newdashboard.Dao.notpayment.NotPayItemDao;
import com.example.pchrp.newdashboard.manager.http.NotPayManager;
import com.example.pchrp.newdashboard.view.NotPayListItem;

public class NotPayAdapter extends BaseAdapter {
    @Override
    public int getCount() {

        if(NotPayManager.getInstance().getNotPayItemColleationDao() == null)
            return 0;
        if (NotPayManager.getInstance().getNotPayItemColleationDao().getObject() == null)
            return 0;
        return NotPayManager.getInstance().getNotPayItemColleationDao().getObject().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
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

        NotPayItemDao dao = (NotPayItemDao) getItem(position);
        item.setNotPayId(dao.getInvoiceCode());
        item.setNotPayBill(dao.getCustomerNam());
        item.setNotPayRoom(dao.getPlace().getPlaceType());
        item.setNotPaySale(dao.getSales().getEmployeeCode(),dao.getSales().getNickName());
        item.setNotPayMoney(dao.getTotalPrice());
        return item;
    }
}
