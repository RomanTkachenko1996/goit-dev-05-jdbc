package com.goit;

import com.goit.feature.db.Database;
import com.goit.feature.dbservice.DatabaseInitService;
import com.goit.feature.dbservice.DatabasePopulateService;
import com.goit.feature.dbservice.DatabaseQueryService;


public class Main {
    public static void main(String[] args) {
        Database db = Database.getInstance();
       // new DatabaseInitService().initDb(db);

        DatabasePopulateService populateService = new DatabasePopulateService() ;
        //populateService.populateDb(db);


        //populateService.addWorkersFromFile();
        //populateService.addClientsFromFile();
        //populateService.addProjectsFromFile();
        //populateService.addProjectWorkerFromFile();

    }
}
