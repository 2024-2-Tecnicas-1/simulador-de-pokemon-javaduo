/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import conexion.Save;
import simulador.entrenador.Entrenador;

import java.util.LinkedList;

import java.io.File;
import java.util.LinkedList;
import conexion.Save;
import simulador.entrenador.Entrenador;

public class CreacionEntrenadores {
    public static void main(String[] args) {
        // Eliminar archivo viejo
        eliminarArchivo("ListaDeEntrenadores.javaduo");

        // Crear lista de entrenadores
        LinkedList<Entrenador> listaEntrenadores = new LinkedList<>();
        listaEntrenadores.add(new Entrenador("Ash"));
        listaEntrenadores.add(new Entrenador("Misty"));
        listaEntrenadores.add(new Entrenador("Brock"));
        listaEntrenadores.add(new Entrenador("Gary"));
        listaEntrenadores.add(new Entrenador("Tracey"));

        // Guardar la lista
        Save.guardar(listaEntrenadores, "ListaDeEntrenadores.javaduo");
        System.out.println("Entrenadores guardados correctamente.");

        // Cargar la lista y verificar su contenido
        cargarEntrenadores();
    }

    public static void eliminarArchivo(String nombreArchivo) {
        File archivo = new File("datos/" + nombreArchivo);
        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("Archivo " + nombreArchivo + " eliminado correctamente.");
            } else {
                System.out.println("No se pudo eliminar el archivo " + nombreArchivo + ".");
            }
        } else {
            System.out.println("Archivo " + nombreArchivo + " no existe.");
        }
    }

    public static void cargarEntrenadores() {
        Object datos = Save.leer("ListaDeEntrenadores.javaduo");
        if (datos instanceof LinkedList<?>) {
            LinkedList<?> lista = (LinkedList<?>) datos;
            if (!lista.isEmpty() && lista.get(0) instanceof Entrenador) {
                LinkedList<Entrenador> listaEntrenadores = (LinkedList<Entrenador>) lista;
                System.out.println("Entrenadores cargados correctamente:");
                for (Entrenador e : listaEntrenadores) {
                    System.out.println("- " + e.getNombre());
                }
            } else {
                System.out.println("El archivo no contiene datos de entrenadores.");
            }
        } else {
            System.out.println("El archivo contiene un formato no válido.");
        }
    }
}
