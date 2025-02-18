/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej2;

/**
 *
 * @author Adrian
 */
public class Revista implements IPublicacion{
    String nombreRev;
    int anioRev;
    int mesRev;

    public Revista(String nombreRev, int anioRev, int mesRev, TipoRevista tipoRev) {
        this.nombreRev = nombreRev;
        this.anioRev = anioRev;
        this.mesRev = mesRev;
        this.tipoRev = tipoRev;
    }
    TipoRevista tipoRev;
    
    @Override
    public String MostrarEtiqueta() {
        return "Revista: " + nombreRev + " - " + anioRev + "/" + mesRev + "- Tipo: " + tipoRev; 
    }
}
