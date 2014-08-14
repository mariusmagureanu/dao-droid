package com.svs.manager.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.svs.manager.AppConstants;
import com.svs.manager.Utils;

import java.io.File;
import java.util.Locale;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public final class DatabaseConnector {

    private SQLiteDatabase localDatabase;
    private SQLiteDatabase testDatabase;

    public DatabaseConnector(final Context currentContext) {

        if (!Utils.databaseExists(AppConstants.APP_DATABASE)) {
            final DatabaseHelper appDbHelper = new DatabaseHelper(currentContext, AppConstants.APP_DATABASE, null, AppConstants.DATABASE_VERSION);
            final DatabaseHelper testDbHelper = new DatabaseHelper(currentContext, AppConstants.APP_TEST_DATABASE, null, AppConstants.DATABASE_VERSION);

            appDbHelper.getWritableDatabase();
            appDbHelper.close();

            testDbHelper.getWritableDatabase();
            testDbHelper.close();
        }


        final String appDatabaseFilePath = String.format("/data/data/%s/databases/%s", currentContext.getPackageName(), AppConstants.APP_DATABASE);
        final String testAppDatabaseFilePath = String.format("/data/data/%s/databases/%s", currentContext.getPackageName(), AppConstants.APP_TEST_DATABASE);

        final File appDbFile = new File(appDatabaseFilePath);
        final File testDbFile = new File(testAppDatabaseFilePath);

        if (appDbFile.exists()) {
            this.localDatabase = SQLiteDatabase.openDatabase(appDatabaseFilePath, null, SQLiteDatabase.OPEN_READWRITE);
            this.localDatabase.setLocale(Locale.getDefault());
        }

        if (testDbFile.exists()) {
            this.testDatabase = SQLiteDatabase.openDatabase(testAppDatabaseFilePath, null, SQLiteDatabase.OPEN_READWRITE);
            this.testDatabase.setLocale(Locale.getDefault());
        }
    }

    public final synchronized SQLiteDatabase getDataBaseConnection() {
        return this.localDatabase;
    }

    public final synchronized SQLiteDatabase getTestDataBaseConnection() {
        return this.testDatabase;
    }
}
