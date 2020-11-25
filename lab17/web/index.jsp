<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Корзина</title>
  </head>
  <body>
  <form action="/basket" method="doGet" id="myForm">
    Id в корзине(только для удаления): <input type="text" name="id" />
    <br>
    Имя файла: <input type="text" name="name" />
    <br>
    Путь к файлу: <input type="text" name="patch" />
    <br>
    <button type="submit" name="button" value="add">Добавить</button>
    <button type="submit" name="button" value="delete">Удалить из корзины</button>
    <button type="submit" name="button" value="search">Посмотреть корзину</button>
    </form>
  </body>
</html>
