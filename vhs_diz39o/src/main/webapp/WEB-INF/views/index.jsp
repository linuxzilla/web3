<%@ page isELIgnored="false"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <title>VHS Jeeeej :D</title>
</head>
<body>
<h1>Organize your old and cool vhs cassettes! #TB</h1>
<form action="${pageContext.servletContext.contextPath}/cassettes">
<button type="submit">List VHS cassettes</button>
</form>
<form action="${pageContext.servletContext.contextPath}/add">
    <button type="submit">Add new cassette</button>
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
