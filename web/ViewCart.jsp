<%@ page import="sample.sp24.t4s4.user.shopping.Cart" %>
<%@ page import="sample.sp24.t4s4.user.shopping.Computer" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Day la View Cart</title>
    </head>
    <body>
        <h1>Your Shopping Cart</h1>
        <c:if test="${sessionScope.CART != null}">
            <c:set var="cart" value="${sessionScope.CART}"/>
            <c:if test="${cart.cart !=null}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total</th>
                            <th>Edit</th>
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="count" value="1"/>
                        <c:set var="total" value="0"/>
                        <c:forEach var="computerEntry" items="${cart.cart}">
                            <c:set var="computer" value="${computerEntry.value}"/>
                            <c:set var="price" value="${computer.price}"/>
                            <c:set var="quantity" value="${computer.quality}"/>
                            <c:set var="subtotal" value="${price * quantity}"/>
                            <tr>
                        <form action="MainController" method="POST">
                            <td>${count}</td>
                            <td>
                                <input type="text" name="id" value="${computer.id}" required=""/>
                            </td>
                            <td>${computer.name}</td>
                            <td>${price}</td>
                            <td>
                                <input type="number" name="quality" value="${quantity}" required=""/>
                            </td>
                            <td>${subtotal}</td>
                            <td>
                                <input type="submit" name="action" value="Edit"/>
                            </td>
                            <td>
                                <input type="submit" name="action" value="Remove"/>
                            </td>
                        </form>
                    </tr>
                    <c:set var="count" value="${count + 1}"/>
                    <c:set var="total" value="${total + subtotal}"/>
                </c:forEach>
            </tbody>
        </table>
        <h1>Total: ${total} $</h1>
    </c:if>
</c:if>
<a href="shopping.html">Add more</a>
</body>
</html>
