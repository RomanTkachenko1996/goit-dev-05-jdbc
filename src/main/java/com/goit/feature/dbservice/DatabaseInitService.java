package com.goit.feature.dbservice;

import com.goit.feature.db.Database;
import com.goit.feature.preferences.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseInitService {

    public void initDb(Database db){
        try {
            String initDbFileName = new Prefs().getString(Prefs.INIT_DB_SQL_FILEPATH);
            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(initDbFileName)));
            db.executeUpdate(sql);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
