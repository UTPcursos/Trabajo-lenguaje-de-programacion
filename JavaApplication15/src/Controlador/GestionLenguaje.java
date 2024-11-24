package Controlador;

/**
 *
 * @author alons
 */
import Modelo.LenguajeProgramacion;

public class GestionLenguaje {
    private static final int FACTOR_CRECIMIENTO = 2;
    private static LenguajeProgramacion[] ArregloLenguajes = new LenguajeProgramacion[FACTOR_CRECIMIENTO];
    private int ContadorLenguajes = 0;
    
    public void agregarLenguaje(int anioCreacion, String caracteristicaPrincipal, String nombre, String utilizacion) {
        if (ContadorLenguajes == ArregloLenguajes.length) {
            
        }
        ArregloLenguajes[ContadorLenguajes++] = new LenguajeProgramacion(anioCreacion, caracteristicaPrincipal, nombre, utilizacion);
        System.out.println("Lenguaje agregado exitosamente.");
    }


    public LenguajeProgramacion buscarLenguaje(String nombre) {
        for (int i = 0; i < ContadorLenguajes; i++) {
            if (ArregloLenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                return ArregloLenguajes[i];
            }
        }
        return null;
    }

    public boolean eliminarLenguaje(String nombre) {
        for (int i = 0; i < ContadorLenguajes; i++) {
            if (ArregloLenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                for (int j = i; j < ContadorLenguajes - 1; j++) {
                    ArregloLenguajes[j] = ArregloLenguajes[j + 1];
                }
                ArregloLenguajes[--ContadorLenguajes] = null;
                return true;
            }
        }
        return false;
    }

  

    public void imprimirLenguajes() {
        if (ContadorLenguajes == 0) {
            System.out.println("No hay lenguajes registrados.");
        } else {
            for (int i = 0; i < ContadorLenguajes; i++) {
                System.out.println(ArregloLenguajes[i]);
            }
        }
    }
}
    