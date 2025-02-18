/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Adrian
 */
public class Libro implements IPublicacion {
    String titulo;
    String autor;
    int anio;
    String editorial;

    public Libro(String titulo, String autor, int anio, String editorial) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.editorial = editorial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public void ObtenerAutor() {
       System.out.print(autor); 
    }

    @Override
    public void Mostrar() {
       System.out.println("Titulo:"+titulo); 
       System.out.println("Autor:"+autor); 
       System.out.println("Año:"+anio); 
       System.out.println("Editorial:"+editorial); 
       
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", autor=" + autor + ", anio=" + anio + ", editorial=" + editorial + '}';
    }
    
    
    
    
}
