<%-- 
    Document   : ManageBooking
    Created on : May 17, 2017, 9:18:46 AM
    Author     : lamtu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/Header.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/managerbooking.css" rel="stylesheet" type="text/css"/>
        

        <title>Manage Booking</title>
    </head>
    <jsp:include page="Header.jsp"/> 
    <body>
        <div class="index">
        <h2 class="text-red">eTicket Receipt</h2>
        <h4>Prepared For</h4>
        <c:forEach var="m"  items="${DetailBooking}" >

            <p>  <h4>${m.fistName} , ${m.lastName} </h4>
            <p> <h4>RESERVATION CODE:  ${m.reservationCode}</h4>
            <p> <h4>Ticket issue date :  ${m.bookingDate} ${m.bookingTime} </h4>
            
            <p><h2 class="text-red">Itinerary Details</h2>

            <table class="location">
                <th>TRAVEL DATE</th>
                <th>DEPARTURE</th>
                <th>ARRIVAL</th>

                <tr>
                    <td>${m.departureDate}</td>


                    <td>
                        ${m.fromCity}<br>
                        Time: ${m.departureTime}
                    </td>


                    <td>
                        ${m.toCity}<br>
                        Time : ${m.arrival}
                    </td>
                </tr>

            </table>
                    <table class="borderTable">
                        <tr>
                            <td>
                                
                            </td>
                        </tr>
                    </table>
        </c:forEach>
            </div>
    </body>
</html>
