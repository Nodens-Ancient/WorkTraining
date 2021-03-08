package com.company.framework;


import com.company.utils.DataBaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DataBaseRequest {
    private final String tableName;
    private final String criteria;

    public DataBaseRequest(String tableName, String criteria){
        this.tableName = tableName;
        this.criteria = criteria;
    }

    public void PerformRequest(Connection connection){
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from " + this.tableName + " where " + this.criteria);
            DataBaseUtil.PrintTable(resultSet);
        }
        catch (SQLException sqlException){
            System.out.println("Connection error");
        }
    }
}
