package com.hdw.android.dashboard.Dao.bankdao;

public class BankItemColleationDao{

        private BankItemDao bank ;
        private Double visa;
        private Double master;
        private Double jcb;
        private Double amax;
        private Double unipay;

//    public String getBank() {
//        return bank;
//    }
//
//    public void setBank(String bank) {
//        this.bank = bank;
//    }


    public BankItemDao getBank() {
        return bank;
    }

    public void setBank(BankItemDao bank) {
        this.bank = bank;
    }

    public Double getVisa() {
            return visa;
        }

        public void setVisa(Double visa) {
            this.visa = visa;
        }

        public Double getMaster() {
            return master;
        }

        public void setMaster(Double master) {
            this.master = master;
        }

        public Double getJcb() {
            return jcb;
        }

        public void setJcb(Double jcb) {
            this.jcb = jcb;
        }

        public Double getAmax() {
            return amax;
        }

        public void setAmax(Double amax) {
            this.amax = amax;
        }

        public Double getUnipay() {
            return unipay;
        }

        public void setUnipay(Double unipay) {
            this.unipay = unipay;
        }
    }

