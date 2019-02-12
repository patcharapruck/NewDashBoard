package com.hdw.android.dashboard.manager;

import android.content.Context;

import com.hdw.android.dashboard.Dao.product.ProductSortDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class ProductManager {

    private static ProductManager instance;

    private ProductSortDao productSortDao;

    public static ProductManager getInstance() {
        if (instance == null)
            instance = new ProductManager();
        return instance;
    }

    public ProductSortDao getProductSortDao() {
        return productSortDao;
    }

    public void setProductSortDao(ProductSortDao productSortDao) {
        this.productSortDao = productSortDao;
    }

    private Context mContext;

    private ProductManager() {
        mContext = Contextor.getInstance().getContext();
    }

}
