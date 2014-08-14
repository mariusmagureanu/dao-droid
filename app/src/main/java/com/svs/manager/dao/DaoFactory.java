package com.svs.manager.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.svs.manager.db.DatabaseConnector;
import com.svs.manager.entities.Customer;
import com.svs.manager.entities.Item;
import com.svs.manager.entities.Order;
import com.svs.manager.entities.OrderLine;
import com.svs.manager.entities.User;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public final class DaoFactory {

    private static DaoFactory daoFactoryInstance;
    private static final Object lockObject = new Object();
    private static Context dataContext;
    private final SQLiteDatabase appDatabase;
    private final SQLiteDatabase testDatabase;


    public static DaoFactory getInstance() {
        synchronized (lockObject) {
            if (daoFactoryInstance == null) {
                daoFactoryInstance = new DaoFactory();
            }
        }
        return daoFactoryInstance;
    }

    public static void setDataContext(Context context)
    {
        dataContext = context;
    }

    private DaoFactory() {
        final DatabaseConnector dbConnector = new DatabaseConnector(dataContext);
        this.appDatabase = dbConnector.getDataBaseConnection();
        this.testDatabase = dbConnector.getTestDataBaseConnection();
    }

    public CustomerDao getCustomerDao() {
        return new CustomerDao(this.appDatabase, Customer.TABLE_NAME);
    }

    public ItemDao getItemDao() {
        return new ItemDao(this.appDatabase, Item.TABLE_NAME);
    }

    public OrderDao getOrderDao() {
        return new OrderDao(this.appDatabase, Order.TABLE_NAME);
    }

    public OrderLineDao getOrderLineDao() {
        return new OrderLineDao(this.appDatabase, OrderLine.TABLE_NAME);
    }

    public UserDao getUserDao() {
        return new UserDao(this.appDatabase, User.TABLE_NAME);
    }
}
