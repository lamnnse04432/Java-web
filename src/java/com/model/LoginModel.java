/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entities.Booking;
import com.entities.Passengers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lamtu
 */
public class LoginModel extends DBContext<Passengers>{

    @Override
    public List<Passengers> getPassenger() throws SQLException, Exception {
         List<Passengers> list = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            list = new ArrayList<Passengers>();
            // get connection
            conn = super.getConnection();

            String sql = "";
            // check it have not condition
       
                sql = "SELECT * FROM Passengers  ";
            
            if (conn != null) {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                 String email=rs.getString("Email");
                 String password=rs.getString("Password");
                 String firstName=rs.getString("FirstName");
                 String lastName =rs.getString("LastName");
                 String address=rs.getString("Address");
                 int phoneNumber=rs.getInt("PhoneNumber");
                 String sex =rs.getString("Sex");
                 int age =rs.getInt("Age");
                 int cardNumber=rs.getInt("CardNumber");
                 
                 Passengers p=new Passengers( email, password, firstName, lastName, address, phoneNumber, sex, age, cardNumber);
                 list.add(p);
                 
                 

                }
            }
            rs.close();
            ps.close();
            conn.close();
            super.closeConnection();

        } catch (Exception e) {
            System.out.println("Error sql get passenger :" + e.toString());
          
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }

        }

        return list;
    }

    @Override
    public List<Passengers> getCity() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<Passengers> searchFlightDeparture(String fromCity, String toCity, String departure) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Passengers> searchFlightReturn(String fromCity, String toCity, String xReturn) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public boolean addBooking(Passengers t) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addPassenger(Passengers t) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Passengers> searchBooking(String code,String Email,boolean condition) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
