package co.edu.unbosque.controller;
import co.edu.unbosque.model.persistence.PokemonDAO;

public class Controller {
	private PokemonDAO pokemonDAO;
	
	public Controller() {
		pokemonDAO = new PokemonDAO();
	}
	
	public String crearPokemon(Object pokemon){
		pokemonDAO.create(pokemon);
		return "Pokemon Creado Con Exito";
	}
	public String eliminarPokemon(int id) {
		if(pokemonDAO.delete(id)) {
			return "Pokemon Eliminado con exito";
		}
		return "Algo Salio mal";
	}
	public String actualizarPokemon(int id, Object pokemon) {
		if(pokemonDAO.update(id, pokemon)) {
			return "Pokemon Actualizado con Exito";
		}
		return "Algo salio Mal";
	}

}
