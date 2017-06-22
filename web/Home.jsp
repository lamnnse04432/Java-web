<%-- 
    Document   : Home
    Created on : May 9, 2017, 11:23:35 PM
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

        <title>Home</title>
    </head>
    <script src="resources/js/main.js" type="text/javascript"></script>
    <body> 
        <script>
            function myFunction() {
                var fromCity = document.getElementById("fromCity").value;
                var toCity = document.getElementById("toCity").value;
                var depart = document.getElementById("depart").value;
                var xReturn = document.getElementById("xReturn").value;
                var xReturn = document.getElementById("xReturn").value;
                var ticket = document.getElementById("ticket").checked;
                var checkCity = false;
                var checkDate = false;
               
                if (ticket == false) {
                    if (fromCity == toCity) {
                        alert('Please chossen from city and to city is diffrent !');
                        checkCity = true;
                    }
                    if (checkCity == false) {
                        return true;
                    } else {
                        return false
                    }
                } else {
                    if (fromCity == toCity) {
                        alert('Please chossen from city and to city is diffrent !');
                        checkCity = true;
                    }

                    if (depart == xReturn) {
                        alert('Please chossen department and return is diffrent !');
                        checkDate = true;
                    }

                    if (checkCity == false && checkDate == false) {
                        return true;
                    } else {
                        return false
                    }
                }
            }
            function show() {
               
                document.getElementById("test").hidden=false;
            }
             function hide() {
                 
                document.getElementById("test").hidden=true;
            }
        </script>
        <div id="page-wrapper">
            <jsp:include page="Header.jsp"/> 
            <div id="wrapper" class="home">
                <div class="main">
                    <form id="search" action="BookingServlet" method="POST" onsubmit="return myFunction()"></form>
                    <h1 class="default">Flight</h1>
                    <table class="home-tripform">

                        <tr>

                            <td>
                                <input type="radio" id="ticket" name="ticket" value="roundtrip"  form="search" onclick="show()" />Round trip
                            </td>
                            <td>
                                <input type="radio" name="ticket" value="oneway" form="search"  onclick="hide()"  checked/>One way

                            </td>

                        </tr>

                        <tr>
                            <td>
                                Room :
                            </td>
                            <td>

                                <select id="fromCity" name="fromCity" form="search">
                                    <c:forEach items="${listC}" var="m"> 
                                        <option  value="${m.cityName}">${m.cityName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                To : 
                            </td>
                            <td>
                                <select id="toCity"  name="toCity" form="search">
                                    <c:forEach items="${listC}" var="m"> 
                                        <option  value="${m.cityName}">${m.cityName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Departure : 
                            </td>
                            <td>
                                <input id="depart" type="date" name="departure" form="search"  value="" required />
                            </td>
                        </tr>

                        <tr hidden="true"   id="test">
                            <td >
                                Return : 
                            </td>
                            <td >
                                <input id="xReturn" type="date" name="return" form="search"  value="" /> 
                            </td>
                        </tr>



                        <tr>
                            <td colspan="2">
                                <input class="button default" type="submit" value="search" form="search" name="btnSearch" >

                            </td>
                        </tr>

                    </table>



                </div>

            </div>

        </div>
    </body>
</html>
