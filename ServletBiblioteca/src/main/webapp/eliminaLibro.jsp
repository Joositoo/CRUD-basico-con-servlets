<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Elimina un libro</title>
</head>
<body>
<h2>Elimina un libro de la base de datos</h2>

<form action="EliminaLibro" method="post">
    <p><label for="isbn">Isbn: &nbsp</label><input type="text" id="isbn" name="isbn"></p>

    <button type="submit">Enviar</button>
</form>
</body>
</html>
