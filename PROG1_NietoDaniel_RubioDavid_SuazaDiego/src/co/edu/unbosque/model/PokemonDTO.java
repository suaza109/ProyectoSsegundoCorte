package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase PokemonDTO representa todos los pokemones. Contiene la informacion
 * sobre el nombre, tipo, id, vida, ataque , defensa , lista de ataque, defensa
 * especial y velocidad del pokemon.
 */
public class PokemonDTO implements Serializable {

	/**
	 * Identificador unico para la serializacion.
	 */
	private static final long serialVersionUID = -8445380900030386364L;

	/**
	 * Contiene los atributos del pokemon.
	 */

	private String nombre;
	private String tipoPokemon;
	private int generacion;
	private int id;
	private int vida;
	private int ptsAtaque;
	private int defensa;
	private int velocidad;
	private String listaAtaque;
	private String defensaEspecial;
	private String fotoGif;

	/**
	 * Constructor por defecto de la clase PokemonDTO.
	 */

	public PokemonDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor por defecto que inicializa el nombre, tipo, id, vida, ataque,
	 * defensa, lista de ataque, defensa especial y velocidad del pokemon.
	 * 
	 * @param nombre          el nombre del pokemon
	 * @param tipoPokemon     el tipo de pokemon
	 * @param id              el id del pokemon
	 * @param vida            la vida del pokemon
	 * @param ataque          el ataque del pokemon
	 * @param defensa         la defensa del pokemon
	 * @param listaAtaque     la lista de ataques del pokemon
	 * @param defensaEspecial la defensa especial del pokemon
	 * @param velocidad       la velocidad del pokemon
	 */

	public PokemonDTO(String nombre, String tipoPokemon, int id, int vida, int ataque, int defensa, String listaAtaque,
			String defensaEspecial, int velocidad, String fotogif, int generacion) {
		super();
		this.nombre = nombre;
		this.tipoPokemon = tipoPokemon;
		this.id = id;
		this.vida = vida;
		this.ptsAtaque = ataque;
		this.defensa = defensa;
		this.listaAtaque = listaAtaque;
		this.defensaEspecial = defensaEspecial;
		this.velocidad = velocidad;
		this.fotoGif = fotogif;
		this.generacion = generacion;
	}

	/**
	 * Obtiene el nombre del pokemon
	 * 
	 * @return nombre el nombre del pokemon
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del pokemon
	 * 
	 * @param nombre el nuevo nombre del pokemon
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el tipo del pokemon
	 * 
	 * @return tipoPokemon el tipo del pokemon
	 */

	public String getTipoPokemon() {
		return tipoPokemon;
	}

	/**
	 * Establece el tipo del pokemon
	 * 
	 * @param tipoPokemon el nuevo tipo del pokemon
	 */

	public void setTipoPokemon(String tipoPokemon) {
		this.tipoPokemon = tipoPokemon;
	}

	/**
	 * Obtiene el id del pokemon
	 * 
	 * @return id el id del pokemon
	 */

	public int getId() {
		return id;
	}

	/**
	 * Establece el id del pokemon
	 * 
	 * @param id el nuevo id del pokemon
	 */

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene la vida del pokemon
	 * 
	 * @return vida la vida del pokemon
	 */

	public int getVida() {
		return vida;
	}

	/**
	 * Establece la vida del pokemon
	 * 
	 * @param vida la nueva vida del pokemon
	 */

	public void setVida(int vida) {
		this.vida = vida;
	}

	/**
	 * Obtiene el ataque del pokemon
	 * 
	 * @return ataque el ataque del pokemon
	 */

	public int getAtaque() {
		return ptsAtaque;
	}

	/**
	 * Establece el ataque del pokemon
	 * 
	 * @param ataque el nuevo ataque del pokemon
	 */

	public void setAtaque(int ataque) {
		this.ptsAtaque = ataque;
	}

	/**
	 * Obtiene la defensa del pokemon
	 * 
	 * @return defensa la defensa del pokemon
	 */

	public int getDefensa() {
		return defensa;
	}

	/**
	 * Establece la defensa del pokemon
	 * 
	 * @param defensa la nueva defensa del pokemon
	 */

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	/**
	 * Obtiene la lista de ataque del pokemon
	 * 
	 * @return listaAtaque la lista de ataque del pokemon
	 */

	public String getListaAtaque() {
		return listaAtaque;
	}

	/**
	 * Establece la lista de ataque del pokemon
	 * 
	 * @param listaAtaque la nueva lista de ataque del pokemon
	 */

	public void setListaAtaque(String listaAtaque) {
		this.listaAtaque = listaAtaque;
	}

	/**
	 * Obtiene la defensa especial del pokemon
	 * 
	 * @return defensaEspecial la defensa especial del pokemon
	 */

	public String getDefensaEspecial() {
		return defensaEspecial;
	}

	/**
	 * Establece la defensa especial del pokemon
	 * 
	 * @param defensaEspecial la nueva defensa especial del pokemon
	 */

	public void setDefensaEspecial(String defensaEspecial) {
		this.defensaEspecial = defensaEspecial;
	}

	/**
	 * Obtiene la velocidad del pokemon
	 * 
	 * @return velocidad la velocidad del pokemon
	 */

	public int getVelocidad() {
		return velocidad;
	}

	/**
	 * Establece la velocidad del pokemon
	 * 
	 * @param velocidad la nueva velocidad del pokemon
	 */

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	/**
	 * Obtiene la foto de tipo gif de cada pokemon.
	 * 
	 * @return fotoGif La foto del pokemon en gif.
	 */

	public String getFotoGif() {
		return fotoGif;
	}

	/**
	 * Establece la foto de tipo gif de cada pokemon.
	 * 
	 * @param fotogif la nueva foto gif de los pokemon.
	 */

	public void setFotoGif(String fotoGif) {
		this.fotoGif = fotoGif;
	}

	/**
	 * Obtiene la generacion del pokemon.
	 * 
	 * @return generacion La generacion del pokemon.
	 */

	public int getGeneracion() {
		return generacion;
	}

	/**
	 * Establece la generacion del pokemon
	 * 
	 * @param generacion la nueva generacion del pokemon.
	 */

	public void setGeneracion(int generacion) {
		this.generacion = generacion;
	}

	/**
	 * Devuelve una representacion en cadena del nombre, tipo, id, vida, ataque,
	 * defensa, lista de ataque, defensa especial y velocidad del pokemon.
	 * 
	 * @return Una cadena que representa el pokemon.
	 */

	@Override
	public String toString() {
		return "Pokemon: \n Nombre:" + nombre + "\n Tipo de Pokemon:" + tipoPokemon + "\n Id:" + id + "\n Vida:" + vida
				+ "\n Ataque:" + ptsAtaque + "\n Defensa:" + defensa + "\n Ataque Especial:" + listaAtaque
				+ "\n Defensa Especial:" + defensaEspecial + "\n Velocidad:" + velocidad + "\n Generación: "
				+ generacion + "\n Url: " + fotoGif + "\n";
	}

}
