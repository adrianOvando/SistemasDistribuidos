/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public class Menu {
    public static void main(String[] args) {
        int op=0;
        int n=0;
        Scanner sc=new Scanner(System.in);
        while (op!=5)
        {
            System.out.println("1. Crear Armario");
            System.out.println("2. Crear Publicacion");
            System.out.println("3. Cargar Publicacion");
            System.out.println("4. Listar Biblioteca");
            System.out.println("5. Salir");
            System.out.println("Introduzca Opcion");
            op=sc.nextInt();
            
            switch(op)
            {
                case 1:
                    CrearArmario(sc);
                   break;
                case 2:
                    CrearPublicacion(sc);
                    break;
                case 3:
                    CargarPubli(sc);
                    break;
                case 4:
                    Listar();
                    break;
            }
            
        }
    }

    private static void CrearArmario(Scanner sc) {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        System.out.println("Material (Madera, Metal): ");
        String materialInput = sc.nextLine();
        Material material = Material.valueOf(materialInput.toUpperCase());
        System.out.println("Código del Armario: ");
        String codigo = sc.nextLine();
        Armario a = new Armario(codigo, material);
        dao.crear(a);
    }

    private static void CrearPublicacion(Scanner sc) {
        System.out.println("¿Qué tipo de publicación desea crear? (1 - Libro, 2 - Revista, 3 - Periódico): ");
        int tipoPubli = sc.nextInt();
        sc.nextLine(); 

        IPublicacion publicacion = null;

        switch (tipoPubli) {
            case 1:
                System.out.println("Nombre del libro: ");
                String nombreLibro = sc.nextLine();
                System.out.println("Autor del libro: ");
                String autorLibro = sc.nextLine();
                System.out.println("Editorial del libro: ");
                String editorialLibro = sc.nextLine();
                System.out.println("Año del libro: ");
                int anioLibro = sc.nextInt();
                sc.nextLine(); 

                publicacion = new Libro(nombreLibro, autorLibro, editorialLibro, anioLibro);
                break;

            case 2:
                System.out.println("Nombre de la revista: ");
                String nombreRev = sc.nextLine();
                System.out.println("Año de la revista: ");
                int anioRev = sc.nextInt();
                System.out.println("Mes de la revista: ");
                int mesRev = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer
                System.out.println("Tipo de revista (Técnica, Moda, Variedades): ");
                String tipoRevistaInput = sc.nextLine();
                TipoRevista tipoRev = TipoRevista.valueOf(tipoRevistaInput.toUpperCase());

                publicacion = new Revista(nombreRev, anioRev, mesRev, tipoRev);
                break;

            case 3:
                System.out.println("Nombre del periódico: ");
                String nombrePer = sc.nextLine();
                System.out.println("Fecha del periódico (en formato YYYY-MM-DD): ");
                String fechaPer = sc.nextLine();
                System.out.println("Lista de suplementos (revista, crucigrama, afiche): ");
                String listaSuplementosInput = sc.nextLine();
                String[] suplementosArray = listaSuplementosInput.split(",");
                ArrayList<Suplemento> listaSuplementos = new ArrayList<>();
                for (String suplemento : suplementosArray) {
                    try {
                            listaSuplementos.add(Suplemento.valueOf(suplemento.trim().toUpperCase()));
                        } catch (IllegalArgumentException e) {
                System.out.println("Suplemento inválido: " + suplemento);
                    }
                }

                publicacion = new Periodico(nombrePer, fechaPer, listaSuplementos);
                break;

            default:
                System.out.println("Opción inválida.");
                return; 
        }


        System.out.println("Código del armario al que desea agregar la publicación: ");
        String codigoArmario = sc.nextLine();
        Armario armario = dao.obtenerArmarioPorCodigo(codigoArmario);

        if (armario != null) {
            armario.agregarPublicacion(publicacion);
            dao.actualizar(armario); 
            System.out.println("Publicación agregada correctamente.");
        } else {
            System.out.println("No se encontró un armario con ese código.");
        }
    }

    private static void CargarPubli(Scanner sc) {
        System.out.println("Cargando publicación en armario...");
       
    }

    private static void Listar() {
        
        System.out.println("Listando biblioteca...");

       
        ArrayList<Armario> armarios = dao.obtenerTodosArmarios();

        if (armarios.isEmpty()) {
            System.out.println("No hay armarios registrados.");
        } else {
            for (Armario armario : armarios) {
                System.out.println("Armario código: " + armario.getCodigo() + ", Material: " + armario.getMaterial());
                System.out.println("Publicaciones: ");
                for (IPublicacion publi : armario.getPublicaciones()) {
                    System.out.println("  - " + publi.MostrarEtiqueta());
                }
            }
        }
    }
}
