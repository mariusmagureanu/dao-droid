package com.svs.manager.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.svs.manager.entities.BaseEntity;
import com.svs.manager.entities.Customer;

import java.util.ArrayList;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public final class CustomerDao extends BaseDao<Customer> {

    public CustomerDao(SQLiteDatabase daoDatabase, String daoTableName) {
        super(daoDatabase, daoTableName);
    }

    @Override
    protected Customer fromCursor(Cursor entityCursor) {
        final Customer customer = new Customer();
        final int idColumnIndex = entityCursor.getColumnIndex(BaseEntity.ID);
        final int entityKeyColumnIndex = entityCursor.getColumnIndex(BaseEntity.ENTITY_KEY);
        final int customerNameColumnIndex = entityCursor.getColumnIndex(Customer.NAME_COLUMN);
        final int addressColumnIndex = entityCursor.getColumnIndex(Customer.ADDRESS_COLUMN);

        customer.setId(entityCursor.getInt(idColumnIndex));
        customer.setEntityKey(entityCursor.getString(entityKeyColumnIndex));
        customer.setName(entityCursor.getString(customerNameColumnIndex));
        customer.setAddress(entityCursor.getString(addressColumnIndex));

        return customer;
    }

    @Override
    public long saveAll(ArrayList<Customer> entities) {
        return 0;
    }
}
