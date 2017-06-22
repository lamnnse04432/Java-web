<%-- 
    Document   : Header
    Created on : May 22, 2017, 9:03:28 AM
    Author     : lamtu
--%>

<%@page import="com.entities.Passengers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    Passengers p = (Passengers) request.getSession().getAttribute("user");
    if (p == null) {
        request.setAttribute("images1", "resources/images/home.png");
        request.setAttribute("name1", "Login");
        request.setAttribute("link1", "Login.jsp");

        request.setAttribute("images2", "resources/images/register.png");
        request.setAttribute("name2", "Register");
        request.setAttribute("link2", "AddPassenger.jsp");
    } else {
        request.setAttribute("images1", "resources/images/home.png");
        request.setAttribute("name1", p.getFirstName());
        request.setAttribute("link1", "#");

        request.setAttribute("images2", "resources/images/quit.png");
        request.setAttribute("name2", "LogOut");
        request.setAttribute("link2", "LoginServlet?action=logOut");
    }

%>
<header>
    <div class="logo">
        <a href="#"><img  src="resources/images/logo.png"></a>
        Fast , Frequent & Safe Fight
    </div>


    <div class="controll">
        <table>
            <tr>
                <td>
                    <a href=${link1}><img  src=${images1}></a><br>
                        ${name1}
                </td>
                <td>
                    <a href=${link2}><img  src=${images2}></a><br>
                        ${name2}
                </td>
            </tr>
        </table>
    </div>
    <div class="menu-item">
        <ul>

            <li>
                <a href="HomeServlet">
                    Home
                </a>
            </li>
            <li>
                <a href="HomeServlet">
                    Book
                </a>
            </li>
            <li>
                <a href="SearchBookingServlet">
                    Manage Booking
                </a>
            </li>
        </ul>

    </div>
</header>


