<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>

<table border="1">
    <thead>
    <th>isbn</th>
    <th>title</th>
    <th>author</th>
    <th>publisher</th>
    <th>type</th>
    <th>Operations</th>
    </thead>
    <tbody>
    <h1>List of Books</h1>
    <h2><a href="${pageContext.request.contextPath}/admin/books/add">Add book</a>
        <%--        Add book<c:url value="/admin/books/add" </h2>--%>
        <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><c:out value="${book.publisher}"/></td>
            <td><c:out value="${book.type}"/></td>
            <td>
                <a href="<c:out value="/admin/books/edit/${book.id}"/>">Edit</a>
                <a href="<c:out value="/admin/books/delete/${book.id}"/>">Remove</a>
                <a href="<c:out value="/admin/books/show/${book.id}"/>">Show</a>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>