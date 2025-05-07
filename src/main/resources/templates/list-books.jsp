<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Books List</title>
    <link rel="stylesheet" href="/css/style.css" />
  </head>
  <body>
    <h2>Books</h2>
    <a href="/books/add"><button>Add New Book</button></a>
    <table>
      <tr>
        <th>ID</th>
        <th>Title</th>
        <th>ISBN</th>
        <th>Author</th>
        <th>Actions</th>
      </tr>
      <c:forEach var="book" items="${books}">
        <tr>
          <td>${book.id}</td>
          <td>${book.title}</td>
          <td>${book.isbn}</td>
          <td>${book.author.name}</td>
          <td><a href="/books/update/${book.id}">Update</a></td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
