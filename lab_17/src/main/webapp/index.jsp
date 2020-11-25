<%--
  Created by IntelliJ IDEA.
  User: andruha.tm
  Date: 08.11.2020
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action="${pageContext.request.contextPath}/basket" method="get">
      Id для удаления: <input type="text" name="id" />
      <br>
      Имя: <input type="text" name="name" />
      <br>
      Путь: <input type="text" name="path" />
      <br>
      <button type="submit" name="button" value="add" >add</button>
      <button type="submit" name="button" value="delete">delete</button>
      <button type="submit" name="button" value="getAll">get all</button>
    </form>
  </body>
</html>
