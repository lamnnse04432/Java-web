/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

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
public class PassengerModel extends DBContext<Passengers> {

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
    public boolean addBooking(Passengers t) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addPassenger(Passengers p) throws SQLException, Exception {
        PreparedStatement ps = null;
        Connection conn = null;

        conn = super.getConnection();

        try {

            String sql = " insert into Passengers(Email,Password,FirstName,LastName,Address,PhoneNumber,Sex,Age,CardNumber) values(?,?,?,?,?,?,?,?,?) ";

            if (conn != null) {
                ps = conn.prepareStatement(sql);

                ps.setString(1, p.getEmail());
                ps.setString(2, p.getPassword());
                ps.setString(3, p.getFirstName());
                ps.setString(4, p.getLastName());
                ps.setString(5, p.getAddress());
                ps.setInt(6, p.getPhoneNumber());
                if (p.getSex().equals("Female")) {
                       ps.setInt(7, 1);
                }else{
                     ps.setInt(7, 0);
                }
             
                ps.setInt(8, p.getAge());
                ps.setInt(9, p.getCardNumber());

                ps.executeUpdate();

            }

            ps.close();
            conn.close();
            super.closeConnection();

        } catch (Exception e) {
            System.out.println("Error sql  insert passengers :" + e.toString());
            return false;
        } finally {

            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return true;
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
    public List<Passengers> searchBooking(String code,String Email,boolean condition) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
