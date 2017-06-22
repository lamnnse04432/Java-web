/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lamtu
 */
public class DateTime {

    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String stringDate = dateFormat.format(date);
        return stringDate;
    }

    public String getTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String stringDate = dateFormat.format(date);
        return stringDate;
    }
    public static void main(String[] args) {
        DateTime d=new DateTime();
        String time =d.getTime();
        System.out.println("time:"+time);
    }
}
