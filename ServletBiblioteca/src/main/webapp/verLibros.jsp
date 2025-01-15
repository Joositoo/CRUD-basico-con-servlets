<%@ page import="org.example.servletbiblioteca.Modelo.DAO" %>
<%@ page import="org.example.servletbiblioteca.Modelo.Libro" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Lista de libros</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
<h2>Lista de libros</h2>

<%
  DAO<Libro, Integer> daoLibro = new DAO<>(Libro.class, Integer.class);

  List<Libro>listaLibros = daoLibro.selectAll();
%>
<table>
  <tr>
    <th>isbn</th> <th>Titulo </th><th> Autor</th>
  </tr>
<%
  for (Libro libro : listaLibros){
%>
<tr><td><%=libro.getIsbn()%></td> <td><%=libro.getTitulo()%></td><td><%=libro.getAutor()%></td></tr>
<%
  }
%>
</table>

  <br><br><a href="index.jsp"><button>Volver atras</button></a>
</body>
</html>
