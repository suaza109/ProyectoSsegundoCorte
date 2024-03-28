package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.PokemonDTO;

public class PokemonDAO implements CRUDOperation{
	private ArrayList<PokemonDTO> lista;

	/*
	 * Constructor de la clase Generacion1DAO que inicializa la lista de la
	 * generacion y utiliza la funcion de leer desde serializado.
	 */

	public PokemonDAO() {
		lista = new ArrayList<>();
		// *leerDesdeArchivo();
		leerDesdeSerializado();
	}

	/*
	 * Lee la lista de la generacion 1 de pokemones mediante un archivo serializado.
	 */

	public void leerDesdeSerializado() {

		Object temp = FileHandler.abrirYLeerSerializable("PokedexSerializado.Ddd");
		if (temp == null) {
			lista = new ArrayList<>();
		} else {
			lista = (ArrayList<PokemonDTO>) temp;
		}
	}

	/*
	 * La funcion atrae todo lo que se haya digitado en consola a contenido , y en
	 * contenido crea un archivo y lo escribe con lo que hay en el contenido.
	 */

	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < lista.size(); i++) {
			contenido += lista.get(i).getNombre() + ";";
			contenido += lista.get(i).getTipoPokemon() + ";";
			contenido += lista.get(i).getId() + ";";
			contenido += lista.get(i).getVida() + ";";
			contenido += lista.get(i).getAtaque() + ";";
			contenido += lista.get(i).getDefensa() + ";";
			contenido += lista.get(i).getListaAtaque() + ";";
			contenido += lista.get(i).getDefensaEspecial() + ";";
			contenido += lista.get(i).getVelocidad()+ ";";
			contenido += lista.get(i).getFotogif()+ ";";
			contenido += lista.get(i).getGeneracion()+ ";";

			if (i < lista.size() - 1) {
				contenido += "\n";
			}

		}

		FileHandler.abrirYEscribirArchivo("Pokedex.csv", contenido);
	}

	/*
	 * Lee la lista de la generacion 1 de pokemones desde un archivo de texto.
	 */

	public void leerDesdeArchivo() {
		String contenido = FileHandler.abrirYLeerArchivo("Pokedex.csv");
		if (contenido.equals("")) {
			lista = new ArrayList<>();
			return;
		}

		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			PokemonDTO temp = new PokemonDTO();
			temp.setNombre(columnas[0]);
			temp.setTipoPokemon(columnas[1]);
			temp.setId(Integer.parseInt(columnas[2]));
			temp.setVida(Integer.parseInt(columnas[3]));
			temp.setAtaque(Integer.parseInt(columnas[4]));
			temp.setDefensa(Integer.parseInt(columnas[5]));
			temp.setListaAtaque(columnas[6]);
			temp.setDefensaEspecial(columnas[7]);
			temp.setVelocidad(Integer.parseInt(columnas[8]));
			temp.setFotogif(columnas[9]);
			temp.setGeneracion(Integer.parseInt(columnas[10]));
			
			lista.add(temp);

		}
	}

	/*
	 * Este metodo agrega un metodo Generacion1DTO a la lista de la generacion en el
	 * DAO y escribe los cambios en un archivo.
	 */

	@Override
	public void create(Object o) {
		PokemonDTO nuevo = (PokemonDTO) o;
		lista.add(nuevo);
		escribirEnArchivo();
		FileHandler.abrirYEscribirSerializado("PokedexSerializado.Ddd", lista);

	}

	/*
	 * Este metodo elimina un pokemon de la generacion 1 de la lista de pokemones
	 * 
	 * @param index
	 * 
	 * @return true si el pokemon se elimino correctamente, false si la posicion no
	 * existe.
	 */

	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= lista.size()) {
			return false;
		} else {
			lista.remove(index);
			escribirEnArchivo();
			FileHandler.abrirYEscribirSerializado("PokedexSerializado.Ddd", lista);
			return true;
		}
	}

	/*
	 * Este metodo actualiza un pokemon de esta generacion, de la lista en la
	 * posicion especificada por index con los atributos de otro objeto
	 * Generacion1DTO.Luego, guarda los datos en el archivo.
	 */

	@Override
	public boolean update(int index, Object o) {
		if (index < 0 || index >= lista.size()) {
			return false;
		} else {
			PokemonDTO info = (PokemonDTO)o;
			lista.get(index).setNombre(info.getNombre());
			lista.get(index).setTipoPokemon(info.getTipoPokemon());
			lista.get(index).setId(info.getId());
			lista.get(index).setVida(info.getVida());
			lista.get(index).setAtaque(info.getAtaque());
			lista.get(index).setDefensa(info.getDefensa());
			lista.get(index).setListaAtaque(info.getListaAtaque());
			lista.get(index).setDefensaEspecial(info.getDefensaEspecial());
			lista.get(index).setVelocidad(info.getVelocidad());
			lista.get(index).setFotogif(info.getFotogif());
			lista.get(index).setGeneracion(info.getGeneracion());

		}
		FileHandler.abrirYEscribirSerializado("PokedexSerializado.Ddd", lista);
		escribirEnArchivo();
		return true;
	}

	/*
	 * Este método devuelve una cadena que contiene una representación de todos los
	 * pokemones de la generacion 1 almacenados en el DAO.
	 */

	@Override
	public String read() {
		String exit = "";
		for (PokemonDTO g : lista) {
			exit += g.toString() + "\n";
		}

		return exit;
	}
	
	public ArrayList<PokemonDTO> getLista(){
		return lista;
	}

}
