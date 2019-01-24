package com.example.pchrp.newdashboard.Dao.bank;

import java.sql.Timestamp;
import java.util.List;

public class BankItemDao {

        private List<RecorderItemDao> recorderdata;
        private Timestamp createDate;
        private List<EditorItemBankDao> editordata;
        private Timestamp lastUpdate;
        private Long id;
        private String bankName;
        private String image = null;
        private boolean active;
        private boolean deleted;

    public List<RecorderItemDao> getRecorderdata() {
        return recorderdata;
    }

    public void setRecorderdata(List<RecorderItemDao> recorderdata) {
        this.recorderdata = recorderdata;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public List<EditorItemBankDao> getEditordata() {
        return editordata;
    }

    public void setEditordata(List<EditorItemBankDao> editordata) {
        this.editordata = editordata;
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


