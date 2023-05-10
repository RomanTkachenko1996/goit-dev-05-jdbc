package com.goit.feature.dbservice;


import com.goit.feature.db.Database;
import com.goit.feature.dbservice.selection_dto.*;
import com.goit.feature.preferences.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DatabaseQueryService {

    private static String getSql(String findLongestProjectSqlPath) {
        String findLongestProject = new Prefs().getString(findLongestProjectSqlPath);
        String sql;
        try {
            sql = String.join("\n", Files.readAllLines(Paths.get(findLongestProject)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sql;
    }

    public static ArrayList<LongestProject> findLongestProject(){
        ArrayList<LongestProject> list = new ArrayList<>();
        String sql = getSql(Prefs.FIND_LONGEST_PROJECT_SQL_PATH);
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String date = rs.getString("duration_in_months");
                list.add(new LongestProject(id, date));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<MaxProjectsClient> findMaxProjectsClient() {
        ArrayList<MaxProjectsClient> list = new ArrayList<>();
        String sql = getSql(Prefs.FIND_MAX_PROJECTS_CLIENT_SQL_PATH);
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String client_name = rs.getString("name");
                int project_count = rs.getInt("project_count");
                list.add(new MaxProjectsClient(client_name, project_count));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<MaxSalaryWorker> findMaxSalaryWorker() {
        ArrayList<MaxSalaryWorker> list = new ArrayList<>();
        String sql = getSql(Prefs.FIND_MAX_SALARY_WORKER_SQL_PATH);
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){
            while (rs.next()) {

                String worker_name = rs.getString("name");
                int salary = rs.getInt("salary");
                list.add(new MaxSalaryWorker(worker_name, salary));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<ProjectPrices> printProjectPrices() {
        String printProjectPrices = new Prefs().getString(Prefs.PRINT_PROJECT_PRICES_SQL_PATH);
        String sql = null;
        try {
            sql = String.join("\n",
                    Files.readAllLines(Paths.get(printProjectPrices)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<ProjectPrices> list = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){
            while (rs.next()) {
                int projectId = rs.getInt("project_id");
                int projectPrice = rs.getInt("overall_price");
                list.add(new ProjectPrices(projectId, projectPrice));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<YoungestEldestWorkers> findYoungestEldestWorkers() {
        ArrayList<YoungestEldestWorkers> list = new ArrayList<>();
        String findYoungestEldestWorkers = new Prefs().getString(Prefs.FIND_YOUNGEST_ELDEST_WORKERS_SQL_PATH);
        String sql = null;
        try {
            sql = String.join("\n",
                    Files.readAllLines(Paths.get(findYoungestEldestWorkers)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (Connection conn = Database.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){
            while (rs.next()) {
                String type = rs.getString("type");
                String workerName = rs.getString("name");
                String birthday = rs.getString("birthday");
                list.add(new YoungestEldestWorkers(type, workerName, birthday));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
