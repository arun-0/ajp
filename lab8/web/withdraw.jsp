<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Withdraw Funds</title>
</head>
<body>
<h1>Withdraw Funds</h1>
<form action="WithdrawServlet" method="post">
    Account ID: <input type="text" name="accountId"><br>
    Amount: <input type="text" name="amount"><br>
    <input type="submit" value="Withdraw">
</form>
<br>
<a href="mainMenu.jsp">Back to Main Menu</a>
</body>
</html>
