package com.proyectofinal.servlets;

import java.io.IOException;

import com.proyectofinal.models.AccionesLibros;  

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/eliminarlibro")
public class eliminarServlets extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    int id = Integer.parseInt(req.getParameter("id"));

    int estado = AccionesLibros.borrarLibro(id);

    if(estado == 1){
        resp.sendRedirect("elimExitosa.jsp");
    } else {
        resp.sendRedirect("elimFallida.jsp");
    }
        
    }
    
}