package com.example.pchrp.newdashboard.Dao.objectdao;

public class ObjectListItemDao {

    private Float cashPayments;
    private Float creditPayments;
    private Float creditCardPayments;
    private Float totalIncome;

    public Float getCashPayments() {
        return cashPayments;
    }

    public void setCashPayments(Float cashPayments) {
        this.cashPayments = cashPayments;
    }

    public Float getCreditPayments() {
        return creditPayments;
    }

    public void setCreditPayments(Float creditPayments) {
        this.creditPayments = creditPayments;
    }

    public Float getCreditCardPayments() {
        return creditCardPayments;
    }

    public void setCreditCardPayments(Float creditCardPayments) {
        this.creditCardPayments = creditCardPayments;
    }

    public Float getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Float totalIncome) {
        this.totalIncome = totalIncome;
    }
}
