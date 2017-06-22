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
public class BookingModel extends DBContext<Booking> {

    @Override
    public List<Booking> getPassenger() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Booking> getCity() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Booking> searchFlightDeparture(String fromCity, String toCity, String departure) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Booking> searchFlightReturn(String fromCity, String toCity, String xReturn) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addBooking(Booking b) throws SQLException, Exception {
        PreparedStatement ps = null;
        Connection conn = null;

        conn = super.getConnection();

        try {

            String sql = " insert into Bookings(Email,PlaneID,BookingDate,BookingTime,ReservationCode) values(?,?,?,?,?) ";

            if (conn != null) {
                ps = conn.prepareStatement(sql);
                ps.setString(1, b.getEmail());
                ps.setString(2, b.getPlaneID());

                ps.setString(3, b.getBookingDate());
                ps.setString(4, b.getBookingTime());
                ps.setString(5, b.getReservationCode());
                ps.executeUpdate();

            }

            ps.close();
            conn.close();
            super.closeConnection();

        } catch (Exception e) {
            System.out.println("Error sql  insert booking :" + e.toString());
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
    public boolean addPassenger(Booking t) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Booking> searchBooking(String code,String xEmail,boolean condition) throws SQLException, Exception {
        List<Booking> list = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            list = new ArrayList<Booking>();
            // get connection
            conn = super.getConnection();

            String sql = "";

            
            if (condition==true) {
                 sql = " select b.ReservationCode,b.Email,b.PlaneID,b.BookingDate,b.BookingTime,pg.FirstName,pg.LastName,p.FlightID,p.Fare,p.DepartureDate,p.DepartureTime,f.FromCity,f.ToCity,f.Duration "
                    + " from Flight f,Plane p ,Bookings b,Passengers pg "
                    + " where  p.FlightID=f.FlightID and p.PlaneID = b.PlaneID and b.Email=pg.Email and b.ReservationCode = ? ";

            if (conn != null) {
                ps = conn.prepareStatement(sql);

                ps.setString(1, code);
                rs = ps.executeQuery();
            }
            }else{
                 sql = " select b.ReservationCode,b.Email,b.PlaneID,b.BookingDate,b.BookingTime,pg.FirstName,pg.LastName,p.FlightID,p.Fare,p.DepartureDate,p.DepartureTime,f.FromCity,f.ToCity,f.Duration "
                    + " from Flight f,Plane p ,Bookings b,Passengers pg "
                    + " where  p.FlightID=f.FlightID and p.PlaneID = b.PlaneID and b.Email=pg.Email and b.Email = ? ";

            if (conn != null) {
                ps = conn.prepareStatement(sql);

                ps.setString(1, xEmail);
                rs = ps.executeQuery();
            }
            }
           

            while (rs.next()) {

                String reservationCode = rs.getString("ReservationCode");
                String email = rs.getString("Email");
                String planeID = rs.getString("PlaneID");
                String bookingDate = rs.getString("BookingDate");
                String bookingTime = rs.getString("BookingTime");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                int flightID = rs.getInt("FlightID");
                float fare = rs.getFloat("Fare");
                String departureDate = rs.getString("DepartureDate");
                String departureTime = rs.getString("DepartureTime");
                String fromCity = rs.getString("FromCity");
                String toCity = rs.getString("ToCity");
                float duration = rs.getFloat("Duration");

                Booking b = new Booking(reservationCode, email, planeID, bookingDate, bookingTime, firstName, lastName, flightID, fare, departureDate, departureTime, fromCity, toCity, duration);
                list.add(b);

            }
            rs.close();
            ps.close();
            conn.close();
            super.closeConnection();

        } catch (Exception e) {
            System.out.println("Error sql search booking:" + e.toString());

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

}
