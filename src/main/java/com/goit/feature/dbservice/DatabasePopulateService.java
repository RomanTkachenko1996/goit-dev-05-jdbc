package com.goit.feature.dbservice;

import com.goit.feature.db.Database;
import com.goit.feature.dbservice.entity.Client;
import com.goit.feature.dbservice.entity.Project;
import com.goit.feature.dbservice.entity.ProjectWorker;
import com.goit.feature.dbservice.entity.Worker;
import com.goit.feature.preferences.Prefs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class DatabasePopulateService {

    public void addProjectWorkerFromFile(){
        String sql = "INSERT INTO project_worker (project_id,worker_id) VALUES (?,?);";
        ArrayList<ProjectWorker> projectWorkerArrayList = new ArrayList<>();
        addProjectWorkerToList(projectWorkerArrayList);
        try (PreparedStatement st = Database.getInstance().getConnection().prepareStatement(sql)) {
            for (ProjectWorker projectWorker : projectWorkerArrayList) {
                st.setInt(1, projectWorker.getProject_id());
                st.setInt(2, projectWorker.getWorker_id());
                st.addBatch();
            }
            st.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void addProjectWorkerToList(ArrayList<ProjectWorker> projectWorkerArrayList) {
        Scanner sc;
        try {
            sc = new Scanner(new FileReader(Prefs.FILE_PATH_WITH_NEW_PROJECT_WORKERS));
            while (sc.hasNext()) {
                String[] project = sc.nextLine().split(",");
                projectWorkerArrayList.add(
                        new ProjectWorker(Integer.parseInt(project[0]), Integer.parseInt(project[1])));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addProjectsFromFile(){
        String sql = "INSERT INTO project (client_id,start_date,finish_date) VALUES (?,?,?);";
        ArrayList<Project> projectsArrayList = new ArrayList<>();
        addProjectsToList(projectsArrayList);
        try (PreparedStatement st = Database.getInstance().getConnection().prepareStatement(sql)) {
            for (Project project : projectsArrayList) {
                st.setInt(1, project.getClient_id());
                st.setDate(2,Date.valueOf(project.getStart_date()));
                st.setDate(3,Date.valueOf(project.getFinish_date()));
                st.addBatch();
            }
            st.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void addProjectsToList(ArrayList<Project> projectsArrayList) {
        Scanner sc;
        try {
            sc = new Scanner(new FileReader(Prefs.FILE_PATH_WITH_NEW_PROJECTS));
            while (sc.hasNext()) {
                String[] project = sc.nextLine().split(",");
                projectsArrayList.add(
                        new Project(Integer.parseInt(project[0]),
                        LocalDate.parse(project[1]),
                        LocalDate.parse(project[2])));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addClientsFromFile() {
        String sql = "INSERT INTO client (name) VALUES (?);";
        ArrayList<Client> clientsArrayList = new ArrayList<>();
        addClientsToList(clientsArrayList);
        try (PreparedStatement st = Database.getInstance().getConnection().prepareStatement(sql)) {
            for (Client client : clientsArrayList) {
                st.setString(1, client.getName());
                st.addBatch();
            }
            st.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addClientsToList(ArrayList<Client> clientsArrayList) {
        Scanner sc;
        try {
            sc = new Scanner(new FileReader(Prefs.FILE_PATH_WITH_NEW_CLIENTS));
            while (sc.hasNext()) {
                clientsArrayList.add(new Client(sc.nextLine()));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addWorkersFromFile() {
        String sql = "INSERT INTO worker (name, birthday, level,salary) VALUES (?, ?, ?,?);";
        ArrayList<Worker> workerArrayList = new ArrayList<>();
        addWorkersToList(workerArrayList);
        try (PreparedStatement st = Database.getInstance().getConnection().prepareStatement(sql)) {
            for (Worker worker : workerArrayList) {
                st.setString(1, worker.getName());
                st.setDate(2, Date.valueOf(worker.getBirthday()));
                st.setString(3, worker.getLevel());
                st.setInt(4, worker.getSalary());
                st.addBatch();
            }
            st.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addWorkersToList(ArrayList<Worker> workerArrayList) {
        Scanner sc;
        try {
            sc = new Scanner(new FileReader(Prefs.FILE_PATH_WITH_NEW_WORKERS));
            while (sc.hasNext()) {
                String[] worker = sc.nextLine().split(",");
                workerArrayList.add(new Worker(worker[0], LocalDate.parse(worker[1]), worker[2], Integer.parseInt(worker[3])));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void populateDb(Database db) {
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
