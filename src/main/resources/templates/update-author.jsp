<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> <%@
page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Update Author</title>
    <link rel="stylesheet" href="/css/style.css" />
  </head>
  <body>
    <h2>Update Author</h2>
    <c:if test="${not empty error}">
      <div class="error">${error}</div>
    </c:if>
    <form:form modelAttribute="author" method="post" action="/authors/update">
      <form:hidden path="id" />
      <form:input path="name" placeholder="Author Name" /><br />
      <form:input path="nationality" placeholder="Nationality" /><br />
      <button type="submit">Update Author</button>
    </form:form>
  </body>
</html>
