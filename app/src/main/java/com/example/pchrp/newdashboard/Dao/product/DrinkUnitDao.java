package com.example.pchrp.newdashboard.Dao.product;

public class DrinkUnitDao {

    private String recorder;
    private String createDate;
    private String editor;
    private String lastUpdate;
    private int id;
    private String unitNameTh;
    private String unitNameEn;
    private String description;
    private boolean active;
    private boolean deleted;

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnitNameTh() {
        return unitNameTh;
    }

    public void setUnitNameTh(String unitNameTh) {
        this.unitNameTh = unitNameTh;
    }

    public String getUnitNameEn() {
        return unitNameEn;
    }

    public void setUnitNameEn(String unitNameEn) {
        this.unitNameEn = unitNameEn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
