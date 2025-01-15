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

@WebServlet(name = "ActualizaLibro", value = "/ActualizaLibro")
public class ActualizaLibro extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Libro libro = null;
        DAO<Libro, Integer> dao = new DAO<>(Libro.class, Integer.class);

        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");


        List<Libro> listaLibros = dao.selectAll();

        for (Libro l : listaLibros) {
            if (l.getIsbn().equals(isbn)) {
                libro = l;
                break;
            }
        }

        if (libro != null) {
            libro.setTitulo(titulo);
            libro.setAutor(autor);

            dao.update(libro);
            response.sendRedirect("verLibros.jsp");
        }
    }
}
