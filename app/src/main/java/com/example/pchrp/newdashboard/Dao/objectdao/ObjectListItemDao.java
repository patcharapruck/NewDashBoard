package com.example.pchrp.newdashboard.Dao.objectdao;

public class ObjectListItemDao {

    private Double cashPayments;
    private Double creditPayments;
    private Double creditCardPayments;
    private Double totalIncome;

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

    public Double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Double totalIncome) {
        this.totalIncome = totalIncome;
    }
}
