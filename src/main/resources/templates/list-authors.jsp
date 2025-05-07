<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Authors List</title>
    <link rel="stylesheet" href="/css/style.css" />
  </head>
  <body>
    <h2>Authors</h2>
    <a href="/authors/add"><button>Add New Author</button></a>
    <table>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Nationality</th>
        <th>Actions</th>
      </tr>
      <c:forEach var="author" items="${authors}">
        <tr>
          <td>${author.id}</td>
          <td>${author.name}</td>
          <td>${author.nationality}</td>
          <td><a href="/authors/update/${author.id}">Update</a></td>
        </tr>
      </c:forEach>
    </table>

    <h2>Authors and Their Books</h2>
    <table>
      <tr>
        <th>Author Name</th>
        <th>Book Title</th>
      </tr>
      <c:forEach var="entry" items="${authorBooks}">
        <tr>
          <td>${entry[0].name}</td>
          <td>${entry[1].title}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
