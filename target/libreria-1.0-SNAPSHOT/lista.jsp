<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.proyectofinal.models.AccionesLibros"%>
<%@page import="com.proyectofinal.models.Libros"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Proyecto final</title>
    </head>
    <body>
        <div class="container mt-5">
            <div class="d-flex justify-content-between">
                <h1 class="">Libros</h1>
                <a class="btn btn-secondary mt-5" href="index.html">Volver</a>
            </div>
            <br>
            <table class="table table-bordered mt-3">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Titulo</th>
                        <th class="text-center">Autor</th>
                        <th class="text-center">Genero</th>
                        <th class="text-center">Cantidad de paginas</th>
                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>
                <%
                    AccionesLibros acciones = new AccionesLibros();
                    List<Libros> list = acciones.verTodosLosLibros();
                    Iterator<Libros> iter = list.iterator();
                    Libros libro = null;
                    while (iter.hasNext()) {
                        libro = iter.next();

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%=libro.getId()%></td>
                        <td class="text-center"><%=libro.getTitulo()%></td>
                        <td class="text-center"><%=libro.getAutor()%></td>
                        <td class="text-center"><%=libro.getGenero()%></td>
                        <td class="text-center"><%=libro.getCantPaginas()%></td>
                        <td class="text-center">
                        <!--<a class="btn btn-warning" href="#">Editar</a>-->  
                            <a class="btn btn-danger" href="eliminarlibro?id=<%=libro.getId()%>">Eliminar</a>
                        </td>
                    </tr>  
                    <%}%>
                </tbody>

            </table>
        </div>
    </body>
</html>
