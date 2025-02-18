/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import Comunes.Color;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Alumno extends Persona {
    String  cu;
    Carrera carrera;
    IPublicacion[] pulicaciones_favoritas;
    ArrayList<Materia> materias;

    public Alumno(String cu, IPublicacion[] pulicaciones_favoritas, ArrayList<Materia> materias, String nombre, String apellidos, int edad, Sexo sexo, Color colorFavorito) {
        super(nombre, apellidos, edad, sexo, colorFavorito);
        this.cu = cu;
        this.pulicaciones_favoritas = pulicaciones_favoritas;
        this.materias = materias;
    }

    public String getCu() {
        return cu;
    }

    public void setCu(String cu) {
        this.cu = cu;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public IPublicacion[] getPulicaciones_favoritas() {
        return pulicaciones_favoritas;
    }

    public void setPulicaciones_favoritas(IPublicacion[] pulicaciones_favoritas) {
        this.pulicaciones_favoritas = pulicaciones_favoritas;
    }

    public ArrayList<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(ArrayList<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return "Alumno{" + "cu=" + cu + ", carrera=" + carrera + ", pulicaciones_favoritas=" + pulicaciones_favoritas + ", materias=" + materias + '}';
    }

   
    
    
    
  
    
    
}