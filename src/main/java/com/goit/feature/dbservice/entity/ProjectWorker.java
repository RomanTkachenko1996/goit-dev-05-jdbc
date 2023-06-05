package com.goit.feature.dbservice.entity;

public class ProjectWorker {

    private int project_id;
    private int worker_id;

    public ProjectWorker(int project_id, int worker_id) {
        this.project_id = project_id;
        this.worker_id = worker_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public int getWorker_id() {
        return worker_id;
    }

    @Override
    public String toString() {
        return "ProjectWorker{" +
                "project_id=" + project_id +
                ", client_id=" + worker_id +
                '}';
    }
}
