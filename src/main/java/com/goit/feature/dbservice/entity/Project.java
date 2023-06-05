package com.goit.feature.dbservice.entity;

import java.time.LocalDate;

public class Project {
    private int client_id;
    private LocalDate start_date;
    private LocalDate finish_date;

    public Project(int client_id, LocalDate startDate, LocalDate endDate) {
        this.client_id = client_id;
        this.start_date = startDate;
        this.finish_date = endDate;
    }
    public int getClient_id() {
        return client_id;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public LocalDate getFinish_date() {
        return finish_date;
    }

    @Override
    public String toString() {
        return "Project{" +
                "client_id=" + client_id +
                ", startDate=" + start_date +
                ", endDate=" + finish_date +
                '}';
    }
}
