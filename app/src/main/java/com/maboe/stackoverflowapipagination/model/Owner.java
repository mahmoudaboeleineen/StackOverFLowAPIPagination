package com.maboe.stackoverflowapipagination.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner {
    @SerializedName("reputation")
    @Expose
    private String reputation;

    @SerializedName("user_id")
    @Expose
    private Integer userId;

    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("profile_image")
    @Expose
    private String profileImage;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("accept_rate")
    @Expose
    private String acceptRate;

    /**
     * No args constructor for use in serialization
     */
    public Owner() {
    }

    /**
     * @param acceptRate
     * @param displayName
     * @param link
     * @param reputation
     * @param userType
     * @param profileImage
     * @param userId
     */
    public Owner(String reputation, Integer userId, String userType, String profileImage, String displayName, String link, String acceptRate) {
        super();
        this.reputation = reputation;
        this.userId = userId;
        this.userType = userType;
        this.profileImage = profileImage;
        this.displayName = displayName;
        this.link = link;
        this.acceptRate = acceptRate;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAcceptRate() {
        return acceptRate;
    }

    public void setAcceptRate(String acceptRate) {
        this.acceptRate = acceptRate;
    }

}

