package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * La clase PokemonDTO representa todos los pokemones.
 * Contiene la informacion sobre el nombre, tipo, id, vida, ataque , defensa , lista de ataque, defensa especial y velocidad del pokemon.
 */
public class PokemonDTO implements Serializable {

	/**
	 * Identificador unico para la serializacion.
	 */
	private static final long serialVersionUID = -8445380900030386364L;

	/*
	 * Contiene los atributos del pokemon.	
	 */
	
	private String nombre;
	private String tipoPokemon;
	private int id;
	private int vida;
	private int ataque;
	private int defensa;
	private ArrayList<AtaqueDTO> listaAtaque;
	private String defensaEspecial;
	private int velocidad;
	
	/*
	 * Constructor por defecto de la clase PokemonDTO.
	 */

	public PokemonDTO() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Constructor por defecto que inicializa el nombre, tipo, id, vida, ataque, defensa, lista de ataque, defensa especial y velocidad del pokemon.
	 * @param nombre			el nombre del pokemon
	 * @param tipoPokemon		el tipo de pokemon
	 * @param id				el id del pokemon
	 * @param vida				la vida del pokemon
	 * @param ataque			el ataque del pokemon
	 * @param defensa			la defensa del pokemon
	 * @param listaAtaque		la lista de ataques del pokemon
	 * @param defensaEspecial	la defensa especial del pokemon
	 * @param velocidad			la velocidad del pokemon
	 */

	public PokemonDTO(String nombre, String tipoPokemon, int id, int vida, int ataque, int defensa,
			ArrayList<AtaqueDTO> listaAtaque, String defensaEspecial, int velocidad) {
		super();
		this.nombre = nombre;
		this.tipoPokemon = tipoPokemon;
		this.id = id;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.listaAtaque = listaAtaque;
		this.defensaEspecial = defensaEspecial;
		this.velocidad = velocidad;
	}
	
	/*
	 * Obtiene el nombre del pokemon
	 * 
	 * @return nombre	el nombre del pokemon
	 */

	public String getNombre() {
		return nombre;
	}
	
	/*
	 * Establece el nombre del pokemon
	 * 
	 * @param nombre	el nuevo nombre del pokemon
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/*
	 * Obtiene el tipo del pokemon
	 * 
	 * @return tipoPokemon	el tipo del pokemon
	 */

	public String getTipoPokemon() {
		return tipoPokemon;
	}
	
	/*
	 * Establece el tipo del pokemon
	 * 
	 * @param tipoPokemon	el nuevo tipo del pokemon
	 */

	public void setTipoPokemon(String tipoPokemon) {
		this.tipoPokemon = tipoPokemon;
	}
	
	/*
	 * Obtiene el id del pokemon
	 * 
	 * @return id	el id del pokemon
	 */

	public int getId() {
		return id;
	}
	
	/*
	 * Establece el id del pokemon
	 * 
	 * @param id	el nuevo id del pokemon
	 */

	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 * Obtiene la vida del pokemon
	 * 
	 * @return vida		la vida del pokemon
	 */

	public int getVida() {
		return vida;
	}
	
	/*
	 * Establece la vida del pokemon
	 * 
	 * @param vida	la nueva vida  del pokemon
	 */

	public void setVida(int vida) {
		this.vida = vida;
	}
	
	/*
	 * Obtiene el ataque del pokemon
	 * 
	 * @return ataque	el ataque del pokemon
	 */

	public int getAtaque() {
		return ataque;
	}
	
	/*
	 * Establece el ataque del pokemon
	 * 
	 * @param ataque	el nuevo ataque del pokemon
	 */

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	/*
	 * Obtiene la defensa del pokemon
	 * 
	 * @return defensa	la defensa del pokemon
	 */

	public int getDefensa() {
		return defensa;
	}
	
	/*
	 * Establece la defensa del pokemon
	 * 
	 * @param defensa	la nueva defensa del pokemon
	 */

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	
	/*
	 * Obtiene la lista de ataque del pokemon
	 * 
	 * @return listaAtaque		la lista de ataque del pokemon
	 */

	public ArrayList<AtaqueDTO> getListaAtaque() {
		return listaAtaque;
	}
	
	/*
	 * Establece la lista de ataque del pokemon
	 * 
	 * @param listaAtaque	la nueva lista de ataque del pokemon
	 */

	public void setListaAtaque(ArrayList<AtaqueDTO> listaAtaque) {
		this.listaAtaque = listaAtaque;
	}
	
	/*
	 * Obtiene la defensa especial del pokemon
	 * 
	 * @return defensaEspecial		la defensa especial del pokemon
	 */

	public String getDefensaEspecial() {
		return defensaEspecial;
	}
	
	/*
	 * Establece la defensa especial del pokemon
	 * 
	 * @param defensaEspecial		la nueva defensa especial del pokemon
	 */

	public void setDefensaEspecial(String defensaEspecial) {
		this.defensaEspecial = defensaEspecial;
	}
	
	/*
	 * Obtiene la velocidad del pokemon
	 * 
	 * @return velocidad	la velocidad del pokemon
	 */

	public int getVelocidad() {
		return velocidad;
	}
	
	/*
	 * Establece la velocidad del pokemon
	 * 
	 * @param velocidad		la nueva velocidad del pokemon
	 */

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	/*
	 * Devuelve una representacion en cadena del nombre, tipo, id, vida, ataque, defensa, lista de ataque, defensa especial y velocidad del pokemon.
	 * 
	 * @return Una cadena que representa el pokemon.
	 */

	@Override
	public String toString() {
		return "Pokemon: \n Nombre:" + nombre + "\n Tipo de Pokemon:" + tipoPokemon + "\n Id:" + id + "\n Vida:" + vida
				+ "\n Ataque:" + ataque + "\n Defensa:" + defensa + "\n Ataque Especial:" + listaAtaque
				+ "\n Defensa Especial:" + defensaEspecial + "\n Velocidad:" + velocidad + "\n";
	}

}
