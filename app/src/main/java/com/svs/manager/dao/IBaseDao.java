package com.svs.manager.dao;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public interface IBaseDao<T> {

    public HashMap<Integer, T> getAll(final String orderByCriteria);

    public T getByKey(final String entityKey);

    public int updateEntity(final T entity);

    public long saveAll(final ArrayList<T> entities);

}