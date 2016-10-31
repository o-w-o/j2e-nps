/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nps.util;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dot
 */
public class DB {

    /**
     * 声明连接数据库的信息,例如数据库URL,用户名及密码
     */
    private static final String URL = "jdbc:mysql://localhost:3306/nps";
    private static final String USER = "root";
    private static final String PASSWORD = "123";

    /**
     * 声明JDBC的相关对象
     */
    protected static Statement statement = null;
    protected static ResultSet resultSet = null;
    protected static Connection conn = null;

    /**
     * 创建数据库链接
     *
     * @return conn
     */
    public static synchronized Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
        }

        return conn;
    }
    
    /**
     * 执行INSERT,UPDATE,DELETE语句
     * @param sql SQL语句,字符串类型
     * @return 执行结果, int类型
     */
    public static int executeUpdate(String sql){
        int result = 0;
        try {
            statement = (Statement) getConnection().createStatement();
            result = statement.executeUpdate(sql);
        } catch (SQLException e) {
        }
        return result;
    }
    
    /**
     * 执行SELECT语句
     * @param sql SQL语句,字符串类型
     * @return ResultSet 结果集
     */
    public static ResultSet executeQuery(String sql){
        try {
            statement = (Statement) getConnection().createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (Exception e) {
        }
        return resultSet;
    }
    
    /**
     * 执行动态SQL语句
     * @param sql 含参数的动态SQL语句
     * @return 返回 PreparedStatement 对象
     */
    public static PreparedStatement executePreparedStatement(String sql){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(sql);
        } catch (Exception e) {
        }
        
        return preparedStatement;
    }
    
    /**
     * 事务回滚
     */
    public static void rollback(){
        try {
            getConnection().rollback();
        } catch (SQLException e) {
        }
    }
    
    /**
     * 关闭数据库连接对象
     */
    public static void close(){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            
            if (statement != null) {
                statement.close();
            }
            
            if (conn != null) {
                conn.close();
            }
            
        } catch (SQLException e) {
        }
    }
}
