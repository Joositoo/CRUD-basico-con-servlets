<%@ page import="org.example.servletbiblioteca.Modelo.DAO" %>
<%@ page import="org.example.servletbiblioteca.Modelo.Libro" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Lista de libros</title>
  <style>
    h2{
      text-align:center;
    }

    table {
      width: 100%;
      border-collapse: collapse;
    }

    th, td {
      text-align: center;
      padding: 8px;
      border-bottom: 1px solid black;
    }

    th {
      background-color: #f2f2f2;
    }

    td {
      background-color: #ffffff;
    }
  </style>
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
