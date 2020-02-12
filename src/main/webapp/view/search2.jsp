<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Items</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css">
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
<jsp:include page="Header.jsp"/>
<form method="get" action="/DistributedJavaWebSite/Search2">
    <input type="text" class="searchItem" value="search" name="Item_Name">
</form>
<table>
    <tr>
        <th>Item ID</th>
        <th>Item Name</th>
        <th>Category ID</th>
    </tr>
    <c:forEach var="item" items="${items}">
        <tr>
            <td>${item.itemId}</td>
            <td>${item.name}</td>
            <td>${item.categoryId}</td>
        </tr>
    </c:forEach>
</table>
<!-- see base tag in head -->
<a href="view/Index.jsp">Home</a>
</body>
</html>
