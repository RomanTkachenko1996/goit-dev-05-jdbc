package com.goit.feature.dbservice.selection_dto;


public class YoungestEldestWorkers {
    private String type;
    private String workerName;
    private String birthday;

    public YoungestEldestWorkers(String type, String workerName, String birthday) {
        this.type = type;
        this.workerName = workerName;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "YoungestEldestWorkers{" +
                "type='" + type + '\'' +
                ", workerName='" + workerName + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
