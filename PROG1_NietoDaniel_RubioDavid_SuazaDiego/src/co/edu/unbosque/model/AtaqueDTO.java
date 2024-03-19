package co.edu.unbosque.model;

import java.io.Serializable;

public class AtaqueDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8716788316249623006L;
	private String nombre;
	private int danio;

	public AtaqueDTO() {
		// TODO Auto-generated constructor stub
	}

	public AtaqueDTO(String nombre, int danio) {
		super();
		this.nombre = nombre;
		this.danio = danio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDanio() {
		return danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}

	@Override
	public String toString() {
		return "Ataque: \n Nombre:" + nombre + "\n Daño:" + danio + "\n";
	}

}
