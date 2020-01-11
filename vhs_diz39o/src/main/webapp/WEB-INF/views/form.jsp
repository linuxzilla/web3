<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <title>VHS Jeeeej :D</title>
    </head>
</head>
<body>
<h1>Lest add some '80s block buster!</h1>
<form:form method="post" action="add">
    <form:label path="title">Title</form:label>
    <form:input path="title"/>
    <br>
    <form:label path="director">Director</form:label>
    <form:input path="director"/>
    <br>
    <form:label path="publisher">Publisher</form:label>
    <form:input path="publisher"/>
    <br>
    <form:label path="release_date">Release</form:label>
    <form:input type="date" path="release_date"/>
    <br>
    <form:label path="genre">Genre</form:label>
    <form:select path="genre" multiple="true">
        <form:options items="${genreTypes}"></form:options>
    </form:select>
    <br>
    <form:label path="type">Type</form:label>
    <form:select path="type" multiple="true">
        <form:options items="${typeTypes}"></form:options>
    </form:select>
    <br>
    <form:label path="length">Length</form:label>
    <form:input type="number" path="length"/>
    <br>
    <button type="submit">Ok! ADD IT</button>
</form:form>
<form action="${pageContext.servletContext.contextPath}/cassettes">
    <button type="Cassettes"></button>
</form>
<form action="${pageContext.servletContext.contextPath}/">
    <button type="submit">BACK</button>
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
