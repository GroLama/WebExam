<%--
  Created by IntelliJ IDEA.
  User: Nico
  Date: 06/02/2022
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Choose your exam</title>
</head>
<body>
    <h1>Click on the test you want to proceed</h1>
    <jsp:scriptlet>
        String[] listDisp = (String[]) request.getAttribute("list");
        pageContext.setAttribute("variables",listDisp);
        </jsp:scriptlet>
    <c:forEach var="listDisp" items="${pageScope.variables}">
        <c:out value="${listDisp}"/> <br> <br>
    </c:forEach>

</body>
</html>
