package com.example.pchrp.newdashboard.Dao;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayItemDao {

    @SerializedName("link") private String link;
    @SerializedName("image_url") private String imageUrl;
    @SerializedName("caption") private String caption;
    @SerializedName("user_id") private int userId;
    @SerializedName("username") private String username;
    @SerializedName("profile_picture") private String profilePicture;
    @SerializedName("tags") private List<String> tags = new ArrayList<>();
    @SerializedName("created_time") private Date ccreatedTime;
    @SerializedName("camera") private String camere;
    @SerializedName("lens") private String lens;
    @SerializedName("focal_length") private String focalLength;
    @SerializedName("iso") private String iso;
    @SerializedName("shutter_speed") private String shutterSpeed;
    @SerializedName("aperture") private String aperture;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Date getCcreatedTime() {
        return ccreatedTime;
    }

    public void setCcreatedTime(Date ccreatedTime) {
        this.ccreatedTime = ccreatedTime;
    }

    public String getCamere() {
        return camere;
    }

    public void setCamere(String camere) {
        this.camere = camere;
    }

    public String getLens() {
        return lens;
    }

    public void setLens(String lens) {
        this.lens = lens;
    }

    public String getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(String focalLength) {
        this.focalLength = focalLength;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getShutterSpeed() {
        return shutterSpeed;
    }

    public void setShutterSpeed(String shutterSpeed) {
        this.shutterSpeed = shutterSpeed;
    }

    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
        this.aperture = aperture;
    }
}
