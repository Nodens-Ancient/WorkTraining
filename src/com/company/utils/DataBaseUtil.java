package com.company.utils;

import com.company.framework.DataBaseRequest;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseUtil {
    private ArrayList<DataBaseRequest> requestList = new ArrayList<>();
    private Connection connection;
    private Statement statement;

    public DataBaseUtil(Connection connection){
        this.connection = connection;
        try {
            this.statement = this.connection.createStatement();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void SetRequestList(DataBaseRequest request){
        requestList.add(request);
    }

    public void GetRequest(){
        for (DataBaseRequest request:
             requestList) {
            request.PerformRequest(this.connection);
        }
    }

    public void GenerateTable(){
        try {
            this.statement.executeUpdate("INSERT tabletask14(spending, paymentID) VALUES (6000, 121675), (7200, 121675), (5000, 121675)");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void AddSpendingToTable(int spendingValue, int paymentID){
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT tabletask14(spending, paymentID) VALUES (?,?)");
            preparedStatement.setInt(1, spendingValue);
            preparedStatement.setInt(2, paymentID);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    public static void PrintTable(String tableName, Connection connection){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from " + tableName);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()){
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++){
                    System.out.print(resultSet.getString(i) + " ");
                }
                System.out.println();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    public static void PrintTable(ResultSet resultSet){
        try{
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()){
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++){
                    System.out.print(resultSet.getString(i) + " ");
                }
                System.out.println();
            }
        }
        catch (SQLException sqlException){
            System.out.println("PrintTable Error");
        }
    }
}
