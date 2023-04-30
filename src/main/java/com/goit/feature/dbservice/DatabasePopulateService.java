package com.goit.feature.dbservice;

import com.goit.feature.db.Database;
import com.goit.feature.preferences.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabasePopulateService {
    public void populateDb(Database db){
        try {
            String populateDbSql = new Prefs().getString(Prefs.POPULATE_DB_SQL_FILEPATH);
            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(populateDbSql)));
            db.executeUpdate(sql);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
