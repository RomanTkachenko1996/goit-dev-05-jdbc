package com.goit.feature.dbservice;

import com.goit.feature.db.Database;
import com.goit.feature.preferences.Prefs;
import org.flywaydb.core.Flyway;

public class DatabaseInitService {

    public void initDb(){
        // Create the Flyway instance and point it to the database
        String url = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL);

        Flyway flyway = Flyway
                .configure()
                .dataSource(url, null, null).load();
        // Start the migration
        flyway.migrate();
    }
}
