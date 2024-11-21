/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import conexion.Save;

import simulador.entrenador.Entrenador;

import simulador.pokemon.Pokemon;
import simulador.pokemon.TipoPokemon;

import simulador.pokemon.Abra;
import simulador.pokemon.Bellsprout;
import simulador.pokemon.Doduo;
import simulador.pokemon.Ekans;
import simulador.pokemon.Machop;
import simulador.pokemon.Magnemite;
import simulador.pokemon.Meowth;
import simulador.pokemon.Onix;
import simulador.pokemon.Ponyta;
import simulador.pokemon.Staryu;
import java.util.LinkedList;

public class creacion {
    public static void main(String[] args) {
        LinkedList<Pokemon> listaInicial = new LinkedList<>();

// Agregar los Pokémon mencionados
        listaInicial.add(new Pokemon("Abra", 25, 20, TipoPokemon.PSIQUICO));
        listaInicial.add(new Pokemon("Bellsprout", 50, 75, TipoPokemon.PLANTA.VENENO));
        listaInicial.add(new Pokemon("Doduo", 35, 85, TipoPokemon.NORMAL.VOLADOR));
        listaInicial.add(new Pokemon("Ekans", 35, 60, TipoPokemon.VENENO));
        listaInicial.add(new Pokemon("Magnemite", 25, 35, TipoPokemon.ELECTRICO.ACERO));
        listaInicial.add(new Pokemon("Machop", 70, 80, TipoPokemon.LUCHA));
        listaInicial.add(new Pokemon("Meowth", 40, 45, TipoPokemon.NORMAL));
        listaInicial.add(new Pokemon("Onix", 35, 45, TipoPokemon.ROCA.TIERRA));
        listaInicial.add(new Pokemon("Ponyta", 50, 85, TipoPokemon.FUEGO));
        listaInicial.add(new Pokemon("Staryu", 30, 45, TipoPokemon.AGUA));



        Save.guardar(listaInicial, "ListaDePokemones.javaduo");
        System.out.println("Archivo generado correctamente.");
    }
}
