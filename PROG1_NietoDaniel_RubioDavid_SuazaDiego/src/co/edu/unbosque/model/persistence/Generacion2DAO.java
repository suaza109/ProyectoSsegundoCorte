package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.AtaqueDTO;
import co.edu.unbosque.model.Generacion2DTO;

/*
 *  La clase Generacion2DAO es una implementacion de CRUDOperation para operaciones relacionadas con los pokemones de esta generacion.
* Hace uso de una lista de objetos de Generacion2DTO y proporciona metodos para crear, eliminar, actualizar y leer.
 */
public class Generacion2DAO implements CRUDOperation {
	private ArrayList<Generacion2DTO> lista;

	/*
	 * Constructor de la clase Generacion2DAO que inicializa la lista de la
	 * generacion y utiliza la funcion de leer desde serializado.
	 */

	public Generacion2DAO() {
		lista = new ArrayList<>();
		leerDesdeSerializado();
	}

	/*
	 * Lee la lista de la generacion 2 de pokemones mediante un archivo serializado.
	 */

	public void leerDesdeSerializado() {

		Object temp = FileHandler.abrirYLeerSerializable("Planeta.ds");
		if (temp == null) {
			lista = new ArrayList<>();
		} else {
			lista = (ArrayList<Generacion2DTO>) temp;
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
			contenido += lista.get(i).getVelocidad();

			if (i < lista.size() - 1) {
				contenido += "\n";
			}

		}

		FileHandler.abrirYEscribirArchivo("Pokedex.csv", contenido);
	}

	/*
	 * Lee la lista de la generacion 2 de pokemones desde un archivo de texto.
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
			Generacion2DTO temp = new Generacion2DTO();
			temp.setNombre(columnas[0]);
			temp.setTipoPokemon(columnas[1]);
			temp.setId(Integer.parseInt(columnas[2]));
			temp.setVida(Integer.parseInt(columnas[3]));
			temp.setAtaque(Integer.parseInt(columnas[4]));
			temp.setDefensa(Integer.parseInt(columnas[5]));
			String[] ataquesStr = columnas[6].split(";");
			ArrayList<AtaqueDTO> listaAtaques = new ArrayList<>();
			for (String ataqueStr : ataquesStr) {
				Generacion2DTO ataque = new Generacion2DTO();
				ataque.setNombre(ataqueStr.trim());
				listaAtaques.add(new AtaqueDTO());
			}
			temp.setListaAtaque(listaAtaques);

			lista.add(temp);
			temp.setDefensaEspecial(columnas[7]);
			temp.setVelocidad(Integer.parseInt(columnas[8]));

		}
	}

	/*
	 * Este metodo agrega un metodo Generacion2DTO a la lista de la generacion en el
	 * DAO y escribe los cambios en un archivo.
	 */

	@Override
	public void create(Object o) {
		Generacion2DTO info = (Generacion2DTO) o;
		lista.add(info);

	}

	/*
	 * Este metodo elimina un pokemon de la generacion 2 de la lista de pokemones
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
			return true;
		}
	}

	/*
	 * Este metodo actualiza un pokemon de esta generacion, de la lista en la
	 * posicion especificada por index con los atributos de otro objeto
	 * Generacion2DTO.Luego, guarda los datos en el archivo.
	 */

	@Override
	public boolean update(int index, Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * Este método devuelve una cadena que contiene una representación de todos los
	 * pokemones de la generacion 2 almacenados en el DAO.
	 */

	@Override
	public String read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

}
