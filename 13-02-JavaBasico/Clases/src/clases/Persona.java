/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import Comunes.Color;

/**
 *
 * @author Dell
 */
public class Persona {
    String  nombre;
    String  apellidos;
    int edad;
    Sexo sexo;
    Color colorFavorito;

    public Persona(String nombre, String apellidos, int edad, Sexo sexo, Color colorFavorito) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sexo = sexo;
        this.colorFavorito = colorFavorito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Color getColorFavorito() {
        return colorFavorito;
    }

    public void setColorFavorito(Color colorFavorito) {
        this.colorFavorito = colorFavorito;
    }

    @Override
    public String toString() {
        return "Persona:{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", sexo=" + sexo + ", colorFavorito=" + colorFavorito + '}';
    }
    
    
}