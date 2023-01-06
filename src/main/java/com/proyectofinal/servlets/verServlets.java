package com.proyectofinal.servlets;

import java.io.IOException;

import com.proyectofinal.models.AccionesLibros;
import com.proyectofinal.models.Libros;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/verlibro")
public class verServlets extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id  = Integer.parseInt(req.getParameter("idlibro"));

        Libros registro = AccionesLibros.verLibros(id);

        req.setAttribute("c", registro);

        RequestDispatcher respuesta = req.getRequestDispatcher("infoLibros.jsp");
        respuesta.forward(req, resp);
    }
    
}

