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
public class FlightPlane {
    private int flightID;
    private String fromCity;
    private String toCity;
    private float duration;
    private String planeID;
    private float fare;
    private String departTime;
    private String departDate;
    private String arrives;

    public FlightPlane() {
    }

    public FlightPlane(int flightID, String fromCity, String toCity, float duration, String planeID, float fare, String departTime, String departDate, String arrives) {
        this.flightID = flightID;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.duration = duration;
        this.planeID = planeID;
        this.fare = fare;
        this.departTime = departTime;
        this.departDate = departDate;
        this.arrives = arrives;
    }

   

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
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

    public String getPlaneID() {
        return planeID;
    }

    public void setPlaneID(String planeID) {
        this.planeID = planeID;
    }

 

    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getArrives() {
        return arrives;
    }

    public void setArrives(String arrives) {
        this.arrives = arrives;
    }

  
    
    
}
