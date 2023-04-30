package com.goit;

import com.goit.feature.db.Database;
import com.goit.feature.dbservice.DatabaseInitService;
import com.goit.feature.dbservice.DatabasePopulateService;
import com.goit.feature.dbservice.DatabaseQueryService;
import com.goit.feature.dbservice.selection_dto.LongestProject;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Database db = Database.getInstance();
        //new DatabasePopulateService().populateDb(db);
        //DatabaseQueryService.findLongestProject().forEach(System.out::println);
        //DatabaseQueryService.findMaxProjectsClient().forEach(System.out::println);
        //DatabaseQueryService.findMaxSalaryWorker().forEach(System.out::println);
        //DatabaseQueryService.printProjectPrices().forEach(System.out::println);
        //DatabaseQueryService.findYoungestEldestWorkers().forEach(System.out::println);
    }
}
