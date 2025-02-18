/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej2;

import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public class Periodico implements IPublicacion{
    String nombrePer;
    String fechaPer;
    ArrayList<Suplemento>listaSuplementos;

     public Periodico(String nombrePer, String fechaPer, ArrayList<Suplemento> listaSuplementos) {
        this.nombrePer = nombrePer;
        this.fechaPer = fechaPer;
        this.listaSuplementos = listaSuplementos; 
    }
    @Override
    public String MostrarEtiqueta() {
        return "Periodico: " + nombrePer + " - " + fechaPer;
    }
}
