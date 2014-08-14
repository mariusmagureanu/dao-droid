package com.svs.manager.rest;

import com.svs.manager.entities.Customer;

import java.util.ArrayList;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public final class CustomerResource extends BaseResource<Customer> {

    @Override
    protected ArrayList<Customer> fromJSONArray(String data) {

        return null;
    }

    @Override
    protected void initEntityUriPath() {
        this.entityUri = "customer";
    }
}
