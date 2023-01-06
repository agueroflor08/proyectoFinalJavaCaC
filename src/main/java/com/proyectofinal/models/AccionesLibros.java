package com.proyectofinal.models;
//import com.proyectofinal.models.Libros;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AccionesLibros {
//insertar registro
public static int cargarLibro(Libros c){
    int estado = 0;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/libreria","root","");

        String query = "INSERT INTO libros(titulo,autor,genero,cantPaginas) VALUES (?,?,?,?)";

        
        String titulo = c.getTitulo();
        String autor = c.getAutor();
        String genero = c.getGenero();
        int cantPaginas = c.getCantPaginas();

        PreparedStatement pst = conexion.prepareStatement(query);
        
        pst.setString(1, titulo);
        pst.setString(2, autor);
        pst.setString(3, genero);
        pst.setInt(4, cantPaginas);

        estado = pst.executeUpdate();

        conexion.close();


    } catch (Exception e){
        System.out.println(e);
        System.out.println("Algo salio mal");
    }

    return estado;
}

//actualizar registro

public static int actualizarLibros(Libros c){
    int estado = 0;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/libreria","root","");

        String query = "UPDATE libros SET titulo=?, autor=?, genero=?, cantPaginas=? WHERE id_libro=?";

        int id = c.getId();
        String titulo = c.getTitulo();
        String autor = c.getAutor();
        String genero = c.getGenero();
        int cantPaginas = c.getCantPaginas();
        
        PreparedStatement pst = conexion.prepareStatement(query);

        pst.setInt(1, id);
        pst.setString(2, titulo);
        pst.setString(3, autor);
        pst.setString(4, genero);
        pst.setInt(5, cantPaginas);

        estado = pst.executeUpdate();

        conexion.close();


    } catch (Exception e){
        System.out.println("Algo salio mal");
    }

    return estado;
}  

//consultar todos los registros de una tabla

public static List<Libros> verTodosLosLibros(){
    List<Libros> listaLibrosADevolver = new ArrayList<Libros>();
    

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/libreria","root","");

        String query = "SELECT * FROM libros";

        PreparedStatement pst = conexion.prepareStatement(query);

        ResultSet consultaLibros = pst.executeQuery();

        while (consultaLibros.next()){
            Libros librosADevolver = new Libros(); 
            librosADevolver.setId( consultaLibros.getInt(1));
            librosADevolver.setTitulo( consultaLibros.getString(2));
            librosADevolver.setAutor( consultaLibros.getString(3));
            librosADevolver.setGenero( consultaLibros.getString(4));
            librosADevolver.setCantPaginas( consultaLibros.getInt(5));
            listaLibrosADevolver.add(librosADevolver);
        }
        conexion.close();
    } catch (Exception e){
        System.out.println(e);
        System.out.println("Algo salio mal");
    }

    return listaLibrosADevolver;
} 

//consultar registro por id

public static Libros verLibros(int idAConsultar){
    Libros libroADevolver = new Libros();

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/libreria","root","");

        String query = "SELECT * FROM libros WHERE id_libro=?";

        PreparedStatement pst = conexion.prepareStatement(query);
        
        pst.setInt(1, idAConsultar);

        ResultSet consultaLibros = pst.executeQuery();

        if (consultaLibros.next()){
            libroADevolver.setId( consultaLibros.getInt(1));
            libroADevolver.setTitulo( consultaLibros.getString(2));
            libroADevolver.setAutor(consultaLibros.getString(3));
            libroADevolver.setGenero(consultaLibros.getString(4));
            libroADevolver.setCantPaginas(consultaLibros.getInt(5));
            conexion.close();
        }
    } catch (Exception e){
        System.out.println(e);
        System.out.println("Algo salio mal");
    }

    return libroADevolver;
}

// borrar libro de la bbdd
 
public static int borrarLibro(int idaBorrar){
    int estado = 0;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/libreria","root","");
        String query = "DELETE FROM libreria WHERE id_libro=?";

        PreparedStatement pst = conexion.prepareStatement(query);

        pst.setInt(1, idaBorrar);

        estado = pst.executeUpdate();

        conexion.close();

    } catch (Exception e){
        System.out.println("No se pudo eliminar");
    }
    return estado;
}
 

}