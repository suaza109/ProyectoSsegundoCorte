package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.AtaqueDTO;
import co.edu.unbosque.model.Generacion1DTO;
import co.edu.unbosque.model.Generacion9DTO;

/*
 * La clase Generacion9DAO es una implementacion de CRUDOperation para operaciones relacionadas con los pokemones de esta generacion.
 * Hace uso de una lista de objetos de Generacion1DTO y proporciona metodos para crear, eliminar, actualizar y leer.
 */

public class Generacion9DAO implements CRUDOperation {
	private ArrayList<Generacion9DTO> listaGen9;

	/*
	 * Constructor de la clase Generacion9DAO que inicializa la lista de la
	 * generacion y utiliza la funcion de leer desde serializado.
	 */

	public Generacion9DAO() {
		listaGen9 = new ArrayList<>();
		// *leerDesdeArchivo();
		leerDesdeSerializado();
	}

	/*
	 * Lee la lista de la generacion 9 de pokemones mediante un archivo serializado.
	 */

	public void leerDesdeSerializado() {

		Object temp = FileHandler.abrirYLeerSerializable("Planeta.ds");
		if (temp == null) {
			listaGen9 = new ArrayList<>();
		} else {
			listaGen9 = (ArrayList<Generacion9DTO>) temp;
		}
	}

	/*
	 * La funcion atrae todo lo que se haya digitado en consola a contenido , y en
	 * contenido crea un archivo y lo escribe con lo que hay en el contenido.
	 */

	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaGen9.size(); i++) {
			contenido += listaGen9.get(i).getNombre() + ";";
			contenido += listaGen9.get(i).getTipoPokemon() + ";";
			contenido += listaGen9.get(i).getId() + ";";
			contenido += listaGen9.get(i).getVida() + ";";
			contenido += listaGen9.get(i).getAtaque() + ";";
			contenido += listaGen9.get(i).getDefensa() + ";";
			contenido += listaGen9.get(i).getListaAtaque() + ";";
			contenido += listaGen9.get(i).getDefensaEspecial() + ";";
			contenido += listaGen9.get(i).getVelocidad();

			if (i < listaGen9.size() - 1) {
				contenido += "\n";
			}

		}

		FileHandler.abrirYEscribirArchivo("Pokedex.csv", contenido);
	}

	/*
	 * Lee la lista de la generacion 9 de pokemones desde un archivo de texto.
	 */

	public void leerDesdeArchivo() {
		String contenido = FileHandler.abrirYLeerArchivo("Pokedex.csv");
		if (contenido.equals("")) {
			listaGen9 = new ArrayList<>();
			return;
		}

		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			Generacion9DTO temp = new Generacion9DTO();
			temp.setNombre(columnas[0]);
			temp.setTipoPokemon(columnas[1]);
			temp.setId(Integer.parseInt(columnas[2]));
			temp.setVida(Integer.parseInt(columnas[3]));
			temp.setAtaque(Integer.parseInt(columnas[4]));
			temp.setDefensa(Integer.parseInt(columnas[5]));
			temp.setListaAtaque(columnas[6]);
			temp.setDefensaEspecial(columnas[7]);
			temp.setVelocidad(Integer.parseInt(columnas[8]));
			listaGen9.add(temp);

		}
	}

	/*
	 * Este metodo agrega un metodo Generacion9DTO a la lista de la generacion en el
	 * DAO y escribe los cambios en un archivo.
	 */

	@Override
	public void create(Object o) {
		Generacion9DTO nuevo = (Generacion9DTO) o;
		listaGen9.add(nuevo);
		escribirEnArchivo();
		FileHandler.abrirYEscribirSerializado("Pokedex.nrs", listaGen9);
	}

	/*
	 * Este metodo elimina un pokemon de la generacion 9 de la lista de pokemones
	 * 
	 * @param index
	 * 
	 * @return true si el pokemon se elimino correctamente, false si la posicion no
	 * existe.
	 */

	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= listaGen9.size()) {
			return false;
		} else {
			listaGen9.remove(index);
			escribirEnArchivo();
			return true;
		}
	}

	/*
	 * Este metodo actualiza un pokemon de esta generacion, de la lista en la
	 * posicion especificada por index con los atributos de otro objeto
	 * Generacion9DTO.Luego, guarda los datos en el archivo.
	 */

	@Override
	public boolean update(int index, Object o) {
		if (index < 0 || index >= listaGen9.size()) {
			return false;
		} else {
			Generacion9DTO info = (Generacion9DTO) o;
			listaGen9.get(index).setNombre(info.getNombre());
			listaGen9.get(index).setTipoPokemon(info.getTipoPokemon());
			listaGen9.get(index).setId(info.getId());
			listaGen9.get(index).setVida(info.getVida());
			listaGen9.get(index).setAtaque(info.getAtaque());
			listaGen9.get(index).setDefensa(info.getDefensa());
			listaGen9.get(index).setListaAtaque(info.getListaAtaque());
			listaGen9.get(index).setDefensaEspecial(info.getDefensaEspecial());
			listaGen9.get(index).setVelocidad(info.getVelocidad());

		}
		escribirEnArchivo();
		return true;
	}

	/*
	 * Este método devuelve una cadena que contiene una representación de todos los
	 * pokemones de la generacion 9 almacenados en el DAO.
	 */

	@Override
	public String read() {
		String exit = "";
		for (Generacion9DTO g : listaGen9) {
			exit += g.toString() + "\n";
		}

		return exit;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}
}
