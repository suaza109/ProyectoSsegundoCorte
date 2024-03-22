package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.AtaqueDTO;
import co.edu.unbosque.model.PokemonDTO;

/*
 * La clase AtaqueDAO es una implementacion de CRUDOperation para operaciones relacionadas con los ataques.
 * Hace uso de una lista de objetos de AtaqueDTO y proporciona metodos para crear, eliminar, actualizar y leer.
 */

public class AtaqueDAO implements CRUDOperation {

	private ArrayList<AtaqueDTO> listaAtaque;

	/*
	 * Constructor de la clase AtaqueDAO que inicializa la lista de ataques
	 */

	public AtaqueDAO() {
		listaAtaque = new ArrayList<>();
		// *leerDesdeArchivo();
		leerDesdeSerializado();
	}

	/*
	 * Lee la lista de ataques en un archivo serializado.
	 */

	public void leerDesdeSerializado() {

		Object temp = FileHandler.abrirYLeerSerializable("Ataque.nrs");
		if (temp == null) {
			listaAtaque = new ArrayList<>();
		} else {
			listaAtaque = (ArrayList<AtaqueDTO>) temp;
		}
	}

	/*
	 * La funcion atrae todo lo que se haya digitado en consola a contenido , y en
	 * contenido crea un archivo y lo escribe con lo que hay en el contenido.
	 */

	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaAtaque.size(); i++) {
			contenido += listaAtaque.get(i).getNombre() + ";";
			contenido += listaAtaque.get(i).getDanio();

			if (i < listaAtaque.size() - 1) {
				contenido += "\n";
			}
		}
		FileHandler.abrirYEscribirArchivo("Ataques.csv", contenido);

	}

	/*
	 * Lee la lista de ataques desde un archivo de texto.
	 */

	public void leerDesdeArchivo() {
		String contenido = FileHandler.abrirYLeerArchivo("Pokedex.csv");
		if (contenido.equals("")) {
			listaAtaque = new ArrayList<>();
			return;
		}

		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			AtaqueDTO temp = new AtaqueDTO();
			temp.setNombre(columnas[0]);
			temp.setDanio(Integer.parseInt(columnas[1]));

			listaAtaque.add(temp);
		}
	}

	/*
	 * Este metodo agrega un metodo AtaqueDTO a la lista de ataques en el DAO y
	 * escribe los cambios en un archivo.
	 */

	@Override
	public void create(Object o) {
		AtaqueDTO info = (AtaqueDTO) o;
		listaAtaque.add(info);
		escribirEnArchivo();
		FileHandler.abrirYEscribirSerializado("Ataque.nrs", o);
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
		if (index < 0 || index >= listaAtaque.size()) {
			return false;
		} else {
			listaAtaque.remove(index);
			escribirEnArchivo();
			return true;
		}
	}

	/*
	 * Este metodo actualiza un ataque de la lista en la posicion especificada por
	 * index con los atributos de otro objeto AtaqueDTO.Luego, guarda los datos en
	 * el archivo.
	 */

	@Override
	public boolean update(int index, Object o) {
		if (index < 0 || index >= listaAtaque.size()) {
			return false;
		} else {
			AtaqueDTO info = (AtaqueDTO) o;
			listaAtaque.get(index).setNombre(info.getNombre());
			listaAtaque.get(index).setDanio(info.getDanio());
		}
		escribirEnArchivo();
		return true;
	}

	/*
	 * Este método devuelve una cadena que contiene una representación de todos los
	 * ataques almacenados en el DAO.
	 */

	@Override
	public String read() {
		String exit = "";
		for (AtaqueDTO a : listaAtaque) {
			exit += a.toString() + "\n";
		}

		return exit;

	}
	
	

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

}
