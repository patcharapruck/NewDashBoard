package com.example.pchrp.newdashboard.Dao.objectdao;

import com.example.pchrp.newdashboard.Dao.bankdao.BankItemColleationDao;
import com.example.pchrp.newdashboard.Dao.product.DrinkProductItemCollectionDao;

import java.util.ArrayList;
import java.util.List;

public class ObjectItemDao {

        private Long pax;
        private Double cashPayments;
        private Double creditPayments;
        private Double creditCardPayments;
        private Double memberDebitPayments;
        private Double entertainPayments;
        private Double income;
        private Double unpaid;
        private Double receipts;
        private Double revenue;
        private Double totalServiceCharge;
        private List<BankItemColleationDao> incomeByCreditCardList;
        private String invoice = null;
        private Long memberNew;
        private Long memberRenew;
        private List<DrinkProductItemCollectionDao> summaryUseProductList;
        private String summaryOrderFoodList = null;
        private String summaryServiceDrinkList = null;
        private Double serivceDrinkCharge;
        private Long serviceDringQty;
        private Double foodPrice;
        private Double serviceCharge;
        private Double productPrice;
        private Double memberCharge;
        private Long openMemberAccount;
        private Long openNewMemberAccount;
        private Long openRenewMemberAccount;


    public Long getPax() {
        return pax;
    }

    public void setPax(Long pax) {
        this.pax = pax;
    }

    public Double getCashPayments() {
        return cashPayments;
    }

    public void setCashPayments(Double cashPayments) {
        this.cashPayments = cashPayments;
    }

    public Double getCreditPayments() {
        return creditPayments;
    }

    public void setCreditPayments(Double creditPayments) {
        this.creditPayments = creditPayments;
    }

    public Double getCreditCardPayments() {
        return creditCardPayments;
    }

    public void setCreditCardPayments(Double creditCardPayments) {
        this.creditCardPayments = creditCardPayments;
    }

    public Double getMemberDebitPayments() {
        return memberDebitPayments;
    }

    public void setMemberDebitPayments(Double memberDebitPayments) {
        this.memberDebitPayments = memberDebitPayments;
    }

    public Double getEntertainPayments() {
        return entertainPayments;
    }

    public void setEntertainPayments(Double entertainPayments) {
        this.entertainPayments = entertainPayments;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getUnpaid() {
        return unpaid;
    }

    public void setUnpaid(Double unpaid) {
        this.unpaid = unpaid;
    }

    public Double getReceipts() {
        return receipts;
    }

    public void setReceipts(Double receipts) {
        this.receipts = receipts;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    public Double getTotalServiceCharge() {
        return totalServiceCharge;
    }

    public void setTotalServiceCharge(Double totalServiceCharge) {
        this.totalServiceCharge = totalServiceCharge;
    }

    public List<BankItemColleationDao> getIncomeByCreditCardList() {
        return incomeByCreditCardList;
    }

    public void setIncomeByCreditCardList(List<BankItemColleationDao> incomeByCreditCardList) {
        this.incomeByCreditCardList = incomeByCreditCardList;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public Long getMemberNew() {
        return memberNew;
    }

    public void setMemberNew(Long memberNew) {
        this.memberNew = memberNew;
    }

    public Long getMemberRenew() {
        return memberRenew;
    }

    public void setMemberRenew(Long memberRenew) {
        this.memberRenew = memberRenew;
    }

    public List<DrinkProductItemCollectionDao> getSummaryUseProductList() {
        return summaryUseProductList;
    }

    public void setSummaryUseProductList(List<DrinkProductItemCollectionDao> summaryUseProductList) {
        this.summaryUseProductList = summaryUseProductList;
    }

    public String getSummaryOrderFoodList() {
        return summaryOrderFoodList;
    }

    public void setSummaryOrderFoodList(String summaryOrderFoodList) {
        this.summaryOrderFoodList = summaryOrderFoodList;
    }

    public String getSummaryServiceDrinkList() {
        return summaryServiceDrinkList;
    }

    public void setSummaryServiceDrinkList(String summaryServiceDrinkList) {
        this.summaryServiceDrinkList = summaryServiceDrinkList;
    }

    public Double getSerivceDrinkCharge() {
        return serivceDrinkCharge;
    }

    public void setSerivceDrinkCharge(Double serivceDrinkCharge) {
        this.serivceDrinkCharge = serivceDrinkCharge;
    }

    public Long getServiceDringQty() {
        return serviceDringQty;
    }

    public void setServiceDringQty(Long serviceDringQty) {
        this.serviceDringQty = serviceDringQty;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getMemberCharge() {
        return memberCharge;
    }

    public void setMemberCharge(Double memberCharge) {
        this.memberCharge = memberCharge;
    }

    public Long getOpenMemberAccount() {
        return openMemberAccount;
    }

    public void setOpenMemberAccount(Long openMemberAccount) {
        this.openMemberAccount = openMemberAccount;
    }

    public Long getOpenNewMemberAccount() {
        return openNewMemberAccount;
    }

    public void setOpenNewMemberAccount(Long openNewMemberAccount) {
        this.openNewMemberAccount = openNewMemberAccount;
    }

    public Long getOpenRenewMemberAccount() {
        return openRenewMemberAccount;
    }

    public void setOpenRenewMemberAccount(Long openRenewMemberAccount) {
        this.openRenewMemberAccount = openRenewMemberAccount;
    }
}
