package com.example.pchrp.newdashboard.Dao.bankdao;

import java.sql.Timestamp;
import java.util.List;

public class BankItemDao {

        private Object recorder;
        private Timestamp createDate;
        private Object editor;
        private Timestamp lastUpdate;
        private Long id;
        private String bankName;
        private String image = null;
        private boolean active;
        private boolean deleted;

    public Object getRecorder() {
        return recorder;
    }

    public void setRecorder(Object recorder) {
        this.recorder = recorder;
    }

    public Object getEditor() {
        return editor;
    }

    public void setEditor(Object editor) {
        this.editor = editor;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
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


