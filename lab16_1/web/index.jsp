<%--
  Created by IntelliJ IDEA.
  User: psiho
  Date: 23.09.2020
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Калькулятор</title>
  </head>
  <body>
  <form action="/calculation" method="doGet" id="myForm">
    Первое число: <input type="text" name="a" />
    <br>
    Второе число: <input type="text" name="b" />
    <br>
    Ответ: ${answer}
    <br>
    <button type="submit" name="button" value="+">+</button>
    <button type="submit" name="button" value="-">-</button>
    <button type="submit" name="button" value="*">*</button>
    <button type="submit" name="button" value="/">/</button>
  </form>
  </body>
</html>
