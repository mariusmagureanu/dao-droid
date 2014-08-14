package com.svs.manager;

import android.os.Environment;

import java.io.File;

/**
 * Created by mariusmagureanu on 8/13/14.
 */
public final class Utils {

    public static boolean databaseExists(final String database) {

        final File databaseFile = new File(getApplicationFolder() + File.separator + database);
        return databaseFile.exists();
    }

    public static String getApplicationFolder() {
        return Environment.getExternalStorageDirectory().getPath() + File.separator + AppConstants.DEFAULT_DATA_FOLDER;
    }
}
