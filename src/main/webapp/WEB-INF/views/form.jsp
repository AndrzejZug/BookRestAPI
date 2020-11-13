<%--
  Created by IntelliJ IDEA.
  User: andrzej
  Date: 13.11.2020
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<form method="POST" action="/books/add">
    <input type="text" name="isbn">ISBN
    <br>
    <input type="text" name="title">Title
    <br>
    <input type="text" name="author">Author
    <br>
    <input type="text" name="publisher">Publisher
    <br>
    <input type="text" name="type">Type
    <br>
    <input type="submit" value="Sendform">
</form>
</body>
</html>
