package simulador.batalla;

import simulador.pokemon.Pokemon;

public class Batalla {
   
   public String iniciarBatalla(Pokemon pokemon1, Pokemon pokemon2){
      
      String nombrePokemonGanador;

      while (pokemon1.getSalud() > 0 && pokemon2.getSalud() > 0) {
         
         pokemon1.atacar(pokemon2);

         if (pokemon2.getSalud() > 0 ){
            pokemon2.atacar(pokemon1);
         }//cierra if

      }//cierra while
      
      if (pokemon1.getSalud() > 0) {
         nombrePokemonGanador = pokemon1.getNombre();
      } else if (pokemon2.getSalud() > 0) {
         nombrePokemonGanador = pokemon2.getNombre();
      } else {
         nombrePokemonGanador = "Error de ganador.";
      }//cierra else-if

      return nombrePokemonGanador;
      
   }//cierra iniciarBatalla

}//cierra class