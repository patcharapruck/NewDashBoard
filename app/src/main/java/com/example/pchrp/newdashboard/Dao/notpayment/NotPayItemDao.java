package com.example.pchrp.newdashboard.Dao.notpayment;

import com.example.pchrp.newdashboard.Dao.payment.PayplaceItemDao;
import com.example.pchrp.newdashboard.Dao.payment.PaysalesItemDao;

public class NotPayItemDao {

    private String invoiceCode;
    private String customerName;
    private NotPayplaceItemDao place;
    private Double totalPrice;
    private NotPaysalesItemDao sales;

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getCustomerNam() {
        return customerName;
    }

    public void setCustomerNam(String customerNam) {
        this.customerName = customerNam;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public NotPayplaceItemDao getPlace() {
        return place;
    }

    public void setPlace(NotPayplaceItemDao place) {
        this.place = place;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public NotPaysalesItemDao getSales() {
        return sales;
    }

    public void setSales(NotPaysalesItemDao sales) {
        this.sales = sales;
    }
}
