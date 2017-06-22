/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Passengers;
import com.model.DBContext;
import com.model.LoginModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author lamtu
 */
public class LoginServlet extends HttpServlet {

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
        Encryption e = new Encryption();
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
     
        String action = request.getParameter("action");
        if (request.getParameter("btnLogin") != null) {
            //   try {
            DBContext passengerContex = new LoginModel();
            passengerContex.setContext(getServletContext());

            String email = request.getParameter("txtEmail");
            String password = request.getParameter("txtPassword");

            String passMD5 = e.encryption(password);

            ArrayList<Passengers> listP = (ArrayList<Passengers>) passengerContex.getPassenger();
            boolean isHave = false;
            if (email != null && password != null) {
                for (int i = 0; i < listP.size(); i++) {
                    if (listP.get(i).getEmail().equals(email)) {

                        if (listP.get(i).getPassword().equals(passMD5)) {
                            Passengers p = new Passengers(listP.get(i).getEmail(), listP.get(i).getPassword(), listP.get(i).getFirstName(), listP.get(i).getLastName(), listP.get(i).getAddress(), listP.get(i).getPhoneNumber(), listP.get(i).getSex(), listP.get(i).getAge(), listP.get(i).getCardNumber());
                            session.setMaxInactiveInterval(60 * 60 * 5);//trả về khoảng thời gian bằng giây để  giữ đăng nhập của client
                            session.setAttribute("user", p);
                            isHave = true;
                            break;

                        }
                    }
                }
                if (isHave == false) {
                    // set paramater for text
                    request.setAttribute("email", email);
                    request.setAttribute("password", password);
                    // set param error
                    request.setAttribute("error", "Wrong username or password ! <br> Try Again !!");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                } else {

                    if (request.getSession().getAttribute("booking") != null) {
                        request.getRequestDispatcher("AddBookingServlet").forward(request, response);
                    } else {
                        request.getRequestDispatcher("HomeServlet").forward(request, response);
                    }

                }
            } else {
            
                    // has been logged in
                    request.setAttribute("error", "Please input email and password");
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                
            }

//            } catch (Exception e) {
//                System.out.println("Error login servlet :"+e.toString());
//            }
        } else if (action.equals("logOut")) {
          
          
            if (request.getSession().getAttribute("user") != null) {
                if (session.getAttribute("user") != null) {
                    session.removeAttribute("user");
                    session.invalidate();

                }
                RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.include(request, response);
              
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
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
