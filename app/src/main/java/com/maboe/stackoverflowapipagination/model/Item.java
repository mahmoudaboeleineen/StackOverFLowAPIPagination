package com.maboe.stackoverflowapipagination.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("owner")
    @Expose
    private Owner owner;
    @SerializedName("is_accepted")
    @Expose
    private Boolean isAccepted;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("last_activity_date")
    @Expose
    private long lastActivityDate;
    @SerializedName("creation_date")
    @Expose
    private long creationDate;
    @SerializedName("answer_id")
    @Expose
    private Integer answerId;
    @SerializedName("question_id")
    @Expose
    private Integer questionId;
    @SerializedName("last_edit_date")
    @Expose
    private long lastEditDate;

    /**
     * No args constructor for use in serialization
     */
    public Item() {
    }

    public Item(Owner owner, Boolean isAccepted, Integer score, long lastActivityDate, long creationDate, Integer answerId, Integer questionId, long lastEditDate) {
        super();
        this.owner = owner;
        this.isAccepted = isAccepted;
        this.score = score;
        this.lastActivityDate = lastActivityDate;
        this.creationDate = creationDate;
        this.answerId = answerId;
        this.questionId = questionId;
        this.lastEditDate = lastEditDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(Boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public long getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(long lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public long getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(long lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

}

