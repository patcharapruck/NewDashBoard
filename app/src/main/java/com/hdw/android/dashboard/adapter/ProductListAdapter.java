package com.hdw.android.dashboard.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hdw.android.dashboard.Dao.product.DrinkProductItemCollectionDao;
import com.hdw.android.dashboard.manager.Contextor;
import com.hdw.android.dashboard.manager.DashBoradManager;
import com.hdw.android.dashboard.view.ProductListltem;

public class ProductListAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        if(DashBoradManager.getInstance().getDao() == null)
            return 0;
        if (DashBoradManager.getInstance().getDao().getObject() == null)
            return 0;
        if (DashBoradManager.getInstance().getDao().getObject().getSummaryUseProductList() == null)
            return 0;
        return DashBoradManager.getInstance().getDao().getObject().getSummaryUseProductList().size();
    }

    @Override
    public Object getItem(int position) {
        return DashBoradManager.getInstance().getDao().getObject().getSummaryUseProductList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProductListltem item;
        if(convertView != null){
            item = (ProductListltem) convertView;
        }else{
            item = new ProductListltem(parent.getContext());
        }

        DrinkProductItemCollectionDao dao = (DrinkProductItemCollectionDao) getItem(position);

        try {
            item.setNameProduct(dao.getProduct().getProductNameTh());
        }catch (NullPointerException e){
            item.setNameProduct("null");
        }
        try {
            item.setWithdrawProduct(dao.getWithdrawUse());
        }catch (NullPointerException e){
            item.setWithdrawProduct(0L);
        }
        try {
            item.setPurchaseProduct(dao.getPurchaseAmount());
        }catch (NullPointerException e){
            item.setPurchaseProduct(0L);
        }
        try {
            item.setEntertainProduct(dao.getEntertainAmount());
        }catch (NullPointerException e){
            item.setEntertainProduct(0L);
        }
        try {
            item.setTotalProduct(dao.getTotalAll());
        }catch (NullPointerException e){
            item.setTotalProduct(0L);
        }
//
//        try {
//            Double WithdrawPercent = (dao.getTotalAll()/dao.getWithdrawUse())*100.00;
//            item.setWithdrawPercent(WithdrawPercent);
//        }catch (Exception e){
//            item.setWithdrawPercent(0D);
//        }
//        try {
//            Double PurchasePercent = (dao.getTotalAll()/dao.getPurchaseAmount())*100.00;
//            item.setPurchasePercent(PurchasePercent);
//        }catch (Exception e){
//            item.setPurchasePercent(0D);
//        }
//        try {
//            Double EntertainPercent = (dao.getTotalAll()/dao.getEntertainAmount())*100.00;
//            item.setEntertainPercent(EntertainPercent);
//        }catch (Exception e){
//            item.setEntertainPercent(0D);
//        }

        return item;
    }
}
