package com.svs.manager.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.svs.manager.entities.OrderLine;

import java.util.ArrayList;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public final class OrderLineDao extends BaseDao<OrderLine>{

    public OrderLineDao(SQLiteDatabase daoDatabase, String daoTableName) {
        super(daoDatabase, daoTableName);
    }

    @Override
    protected OrderLine fromCursor(Cursor entityCursor) {
        return null;
    }

    @Override
    public long saveAll(ArrayList<OrderLine> entities) {
        return 0;
    }
}
