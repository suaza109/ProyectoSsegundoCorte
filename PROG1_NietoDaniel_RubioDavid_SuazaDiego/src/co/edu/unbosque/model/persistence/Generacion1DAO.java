package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.AtaqueDTO;
import co.edu.unbosque.model.Generacion1DTO;
import co.edu.unbosque.model.PokemonDTO;

/*
 * La clase Generacion1DAO es una implementacion de CRUDOperation para operaciones relacionadas con los pokemones de esta generacion.
 * Hace uso de una lista de objetos de Generacion1DTO y proporciona metodos para crear, eliminar, actualizar y leer.
 */

public class Generacion1DAO implements CRUDOperation {
	private ArrayList<Generacion1DTO> listaGen1;

	/*
	 * Constructor de la clase Generacion1DAO que inicializa la lista de la
	 * generacion y utiliza la funcion de leer desde serializado.
	 */

	public Generacion1DAO() {
		listaGen1 = new ArrayList<>();
		// *leerDesdeArchivo();
		leerDesdeSerializado();
	}

	/*
	 * Lee la lista de la generacion 1 de pokemones mediante un archivo serializado.
	 */

	public void leerDesdeSerializado() {

		Object temp = FileHandler.abrirYLeerSerializable("Planeta.ds");
		if (temp == null) {
			listaGen1 = new ArrayList<>();
		} else {
			listaGen1 = (ArrayList<Generacion1DTO>) temp;
		}
	}

	/*
	 * La funcion atrae todo lo que se haya digitado en consola a contenido , y en
	 * contenido crea un archivo y lo escribe con lo que hay en el contenido.
	 */

	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaGen1.size(); i++) {
			contenido += listaGen1.get(i).getNombre() + ";";
			contenido += listaGen1.get(i).getTipoPokemon() + ";";
			contenido += listaGen1.get(i).getId() + ";";
			contenido += listaGen1.get(i).getVida() + ";";
			contenido += listaGen1.get(i).getAtaque() + ";";
			contenido += listaGen1.get(i).getDefensa() + ";";
			contenido += listaGen1.get(i).getListaAtaque() + ";";
			contenido += listaGen1.get(i).getDefensaEspecial() + ";";
			contenido += listaGen1.get(i).getVelocidad();

			if (i < listaGen1.size() - 1) {
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
			listaGen1 = new ArrayList<>();
			return;
		}

		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			Generacion1DTO temp = new Generacion1DTO();
			temp.setNombre(columnas[0]);
			temp.setTipoPokemon(columnas[1]);
			temp.setId(Integer.parseInt(columnas[2]));
			temp.setVida(Integer.parseInt(columnas[3]));
			temp.setAtaque(Integer.parseInt(columnas[4]));
			temp.setDefensa(Integer.parseInt(columnas[5]));
			temp.setListaAtaque(columnas[6]);
			temp.setDefensaEspecial(columnas[7]);
			temp.setVelocidad(Integer.parseInt(columnas[8]));
			listaGen1.add(temp);

		}
	}

	/*
	 * Este metodo agrega un metodo Generacion1DTO a la lista de la generacion en el
	 * DAO y escribe los cambios en un archivo.
	 */

	@Override
	public void create(Object o) {
		Generacion1DTO nuevo = (Generacion1DTO) o;
		listaGen1.add(nuevo);
		escribirEnArchivo();
		FileHandler.abrirYEscribirSerializado("Pokedex.nrs", listaGen1);

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
		if (index < 0 || index >= listaGen1.size()) {
			return false;
		} else {
			listaGen1.remove(index);
			escribirEnArchivo();
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
		if (index < 0 || index >= listaGen1.size()) {
			return false;
		} else {
			Generacion1DTO info = (Generacion1DTO) o;
			listaGen1.get(index).setNombre(info.getNombre());
			listaGen1.get(index).setTipoPokemon(info.getTipoPokemon());
			listaGen1.get(index).setId(info.getId());
			listaGen1.get(index).setVida(info.getVida());
			listaGen1.get(index).setAtaque(info.getAtaque());
			listaGen1.get(index).setDefensa(info.getDefensa());
			listaGen1.get(index).setListaAtaque(info.getListaAtaque());
			listaGen1.get(index).setDefensaEspecial(info.getDefensaEspecial());
			listaGen1.get(index).setVelocidad(info.getVelocidad());

		}
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
		for (Generacion1DTO g : listaGen1) {
			exit += g.toString() + "\n";
		}

		return exit;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}
}
