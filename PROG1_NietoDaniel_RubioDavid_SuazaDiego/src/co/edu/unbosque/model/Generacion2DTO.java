package co.edu.unbosque.model;


/*
 * La clase Generacion2DTO representa la segunda generacion de pokemones
 */

public class Generacion2DTO extends PokemonDTO {

	/**
	 * Identificador unico para la serializacion.
	 */
	private static final long serialVersionUID = 819990090731183264L;

	/*
	 * Constructor por defecto de la clase Gneracion2DTO.
	 */

	public Generacion2DTO() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * Constructor por defecto que inicializa el nombre, tipo, id,vida, ataque,
	 * defensa, lista de ataque, defensa especial y velocidad de la generacion 2 de
	 * pokemones.
	 */

	public Generacion2DTO(String nombre, String tipoPokemon, int id, int vida, int ataque, int defensa,
			String listaAtaque, String defensaEspecial, int velocidad) {
		super(nombre, tipoPokemon, id, vida, ataque, defensa, listaAtaque, defensaEspecial, velocidad);
		// TODO Auto-generated constructor stub
	}

	/*
	 * Devuelve una representacion en cadena de la generacion 2 de pokemones.
	 * 
	 * @return Una cadena que representa la generacion 2 de pokemones.
	 */

	@Override
	public String toString() {
		return "Generacion 2: \n Nombre:" + getNombre() + "\n Tipo de Pokemon:" + getTipoPokemon() + "\n Id:" + getId()
				+ "\n Vida:" + getVida() + "\n Ataque:" + getAtaque() + "\n Defensa:" + getDefensa()
				+ "\n Lista de Ataque:" + getListaAtaque() + "\n Defensa Especial" + getDefensaEspecial()
				+ "\n Velocidad:" + getVelocidad() + "\n";
	}

}
