<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Update Book</title>
    <link rel="stylesheet" href="/css/style.css" />
  </head>
  <body>
    <h2>Update Book</h2>
    <c:if test="${not empty error}">
      <div class="error">${error}</div>
    </c:if>
    <form:form modelAttribute="book" method="post" action="/books/update">
      <form:hidden path="id" />
      <form:input path="title" placeholder="Book Title" /><br />
      <form:input path="isbn" placeholder="ISBN" /><br />
      <form:select path="author.id">
        <form:option value="" label="--Select Author--" />
        <form:options
          items="${authors}"
          itemValue="id"
          itemLabel="name"
        /> </form:select
      ><br />
      <button type="submit">Update Book</button>
    </form:form>
  </body>
</html>
