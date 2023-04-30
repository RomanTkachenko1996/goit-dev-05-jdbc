package com.goit.feature.dbservice.selection_dto;


public class MaxProjectsClient {
    private String clientName;
    private int projectCount;

    public MaxProjectsClient(String clientName, int projectCount) {
        this.clientName = clientName;
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return "MaxProjectsClient{" +
                "clientName='" + clientName + '\'' +
                ", projectCount=" + projectCount +
                '}';
    }
}
