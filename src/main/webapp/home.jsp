<%--
  Created by IntelliJ IDEA.
  User: dream
  Date: 17.06.2019
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/" method="post">
    <input type="text" name="userText"value="${user}">
    <input type="submit" name="userBut" value="get">
    <br>
    <input type="text" name="sumText" value="${sum}">
    <input type="submit" name="sumBut" value="get">
</form>
</body>
</html>
