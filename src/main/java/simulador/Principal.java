package simulador;

import java.util.*;

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



public class Principal {

    // > > > > > > > > > > > > > > > > > > > G L O B A L E S < < < < < < < < < < < < < < < < < < < //

    static Scanner sc = new Scanner(System.in);

    static int option;
    static String busqueda;
    static int menuActual;

    static boolean firstMenuGestionarEntrenadores = true;
    static boolean firstSubMenuSeleccionarEntrenadores = true;
    static boolean firstMenuGestionarPokemones = true;
    static boolean firstMenuIniciarBatalla = true;

    static LinkedList<Pokemon> pokemonesDisponibles = new LinkedList<>();
    static LinkedList<Entrenador> pokeEntrenadores = new LinkedList<>();

    // > > > > > > > > > > > > > > > > > > > > > M A I N < < < < < < < < < < < < < < < < < < < < < //
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        final String NOMBRE_ARCHIVO = "ListaDePokemones.javaduo";
        final String NOMBRE2_ARCHIVO = "ListaDeEntrenadores.javaduo";

        // Leer datos guardados //
        pokemonesDisponibles = (LinkedList<Pokemon>)Save.leer(NOMBRE_ARCHIVO);
        pokeEntrenadores = (LinkedList<Entrenador>) Save.leer(NOMBRE2_ARCHIVO);
        interfazDeCarga(); //✅
        interfazBIENVENIDA(); //✅
        menu1(); //✅

        sc.close(); //cierra Scanner

    }//cierra main










    // > > > > > > > > > > > > > > > > > M E N U S  &  S W I T C H E S < < < < < < < < < < < < < < < < < //



    // [] [] [] [] [] [] [] [] [] [] [] [] MENU 1 [] [] [] [] [] [] [] [] [] [] [] [] //
    
    public static void menu1() {
    while (true) { // Repetir hasta que el usuario elija salir
        System.out.println("======== MENU PRINCIPAL ========");
        System.out.println("1. Gestionar Entrenadores");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opcion: ");
        int option = check(); // Valida la entrada del usuario

        switch (option) {
            case 1:
                menuGestionarEntrenadores();
                break;
            case 4:
                System.out.println("Saliendo del programa...");
                System.exit(0); // Termina el programa
                break;
            default:
                System.out.println("Opcion inválida. Intente nuevamente.");
        }
    }
}

     // [] [] [] [] [] [] [] [] [] MENU GESTIONAR ENTRENADORES [] [] [] [] [] [] [] [] [] //

    public static void menuGestionarEntrenadores(){ //✅

        while (firstMenuGestionarEntrenadores == true){
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡Has seleccionado « Gestionar Entrenadores » !");
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            firstMenuGestionarEntrenadores = false;
        }//cierra while
        
        wait(5);
    
        System.out.println("======== GESTIONAR ENTRENADORES ========");
        System.out.println("1. Registrar nuevo entrenador");
        System.out.println("2. Ver lista de entrenadores");
        System.out.println("3. Seleccionar un entrenador");
        System.out.println("4. Volver al menu principal");
        System.out.println("5. Guardar datos");
        System.out.print("Seleccione una opcion: ");
                    
        switchMenuGestionarEntrenadores(check());
    }//cierra menuGestionarEntrenadores

    // {} {} {} {} {} {} {} {} {} SWITCH GESTIONAR ENTRENADORES {} {} {} {} {} {} {} {} {} //

    public static void switchMenuGestionarEntrenadores(int option){ //✅

        switch (option){
            case 1: //✅
                
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado « Registrar nuevo entrenador » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(5);

                interfazDeCarga();

                wait(4);
                
                System.out.println("¡Ingrese el nombre del nuevo entrenador!");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                
                sc.nextLine();//Limpia Scanner
                String nombreEntrenador = sc.nextLine();
                pokeEntrenadores.add(new Entrenador(nombreEntrenador));

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Creando nuevo entrenador...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println("Registrando en la Liga Pokemon...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println(" ¡Entrenador registrado con exito! ");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println("Regresando al menu anterior...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(4);

                menu1();

                break;

            case 2: //✅

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado « Ver lista de entrenadores » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(5);

                interfazDeCarga();

                wait(4);

                if (pokeEntrenadores.isEmpty()) {
                    System.out.println("¡No hay entrenadores registrados!");
                    System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                    miniMenu(2);
                } else{
                    for (int i = 0; i < pokeEntrenadores.size(); i++) {
                        String pokeNombre = pokeEntrenadores.get(i).getNombre();
                        System.out.println("(" + (i) + ") | " + pokeNombre + " |");
                    }//cierra for
                    System.out.println("");
                }//cierra else-if

                menu1();

                break;
            case 3: //✅

                subMenuSeleccionarEntrenadores();

                break;
            case 4: //✅
                
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Regresando al menu principal...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
    
                wait(5);

                menu1();

                break;
            case 5: //✅

                
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Guardando pokemones...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                salir();
                break;
            default: //✅
                
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                System.out.println("¡Debe seleccionar una opcion valida!");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                wait(3);

                System.out.println("Reiniciando...");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                menuGestionarEntrenadores();

                break;
        }//cierra switch

    }//cierra switchMenuGestionarEntrenadores

    // [] [] [] [] [] [] [] [] [] SUBMENU SELECCIONAR ENTRENADORES [] [] [] [] [] [] [] [] [] //
    
    public static void subMenuSeleccionarEntrenadores(){ //✅

        int entrenadorSeleccionado = 0; //Reset

        while (firstSubMenuSeleccionarEntrenadores == true){
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("¡Has seleccionado « Seleccionar Entrenadores » !");     
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            firstSubMenuSeleccionarEntrenadores = false;
        }//cierra while
            
        wait(5);

        interfazDeCarga();

        wait(4);
        if (pokeEntrenadores.isEmpty()) {
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println("No hay entrenadores registrados.");
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual

            miniMenu(3);
        } else{

            for (int i = 0; i < pokeEntrenadores.size(); i++) {
                String pokeNombre = pokeEntrenadores.get(i).getNombre();
                System.out.println("(" + (i) + ") | " + pokeNombre + " |");
            }//cierra for

            System.out.println(""); //Espacio visual
            System.out.print("Selecciona el entrenador que deseas usar a continuación: ");
            entrenadorSeleccionado = check();

        }//cierra

        wait(4);

        System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        System.out.println("¡Has seleccionado al entrenador « " + pokeEntrenadores.get(entrenadorSeleccionado) + " » !");     
        System.out.println(" \n \n \n \n \n \n"); //Espacio visual

        wait(4);
        
        subMenuNombreEntrenador(entrenadorSeleccionado);

    }//cierra subMenuSeleccionarEntrenadores

    // [] [] [] [] [] [] [] [] [] SUBMENU NOMBRE ENTRENADOR [] [] [] [] [] [] [] [] [] //

    public static void subMenuNombreEntrenador(int entrenadorSeleccionado){ //✅

        System.out.println("======== MENU DE POKEMON ========");
        System.out.println("1. Ver equipo de Pokemon");
        System.out.println("2. Agregar Pokemon al equipo");
        System.out.println("3. Entrenar Pokemon");
        System.out.println("4. Volver al menú anterior");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opcion: ");
        switchNombreEntrenador(check(), entrenadorSeleccionado);
    }//cierra subMenuNombreEntrenador

    // {} {} {} {} {} {} {} {} {} SWITCH NOMBRE ENTRENADOR {} {} {} {} {} {} {} {} {} //

    public static void switchNombreEntrenador(int option, int entrenadorSeleccionado){ //✅
        switch (option){ //✅
            case 1: //✅
                
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado « Ver equipo de pokemones » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(5);

                interfazDeCarga();

                wait(4);

                Entrenador.mostrarPokemones();

                wait(5);

                miniMenu(4);

                break;

            case 2: //✅

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado « Agregar pokemon al equipo » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(5);

                interfazDeCarga();

                wait(4);

                pokeEntrenadores.get(entrenadorSeleccionado).agregarPokemon(pokemonesEquipo6(entrenadorSeleccionado));
                
                
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Agregando pokémon...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println(" ☆ ☆ ☆ Pokémon agregado al equipo con exito! ☆ ☆ ☆ ");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println("Regresando al menu anterior...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(4);

                subMenuNombreEntrenador(entrenadorSeleccionado);

                break;
            case 3: //✅

                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("¡Has seleccionado « Entrenar pokemon » !");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            
                wait(5);

                interfazDeCarga();

                wait(4);

                pokeEntrenadores.get(entrenadorSeleccionado).entrenarPokemon(pokemonesEquipo6(entrenadorSeleccionado));
                
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Entrenando pokemon...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println("Creando lazos más fuertes con el entrenador...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println("Perfeccionando movimientos...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println("Aumentando autoestima...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println(" ☆ ☆ ☆ Pokemon entrenado con exito! ☆ ☆ ☆ ");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(5);

                System.out.println("Regresando al menu anterior...");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(4);

                subMenuNombreEntrenador(entrenadorSeleccionado); 

                break;
            case 4: //✅
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Regresando al menu anterior...");     
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
    
                wait(5);

                menuGestionarEntrenadores();

            case 5: //✅
                
                
                System.out.println("Guardando entrenadores...");
                Save.guardar(pokeEntrenadores, "ListaDeEntrenadores.javaduo");
                System.out.println("Entrenadores guardados.");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual
                System.out.println("Datos guardados con exito!");
                System.out.println(" \n \n \n \n \n \n"); //Espacio visual

                wait(3); // Espera para que el mensaje de éxito sea visible

                salir();  // Salir del programa o volver al menú principal
                break;

            default: //✅
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                System.out.println("Debe seleccionar una opcion valida!");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                wait(2);

                System.out.println("Reiniciando...");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                menuGestionarEntrenadores();
                break;
        }//cierra switch
    }//cierra switchNombreEntrenador

    // [] [] [] [] [] [] [] [] [] POKEMONES EQUIPO 6 [] [] [] [] [] [] [] [] [] //

    public static Pokemon pokemonesEquipo6(int entrenadorSeleccionado){ //✅

        for (int i = 0; i < pokemonesDisponibles.size(); i++) {

            Pokemon p = pokemonesDisponibles.get(i);

            System.out.println("(" + (i+1) + ") | " + p.getNombre() + " | Salud -> " + p.getSalud() + " | Ataque -> " + p.getPuntosDeAtaque() + " | Tipo -> " + p.getTipo() + " |");
        }//cierra for
    
        return switchPokemonesEquipo6(check(), entrenadorSeleccionado);

    }//cierra pokemonesEquipo6

    // {} {} {} {} {} {} {} {} {} SWITCH POKEMONES EQUIPO 6 {} {} {} {} {} {} {} {} {} //

    public static Pokemon switchPokemonesEquipo6(int option, int entrenadorSeleccionado){ //✅🅿️
        switch (option) {
            case 1: // 🅿️
                // Abra
                Pokemon Abra = new Abra("Abra", 25, 20, TipoPokemon.PSIQUICO);
                return Abra;

            case 2: // 🅿️
                // Bellsprout
                Pokemon Bellsprout = new Bellsprout("Bellsprout", 50, 75, TipoPokemon.PLANTA.VENENO); // 🅿️ TODO: Dos tipos.
                return Bellsprout;

            case 3: // ✅
                // Doduo
                Pokemon Doduo = new Doduo("Doduo", 35, 85, TipoPokemon.NORMAL.VOLADOR); // 🅿️ TODO: Dos tipos.
                return Doduo;

            case 4: // ✅
                // Ekans
                Pokemon Ekans = new Ekans("Ekans", 35, 60, TipoPokemon.VENENO);
                return Ekans;

            case 5: // ✅
                // Magnemite
                Pokemon Magnemite = new Magnemite("Magnemite", 25, 35, TipoPokemon.ELECTRICO.ACERO); // 🅿️ TODO: Dos tipos.
                return Magnemite;

            case 6: // ✅
                // Machop
                Pokemon Machop = new Machop("Machop", 70, 80, TipoPokemon.LUCHA);
                return Machop;

            case 7: // ✅
                // Meowth
                Pokemon Meowth = new Meowth("Meowth", 40, 45, TipoPokemon.NORMAL);
                return Meowth;

            case 8: // ✅
                // Onix
                Pokemon Onix = new Onix("Onix", 35, 45, TipoPokemon.ROCA.TIERRA); // 🅿️ TODO: Dos tipos.
                return Onix;

            case 9: // ✅
                // Ponyta
                Pokemon Ponyta = new Ponyta("Ponyta", 50, 85, TipoPokemon.FUEGO);
                return Ponyta;

            case 10: // ✅
                // Staryu
                Pokemon Staryu = new Staryu("Staryu", 30, 45, TipoPokemon.AGUA);
                return Staryu;


            default: //✅
                System.out.println("No se ha seleccionado un pokemon valido.");
                System.out.print("Ingresa una opcion valida: ");
                switchPokemonesEquipo6(check(), entrenadorSeleccionado);
                break;
        }//cierra switch
        return null;
    }//cierra switchPokemonesEquipo6

    // [] [] [] [] [] [] [] [] [] MENU GESTIONAR POKEMONES [] [] [] [] [] [] [] [] [] //

    public static void menuGestionarPokemones(){ //🅿️
        while (firstMenuGestionarPokemones == true){
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println(" Has seleccionado « Gestionar Pokemones » !");   
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            firstMenuGestionarPokemones = false;
        }//cierra while
        
        wait(5);

        
        switchMenuGestionarPokemones(check());
    }//cierra menuGestionarPokemones

    // {} {} {} {} {} {} {} {} {} SWITCH GESTIONAR POKEMONES {} {} {} {} {} {} {} {} {} //

    public static void switchMenuGestionarPokemones(int option){ //🅿️
        switch (option){
            case 1:
                
                break;
            case 2:

                break;
            case 3:
                
                break;
            case 4:
                
                break;
            default:
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                System.out.println("¡Debe seleccionar una opcion válida!");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                wait(2);

                System.out.println("Reiniciando...");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                menuGestionarPokemones();
                break;
        }//cierra switch
    }//cierra switchMenuGestionarPokemones
    
    // [] [] [] [] [] [] [] [] [] MENU INICIAR BATALLA [] [] [] [] [] [] [] [] [] //

    public static void menuIniciarBatalla(){ //🅿️
        while (firstMenuIniciarBatalla == true){
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            System.out.println(" Has seleccionado «Iniciar Batalla»!");   
            System.out.println(" \n \n \n \n \n \n"); //Espacio visual
            firstMenuIniciarBatalla = false;
        }//cierra while
        
        wait(5);

        
        switchIniciarBatalla(check());
    }//cierra menuIniciarBatalla

    // {} {} {} {} {} {} {} {} {} SWITCH INICIAR BATALLA {} {} {} {} {} {} {} {} {} //
    
    public static void switchIniciarBatalla(int option){ //🅿️
        switch (option){
            case 1:
                
                break;
            case 2:

                break;
            case 3:
                
                break;
            case 4:
                
                break;
            default:
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual
                System.out.println("¡Debe seleccionar una opcion válida!");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                wait(2);

                System.out.println("Reiniciando...");
                System.out.println(" \n \n \n \n \n \n "); //Espacio visual

                menuIniciarBatalla();
                break;
        }//cierra switch
    }//cierra switchIniciarBatalla

    // [] [] [] [] [] [] [] [] [] SALIR [] [] [] [] [] [] [] [] []//

    public static void salir(){ //✅
        System.out.println(" \n \n \n \n \n \n "); //Espacio visual
        System.out.println("» » » Saliendo del simulador « « «");
        System.out.println(" \n \n \n \n \n \n "); //Espacio visual

        guardarPartida(pokemonesDisponibles, "ListaDePokemones.javaduo");
        
        wait(5);

        
        System.exit(0); //kill program
    }//cierra salir

    // > > > > > > > > > > > > > > > > > > H E R R A M I E N T A S < < < < < < < < < < < < < < < < < < //



    // () () () () () () () () () TIEMPO DE ESPERA () () () () () () () () () //

    public static void wait(int sec){ //✅
        try { 
            Thread.sleep(sec * 300);
         } catch (Exception e) {
            System.out.println(e);
         }
    }//cierra wait

    // () () () () () () () () () INTERFAZ DE CARGA () () () () () () () () () //

    public static void interfazDeCarga(){ //✅

        
        System.out.println("Cargando...");
        System.out.println(" \n \n \n \n \n \n"); //Espacio visual
        
    }//cierra interfaz de carga 
    // () () () () () () () () () INTERFAZ BIENVENIDA () () () () () () () () () //
    public static void interfazBIENVENIDA() {
    wait(2);  // Espera de 2 segundos

    System.out.println("Bienvenido al Simulador de Pokémon");
    System.out.println("\n\n\n");  // Espacios visuales (si quieres más separación)

    wait(2);
    
    System.out.println("\n\n\n");
}

    
    // () () () () () () () () () VALIDACION () () () () () () () () () //
    
    public static int check(){ //✅

        option = 0; //Reset de option.

        boolean validation = false; //Reset de validation.

            while (validation == false) {

                if (sc.hasNextInt()) { //Verificar que sea un entero.
                    option = sc.nextInt();
                    validation = true;
                } else {
                    System.out.println("» » » Por favor ingresa un numero entero valido. « « «");
                    sc.next(); // Descarta la entrada del scanner
                    sc.nextLine();
                    validation = false;
                }//cierra if else

            }//cierra while

        return option;
    }//cierra check

    // () () () () () () () () () MINI MENU () () () () () () () () () //

    public static void miniMenu(int actual){ //✅
        System.out.println(" > > > ¿Que deseas hacer? < < <");
        System.out.println("(1) para regresar al menu anterior.");
        System.out.println("(2) para salir del Simulador.");
        System.out.print("Digita una opción: ");

        int menuOpt = check();
        int menuActual = actual;

        if (menuOpt == 1) {
            menusGlobales(menuActual-1);
        } else if (menuOpt == 2){
            salir();
        } else {
            System.out.println("Ingrese una opcion valida");
        }//cierra if

    }//cierra miniMenu
    
    // () () () () () () () () () MENUS GLOBALES () () () () () () () () () //

    public static void menusGlobales(int menuOpt){ //🅿️

        switch (menuOpt) {
            case 1: //✅
                interfazDeCarga();
                menu1();
                break;
            case 2: //🅿️
                interfazDeCarga();
                menuGestionarEntrenadores();
                break;
            case 3: //🅿️
                interfazDeCarga();
                menuGestionarEntrenadores();
                break;
            case 4: //🅿️
                interfazDeCarga();
                menuGestionarPokemones();
                break;
            case 5: //🅿️
                interfazDeCarga();
                menuGestionarPokemones();
                break;
            case 6: //🅿️
                interfazDeCarga();
                menuIniciarBatalla();
                break;
            case 7: //🅿️
                interfazDeCarga();
                
                break;
            default:
                break;
        }
    }//cierra menusGlobales
    
    // () () () () () () () () () GUARDAR ARCHIVO () () () () () () () () () //

    public static void guardarPartida(LinkedList<Pokemon> pokemonesDisponibles, String NOMBRE_ARCHIVO){ //✅

        Save.guardar(pokemonesDisponibles, NOMBRE_ARCHIVO);

    }//cierra guardarPartida

}//cierra class
