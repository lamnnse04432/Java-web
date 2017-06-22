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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lamtu
 */
public class SearchBookingServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */

        DBContext bookingContext = new BookingModel();
        bookingContext.setContext(getServletContext());
        HttpSession session = request.getSession(true);
        FormatList f = new FormatList();
        try {
            if (request.getParameter("btnSearch") != null) {
                String type = request.getParameter("type");
                if (type.equals("1")) {
                    String reservationCode = request.getParameter("txtSearch");
                    ArrayList<Booking> listSearch = (ArrayList<Booking>) bookingContext.searchBooking(reservationCode, "", true);
                    if (listSearch.size() == 0) {
                        request.setAttribute("error", "error");
                        request.setAttribute("code", reservationCode);

                        request.getRequestDispatcher("SearchBooking.jsp").forward(request, response);
                    } else {
                        ArrayList<Booking> listFormat = f.Format(listSearch);
                        request.setAttribute("DetailBooking", listFormat);
                        request.getRequestDispatcher("ManageBooking.jsp").forward(request, response);
                    }

                } else {
                    Passengers p = (Passengers) request.getSession().getAttribute("user");
                    ArrayList<Booking> listSearch = (ArrayList<Booking>) bookingContext.searchBooking("", p.getEmail(), false);
                    ArrayList<Booking> listFormat = f.Format(listSearch);
                    request.setAttribute("DetailBooking", listFormat);
                    request.getRequestDispatcher("ManageBooking.jsp").forward(request, response);
                }
            } else {

                if (request.getSession().getAttribute("user") == null) {
                    // not yet login back to log in

                    request.getRequestDispatcher("Login.jsp").forward(request, response);

                } else if (request.getSession().getAttribute("user") != null) {

                    request.getRequestDispatcher("SearchBooking.jsp").forward(request, response);

                }
            }
        } catch (Exception e) {
            System.out.println("Error seach booking servlet :" + e.toString());
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
        processRequest(request, response);
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
        processRequest(request, response);
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
