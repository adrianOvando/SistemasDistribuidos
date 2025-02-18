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
public class Biblioteca {
    ArrayList<Armario> armarios;

    public Biblioteca() {
        armarios=new ArrayList<Armario>();
    }
    
    public void addArmario(Armario armario)
    {
        armarios.add(armario);
    }
}
