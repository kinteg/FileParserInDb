package com.kinteg.FileParserInDb.app.impl;

import com.kinteg.FileParserInDb.app.TestConnection;
import com.kinteg.FileParserInDb.lib.common.model.CustomConnection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnectionImpl implements TestConnection {

    @Override
    public boolean testConnection(CustomConnection customConnection) {

        try {
            DriverManager.getConnection(
                    customConnection.getURL(),
                    customConnection.getUsername(),
                    customConnection.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
