<%-- 
    Document   : Booking
    Created on : May 11, 2017, 8:22:30 AM
    Author     : lamtu
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/Header.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/Content.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/main.css" rel="stylesheet" type="text/css"/>
        <title>Booking</title>
    </head>
    <body>
        <script>
            function myFunction() {
                var checkA = document.getElementById("checkA").checked;
                var isShow = document.getElementById("isShow").value;
                if (isShow == 'off') {
                    if (checkA == false) {
                        alert('Please chossen flight');
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    var checkB = document.getElementById("checkB").checked;

                    if (checkA == false || checkB == false) {
                        alert('Please chossen flight');
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        </script>

        <jsp:include page="Header.jsp"/> 
        <form id="save" action="AddBookingServlet" method="POST" onsubmit="return myFunction()" >  </form>
        <c:if test="${listSearchDepart != null}">
            <h1 >1.Select Departing Flight</h1>
            <c:forEach items="${listSearchDepart}" var="m"> 
                <h2 class="info">Departure : ${m.fromCity} Return: ${m.toCity}</h2>
                <table >

                    <tr>
                        <td>
                            <h3>${m.fromCity} to ${m.toCity}</h3>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <h4 class="text-red">${m.departDate}</h4>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            Departs
                        </td>
                        <td>
                            Arrives
                        </td>
                        <td>
                            Right Detail
                        </td>
                    </tr>
                    <tr>
                        <td>
                            ${m.departTime}
                        </td>
                        <td>
                            ${m.arrives}
                        </td>
                        <td>
                            ${m.duration}H
                        </td>
                        <td class="text-fare">
                            <input id="checkA" type="checkbox" name="check" value="${m.planeID}" form="save" />
                            <input id="isShow" type="hidden" name="isShow" value="${show}" form="save" />
                            <fmt:setLocale value="en_US"/>
                            <fmt:formatNumber   type="currency" value="${m.fare}" />


                        </td>
                    </tr>


                </table>
            </c:forEach>
            <c:if test="${show != off}">

                <c:forEach items="${listSearchReturn}" var="n"> 
                    <h2 class="info"> Departure : ${n.fromCity}   Return: ${n.toCity}</h2>
                    <table >

                        <tr>
                            <td>
                                <h3>${n.fromCity} to ${n.toCity}</h3>
                            </td>

                        </tr>
                        <tr>
                            <td>
                                <h4 class="text-red">${n.departDate}</h4>
                            </td>

                        </tr>
                        <tr>
                            <td>
                                Departs
                            </td>
                            <td>
                                Arrives
                            </td>
                            <td>
                                Right Detail
                            </td>
                        </tr>
                        <tr>
                            <td>
                                ${n.departTime}
                            </td>
                            <td>
                                ${n.arrives}
                            </td>
                            <td>
                                ${n.duration}
                            </td>
                            <td class="text-fare">
                                <input id="checkB" type="checkbox" name="checkRound" value="${n.planeID}" form="save" />
                                <input type="hidden" name="roundtrip" value="roundtrip" form="save" />
                                <fmt:setLocale value="en_US"/>
                                <fmt:formatNumber   type="currency" value="${n.fare}" />

                            </td>
                        </tr>


                    </table>
                </c:forEach>

            </c:if> 
            <input type="submit" value="Save" name="btnSave" form="save" class="btn btn-submit location" />
        </c:if> 
    </body>
</html>
