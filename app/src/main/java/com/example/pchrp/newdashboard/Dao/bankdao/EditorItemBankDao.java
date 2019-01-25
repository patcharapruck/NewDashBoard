package com.example.pchrp.newdashboard.Dao.bankdao;

import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

public class EditorItemBankDao {

    @SerializedName("recorder") private String recorderData = null;
    @SerializedName("createDate") private Timestamp createDateEdit = null;
    @SerializedName("editor") private String editorData = null;
    @SerializedName("lastUpdate") private Timestamp lastUpdateEdit = null;
    @SerializedName("id") private Long idEdit;
    @SerializedName("userType") private String userTypeData = null;
    @SerializedName("authentication") private String authenticationData = null;
    @SerializedName("permissionGroup") private String permissionGroupData = null;
    @SerializedName("active") private boolean activeEdit;
    @SerializedName("deleted") private boolean deletedEdit;

    public String getRecorderData() {
        return recorderData;
    }

    public void setRecorderData(String recorderData) {
        this.recorderData = recorderData;
    }

    public Timestamp getCreateDateEdit() {
        return createDateEdit;
    }

    public void setCreateDateEdit(Timestamp createDateEdit) {
        this.createDateEdit = createDateEdit;
    }

    public String getEditorData() {
        return editorData;
    }

    public void setEditorData(String editorData) {
        this.editorData = editorData;
    }

    public Timestamp getLastUpdateEdit() {
        return lastUpdateEdit;
    }

    public void setLastUpdateEdit(Timestamp lastUpdateEdit) {
        this.lastUpdateEdit = lastUpdateEdit;
    }

    public Long getIdEdit() {
        return idEdit;
    }

    public void setIdEdit(Long idEdit) {
        this.idEdit = idEdit;
    }

    public String getUserTypeData() {
        return userTypeData;
    }

    public void setUserTypeData(String userTypeData) {
        this.userTypeData = userTypeData;
    }

    public String getAuthenticationData() {
        return authenticationData;
    }

    public void setAuthenticationData(String authenticationData) {
        this.authenticationData = authenticationData;
    }

    public String getPermissionGroupData() {
        return permissionGroupData;
    }

    public void setPermissionGroupData(String permissionGroupData) {
        this.permissionGroupData = permissionGroupData;
    }

    public boolean isActiveEdit() {
        return activeEdit;
    }

    public void setActiveEdit(boolean activeEdit) {
        this.activeEdit = activeEdit;
    }

    public boolean isDeletedEdit() {
        return deletedEdit;
    }

    public void setDeletedEdit(boolean deletedEdit) {
        this.deletedEdit = deletedEdit;
    }
}
