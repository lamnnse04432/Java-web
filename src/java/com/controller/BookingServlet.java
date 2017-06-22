/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Booking;
import com.entities.FlightPlane;
import com.entities.Passengers;
import com.model.BookingModel;
import com.model.DBContext;
import com.model.FlightModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lamtu
 */
public class BookingServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);

        FormatList f = new FormatList();
        try {

            String fromCity = request.getParameter("fromCity");
            String toCity = request.getParameter("toCity");
            String ticket = request.getParameter("ticket");
            String departure = request.getParameter("departure");

            String xReturn = request.getParameter("return");
            ArrayList<FlightPlane> listSearchDepart = null;
            ArrayList<FlightPlane> listSearchReturn = null;
            DBContext flightContext = new FlightModel();
            flightContext.setContext(getServletContext());

            if (ticket.equals("oneway")) {
                listSearchDepart = (ArrayList<FlightPlane>) flightContext.searchFlightDeparture(fromCity, toCity, departure);

                ArrayList<FlightPlane> listSearchDepartFormat = f.FormatListSearch(listSearchDepart, departure);
                request.setAttribute("listSearchDepart", listSearchDepartFormat);
                request.setAttribute("show", "off");

                request.getRequestDispatcher("Booking.jsp").forward(request, response);
            } else {
                listSearchDepart = (ArrayList<FlightPlane>) flightContext.searchFlightDeparture(fromCity, toCity, departure);
                listSearchReturn = (ArrayList<FlightPlane>) flightContext.searchFlightReturn(fromCity, toCity, xReturn);
                ArrayList<FlightPlane> listSearchDepartFormat = f.FormatListSearch(listSearchDepart, departure);
                ArrayList<FlightPlane> listSearchReturnFormat = f.FormatListSearch(listSearchReturn, departure);
            
                request.setAttribute("listSearchDepart", listSearchDepartFormat);
                request.setAttribute("listSearchReturn", listSearchReturnFormat);
                request.setAttribute("show", "on");
                request.getRequestDispatcher("Booking.jsp").forward(request, response);

            }
        } catch (Exception e) {
            System.out.println("Error booking servlet :" + e.toString());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(BookingServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(BookingServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
