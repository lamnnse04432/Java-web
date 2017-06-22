/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Booking;
import com.entities.FlightPlane;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author lamtu
 */
public class FormatList {

    public ArrayList<Booking> Format(ArrayList<Booking> list) throws ParseException {

        for (int i = 0; i < list.size(); i++) {
            String bookingTime = list.get(i).getBookingTime();
            String bookingTime24 = bookingTime.replace(".0000000", "");
            String bookingTime1 = CounvertHours(bookingTime24, false);
            list.get(i).setBookingTime(bookingTime1);

            String temp = list.get(i).getDepartureTime();

            String temp1 = temp.replace(":00.0000000", "");

            String temp2 = temp1.replace(":", ".");

            float temp3 = Float.parseFloat(temp2);

            float temp4 = temp3 + list.get(i).getDuration();

            if (temp4 <= 24) {
                String timeDepart = String.format("%.2f", temp3);

                String timeDepart24 = timeDepart.replace(".", ":");
                String timeDepart1 = CounvertHours(timeDepart24, true);

                String timeArries = String.format("%.2f", temp4);

                String timeArries24 = timeArries.replace(".", ":");
                String timeArries1 = CounvertHours(timeArries24, true);

                String timeArries2 = list.get(i).getDepartureDate() + " (" + timeArries1 + ")";

                list.get(i).setDepartureTime(timeDepart1);
                list.get(i).setArrival(timeArries2);

            } else {
                String timeDepart = String.format("%.2f", temp3);
                String timeDepart24 = timeDepart.replace(".", ":");
                String timeDepart1 = CounvertHours(timeDepart24, true);

                float temp5 = temp4 - 24;
                String timeArries = String.format("%.2f", temp4);
                String timeArries24 = timeArries.replace(".", ":");
                String timeArries1 = CounvertHours(timeArries24, true);

//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                Date myDate = dateFormat.parse(list.get(i).getDepartureDate());
//                Calendar calendar = Calendar.getInstance();
//                calendar.setTime(myDate);
//                calendar.add(Calendar.DAY_OF_MONTH, 1);
//                String arrives = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
//               
                String arrives = CounterDay(list.get(i).getDepartureDate()) + "( " + timeArries1 + " )";
                list.get(i).setDepartureTime(timeDepart1);
                list.get(i).setArrival(arrives);
            }

        }
        return list;
    }

    public ArrayList<FlightPlane> FormatListSearch(ArrayList<FlightPlane> list, String departure) throws ParseException {

        for (int i = 0; i < list.size(); i++) {

            String temp = list.get(i).getDepartTime();

            String temp1 = temp.replace(":00.0000000", "");

            String temp2 = temp1.replace(":", ".");

            float temp3 = Float.parseFloat(temp2);

            float temp4 = temp3 + list.get(i).getDuration();

            if (temp4 <= 24) {
                String timeDepart = String.format("%.2f", temp3);

                String timeDepart24 = timeDepart.replace(".", ":");
                String timeDepart1 = CounvertHours(timeDepart24, true);

                String timeArries = String.format("%.2f", temp4);

                String timeArries24 = timeArries.replace(".", ":");
                String timeArries1 = CounvertHours(timeArries24, true);
                String timeArries2 = departure + " (" + timeArries1 + ")";

                list.get(i).setDepartTime(timeDepart1);
                list.get(i).setArrives(timeArries2);

            } else {

                String timeDepart = String.format("%.2f", temp3);
                String timeDepart24 = timeDepart.replace(".", ":");
                String timeDepart1 = CounvertHours(timeDepart24, true);

                float temp5 = temp4 - 24;
                String timeArries = String.format("%.2f", temp5);
                String timeArries24 = timeArries.replace(".", ":");
                String timeArries1 = CounvertHours(timeArries24, true);

//                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                Date myDate = dateFormat.parse(departure);
//                Calendar calendar = Calendar.getInstance();
//                calendar.setTime(myDate);
//                calendar.add(Calendar.DAY_OF_MONTH, 1);
//
//                String arrives = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
                String arrives = CounterDay(departure) + "( " + timeArries1 + " )";
                list.get(i).setDepartTime(timeDepart1);
                list.get(i).setArrives(arrives);
            }

        }
        return list;
    }

    private String CounterDay(String departureDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myDate = dateFormat.parse(departureDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        return calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
    }

    private String CounvertHours(String hours, boolean condition) throws ParseException {
        DateFormat df = null;
        DateFormat outputformat = null;
        if (condition == true) {
            df = new SimpleDateFormat("HH:mm");

            outputformat = new SimpleDateFormat("hh:mm a");
        } else {
            df = new SimpleDateFormat("HH:mm:ss");

            outputformat = new SimpleDateFormat("hh:mm:ss a");
        }
        Date date = null;
        String output = null;

        //      Conversion of input String to date
        date = df.parse(hours);
        //        old date format to new date format
        output = outputformat.format(date);

        return output;
    }

}
