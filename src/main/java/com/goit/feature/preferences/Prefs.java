package com.goit.feature.preferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Prefs {
    public static final String DB_JDBC_CONNECTION_URL = "dbURL";
    public static final String INIT_DB_SQL_FILEPATH = "initDbSql";
    public static final String POPULATE_DB_SQL_FILEPATH = "populateDbSql";

    public static final String FIND_LONGEST_PROJECT_SQL_PATH = "findLongestProjectSql";
    public static final String FIND_MAX_PROJECTS_CLIENT_SQL_PATH = "findMaxProjectsClientSql";
    public static final String FIND_MAX_SALARY_WORKER_SQL_PATH = "findMaxSalaryWorkerSql";
    public static final String FIND_YOUNGEST_ELDEST_WORKERS_SQL_PATH = "findYoungestEldestWorkersSql";
    public static final String PRINT_PROJECT_PRICES_SQL_PATH = "printProjectPricesSql";
    public static final String DEFAULT_PREFS_FILENAME = "prefs.json";
    public static final String FILE_PATH_WITH_NEW_WORKERS = "src/main/resources/workers.txt";
    public static final String FILE_PATH_WITH_NEW_CLIENTS = "src/main/resources/clients.txt";
    public static final String FILE_PATH_WITH_NEW_PROJECTS = "src/main/resources/projects.txt";
    public static final String FILE_PATH_WITH_NEW_PROJECT_WORKERS = "src/main/resources/project_worker.txt";


    private  Map<String,Object> prefs = new HashMap<>();
    public Prefs(){
        this(DEFAULT_PREFS_FILENAME);
    }

    public Prefs(String filename) {
        try {
            String json = String.join("\n",
                    Files.readAllLines(Paths.get(filename)));
            prefs = new Gson().fromJson(json,new TypeToken<Map<String,Object>>(){}.getType());
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }

    public String getString (String key){
        return getPref(key).toString();
    }
    public Object getPref(String key){
        return prefs.get(key);
    }
}
