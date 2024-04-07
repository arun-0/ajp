<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Account Information</title>
</head>
<body>
<h1>Account Information</h1>
<table border="1">
    <tr>
        <th>Account ID</th>
        <th>Name</th>
        <th>Balance</th>
    </tr>
    <c:forEach var="account" items="${accounts}">
        <tr>
            <td><c:out value="${account.id}" /></td>
            <td><c:out value="${account.name}" /></td>
            <td><c:out value="${account.balance}" /></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="mainMenu.jsp">Back to Main Menu</a>
</body>
</html>
