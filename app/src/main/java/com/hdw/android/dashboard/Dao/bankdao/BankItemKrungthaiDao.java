package com.hdw.android.dashboard.Dao.bankdao;

import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class BankItemKrungthaiDao {

    @SerializedName("recorde") private Object recordeKrungthai;
    @SerializedName("createDate") private Timestamp createDateKrungthai;
    @SerializedName("editor") private Object editorKrungthai;
    @SerializedName("lastUpdate") private Timestamp lastUpdateKrungthai;
    @SerializedName("id") private Long idKrungthai;
    @SerializedName("bankName") private String bankNameKrungthai;
    @SerializedName("image") private String imageKrungthai;
    @SerializedName("active") private boolean activeKrungthai;
    @SerializedName("deleted") private boolean deletedKrungthai;


        public BankItemKrungthaiDao(Object valuebank){
            HashMap newMap = new HashMap((Map) valuebank);
            this.recordeKrungthai = (Object) newMap.get("recorde");
           // this.createDate = (Timestamp) newMap.get("createDate");
            this.editorKrungthai = (Object) newMap.get("editor");
           // this.lastUpdate = (Timestamp) newMap.get("lastUpdate");
            Double idd = (Double) newMap.get("id");
            this.idKrungthai = (new Double(idd)).longValue();
            this.bankNameKrungthai = (String) newMap.get("bankName");
            this.imageKrungthai = (String) newMap.get("image");
            this.activeKrungthai = (boolean) newMap.get("active");
            this.deletedKrungthai = (boolean) newMap.get("deleted");
        }

    public Object getRecordeKrungthai() {
        return recordeKrungthai;
    }

    public void setRecordeKrungthai(Object recordeKrungthai) {
        this.recordeKrungthai = recordeKrungthai;
    }

    public Timestamp getCreateDateKrungthai() {
        return createDateKrungthai;
    }

    public void setCreateDateKrungthai(Timestamp createDateKrungthai) {
        this.createDateKrungthai = createDateKrungthai;
    }

    public Object getEditorKrungthai() {
        return editorKrungthai;
    }

    public void setEditorKrungthai(Object editorKrungthai) {
        this.editorKrungthai = editorKrungthai;
    }

    public Timestamp getLastUpdateKrungthai() {
        return lastUpdateKrungthai;
    }

    public void setLastUpdateKrungthai(Timestamp lastUpdateKrungthai) {
        this.lastUpdateKrungthai = lastUpdateKrungthai;
    }

    public Long getIdKrungthai() {
        return idKrungthai;
    }

    public void setIdKrungthai(Long idKrungthai) {
        this.idKrungthai = idKrungthai;
    }

    public String getBankNameKrungthai() {
        return bankNameKrungthai;
    }

    public void setBankNameKrungthai(String bankNameKrungthai) {
        this.bankNameKrungthai = bankNameKrungthai;
    }

    public String getImageKrungthai() {
        return imageKrungthai;
    }

    public void setImageKrungthai(String imageKrungthai) {
        this.imageKrungthai = imageKrungthai;
    }

    public boolean isActiveKrungthai() {
        return activeKrungthai;
    }

    public void setActiveKrungthai(boolean activeKrungthai) {
        this.activeKrungthai = activeKrungthai;
    }

    public boolean isDeletedKrungthai() {
        return deletedKrungthai;
    }

    public void setDeletedKrungthai(boolean deletedKrungthai) {
        this.deletedKrungthai = deletedKrungthai;
    }
}


