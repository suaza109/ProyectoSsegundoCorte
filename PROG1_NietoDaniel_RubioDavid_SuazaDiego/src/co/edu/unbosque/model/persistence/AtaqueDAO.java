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

	public void leerDesdeSerializado() {

		Object temp = FileHandler.abrirYLeerSerializable("Ataque.nrs");
		if (temp == null) {
			listaAtaque = new ArrayList<>();
		} else {
			listaAtaque = (ArrayList<AtaqueDTO>) temp;
		}
	}

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

	@Override
	public void create(Object o) {
		AtaqueDTO info = (AtaqueDTO) o;
		listaAtaque.add(info);
		escribirEnArchivo();
		FileHandler.abrirYEscribirSerializado("Ataque.nrs", o);
	}

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
