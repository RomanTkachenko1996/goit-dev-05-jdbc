package com.goit.feature.dbservice.selection_dto;


public class LongestProject {
    private int projectId;
    private String durationInMonths;

    public LongestProject(int projectId, String durationInMonths) {
        this.projectId = projectId;
        this.durationInMonths = durationInMonths;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "projectId=" + projectId +
                ", projectDuration=" + durationInMonths +
                '}';
    }
}
