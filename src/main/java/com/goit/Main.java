package com.goit;

import com.goit.feature.db.Database;
import com.goit.feature.dbservice.DatabaseInitService;
import com.goit.feature.dbservice.DatabasePopulateService;
import com.goit.feature.dbservice.DatabaseQueryService;
import com.goit.feature.dbservice.dao.ClientService;
import com.goit.feature.preferences.Prefs;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        Database db = Database.getInstance();
        new DatabaseInitService().initDb();
        ClientService cs = new ClientService(db.getConnection());
        //create
        System.out.println("cs.create(\"NANCY BACKS\") = " + cs.create("NANCY BACKS"));
        //read
        System.out.println("cs.getById(1) = " + cs.getById(1));
        cs.listAll().forEach(System.out::println);
        //update
        cs.setName(1,"DUSTIN MALL");
        //delete
        cs.deleteById(6);







    }
}
