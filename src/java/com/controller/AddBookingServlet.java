/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Booking;
import com.entities.Passengers;
import com.model.BookingModel;
import com.model.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
public class AddBookingServlet extends HttpServlet {

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
        DBContext bookingContext = new BookingModel();
        bookingContext.setContext(getServletContext());
        HttpSession session = request.getSession(true);
        DateTime date = new DateTime();
        RandomBookingID rdom = new RandomBookingID();
        FormatList f =new FormatList();
        String reservationCode = rdom.randomString();
        if (request.getParameter("btnSave") != null) {

            String roundTrip = request.getParameter("roundtrip");
            roundTrip = (roundTrip == null) ? "" : roundTrip;

            if (roundTrip.equals("")) {

                String planeID = request.getParameter("check");
                String dateBooking = date.getDate();
                String timeBooking = date.getTime();
                Booking b = new Booking("", planeID, dateBooking, timeBooking, reservationCode);

                if (request.getSession().getAttribute("user") == null) {
                    // not yet login back to log in
                    session.setAttribute("booking", b);

                    response.sendRedirect(request.getContextPath() + "/Login.jsp");

                } else if (request.getSession().getAttribute("user") != null) {
                     Passengers p = (Passengers) request.getSession().getAttribute("user");
                      b.setEmail(p.getEmail());
                    boolean check = bookingContext.addBooking(b);

                    if (check == true) {
                        ArrayList<Booking> listSearch = (ArrayList<Booking>) bookingContext.searchBooking(reservationCode,"",true);

                        ArrayList<Booking> listFormat = f.Format(listSearch);

                        request.setAttribute("DetailBooking", listFormat);
                        request.getRequestDispatcher("ManageBooking.jsp").forward(request, response);
                    }
                }
            } else {

                String planeID = request.getParameter("check");
                String planeIDRound = request.getParameter("checkRound");
                String dateBooking = date.getDate();
                String timeBooking = date.getTime();
                Booking b = new Booking("", planeID, dateBooking, timeBooking, reservationCode);
                Booking b1 = new Booking("", planeIDRound, dateBooking, timeBooking, reservationCode);

                if (request.getSession().getAttribute("user") == null) {
                    // not yet login back to log in
                    session.setAttribute("booking", b);
                    session.setAttribute("booking1", b1);

                    response.sendRedirect(request.getContextPath() + "/Login.jsp");

                } else if (request.getSession().getAttribute("user") != null) {

                      Passengers p = (Passengers) request.getSession().getAttribute("user");
                      b.setEmail(p.getEmail());
                      b1.setEmail(p.getEmail());
                    
                    boolean check = bookingContext.addBooking(b);
                    boolean check1 = bookingContext.addBooking(b1);

                    if (check == true && check1 == true) {
                        ArrayList<Booking> listSearch = (ArrayList<Booking>) bookingContext.searchBooking(reservationCode,"",true);

                        ArrayList<Booking> listFormat = f.Format(listSearch);

                        request.setAttribute("DetailBooking", listFormat);
                        request.getRequestDispatcher("ManageBooking.jsp").forward(request, response);
                    }

                }
            }
        } else {
            Passengers p = (Passengers) request.getSession().getAttribute("user");
            if (request.getSession().getAttribute("booking") != null && request.getSession().getAttribute("booking1") == null) {

                Booking b = (Booking) request.getSession().getAttribute("booking");

                b.setEmail(p.getEmail());
                boolean check = bookingContext.addBooking(b);

                if (check == true) {
                    ArrayList<Booking> listSearch = (ArrayList<Booking>) bookingContext.searchBooking(reservationCode,"",true);

                    ArrayList<Booking> listFormat = f.Format(listSearch);

                    request.setAttribute("DetailBooking", listFormat);
                    request.getRequestDispatcher("ManageBooking.jsp").forward(request, response);
                }

            } else if (request.getSession().getAttribute("booking") != null && request.getSession().getAttribute("booking1") != null) {
                Booking b = (Booking) request.getSession().getAttribute("booking");
                Booking b1 = (Booking) request.getSession().getAttribute("booking1");

                b.setEmail(p.getEmail());
                boolean check = bookingContext.addBooking(b);
                boolean check1 = bookingContext.addBooking(b1);

                   if (check == true && check1 == true) {
                        ArrayList<Booking> listSearch = (ArrayList<Booking>) bookingContext.searchBooking(reservationCode,"",true);

                        ArrayList<Booking> listFormat = f.Format(listSearch);

                        request.setAttribute("DetailBooking", listFormat);
                        request.getRequestDispatcher("ManageBooking.jsp").forward(request, response);
                    }
            }

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
            Logger.getLogger(AddBookingServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddBookingServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
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
