package com.example.frige.models;

public class FrigeItemModel {

    private String contentID, userFrigeID, itemID, quantity, createDate, updateDate;

    public FrigeItemModel(String contentID, String userFrigeID, String itemID, String quantity, String createDate, String updateDate) {
        this.contentID = contentID;
        this.userFrigeID = userFrigeID;
        this.itemID = itemID;
        this.quantity = quantity;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public String getContentID() {
        return contentID;
    }

    public void setContentID(String contentID) {
        this.contentID = contentID;
    }

    public String getUserFrigeID() {
        return userFrigeID;
    }

    public void setUserFrigeID(String userFrigeID) {
        this.userFrigeID = userFrigeID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
