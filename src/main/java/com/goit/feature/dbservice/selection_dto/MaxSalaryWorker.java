package com.goit.feature.dbservice.selection_dto;


public class MaxSalaryWorker {
    private String workerName;
    private int salary;

    public MaxSalaryWorker(String workerName, int salary) {
        this.workerName = workerName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "MaxSalaryWorker{" +
                "workerName='" + workerName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
