package com.proyectofinal.models;
import java.io.Serializable;

public class Libros implements Serializable {
        private int id, cantPaginas;
        private String titulo, autor, genero;

        public Libros(){
    
        }
    
        public int getId(){
            return id;
        }
    
        public void setId(int nuevoId){
            this.id = nuevoId;
        }
    
        public String getTitulo(){
            return titulo;
        }
    
        public void setTitulo(String nuevoTitulo){
            this.titulo = nuevoTitulo;
        }
    
        public String getAutor(){
            return autor;
        }
    
        public void setAutor(String nuevoAutor){
            this.autor = nuevoAutor;
        }

        public String getGenero(){
            return genero;
        }
    
        public void setGenero(String nuevoGenero){
            this.genero = nuevoGenero;
        }
    
        public int getCantPaginas(){
            return cantPaginas;
        }
    
        public void setCantPaginas(int nuevaCantPaginas){
            this.cantPaginas = nuevaCantPaginas;
        }
    }