<%-- 
    Document   : SearchBooking
    Created on : May 20, 2017, 10:04:24 PM
    Author     : lamtu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/Header.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/main.css" rel="stylesheet" type="text/css"/>
        <title>Search Booking</title>
    </head>
    <body>
        <jsp:include page="Header.jsp"/> 
        <c:if test="${error != null}">
            <script>
                alert('Not Found !');

            </script>
        </c:if>   
            <form id="search" action="SearchBookingServlet" method="POST">       </form>
        <div class="search">

            <table class="login">
                <td>
                    <h2>Search Booking</h2>
                </td>
                <tr>
                    <td>
                        <input type="radio" name="type" value="1" checked form="search"/>   Reservation Code
                    </td>
                    <td>

                        <input type="radio" name="type" value="0" form="search"/>    All Bookings
                    </td>
                </tr>

                <tr>
                    <td>
                        Enter Code :
                    </td>
                    <td>
                        <input type="text" name="txtSearch" value="${code}" form="search"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                         <input  class="button default" type="submit" value="Search" name="btnSearch" form="search"/>
                    </td>
                </tr>
            </table>
         
        </div>
    </body>
</html>
