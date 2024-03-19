package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class PokemonDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8445380900030386364L;

	private String nombre;
	private String tipoPokemon;
	private int id;
	private int vida;
	private int ataque;
	private int defensa;
	private ArrayList<AtaqueDTO> listaAtaque;
	private String defensaEspecial;
	private int velocidad;

	public PokemonDTO() {
		// TODO Auto-generated constructor stub
	}

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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoPokemon() {
		return tipoPokemon;
	}

	public void setTipoPokemon(String tipoPokemon) {
		this.tipoPokemon = tipoPokemon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public ArrayList<AtaqueDTO> getListaAtaque() {
		return listaAtaque;
	}

	public void setListaAtaque(ArrayList<AtaqueDTO> listaAtaque) {
		this.listaAtaque = listaAtaque;
	}

	public String getDefensaEspecial() {
		return defensaEspecial;
	}

	public void setDefensaEspecial(String defensaEspecial) {
		this.defensaEspecial = defensaEspecial;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public String toString() {
		return "Pokemon: \n Nombre:" + nombre + "\n Tipo de Pokemon:" + tipoPokemon + "\n Id:" + id + "\n Vida:" + vida
				+ "\n Ataque:" + ataque + "\n Defensa:" + defensa + "\n Ataque Especial:" + listaAtaque
				+ "\n Defensa Especial:" + defensaEspecial + "\n Velocidad:" + velocidad + "\n";
	}

}
