package com.svs.manager.entities;

import android.content.ContentValues;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public final class Item extends BaseEntity {

    public static String TABLE_NAME="item";
    public static String NAME_COLUMN="name";
    public static String DESCRIPTION_COLUMN="description";

    private String name;
    private String description;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public ContentValues asContentValues() {
        return null;
    }
}
