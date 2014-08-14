package com.svs.manager.rest;

import com.svs.manager.entities.Order;

import java.util.ArrayList;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public final class OrderResource extends BaseResource<Order>{

    @Override
    protected ArrayList<Order> fromJSONArray(String data) {
        return null;
    }

    @Override
    protected void initEntityUriPath() {
        this.entityUri="order";
    }
}
