package com.proyectofinal.servlets;

import java.io.IOException;

import com.proyectofinal.models.AccionesLibros;
import com.proyectofinal.models.Libros;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/nuevolibro")
public class insertarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tit, aut, gen;
        int pag;

        tit = req.getParameter("titulo");
        aut = req.getParameter("autor");
        gen = req.getParameter("genero");
        pag = Integer.parseInt(req.getParameter("paginas"));

        Libros nuevoLibro = new Libros();

        nuevoLibro.setTitulo(tit);
        nuevoLibro.setAutor(aut);
        nuevoLibro.setGenero(gen);
        nuevoLibro.setCantPaginas(pag);

        int estado = AccionesLibros.cargarLibro(nuevoLibro);

        if(estado == 1){
            resp.sendRedirect("exito.jsp");
        } else {
            resp.sendRedirect("error.jsp");
        }
    }
}
