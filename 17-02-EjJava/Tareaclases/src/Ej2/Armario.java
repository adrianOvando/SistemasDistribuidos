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
class Armario {

    static Material material;
    static String codigo;
    ArrayList<IPublicacion> publicaciones;
    public Armario(String codigo, Material material) {
        this.codigo = codigo;
        this.material = material;
        this.publicaciones = new ArrayList<>(); 
    }

    public void agregarPublicacion(IPublicacion publicacion) {
        publicaciones.add(publicacion);
    }

    public ArrayList<IPublicacion> getPublicaciones() {
        return publicaciones;
    }
    public static Material getMaterial() {
        return material;
    }

    public static String getCodigo() {
        return codigo;
    }
}
