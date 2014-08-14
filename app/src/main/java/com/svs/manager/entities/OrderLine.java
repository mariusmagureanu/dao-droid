package com.svs.manager.entities;

import android.content.ContentValues;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public final class OrderLine extends BaseEntity {

    public static String TABLE_NAME = "order_line";
    public static String CUSTOMER_ID_COLUMN = "customer_id";
    public static String ITEM_ID_COLUMN = "item_id";
    public static String COMMENTS_COLUMN = "comments";
    public static String QUANTITY_COLUMN = "quantity";

    private String customerId;
    private String itemId;
    private String comments;
    private int quantity;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public ContentValues asContentValues() {
        return null;
    }
}
