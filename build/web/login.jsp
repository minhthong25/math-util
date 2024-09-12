
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Input your infomation:</h1>
        <form action="MainController" method="POST">
            User ID: <input type="text" name="userID"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" name="action" value="Login">
            <input type="reset" value="Reset">
        </form>
    <c:if test="${requestScope.ERROR != null}">
        <p>
            ${requestScope.ERROR}
        </p>
    </c:if>
        
    </body>
</html>
