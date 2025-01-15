package org.example.servletbiblioteca.Controlador;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbiblioteca.Modelo.DAO;
import org.example.servletbiblioteca.Modelo.Libro;

import java.io.IOException;

@WebServlet(name = "AltaLibro", value = "/AltaLibro")
public class AltaLibro extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DAO<Libro, Integer> dao = new DAO<>(Libro.class, Integer.class);

        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");

        System.out.println("ISBN: " + isbn);
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);

        Libro libro = new Libro(isbn, titulo, autor);
        dao.insert(libro);

        response.sendRedirect("verLibros.jsp");

    }
}
