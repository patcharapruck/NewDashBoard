package com.example.pchrp.newdashboard.Dao.bankdao;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleToLongFunction;

public class BankItemDao{

        private Object recorde;
        private Timestamp createDate;
        private Object editor;
        private Timestamp lastUpdate;
        private Long id;
        private String bankName;
        private String image;
        private boolean active;
        private boolean deleted;


        public BankItemDao(Object valuebank){
            HashMap newMap = new HashMap((Map) valuebank);
            this.recorde = (Object) newMap.get("recorde");
           // this.createDate = (Timestamp) newMap.get("createDate");
            this.editor = (Object) newMap.get("editor");
           // this.lastUpdate = (Timestamp) newMap.get("lastUpdate");
            Double idd = (Double) newMap.get("id");
            this.id = (new Double(idd)).longValue();
            this.bankName = (String) newMap.get("bankName");
            this.image = (String) newMap.get("image");
            this.active = (boolean) newMap.get("active");
            this.deleted = (boolean) newMap.get("deleted");
        }

    public Object getRecorde() {
        return recorde;
    }

    public void setRecorde(Object recorde) {
        this.recorde = recorde;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Object getEditor() {
        return editor;
    }

    public void setEditor(Object editor) {
        this.editor = editor;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}


