/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entities.Cities;
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
public class CityModel extends DBContext<Cities> {

    @Override
    public List<Cities> getPassenger() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cities> getCity() throws SQLException, Exception {
        List<Cities> list = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            list = new ArrayList<Cities>();
            // get connection
            conn = super.getConnection();

            String sql = "";
            // check it have not condition

            sql = "SELECT * FROM Cities  ";

            if (conn != null) {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {

                    int cityID = rs.getInt("CityID");
                    String cityName = rs.getString("CityName");

                    Cities c = new Cities(cityID, cityName);
                    list.add(c);

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
        System.out.println("list:"+list.size());
        return list;
    }



    @Override
    public List<Cities> searchFlightDeparture(String fromCity, String toCity, String departure) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cities> searchFlightReturn(String fromCity, String toCity, String xReturn) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addBooking(Cities t) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addPassenger(Cities t) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cities> searchBooking(String code,String Email,boolean condition) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


