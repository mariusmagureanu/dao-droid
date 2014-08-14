package com.svs.manager.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.svs.manager.entities.Order;

import java.util.ArrayList;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public final class OrderDao extends BaseDao<Order> {

    public OrderDao(SQLiteDatabase daoDatabase, String daoTableName) {
        super(daoDatabase, daoTableName);
    }

    @Override
    protected Order fromCursor(Cursor entityCursor) {
        return null;
    }

    @Override
    public long saveAll(ArrayList<Order> entities) {
        return 0;
    }
}
