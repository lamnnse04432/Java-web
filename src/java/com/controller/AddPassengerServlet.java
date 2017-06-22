/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Passengers;
import com.model.DBContext;
import com.model.PassengerModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lamtu
 */
public class AddPassengerServlet extends HttpServlet {

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

        try {
            Encryption e = new Encryption();
            DBContext passengerContext = new PassengerModel();
            passengerContext.setContext(getServletContext());

            boolean checkDuplicate = false;
            boolean checkPass = false;
            String email = request.getParameter("txtEmail");
            String password = request.getParameter("txtPassword");
            String verifyPassword = request.getParameter("txtVerifyPassword");
            String fistName = request.getParameter("txtFistName");
            String lastName = request.getParameter("txtLastName");
            String address = request.getParameter("txtAddress");
            int phoneNumber = Integer.parseInt(request.getParameter("txtPhoneNumber"));
            String sex = request.getParameter("txtSex");
            int age = Integer.parseInt(request.getParameter("txtAge"));
            int cardNumber = Integer.parseInt(request.getParameter("txtCardNumber"));

            ArrayList<Passengers> listP = (ArrayList<Passengers>) passengerContext.getPassenger();

            for (int i = 0; i < listP.size(); i++) {
                if (listP.get(i).getEmail().equals(email)) {
                    checkDuplicate = true;
                }

            }
            if (!password.equals(verifyPassword)) {
                checkPass = true;
            }
            if (checkDuplicate == true) {
                request.setAttribute("error", "Email already in DB");
                request.setAttribute("email", email);
                request.setAttribute("fistName", fistName);
                request.setAttribute("lastName", lastName);
                request.setAttribute("address", address);
                request.setAttribute("phoneNumber", phoneNumber);
                request.setAttribute("sex", sex);
                request.setAttribute("age", age);
                request.setAttribute("cardNumber", cardNumber);

                request.getRequestDispatcher("AddPassenger.jsp").forward(request, response);
            } else if (checkPass == true) {
                request.setAttribute("error", "Verify password must eaqual password !");
                request.setAttribute("email", email);
                request.setAttribute("fistName", fistName);
                request.setAttribute("lastName", lastName);
                request.setAttribute("address", address);
                request.setAttribute("phoneNumber", phoneNumber);
                request.setAttribute("sex", sex);
                request.setAttribute("age", age);
                request.setAttribute("cardNumber", cardNumber);
                request.getRequestDispatcher("AddPassenger.jsp").forward(request, response);
            } else if (checkDuplicate == false && checkPass == false) {

                String passMD5 = e.encryption(password);
                Passengers p = new Passengers(email, passMD5, fistName, lastName, address, phoneNumber, sex, age, cardNumber);

                boolean check = passengerContext.addPassenger(p);
                System.out.println("check:" + check);
                request.getRequestDispatcher("#").forward(request, response);

            }
            checkDuplicate = false;
            checkPass = false;
        } catch (Exception e) {
            System.out.println("Error add passenger servlet:" + e.toString());
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
