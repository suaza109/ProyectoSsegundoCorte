package co.edu.unbosque.controller;

import co.edu.unbosque.model.persistence.PokemonDAO;

/**
 * La clase Controller es el controlador principal del programa.
 * Crea el objeto pokemonDAO que pertenece al DAO de pokemon.
 */
public class Controller {
	private PokemonDAO pokemonDAO;

	/**
	 * Constructor de la clase , inicializa el objeto pokemonDAO
	 */
	public Controller() {
		pokemonDAO = new PokemonDAO();
	}

	/**
	 * Este metodo crea un pokemon y retorna un mensaje.
	 * 
	 * @param pokemon Objeto del pokemon a crear.
	 * 
	 * @return pokemon creado con exito.
	 */
	public String crearPokemon(Object pokemon) {
		pokemonDAO.create(pokemon);
		return "Pokemon Creado Con Exito";
	}

	/**
	 * Este metodo elimina un pokemon mediante el id y retorna un mensaje si este es
	 * eliminado correctamente, y otro si no se pudo eliminar.
	 * 
	 * @param id el id del pokemon.
	 * 
	 * @return Pokemon eliminado con exito
	 * 
	 * @return Algo salio mal.
	 */
	public String eliminarPokemon(int id) {
		if (pokemonDAO.delete(id)) {
			return "Pokemon Eliminado con exito";
		}
		return "Algo Salio mal";
	}

	/**
	 * Este metodo actualiza un pokemon mediante el id y el objeto de este, y
	 * retorna un mensaje para cada caso.
	 * 
	 * @param id		el id del pokemon.
	 * @param pokemon	el objeto el cual es el pokemon.
	 * 
	 * @return Pokemon actualizado con exito
	 * @return Algo salio mal.
	 */
	public String actualizarPokemon(int id, Object pokemon) {
		if (pokemonDAO.update(id, pokemon)) {
			return "Pokemon Actualizado con Exito";
		}
		return "Algo salio Mal";
	}

}
