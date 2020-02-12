<%--
  Created by IntelliJ IDEA.
  User: bgallenberger
  Date: 2020-01-21
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="../resources/style.css">
</head>
<body>
<jsp:include page="Header.jsp"/>

<h2>stuff</h2>
<form action="<%= request.getContextPath() %>/List" method="get">
    <input type="submit" value="Go to List">
</form>
<form action="<%= request.getContextPath() %>/Search" method="get">
    <input type="submit" value="Go to Search">
</form>
<form action="<%= request.getContextPath() %>/List2" method="get">
    <input type="submit" value="Go to List2">
</form>
<form action="<%= request.getContextPath() %>/Search2" method="get">
    <input type="submit" value="Go to Search2">
</form>

<jsp:include page="Footer.jsp"/>
</body>
</html>