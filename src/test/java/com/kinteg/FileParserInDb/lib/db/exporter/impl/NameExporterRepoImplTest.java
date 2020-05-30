package com.kinteg.FileParserInDb.lib.db.exporter.impl;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NameExporterRepoImplTest {

    private final NameExporterRepoImpl nameExporterRepo;
    private final Connection connection;

    public NameExporterRepoImplTest() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/iac5", "postgres", "1");
        nameExporterRepo = new NameExporterRepoImpl(connection);
    }

    @Test
    public void exportNames() throws SQLException {
        System.out.println(nameExporterRepo.exportNames());
    }

    @Test
    public void exportNames1() throws SQLException {
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM pattern LIMIT 5");
            System.out.println(resultSetToList(resultSet));
        }
    }


    private List<Map<String, String>> resultSetToList(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        List<Map<String, String>> rows = new ArrayList<>();
        while (rs.next()){
            Map<String, String> row = new HashMap<>(columns);
            for(int i = 1; i <= columns; ++i){
                row.put(md.getColumnName(i), rs.getString(i));
            }
            rows.add(row);
        }
        return rows;
    }

}