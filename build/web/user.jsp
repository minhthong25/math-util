<%-- 
    Document   : user
    Created on : Jan 24, 2024, 5:06:51 PM
    Author     : PC
--%>

<%@page import="sample.sp24.t4s4.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        User infomation:
        </br>UserID: ${sessionScope.LOGIN_USER.userID}
        </br>Full Name:${sessionScope.LOGIN_USER.fullName}
        </br>ID: ${sessionScope.LOGIN_USER.roleID}
        </br>Password: ${sessionScope.LOGIN_USER.password}
        </br>
        <a href="MainController?action=Shopping_Page">Go to Nhan's Store</a>
    </body>
</html>
