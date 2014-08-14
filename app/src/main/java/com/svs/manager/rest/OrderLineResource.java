package com.svs.manager.rest;

import com.svs.manager.entities.OrderLine;

import java.util.ArrayList;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public final class OrderLineResource extends BaseResource<OrderLine> {

    @Override
    protected ArrayList<OrderLine> fromJSONArray(String data) {
        return null;
    }

    @Override
    protected void initEntityUriPath() {
        this.entityUri = "orderline";
    }
}
