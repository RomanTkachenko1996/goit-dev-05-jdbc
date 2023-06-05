package com.goit.feature.dbservice.dao;

import com.goit.feature.dbservice.entity.Client;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private PreparedStatement createSt;
    private PreparedStatement getByIdSt;
    private PreparedStatement selectMaxIdSt;
    private PreparedStatement updateNameById;
    private PreparedStatement getAllSt;
    private PreparedStatement deleteByIdSt;

    public ClientService(Connection connection) throws SQLException {
        createSt = connection.prepareStatement(
                "INSERT INTO client (name) VALUES (?);");
        getByIdSt = connection.prepareStatement(
                "SELECT name FROM client WHERE id = ?;");
        selectMaxIdSt = connection.prepareStatement(
                "SELECT MAX(id) AS max_id FROM client;");
        updateNameById = connection.prepareStatement(
                "UPDATE client SET name = ? WHERE id = ?;");
        getAllSt = connection.prepareStatement(
                "SELECT id, name FROM client;");
        deleteByIdSt = connection.prepareStatement(
                "DELETE FROM client WHERE id = ?;");
    }


    /**
     * Додає нового клієнта з іменем name. Повертає ідентифікатор щойно створеного клієнта.
     *
     * @param name
     * @return
     */
    public long create(String name) {
        int max = -1;
        try {
            createSt.setString(1, name);
            createSt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Failed size validation for the NAME");
        }
        return max;
    }

    /**
     * Повертає назву клієнта з ідентифікатором id
     *
     * @param id
     * @return
     */
    public String getById(long id) throws SQLException {
        getByIdSt.setLong(1, id);
        try (ResultSet rs = getByIdSt.executeQuery()) {
            if (!rs.next()) {
                return null;
            } else {
                Client client = new Client();
                client.setId(id);
                client.setName(rs.getString("name"));
                return client.getName();
            }

        }
    }

    /**
     * Встановлює нове ім'я name для клієнта з ідентифікатором id
     *
     * @param id
     * @param name
     */
    public void setName(long id, String name)  {
        try {
            updateNameById.setString(1, name);
            updateNameById.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed size validation for the NAME");
        }
        try {
            updateNameById.setLong(2, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Видаляє клієнта з ідентифікатором id
     *
     * @param id
     */
    public void deleteById(long id) throws SQLException {
        deleteByIdSt.setLong(1,id);
        deleteByIdSt.executeUpdate();
    }

    /**
     * Повертає всіх клієнтів з БД у вигляді колекції об'єктів типу Client
     * (цей клас створи сам, у ньому має бути 2 поля - id та name)
     *
     * @return
     */
    public List<Client> listAll() throws SQLException {
        List<Client> clients = new ArrayList<>();
        try (ResultSet rs = getAllSt.executeQuery()) {
            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getLong("id"));
                client.setName(rs.getString("name"));
                clients.add(client);
            }
        }
        return clients;
    }
}
