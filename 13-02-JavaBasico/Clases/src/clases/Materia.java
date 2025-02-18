/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Dell
 */
public class Materia {
    String sigla;
    String nombre;
    String horario;

    public Materia(String sigla, String nombre, String horario) {
        this.sigla = sigla;
        this.nombre = nombre;
        this.horario = horario;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Materia{" + "sigla=" + sigla + ", nombre=" + nombre + ", horario=" + horario + '}';
    }
    
}