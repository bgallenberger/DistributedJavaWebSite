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
    <title>List</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/bgallenbergerWebSite/resources/style.css">
</head>
<body>
<div id="loginLink"><a href="Login.jsp">Login</a></div>
<h1>My Site</h1>
<form>
    <ul>
        <li>Item 1</li><input type="button" class="editItem" value="edit"><input type="button" class="deleteItem" value="delete">
        <li>Item 2</li><input type="button" class="editItem" value="edit"><input type="button" class="deleteItem" value="delete">
        <li>Item 3</li><input type="button" class="editItem" value="edit"><input type="button" class="deleteItem" value="delete">
        <li>Item 4</li><input type="button" class="editItem" value="edit"><input type="button" class="deleteItem" value="delete">
    </ul>
    <input type="button" class="addItem" value="add">
</form>
</body>
</html>
