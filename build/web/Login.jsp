<%-- 
    Document   : Login
    Created on : May 9, 2017, 10:27:56 PM
    Author     : lamtu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/Header.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/Content.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/main.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body>

        <jsp:include page="Header.jsp"/> 
   
            <div>
                
                <table class="login">
                    <td colspan="2">
                        <h1 class="text-red">Login</h1>
                    </td>
                    <tr>
                        <td colspan="2">
                            Using your user name and pass word.
                        </td>
                    </tr>
                    <tr>
                        <td class="font">
                            Email : 
                        </td>
                        <td>
                            <input type="text" name="txtEmail" required="" value="${username}" form="login">
                            <span class="text-red">(*)</span>
                        </td>
                    </tr>

                    <tr>
                        <td class="font">
                            Password : 
                        </td>
                        <td>
                            <input type="text" name="txtPassword" required="" value="${password}" form="login">
                            <span class="text-red">(*)</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Login" name="btnLogin" class="btn btn-submit" form="login">
                            <input type="submit" value="Register" name="btnRegister" class="btn btn-submit" form="register">
                            <br>

                            <p>
                                The fidel<span class="red-text">(*)</span> is required.
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            ${error}
                        </td>
                    </tr>
                </table>

            <form id="login" action="LoginServlet" method="POST">     </form>
                <form id="register" action="AddPassenger.jsp" method="POST">     </form>
        </div>
    </body>

</html>
