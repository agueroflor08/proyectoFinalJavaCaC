<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="estilo.css">
    <title>Proyecto final</title>
</head>
<body>
    <section id="seccionInfo">
        <h1>Libros</h1>
        <p>ID libro: ${c.getId()}</p>
        <p>Titulo: ${c.getTitulo()}</p>
        <p>Autor: ${c.getAutor()}</p>
        <p>Genero: ${c.getGenero()}</p>
        <p>Cantidad de Páginas: ${c.getCantPaginas()}</p>
        <a class="btn btn-secondary mt-5" href="index.html">Volver</a>
    </section>
</body>
</html>