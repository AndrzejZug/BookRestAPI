<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Book Add</title>
</head>
<body>
<h1>Fill the form below to Add a Book</h1>
<form:form method = "POST" modelAttribute = "book">
    ISBN<form:input path="isbn"/>
    <form:errors path="isbn"/><br/>
    Title<form:input path="title"/>
    <form:errors path="title"/><br/>
    Author<form:input path="author"/>
    <form:errors path="author"/><br/>
    Publisher<form:input path="publisher"/>
    <form:errors path="publisher"/><br/>
    Type<form:input path="type"/>
    <form:errors path="type"/><br/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>