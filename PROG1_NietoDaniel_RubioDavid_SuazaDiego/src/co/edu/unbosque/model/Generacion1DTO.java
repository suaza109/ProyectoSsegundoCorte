package co.edu.unbosque.model;


/*
 * La clase Generacion1DTO representa la generacion 1 de los pokemones 
 */

public class Generacion1DTO extends PokemonDTO {

	/**
	 * Identificador unico para la serializacion.
	 */
	private static final long serialVersionUID = -1638480933006394296L;

	/*
	 * Constructor por defecto de la clase Generacion1DTO.
	 */

	public Generacion1DTO() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * Constructor por defecto que inicializa el nombre, tipo, id,vida, ataque,
	 * defensa, lista de ataque, defensa especial y velocidad de la generacion 1 de
	 * pokemones.
	 */

	public Generacion1DTO(String nombre, String tipoPokemon, int id, int vida, int ataque, int defensa,
			String listaAtaque, String defensaEspecial, int velocidad) {
		super(nombre, tipoPokemon, id, vida, ataque, defensa, listaAtaque, defensaEspecial, velocidad);
		// TODO Auto-generated constructor stub
	}

	/*
	 * Devuelve una representacion en cadena de la generacion 1 de pokemones.
	 * 
	 * @return Una cadena que representa la generacion 1 de pokemones.
	 */

	@Override
	public String toString() {
		return "Generacion 1: \n Nombre:" + getNombre() + "\n Tipo de Pokemon:" + getTipoPokemon() + "\n Id:" + getId()
				+ "\n Vida:" + getVida() + "\n Ataque:" + getAtaque() + "\n Defensa:" + getDefensa()
				+ "\n Lista de Ataque:" + getListaAtaque() + "\n Defensa Especial:" + getDefensaEspecial()
				+ "\n Velocidad:" + getVelocidad() + "\n";
	}
}
