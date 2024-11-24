package Vista;
import Controlador.GestionLenguaje;
import Modelo.LenguajeProgramacion;
import java.util.Scanner;
/**
 *
 * @author alons
 */

public class SistemaRegistro {
    private static GestionLenguaje gestion = new GestionLenguaje();
    private static Scanner Lector = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcion;
        do {
            System.out.println("\n*** Menu para Registrar Lenguajes ***");
            System.out.println("* 1. Agregar Lenguaje               *");
            System.out.println("* 2. Buscar Lenguaje                *");
            System.out.println("* 3. Eliminar Lenguaje              *");
            System.out.println("* 4. Imprimir Lenguajes             *");
            System.out.println("* 5. Salir                          *");
            System.out.println("*************************************");
            System.out.print("Seleccione una opcion: ");
            opcion = Lector.nextInt();
            Lector.nextLine(); 

            switch (opcion) {
                case 1 -> agregarLenguaje();
                case 2 -> buscarLenguaje();
                case 3 -> eliminarLenguaje();
                case 4 -> gestion.imprimirLenguajes();
                case 5 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    private static void agregarLenguaje() {
        System.out.print("Ingrese el año de creación: ");
        int anioCreacion = Lector.nextInt();
        Lector.nextLine(); 
        System.out.print("Ingrese la característica principal: ");
        String caracteristicaPrincipal = Lector.nextLine();
        System.out.print("Ingrese el nombre del lenguaje: ");
        String nombre = Lector.nextLine();
        System.out.print("Ingrese la utilización: ");
        String utilizacion = Lector.nextLine();

        gestion.agregarLenguaje(anioCreacion, caracteristicaPrincipal, nombre, utilizacion);
    }
                                                    
    private static void buscarLenguaje() {
        System.out.print("Ingrese el nombre del lenguaje que desea buscar: ");
        String nombre = Lector.nextLine();
        LenguajeProgramacion lenguaje = gestion.buscarLenguaje(nombre);
        if (lenguaje != null) {
            System.out.println("Lenguaje encontrado: " + lenguaje);
        } else {
            System.out.println("El lenguaje no ha sido encontrado.");
        }
    }

    private static void eliminarLenguaje() {
        System.out.print("Ingrese el nombre del lenguaje que desea eliminar: ");
        String nombre = Lector.nextLine();
        if (!gestion.eliminarLenguaje(nombre)) {
            System.out.println("No se pudo eliminar, el lenguaje no ha sido encontrado.");
        }
    }
}