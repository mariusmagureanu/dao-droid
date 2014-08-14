package com.svs.manager.rest;

import com.svs.manager.entities.Item;

import java.util.ArrayList;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public final class ItemResource extends BaseResource<Item> {


    @Override
    protected ArrayList<Item> fromJSONArray(String data) {
        return null;
    }

    @Override
    protected void initEntityUriPath() {
        this.entityUri = "item";
    }
}
