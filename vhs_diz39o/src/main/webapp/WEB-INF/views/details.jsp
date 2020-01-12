<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linuxzilla
  Date: 2020. 01. 11.
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <title>VHS Jeeeej :D</title>
    </head>
</head>
<body>
<table align="center">
    <h1>Look what is it?</h1>

    <tr>
        <td>Title</td>
        <td>${cassette.title}</td>
    </tr>
    <tr>
        <td>Director</td>
        <td>${cassette.director}</td>
    </tr>
    <tr>
        <td>Publisher</td>
        <td>${cassette.publisher}</td>
    </tr>
    <tr>
        <td>Release</td>
        <td>${cassette.release}</td>
    </tr>
    <tr>
        <td>Genre</td>
        <td><c:forEach items="${cassette.genre}" var="genre">
            ${genre}
        </c:forEach></td>
    </tr>
    <tr>
        <td>Type</td>
        <td><c:forEach items="${cassette.type}" var="type">
            ${type}
        </c:forEach></td>
    </tr>
    <tr>
        <td>Length</td>
        <td>${cassette.legth}</td>
    </tr>
</table>
<form action="${pageContext.servletContext.contextPath}/cassettes">
    <button type="submit">Cassettes</button>
</form>
<form action="${pageContext.servletContext.contextPath}/">
    <button type="submit">BACK</button>
</form>
<br>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
