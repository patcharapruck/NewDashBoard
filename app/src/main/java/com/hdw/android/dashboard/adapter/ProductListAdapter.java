package com.hdw.android.dashboard.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.hdw.android.dashboard.Dao.product.DrinkProductItemCollectionDao;
import com.hdw.android.dashboard.Dao.product.ProductSortDao;
import com.hdw.android.dashboard.manager.Contextor;
import com.hdw.android.dashboard.manager.DashBoradManager;
import com.hdw.android.dashboard.manager.ProductManager;
import com.hdw.android.dashboard.view.ProductListltem;

public class ProductListAdapter extends BaseAdapter {
    @Override
    public int getCount() {
//        if(DashBoradManager.getInstance().getDao() == null)
//            return 0;
//        if (DashBoradManager.getInstance().getDao().getObject() == null)
//            return 0;
//        if (DashBoradManager.getInstance().getDao().getObject().getSummaryUseProductList() == null)
//            return 0;
//        return DashBoradManager.getInstance().getDao().getObject().getSummaryUseProductList().size();

        return ProductManager.getInstance().getProductSortDao().getTotalAllProductSort().length;
    }

    @Override
    public Object getItem(int position) {
//        return DashBoradManager.getInstance().getDao().getObject().getSummaryUseProductList().get(position);

        return null;
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


        ProductSortDao dao = ProductManager.getInstance().getProductSortDao();
//        DrinkProductItemCollectionDao dao = (DrinkProductItemCollectionDao) getItem(position);

//        try {
//            item.setNameProduct(position+1,dao.getProduct().getProductNameTh());
//        }catch (NullPointerException e){
//            item.setNameProduct(0,"null");
//        }
//        try {
//            item.setWithdrawProduct(dao.getWithdrawUse());
//        }catch (NullPointerException e){
//            item.setWithdrawProduct(0L);
//        }
//        try {
//            item.setPurchaseProduct(dao.getPurchaseAmount());
//        }catch (NullPointerException e){
//            item.setPurchaseProduct(0L);
//        }
//        try {
//            item.setEntertainProduct(dao.getEntertainAmount());
//        }catch (NullPointerException e){
//            item.setEntertainProduct(0L);
//        }
//        try {
//            item.setTotalProduct(dao.getTotalAll());
//        }catch (NullPointerException e){
//            item.setTotalProduct(0L);
//        }

        try {
            item.setNameProduct(position+1,dao.getNameProductSort()[position]);
        }catch (NullPointerException e){
            item.setNameProduct(0,"null");
        }
        try {
            item.setWithdrawProduct(dao.getWithdrawProductSort()[position]);
        }catch (NullPointerException e){
            item.setWithdrawProduct(0L);
        }
        try {
            item.setPurchaseProduct(dao.getPurchaseProductSort()[position]);
        }catch (NullPointerException e){
            item.setPurchaseProduct(0L);
        }
        try {
            item.setEntertainProduct(dao.getEntertainProductSort()[position]);
        }catch (NullPointerException e){
            item.setEntertainProduct(0L);
        }
        try {
            item.setTotalProduct(dao.getTotalAllProductSort()[position]);
        }catch (NullPointerException e){
            item.setTotalProduct(0L);
        }



        return item;
    }
}
