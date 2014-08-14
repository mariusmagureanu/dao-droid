package com.svs.manager.rest;

import com.svs.manager.AppConstants;
import com.svs.manager.entities.BaseEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public abstract class BaseResource<T extends BaseEntity> {

    protected String entityUri;
    protected abstract ArrayList<T> fromJSONArray(final String data);
    protected abstract void initEntityUriPath();

    public BaseResource() {
        this.initEntityUriPath();
    }

    public ArrayList<T> getAll() {
        final ArrayList<T> entities = new ArrayList<T>();
        final String requestString = String.format("%s/closed/%s/all", AppConstants.BASE_URL, this.entityUri);
        final StringBuilder stringBuilder = new StringBuilder();

        HttpURLConnection urlConnection = null;

        try {
            final URL url = new URL(requestString);

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("Content-type", "application/json");
            urlConnection.setDoInput(true);
            urlConnection.connect();

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                final InputStream inputStream = urlConnection.getInputStream();
                final BufferedReader reader = new BufferedReader(
                        new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                inputStream.close();
                reader.close();

                entities.addAll(this.fromJSONArray(stringBuilder.toString()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return entities;
    }
}
