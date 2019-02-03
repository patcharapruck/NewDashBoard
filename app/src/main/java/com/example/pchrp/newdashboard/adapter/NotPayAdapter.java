package com.example.pchrp.newdashboard.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.pchrp.newdashboard.Dao.notpayment.NotPayItemDao;
import com.example.pchrp.newdashboard.manager.NotPayManager;
import com.example.pchrp.newdashboard.view.NotPayListItem;

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
        item.setNotPayId(dao1.getInvoiceCode());
        item.setNotPayBill(dao1.getCustomerName());
        item.setNotPayRoom(dao1.getPlace().getPlaceType());
        item.setNotPaySale(dao1.getSales().getEmployeeCode(),dao1.getSales().getNickName());
        item.setNotPayMoney(dao1.getTotalPrice());
        return item;
    }
}
