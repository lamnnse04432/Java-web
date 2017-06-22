/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entities.Booking;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.servlet.ServletContext;

/**
 *
 * @author Tan
 */
public abstract class DBContext<T> {

    private final String CMS_FILE_PATH = "/WEB-INF/cms.properties";
    /**
     * declaration connection
     */
    private Connection connection;

    /**
     * constant username
     */
    private final String USER_NAME = "username";

    /**
     * constant password
     */
    private final String PASS_WORD = "password";

    /**
     * constant internet protocol
     */
    private final String IP = "ip";

    /**
     * constant database name
     */
    private final String DATABASE_NAME = "database";

    /**
     * constant port number
     */
    private final String PORT = "port";

    /**
     * constant connection string
     */
    private final String URL_STRING = "url";
    /**
     * constant connection string
     */
    private final String DRIVER_STRING = "driver";

    /**
     * Get the value of connection
     *
     * @return Connection
     *
     * @throws java.lang.Exception
     */
    public Connection getConnection() throws Exception {
        String urlString;
        String ip;
        String port;
        String database;
        String username;
        String password;
        String driver;

        Properties properties = new Properties();
        try {
            InputStream is = context.getResourceAsStream(CMS_FILE_PATH);
            properties.load(is); // list property from properties file
            // get all properties
            urlString = properties.getProperty(URL_STRING).trim();
            ip = properties.getProperty(IP).trim();
            port = properties.getProperty(PORT).trim();
            database = properties.getProperty(DATABASE_NAME);
            username = properties.getProperty(USER_NAME);
            password = properties.getProperty(PASS_WORD);
            driver = properties.getProperty(DRIVER_STRING);
            // get connection 
            //  jdbc:sqlserver://l..
            Class.forName(driver);
            connection = DriverManager.getConnection(urlString + ip + ":" + port + ";databaseName=" + database, username, password);

        } catch (Exception ex) {
            // with have any error nothing return
            return null;
        }
        return connection;
    }

    /**
     * Close connection to database
     *
     * @throws java.lang.Exception
     */
    public void closeConnection() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
    private ServletContext context;
    public void setContext(ServletContext context){
        this.context=context;
    }
    
    
    public abstract List<T>getPassenger()throws SQLException,Exception ;
    public abstract List<T>getCity()throws SQLException,Exception ;
    public abstract boolean addBooking(T t)throws SQLException,Exception ;
    public abstract boolean addPassenger(T t)throws SQLException,Exception ;
    public abstract List<T>searchFlightDeparture(String fromCity,String toCity,String departure)throws SQLException,Exception ;
    public abstract List<T>searchFlightReturn(String fromCity,String toCity,String xReturn)throws SQLException,Exception ;
    public abstract List<T>searchBooking(String code,String Email,boolean condition)throws SQLException,Exception ;


    
}
