package com.svs.manager.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import com.svs.manager.AppConstants;
import com.svs.manager.entities.BaseEntity;
import com.svs.manager.entities.Customer;
import com.svs.manager.entities.Item;
import com.svs.manager.entities.Order;
import com.svs.manager.entities.OrderLine;
import com.svs.manager.entities.User;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public final class DatabaseHelper extends SQLiteOpenHelper {

    private static final String CREATE_CUSTOMER_TABLE = String.format("create table %s(%s integer primary key autoincrement, %s integer, %s nvarchar(25), %s nvarchar(75), %s nvarchar(75));", Customer.TABLE_NAME, BaseColumns._ID, BaseEntity.ID,
            BaseEntity.ENTITY_KEY, Customer.NAME_COLUMN, Customer.ADDRESS_COLUMN);

    private static final String CREATE_ITEM_TABLE = String.format("create table %s(%s integer primary key autoincrement, %s integer, %s nvarchar(25), %s nvarchar(75), %s nvarchar(75));", Item.TABLE_NAME, BaseColumns._ID, BaseEntity.ID,
            BaseEntity.ENTITY_KEY, Item.NAME_COLUMN, Item.DESCRIPTION_COLUMN);

    private static final String CREATE_USER_TABLE = String.format("create table %s(%s integer primary key autoincrement, %s integer, %s nvarchar(25), %s nvarchar(75), %s nvarchar(75), %s nvarchar(30), %s nvarchar(30));", User.TABLE_NAME, BaseColumns._ID, BaseEntity.ID,
            BaseEntity.ENTITY_KEY, User.FIRST_NAME_COLUMN, User.LAST_NAME_COLUMN, User.USER_NAME_COLUMN, User.PASSWORD_COLUMN);

    private static final String CREATE_ORDER_TABLE = String.format("create table %s(%s integer primary key autoincrement, %s integer, %s nvarchar(25), %s nvarchar(75), %s datetime, %s nvarchar(150), %s nvarchar(30));", Order.TABLE_NAME, BaseColumns._ID, BaseEntity.ID,
            BaseEntity.ENTITY_KEY, Order.CUSTOMER_ID_COLUMN, Order.ORDER_DATE_COLUMN, Order.COMMENTS_COLUMN, Order.STATUS_COLUMN);

    private static final String CREATE_ORDER_LINE_TABLE = String.format("create table %s(%s integer primary key autoincrement, %s integer, %s nvarchar(25), %s nvarchar(75), %s nvarchar(25), %s nvarchar(150), %s integer);", OrderLine.TABLE_NAME, BaseColumns._ID, BaseEntity.ID,
            BaseEntity.ENTITY_KEY, OrderLine.CUSTOMER_ID_COLUMN, OrderLine.ITEM_ID_COLUMN, OrderLine.COMMENTS_COLUMN, OrderLine.QUANTITY_COLUMN);


    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(CREATE_CUSTOMER_TABLE);
            sqLiteDatabase.execSQL(CREATE_ITEM_TABLE);
            sqLiteDatabase.execSQL(CREATE_USER_TABLE);
            sqLiteDatabase.execSQL(CREATE_ORDER_TABLE);
            sqLiteDatabase.execSQL(CREATE_ORDER_LINE_TABLE);
        } catch (final SQLiteException ex) {
            Log.e("Create table exception", ex.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.w("TaskDBAdapter", String.format("Upgrading from %s to %s version.", oldVersion, newVersion));
        try {
            sqLiteDatabase.execSQL("drop table if exists " + Customer.TABLE_NAME);
            sqLiteDatabase.execSQL("drop table if exists " + User.TABLE_NAME);
            sqLiteDatabase.execSQL("drop table if exists " + Item.TABLE_NAME);
            sqLiteDatabase.execSQL("drop table if exists " + OrderLine.TABLE_NAME);
            sqLiteDatabase.execSQL("drop table if exists " + Order.TABLE_NAME);
            this.onCreate(sqLiteDatabase);
        } catch (Exception ex) {
            Log.e("Upgrade database exception", ex.getMessage());
        }
    }
}
