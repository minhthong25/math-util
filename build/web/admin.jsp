
<%@page import="java.util.List"%>
<%@page import="sample.sp24.t4s4.user.UserDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>welcome ${sessionScope.LOGIN_USER.fullName}</h1>
        <c:url var="logoutLink" value="MainController" >
            <c:param name="action" value="Logout"></c:param>
        </c:url>
        
        <!--Create-->
         <form action="MainController" >
            <input type="submit" name="action" value="Create" />
        </form>
        <a href="MainController?action=Create">Create</a>
        <!--add-->
         <form action="MainController" >
            <input type="submit" name="action" value="Add" />
        </form>
        <a href="MainController?action=Add">Add</a>
        <!--logout-->
        <form action="MainController" >
            <input type="submit" name="action" value="Logout" />
        </form>
        <a href="${logoutLink}" >Logout JSP</a>
        <a href="MainController?action=Logout">Logout URL Rewriting</a>
         <!--search-->
        <form action="MainController">
            Search:<input type="text" name="search" value="${param.search}" />
            <input type="submit" name="action" value="Search"/>
        </form>

        <c:if test="${requestScope.LIST_USER != null}">
            <c:if test="${not empty requestScope.LIST_USER}">
                <table border="1">
                    <thread>
                        <tr>
                            <th>No</th>
                            <th>User ID</th>
                            <th>Full Name</th>
                            <th>Role ID</th>
                            <th>Password</th>
                            <th>Update</th>
                            <th>Delete</th>
                            <th>Delete URL</th>
                            <th>Delete URL Writing</th>
                        </tr>
                    </thread>
                    <tbody>
                        <c:forEach var="user" varStatus="couter" items="${requestScope.LIST_USER}">
                        <form action="MainController">
                            <tr>
                                <td>${couter.count}</td>
                                <td>
                                    <input type="text" name="userID" value="${user.userID}" readonly="" />
                                </td>

                                <td>
                                    <input type="text" name="fullName" value="${user.fullName}" required=""/>
                                </td>
                                <td>
                                    <input type="text" name="roleID" value="${user.roleID}" readonly=""/>
                                </td>
                                <td>
                                    ${user.password}
                                </td>
                                <td>
                                    <input type="submit" name="action" value="Update"/>
                                    <input type="hidden" name="search" value="${param.search}"/>
                                </td>
                            
                            <td>
                                <input type="submit" name="action" value="Delete"/>
                            </td>
                            <c:url var="deleteLink" value="MainController">
                                <c:param name="userID" value="${user.userID}"></c:param>
                                <c:param name="search" value="${param.search}"></c:param>
                                <c:param name="action" value="Delete"></c:param>

                            </c:url>
                            <td>
                                <a href="${deleteLink}">Delete JSTL</a>
                            </td>
                            <td>
                                <a href="MainController?search=${param.search}&action=Delete&userID=${user.userID}">Delete URL Writing</a>
                            </td>
                            </tr>
                        </form>

                    </c:forEach>
                </tbody>
            </table>
                ${requestScope.ERROR}
        </c:if>

    </c:if>

</body>
</html>
