package com.example.pchrp.newdashboard.Dao.payment;

public class PayItemDao {

    private String invoiceCode;
    private String customerName;
    private PayplaceItemDao place;
    private Double totalPrice;
    private PaysalesItemDao sales;

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

    public PayplaceItemDao getPlace() {
        return place;
    }

    public void setPlace(PayplaceItemDao place) {
        this.place = place;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PaysalesItemDao getSales() {
        return sales;
    }

    public void setSales(PaysalesItemDao sales) {
        this.sales = sales;
    }
}
