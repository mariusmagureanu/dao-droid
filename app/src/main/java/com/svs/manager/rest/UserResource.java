package com.svs.manager.rest;

import com.svs.manager.entities.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public final class UserResource extends BaseResource<User> {


    @Override
    protected ArrayList<User> fromJSONArray(String data) {
        final ArrayList<User> users = new ArrayList<User>();
        try {
            final JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                final JSONObject jsonObject = jsonArray.getJSONObject(i);
                final User user = new User();
                user.setId(jsonObject.getInt("id"));
                user.setEntityKey(jsonObject.getString("entityKey"));
                user.setFirstName(jsonObject.getString("firstName"));
                user.setLastName(jsonObject.getString("lastName"));
                user.setUserName(jsonObject.getString("userName"));
                user.setPassword(jsonObject.getString("password"));

                users.add(user);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    protected void initEntityUriPath() {
        this.entityUri = "user";
    }
}
