package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.AtaqueDTO;
import co.edu.unbosque.model.PokemonDTO;

/*
 * La clase PokemonDAO es una implementacion de la interfaz CRUDOperation para operaciones relacionadas con los pokemones.
 * Gestiona una lista de objetos PokemonDTO y proporciona metodos para crear, eliminar, actualizar y leer pokemones.
 */

public class PokemonDAO implements CRUDOperation {

	private ArrayList<PokemonDTO> listaPokemon;

	/*
	 * Constructor de la clase PokemonDAO que inicializa la lista de pokemones y lee
	 * lo serializado.
	 */

	public PokemonDAO() {
		listaPokemon = new ArrayList<>();
		// *leerDesdeArchivo();
		leerDesdeSerializado();
	}

	/*
	 * La funcion leerDesdeSerializado lee desde serializado.
	 * 
	 * Abre y lee desde serializado si existe una lista de pokemones.
	 */

	public void leerDesdeSerializado() {

		Object temp = FileHandler.abrirYLeerSerializable("Planeta.ds");
		if (temp == null) {
			listaPokemon = new ArrayList<>();
		} else {
			listaPokemon = (ArrayList<PokemonDTO>) temp;
		}
	}

	/*
	 * La funcion atrae todo lo que se haya digitado en consola a contenido , y en
	 * contenido crea un archivo y lo escribe con lo que hay en el contenido.
	 */

	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaPokemon.size(); i++) {
			contenido += listaPokemon.get(i).getNombre() + ";";
			contenido += listaPokemon.get(i).getTipoPokemon() + ";";
			contenido += listaPokemon.get(i).getId() + ";";
			contenido += listaPokemon.get(i).getVida() + ";";
			contenido += listaPokemon.get(i).getAtaque() + ";";
			contenido += listaPokemon.get(i).getDefensa() + ";";
			contenido += listaPokemon.get(i).getListaAtaque() + ";";
			contenido += listaPokemon.get(i).getDefensaEspecial() + ";";
			contenido += listaPokemon.get(i).getVelocidad();

			if (i < listaPokemon.size() - 1) {
				contenido += "\n";
			}

		}

		FileHandler.abrirYEscribirArchivo("Pokedex.csv", contenido);
	}

	/*
	 * Lee la lista de pokemones desde un archivo de texto,
	 */

	public void leerDesdeArchivo() {
		String contenido = FileHandler.abrirYLeerArchivo("Pokedex.csv");
		if (contenido.equals("")) {
			listaPokemon = new ArrayList<>();
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
			String[] ataquesStr = columnas[6].split(";");
			ArrayList<AtaqueDTO> listaAtaques = new ArrayList<>();
			for (String ataqueStr : ataquesStr) {
				AtaqueDTO ataque = new AtaqueDTO();
				ataque.setNombre(ataqueStr.trim());
				listaAtaques.add(ataque);
			}
			temp.setListaAtaque(listaAtaques);

			listaPokemon.add(temp);
			temp.setDefensaEspecial(columnas[7]);
			temp.setVelocidad(Integer.parseInt(columnas[8]));

		}
	}

	/*
	 * Este metodo agrega un metodo PokemonDTO a la lista de pokemones en el DAO y
	 * escribe los cambios en un archivo.
	 */

	@Override
	public void create(Object o) {
		PokemonDTO info = (PokemonDTO) o;
		listaPokemon.add(info);
		escribirEnArchivo();
		FileHandler.abrirYEscribirSerializado("Pokedex.nrs", o);
	}

	/*
	 * Este metodo elimina un pokemon de la lista de pokemones
	 * 
	 * @param index
	 * 
	 * @return true si el pokemon se elimino correctamente, false si la posicion no
	 * existe.
	 */

	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= listaPokemon.size()) {
			return false;
		} else {
			listaPokemon.remove(index);
			escribirEnArchivo();
			return true;
		}
	}

	/*
	 * Este metodo actualiza un pokemon de la lista en la posicion especificada por
	 * index con los atributos de otro objeto PokemonDTO.Luego, guarda los datos en
	 * el archivo.
	 */

	@Override
	public boolean update(int index, Object o) {
		if (index < 0 || index >= listaPokemon.size()) {
			return false;
		} else {
			PokemonDTO info = (PokemonDTO) o;
			listaPokemon.get(index).setNombre(info.getNombre());
			listaPokemon.get(index).setTipoPokemon(info.getTipoPokemon());
			listaPokemon.get(index).setId(info.getId());
			listaPokemon.get(index).setVida(info.getVida());
			listaPokemon.get(index).setAtaque(info.getAtaque());
			listaPokemon.get(index).setDefensa(info.getDefensa());
			listaPokemon.get(index).setListaAtaque(info.getListaAtaque());
			listaPokemon.get(index).setDefensaEspecial(info.getDefensaEspecial());
			listaPokemon.get(index).setVelocidad(info.getVelocidad());

		}
		escribirEnArchivo();
		return true;
	}

	/*
	 * Este método devuelve una cadena que contiene una representación de todos los
	 * pokemones almacenados en el DAO.
	 */

	@Override
	public String read() {
		String exit = "";
		for (PokemonDTO p : listaPokemon) {
			exit += p.toString() + "\n";
		}

		return exit;

	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

}
