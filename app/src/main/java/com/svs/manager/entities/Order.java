package com.svs.manager.entities;

import android.content.ContentValues;

import java.sql.Date;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public final class Order extends BaseEntity {

    public static String TABLE_NAME="orders";
    public static String CUSTOMER_ID_COLUMN="customer_id";
    public static String ORDER_DATE_COLUMN="order_date";
    public static String COMMENTS_COLUMN="comments";
    public static String STATUS_COLUMN="status";


    private String customerId;
    private Date orderDate;
    private String comments;
    private String status;


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public ContentValues asContentValues() {
        return null;
    }
}
