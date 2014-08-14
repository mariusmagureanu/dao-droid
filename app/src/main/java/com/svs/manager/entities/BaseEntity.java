package com.svs.manager.entities;

import android.content.ContentValues;
import android.provider.BaseColumns;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public abstract class BaseEntity {

    public static String ID="id";
    public static String ENTITY_KEY="entity_key";

    protected String entityKey;
    protected int id;

    public abstract ContentValues asContentValues();

    public String getEntityKey() {
        return this.entityKey;
    }

    public int getId() {
        return this.id;
    }

    public void setEntityKey(final String entityKey) {
        this.entityKey = entityKey;
    }

    public void setId(final int id) {
        this.id = id;
    }

}
