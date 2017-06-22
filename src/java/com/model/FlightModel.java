/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.entities.Booking;
import com.entities.Cities;
import com.entities.FlightPlane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lamtu
 */
public class FlightModel extends DBContext<FlightPlane> {

    @Override
    public List<FlightPlane> getPassenger() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FlightPlane> getCity() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FlightPlane> searchFlightDeparture(String xFromCity, String xToCity, String xDeparture) throws SQLException, Exception {
        List<FlightPlane> list = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            list = new ArrayList<FlightPlane>();
            // get connection
            conn = super.getConnection();

            String sql = "";

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = df.parse(xDeparture);
            java.sql.Date departure = new java.sql.Date(date.getTime());

            sql = "select f.FlightID,f.FromCity,f.ToCity,f.Duration,p.PlaneID,p.DepartureDate,p.DepartureTime,p.Fare "
                    + " from Flight f,Plane p "
                    + " where  p.FlightID=f.FlightID and p.DepartureDate = ? and f.FromCity = ? and f.ToCity = ? ";

            if (conn != null) {
                ps = conn.prepareStatement(sql);
                ps.setDate(1, departure);
                ps.setString(2, xFromCity);
                ps.setString(3, xToCity);
                rs = ps.executeQuery();
            }

            while (rs.next()) {

                int flightID = rs.getInt("FlightID");
                String fromCity = rs.getString("FromCity");
                String toCity = rs.getString("ToCity");
                float duration = rs.getFloat("Duration");
                String planeID = rs.getString("PlaneID");
                float fare = rs.getFloat("Fare");
                String departureTime = rs.getString("DepartureTime");
                String departureDate = rs.getString("DepartureDate");
                String arrives = "";

                FlightPlane fp = new FlightPlane(flightID, fromCity, toCity, duration, planeID, fare, departureTime, departureDate, arrives);
                list.add(fp);

            }
            rs.close();
            ps.close();
            conn.close();
            super.closeConnection();

        } catch (Exception e) {
            System.out.println("Error sql search flight departure:" + e.toString());

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
    public List<FlightPlane> searchFlightReturn(String xFromCity, String xToCity, String xReturn) throws SQLException, Exception {
        List<FlightPlane> list = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            list = new ArrayList<FlightPlane>();
            // get connection
            conn = super.getConnection();

            String sql = "";

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = df.parse(xReturn);
            java.sql.Date xreturn = new java.sql.Date(date.getTime());

            sql = "select f.FlightID,f.FromCity,f.ToCity,f.Duration,p.PlaneID,p.DepartureDate,p.DepartureTime,p.Fare "
                    + " from Flight f,Plane p "
                    + " where  p.FlightID=f.FlightID and p.DepartureDate = ? and f.FromCity = ? and f.ToCity = ? ";

            if (conn != null) {
                ps = conn.prepareStatement(sql);
                ps.setDate(1, xreturn);
                ps.setString(2, xToCity);
                ps.setString(3, xFromCity);
                rs = ps.executeQuery();
            }

            while (rs.next()) {

                int flightID = rs.getInt("FlightID");
                String fromCity = rs.getString("FromCity");
                String toCity = rs.getString("ToCity");
                float duration = rs.getFloat("Duration");
                String planeID = rs.getString("PlaneID");
                float fare = rs.getFloat("Fare");
                String departureTime = rs.getString("DepartureTime");
                String departureDate = rs.getString("DepartureDate");
                String arrives = "";

                FlightPlane fp = new FlightPlane(flightID, fromCity, toCity, duration, planeID, fare, departureTime, departureDate, arrives);
                list.add(fp);

            }
            rs.close();
            ps.close();
            conn.close();
            super.closeConnection();

        } catch (Exception e) {
            System.out.println("Error sql search flight return:" + e.toString());

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
        System.out.println("list:" + list.size());
        return list;
    }

  

    @Override
    public boolean addBooking(FlightPlane t) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addPassenger(FlightPlane t) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FlightPlane> searchBooking(String code,String Email,boolean condition) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
