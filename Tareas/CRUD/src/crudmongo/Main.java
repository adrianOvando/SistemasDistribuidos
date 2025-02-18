package crudmongo;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final PersonaDAO dao = new PersonaDAO();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- CRUD Personas ---");
            System.out.println("1. Crear Persona");
            System.out.println("2. Listar Personas");
            System.out.println("3. Actualizar Persona");
            System.out.println("4. Eliminar Persona");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> crearPersona();
                case 2 -> listarPersonas();
                case 3 -> actualizarPersona();
                case 4 -> eliminarPersona();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 5);
    }

    private static void crearPersona() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        Persona p = new Persona(nombre, apellido, edad);
        dao.crear(p);
    }

    private static void listarPersonas() {
        List<Persona> lista = dao.listar();
        System.out.println("\n--- Lista de Personas ---");
        for (Persona p : lista) {
            System.out.println(p);
        }
    }

    private static void actualizarPersona() {
        listarPersonas();
        System.out.print("\nIngrese el ID de la persona a actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nuevo Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nuevo Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Nueva Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        Persona p = new Persona(nombre, apellido, edad);
        dao.actualizar(id, p);
    }

    private static void eliminarPersona() {
        listarPersonas();
        System.out.print("\nIngrese el ID de la persona a eliminar: ");
        int id = sc.nextInt();
        sc.nextLine();
        dao.eliminar(id);
    }
}