package org.example.servletbiblioteca.Controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbiblioteca.Modelo.DAO;
import org.example.servletbiblioteca.Modelo.Libro;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EliminaLibro", value = "/EliminaLibro")
public class EliminaLibro extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO<Libro, Integer> dao = new DAO<>(Libro.class, Integer.class);

        String isbn = request.getParameter("isbn");

        List<Libro> listaLibros = dao.selectAll();

        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                dao.delete(libro);
                break;
            }
        }
        response.sendRedirect("verLibros.jsp");
    }
}
