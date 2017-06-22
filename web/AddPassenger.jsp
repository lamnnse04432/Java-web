<%-- 
    Document   : AddPassenger
    Created on : May 14, 2017, 10:21:27 AM
    Author     : lamtu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/Header.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/Content.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/main.css" rel="stylesheet" type="text/css"/>
        <title>Add Passenger</title>
    </head>
    <body>
          <jsp:include page="Header.jsp"/> 
        <c:if test="${error != null}">
            <script>
                alert('${error}');
            </script>
        </c:if>    
        <form  action="AddPassengerServlet" method="POST">

            <table class="content-body-table">
                <td colspan="2">
                    <h1 class="text-red">Register</h1>
                </td>
                <tr>
                    <td colspan="2" class="text-red">
                        New Account
                    </td>
                </tr>
                <tr>
                    <td class="text-alignLeft">
                        Email : 
                    </td>
                    <td>
                        <input type="text" name="txtEmail" required="" value="${email}">

                    </td>
                </tr>
                <tr>
                    <td class="text-alignLeft">
                        Password : 
                    </td>
                    <td>
                        <input type="password" name="txtPassword" required="" value="">

                    </td>
                </tr>
                <tr>
                    <td class="text-alignLeft">
                        Verify Password : 
                    </td>
                    <td>
                        <input type="password" name="txtVerifyPassword" required="" value="">

                    </td>
                </tr>
                <tr>
                    <td colspan="2" class="text-red">
                        Contact Information
                    </td>
                </tr>
                <tr>
                    <td class="text-alignLeft">
                        Fist Name : 
                    </td>
                    <td>
                        <input type="text" name="txtFistName" required="" value="${fistName}">

                    </td>
                </tr>
                <tr>
                    <td class="text-alignLeft">
                        Last Name : 
                    </td>
                    <td>
                        <input type="text" name="txtLastName" required="" value="${lastName}">

                    </td>
                </tr>
                <tr>
                    <td class="text-alignLeft">
                        Address : 
                    </td>
                    <td>
                        <input type="text" name="txtAddress" required="" value="${address}">

                    </td>
                </tr>
                <tr>
                    <td class="text-alignLeft">
                        Phone Number : 
                    </td>
                    <td>
                        <input type="number" name="txtPhoneNumber" required="" value="${phoneNumber}">

                    </td>
                </tr>
                <tr>
                    <td class="text-alignLeft">
                        Sex : 
                    </td>
                    <td>
                        <select name="txtSex">
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                        </select>

                    </td>
                </tr>
                <tr>
                    <td class="text-alignLeft">
                        Age : 
                    </td>
                    <td>
                        <input type="number" name="txtAge" required="" value="${age}">

                    </td>
                </tr>

                <tr>
                    <td class="text-alignLeft">
                        Card Number : 
                    </td>
                    <td>
                        <input type="number" name="txtCardNumber" required="" value="${cardNumber}">

                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Register" name="btnRegister" class="btn btn-submit">

                    </td>
                </tr>

            </table>
        </form>
    </body>
</html>
