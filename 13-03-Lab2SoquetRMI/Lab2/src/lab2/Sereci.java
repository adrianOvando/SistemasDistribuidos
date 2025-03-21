/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

/**
 *
 * @author Adrian
 */
public class Sereci {
     public String verificarFecha(String nombres, String apellidos, String fecha) {
        // verificar la fecha de nacimiento
        if (fecha.equals("11-02-1996")) { 
            return "respuesta:si,mensaje:verificación correcta";
        } else {
            return "respuesta:no,mensaje:error fecha nacimiento no correcta";
        }
    }
}
