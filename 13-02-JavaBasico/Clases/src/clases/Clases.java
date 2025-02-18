/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases;

import Comunes.Color;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Clases {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona juan = new Persona("Juan", "Perez", 30,Sexo.Masculino, Color.morado);
        
        Materia sis258=new Materia("SIS-258", "Sistemas Dstribuidos", "Lunes 2-4, Jueves 4-6");
        Materia sis256=new Materia("SIS-256", "Programacion Web", "Lunes 4-6, Miercoles 4-6");
        
        IPublicacion cienanos=new Libro("100 años de soledad", "GAbriel Garcia Marqiuez", 1974, "LaJoya");
        IPublicacion nina=new Libro("LaNiña de mis ojos", "Antonio Paredes", 1980, "LaJoya");
        IPublicacion corre13225=new Periodico("Correo del Sur", "2025-02-13");
        IPublicacion corre101223=new Periodico("Correo del Sur", "2025-12-10");
        IPublicacion larazon101219=new Periodico("La Razon ", "2019-10-10");
        
        IPublicacion[] publicaciones_pedro= new IPublicacion[5];
        publicaciones_pedro[0]=cienanos;
        publicaciones_pedro[1]=nina;
        publicaciones_pedro[2]=corre13225;
        publicaciones_pedro[3]=corre101223;
        publicaciones_pedro[4]=larazon101219;
        
        ArrayList<Materia> materias_pedro =new ArrayList<Materia>();
        materias_pedro.add(sis258);
        materias_pedro.add(sis256);
                
        Alumno pedro =new Alumno("111-55", publicaciones_pedro, materias_pedro, "Pedro", "Aguirre", 20, Sexo.Masculino, Color.morado);
        
        System.out.println(pedro.getApellidos()+pedro.nombre);
        System.out.println("------------------------------");
        System.out.println("Publicaciones Favoritas");
        System.out.println("------------------------------");
        for (IPublicacion publicacion:pedro.getPulicaciones_favoritas())
        {
            publicacion.Mostrar();
            System.out.println("------------------------------");
        }
        
        
        
        
        
        
        
        
        //System.out.print(juan);
        //System.out.print(sis258);
        
        
        
    }
    
}