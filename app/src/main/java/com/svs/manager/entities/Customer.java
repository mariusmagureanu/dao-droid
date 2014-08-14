package com.svs.manager.entities;

import android.content.ContentValues;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public final class Customer extends BaseEntity {

    public static String TABLE_NAME = "customer";
    public static String NAME_COLUMN = "name";
    public static String ADDRESS_COLUMN = "address";

    private String name;
    private String address;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public ContentValues asContentValues() {
        final ContentValues contentValues = new ContentValues();
        contentValues.put(BaseEntity.ID, this.id);
        contentValues.put(BaseEntity.ENTITY_KEY, this.entityKey);
        contentValues.put(Customer.NAME_COLUMN, this.name);
        contentValues.put(Customer.ADDRESS_COLUMN, this.address);
        return contentValues;
    }
}
