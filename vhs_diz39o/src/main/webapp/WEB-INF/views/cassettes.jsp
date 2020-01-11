<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linuxzilla
  Date: 2020. 01. 11.
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <title>VHS Jeeeej :D</title>
</head>
<body>
<h1>What we have so far ?!</h1>
<c:if test="${!empty cassettes}">
    <h1>What we have so far</h1>
    <table align="center" frame="border" width="1150" rules="all">
        <tr>
            <td><b>Title</b></td>
            <td><b>Director</b></td>
            <td><b>Publisher</b></td>
            <td><b>Release date</b></td>
            <td><b>Genre</b></td>
            <td><b>Type</b></td>
            <td><b>Length</b></td>
        </tr>
        <c:forEach items="${cassettes}" var="cassette">
            <tr>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/cassette/${cassette.title}">
                            ${cassette.title}</a>
                </td>
                <td>${cassette.director}</td>
                <td>${cassette.publisher}</td>
                <td>${cassette.release}</td>
                <td>
                    <c:forEach items="${cassette.genre}" var="genre">
                        ${genre}
                    </c:forEach>
                </td>
                <td>
                    <c:forEach items="${cassette.type}" var="type">
                        ${type}
                    </c:forEach>
                </td>
                <td>${cassette.length}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty cassettes}">
    <h1>Ohh no! I don't have any!</h1>
</c:if>
<form action="${pageContext.servletContext.contextPath}/add">
    <button type="submit">Add new cassette</button>
</form>
<form action="${pageContext.servletContext.contextPath}/">
    <button type="submit">BACK</button>
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>