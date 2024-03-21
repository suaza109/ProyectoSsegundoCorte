package co.edu.unbosque.model;

import java.io.Serializable;
	/*
	 * La clase AtaqueDTO representa los ataques de los pokemones.
	 * Contiene la informacion sobre el nombre del ataque y el daño del ataque.
	 */
public class AtaqueDTO implements Serializable {

	/**
	 * Identificador unico para la serializacion.
	 */
	private static final long serialVersionUID = 8716788316249623006L;
	private String nombre;
	private int danio;

	/*
	 * Constructor por defecto de la clase AtaqueDTO.
	 */
	public AtaqueDTO() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * Constructor por defecto que inicializa el nombre y el daño del ataque.
	 *  @param  nombre		el nombre del ataque.
	 *  @param  danio       el daño del ataque. 
	 *  
	 */

	public AtaqueDTO(String nombre, int danio) {
		super();
		this.nombre = nombre;
		this.danio = danio;
	}
	
	/*
	 * Obtiene el nombre del ataque.
	 * 
	 * @return el nombre.
	 */

	public String getNombre() {
		return nombre;
	}
	
	/*
	 * Establese el nombre de la clase
	 * 
	 * @param nombre	el nuevo nombre del ataque.
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/*
	 * Obtiene el daño del ataque.
	 * 
	 * return danio.
	 */

	public int getDanio() {
		return danio;
	}
	
	/*
	 * Establece el daño del ataque
	 * 
	 * @param danio    el nuevo daño del ataque.
	 */

	public void setDanio(int danio) {
		this.danio = danio;
	}
	
	/*
	 * Devuelve una representacion en cadena del ataque, incluyendo su nombre y daño.
	 * 
	 * @return Una cadena que representa el ataque.
	 */

	@Override
	public String toString() {
		return "Ataque: \n Nombre:" + nombre + "\n Daño:" + danio + "\n";
	}

}
