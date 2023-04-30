package com.goit.feature.dbservice.selection_dto;

public class ProjectPrices {
    private int projectId;
    private int projectPrice;

    public ProjectPrices(int projectId,int projectPrice) {
        this.projectId = projectId;
        this.projectPrice = projectPrice;
    }

    @Override
    public String toString() {
        return "ProjectPrices{" +
                "projectId=" + projectId +
                ", projectPrice=" + projectPrice +
                '}';
    }
}
