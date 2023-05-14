package com.goit.feature.dbservice.tables_dto;

public class Client {
    public Client(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    private String name;

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                '}';
    }
}
