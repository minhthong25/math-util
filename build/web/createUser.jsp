<%@page import="sample.sp24.t4s4.user.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Create New User </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Create user. Input user information</h1>
        <% UserError userError = (UserError) request.getAttribute("USER_ERROR");
            if (userError == null) {
                userError = new UserError();
            }
        %>

        <form action="MainController" method="POST">
            UserID <input type="text" name="userID" required=""/> ${requestScope.USER_ERROR.userIDError}
            </br>Full Name<input type="text" name="fullName" required=""/> ${requestScope.USER_ERROR.fullNameError}
            </br>Role ID <select name="roleID">
                <option value="AD">AD</option>
                <option value="US">US</option>
                <option value="OTHER">OTHER</option>
            </select>
            </br> Password<input type="password" name="password" required=""/>
            </br> Confirm<input type="password" name="confirm" required=""/> ${requestScope.USER_ERROR.confirmError}
            </br><input type="submit" name="action" value="Create"/>
            <input type="reset" value="Reset"/>
            ${requestScope.USER_ERROR.error}
        </form>
    </body>
</html>

