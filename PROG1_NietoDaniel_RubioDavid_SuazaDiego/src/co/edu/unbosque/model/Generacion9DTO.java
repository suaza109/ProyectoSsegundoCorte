package co.edu.unbosque.model;


/*
 * La clase Generacion3DTO representa la generacion 9 de los pokemones 
 */
public class Generacion9DTO extends PokemonDTO {

	/**
	 * Identificador unico para la serializacion.
	 */
	private static final long serialVersionUID = 5778879903897961119L;

	/*
	 * Constructor por defecto de la clase Generacion9DTO.
	 */

	public Generacion9DTO() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * Constructor por defecto que inicializa el nombre, tipo, id,vida, ataque,
	 * defensa, lista de ataque, defensa especial y velocidad de la generacion 9 de
	 * pokemones.
	 */

	public Generacion9DTO(String nombre, String tipoPokemon, int id, int vida, int ataque, int defensa,
			String listaAtaque, String defensaEspecial, int velocidad) {
		super(nombre, tipoPokemon, id, vida, ataque, defensa, listaAtaque, defensaEspecial, velocidad);
		// TODO Auto-generated constructor stub
	}

	/*
	 * Devuelve una representacion en cadena de la generacion 9 de pokemones.
	 * 
	 * @return Una cadena que representa la generacion 9 de pokemones.
	 */

	@Override
	public String toString() {
		return "Generacion 9: \n Nombre:" + getNombre() + "\n Tipo de Pokemon:" + getTipoPokemon() + "\n Id:" + getId()
				+ "\n Vida:" + getVida() + "\n Ataque:" + getAtaque() + "\n Defensa:" + getDefensa()
				+ "\n Lista de Ataque:" + getListaAtaque() + "\n Defensa Especial:" + getDefensaEspecial()
				+ "\n Velocidad:" + getVelocidad() + "\n";
	}

}
