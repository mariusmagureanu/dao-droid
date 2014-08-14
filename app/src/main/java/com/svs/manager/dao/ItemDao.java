package com.svs.manager.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.svs.manager.entities.Item;

import java.util.ArrayList;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public final class ItemDao extends BaseDao<Item> {

    public ItemDao(SQLiteDatabase daoDatabase, String daoTableName) {
        super(daoDatabase, daoTableName);
    }

    @Override
    protected Item fromCursor(Cursor entityCursor) {
        return null;
    }

    @Override
    public long saveAll(ArrayList<Item> entities) {
        return 0;
    }
}
