package com.goit.feature.dbservice;


import com.goit.feature.db.Database;
import com.goit.feature.dbservice.selection_dto.*;
import com.goit.feature.preferences.Prefs;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DatabaseQueryService {
    public static ArrayList<LongestProject> findLongestProject() {
        ArrayList<LongestProject> list = new ArrayList<>();
        try (Statement st = Database.getInstance().getConnection().createStatement()) {
            String findLongestProject = new Prefs().getString(Prefs.FIND_LONGEST_PROJECT_SQL_PATH);
            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(findLongestProject)));
            ResultSet rs = st.executeQuery(sql);
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
        try (Statement st = Database.getInstance().getConnection().createStatement()) {
            String findMaxProjectClient = new Prefs().getString(Prefs.FIND_MAX_PROJECTS_CLIENT_SQL_PATH);
            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(findMaxProjectClient)));
            ResultSet rs = st.executeQuery(sql);
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
        try (Statement st = Database.getInstance().getConnection().createStatement()) {
            String findMaxSalaryWorker = new Prefs().getString(Prefs.FIND_MAX_SALARY_WORKER_SQL_PATH);
            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(findMaxSalaryWorker)));
            ResultSet rs = st.executeQuery(sql);
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
        ArrayList<ProjectPrices> list = new ArrayList<>();
        try (Statement st = Database.getInstance().getConnection().createStatement()) {
            String printProjectPrices = new Prefs().getString(Prefs.PRINT_PROJECT_PRICES_SQL_PATH);
            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(printProjectPrices)));
            ResultSet rs = st.executeQuery(sql);
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
        try (Statement st = Database.getInstance().getConnection().createStatement()) {
            String findYoungestEldestWorkers = new Prefs().getString(Prefs.FIND_YOUNGEST_ELDEST_WORKERS_SQL_PATH);
            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(findYoungestEldestWorkers)));
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String type = rs.getString("type");
                String workerName = rs.getString("name");
                String birthday = rs.getString("birthday");
                list.add(new YoungestEldestWorkers(type, workerName,birthday));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
