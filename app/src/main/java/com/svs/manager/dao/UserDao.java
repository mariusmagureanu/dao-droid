package com.svs.manager.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.svs.manager.entities.BaseEntity;
import com.svs.manager.entities.User;

import java.util.ArrayList;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public final class UserDao extends BaseDao<User> {

    public UserDao(SQLiteDatabase daoDatabase, String daoTableName) {
        super(daoDatabase, daoTableName);
    }

    @Override
    protected User fromCursor(Cursor entityCursor) {
        final User user = new User();
        final int idColumnIndex = entityCursor.getColumnIndex(BaseEntity.ID);
        final int entityKeyColumnIndex = entityCursor.getColumnIndex(BaseEntity.ENTITY_KEY);
        final int firstNameColumnIndex = entityCursor.getColumnIndex(User.FIRST_NAME_COLUMN);
        final int lastNameColumnIndex = entityCursor.getColumnIndex(User.LAST_NAME_COLUMN);
        final int userNameColumnIndex = entityCursor.getColumnIndex(User.USER_NAME_COLUMN);
        final int passwordColumnIndex = entityCursor.getColumnIndex(User.PASSWORD_COLUMN);

        user.setId(entityCursor.getInt(idColumnIndex));
        user.setEntityKey(entityCursor.getString(entityKeyColumnIndex));
        user.setFirstName(entityCursor.getString(firstNameColumnIndex));
        user.setLastName(entityCursor.getString(lastNameColumnIndex));
        user.setUserName(entityCursor.getString(userNameColumnIndex));
        user.setPassword(entityCursor.getString(passwordColumnIndex));

        return user;
    }

    @Override
    public long saveAll(final ArrayList<User> entities) {
        final String insertSql = String.format("insert into %s (%s, %s, %s, %s, %s, %s) values(?,?,?,?,?,?)", User.TABLE_NAME, BaseEntity.ID, BaseEntity.ENTITY_KEY, User.FIRST_NAME_COLUMN, User.LAST_NAME_COLUMN, User.USER_NAME_COLUMN, User.PASSWORD_COLUMN);
        long insertedLines = 0;

        this.database.beginTransaction();
        final SQLiteStatement statement = this.database.compileStatement(insertSql);

        for (final User user : entities) {

            statement.bindLong(1, user.getId());
            statement.bindString(2, user.getEntityKey());
            statement.bindString(3, user.getFirstName());
            statement.bindString(4, user.getLastName());
            statement.bindString(5, user.getUserName());
            statement.bindString(6, user.getPassword());
            insertedLines = statement.executeInsert();
            statement.clearBindings();
        }

        this.database.setTransactionSuccessful();
        this.database.endTransaction();
        return insertedLines;
    }
}
