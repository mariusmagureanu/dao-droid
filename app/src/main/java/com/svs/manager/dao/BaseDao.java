package com.svs.manager.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.svs.manager.entities.BaseEntity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public abstract class BaseDao<T extends BaseEntity> implements IBaseDao<T> {

    protected SQLiteDatabase database;
    protected String tableName;

    protected abstract T fromCursor(final Cursor entityCursor);

    public BaseDao(final SQLiteDatabase daoDatabase, final String daoTableName) {
        this.database = daoDatabase;
        this.tableName = daoTableName;
    }

    @Override
    public HashMap<Integer, T> getAll(String orderByCriteria) {
        final HashMap<Integer, T> genericList = new HashMap<Integer, T>();
        if (this.database != null) {
            final Cursor genericCursor = this.database.query(this.tableName, null, null, null, null, null, orderByCriteria);

            if (genericCursor != null) {
                if (genericCursor.moveToFirst()) {
                    do {
                        final T t = this.fromCursor(genericCursor);
                        if (t != null) {
                            genericList.put(genericCursor.getPosition(), t);
                        }
                    } while (genericCursor.moveToNext());
                }
                genericCursor.close();
            }
        }
        return genericList;
    }

    @Override
    public T getByKey(String entityKey) {
        T t = null;
        if (entityKey != null && this.database != null) {
            final Cursor genericCursor = this.database.query(this.tableName, null, T.ENTITY_KEY + " =?", new String[]{entityKey}, null, null, T.ENTITY_KEY + " LIMIT 1");
            if (genericCursor != null) {
                if (genericCursor.moveToFirst()) {
                    t = this.fromCursor(genericCursor);
                }
                genericCursor.close();
            }
        }
        return t;
    }

    @Override
    public int updateEntity(T entity) {
        int updatedRows = 0;
        if (this.database != null) {
            final ContentValues entityValues = entity.asContentValues();
            if (entityValues != null && this.database != null) {
                updatedRows = this.database.update(this.tableName, entityValues, T.ENTITY_KEY + " =?", new String[]{entity.getEntityKey()});
            }
        }
        return updatedRows;
    }

    public long insertEntity(final T entity) {
        long insertedRows = 0;
        if (this.database != null) {
            final ContentValues entityValues = entity.asContentValues();
            if (entityValues != null && this.database != null) {
                insertedRows = this.database.insert(this.tableName, null, entityValues);
            }
        }
        return insertedRows;
    }

    /**
     * @param entity *
     * @return *
     */
    public int deleteEntity(final T entity) {
        int deletedRows = 0;
        if (this.database != null) {
            final ContentValues entityValues = entity.asContentValues();
            if (entityValues != null && this.database != null) {
                deletedRows = this.database.delete(this.tableName, T.ENTITY_KEY + " =?", new String[]{entity.getEntityKey()});
            }
        }
        return deletedRows;
    }
}
