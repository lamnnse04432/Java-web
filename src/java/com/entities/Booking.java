/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

/**
 *
 * @author lamtu
 */
public class Booking {
    private String bookingID;
    private String email;
    private String planeID;
    private String bookingDate;
    private String bookingTime;
    private String reservationCode;


    private String fistName;
    private String lastName;
    private int flightID;
    private float fare;
    private String departureDate;
    private String departureTime;
    private String fromCity;
    private String toCity;
    private float duration;
    private String arrival;
    public Booking() {
    }

    public Booking( String email, String planeID, String bookingDate, String bookingTime, String reservationCode) {
      
        this.email = email;
        this.planeID = planeID;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.reservationCode = reservationCode;
    }
   public Booking(String reservationCode, String email, String planeID, String bookingDate, String bookingTime, String fistName, String lastName, int flightID, float fare, String departureDate, String departureTime, String fromCity, String toCity, float duration) {
        this.reservationCode = reservationCode;
        this.email = email;
        this.planeID = planeID;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.fistName = fistName;
        this.lastName = lastName;
        this.flightID = flightID;
        this.fare = fare;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.duration = duration;
      
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }
   
   
    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

 
    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

 

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlaneID() {
        return planeID;
    }

    public void setPlaneID(String planeID) {
        this.planeID = planeID;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }


    
    
}
