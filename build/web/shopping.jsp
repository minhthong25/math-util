<%-- 
    Document   : shopping
    Created on : Feb 28, 2024, 4:47:46 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Nhan Store</title>
        
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>Supper Computer Paradise </div>
        <form action="MainController" method="POST">
        Pick your computer <select name="computer">
            <option value="C001-Macbook M1-2000"> Macbook M1-2000$ </option>
            <option value="C002-ASUS TUF 113-2500"> ASUS TUF 113-2500$</option>
            <option value="C003-DELL MAX 45-1500"> Dell MAX 45-1500$ </option>
            <option value="C004-Lenovo X89-1000"> Lenovo X89-1000$ </option>

        </select>
        Quality <select name="quality">
            <option value="1">1 Items</option>
            <option value="2">2 Items</option>
            <option value="3">3 Items</option>
            <option value="4">4 Items</option>
            <option value="5">5 Items</option>
            <option value="10">10 Items</option>
        </select>
        </br>
        <input type="submit" name="action" value="Add"/>
        <input type="submit" name="action" value="View"/>
        </br>
         </br>
         <a href="MainController?action=Search">Return</a>
        </br>
       
    </form>
        <c:if test="${requestScope.MESSAGE != null}">
            <p>
                ${requestScope.MESSAGE}
            </p>
    </c:if>

    </body>
</html>
