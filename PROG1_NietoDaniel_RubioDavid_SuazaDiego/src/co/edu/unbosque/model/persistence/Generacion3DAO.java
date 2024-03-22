package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.AtaqueDTO;
import co.edu.unbosque.model.Generacion3DTO;

/*
* La clase Generacion3DAO es una implementacion de CRUDOperation para operaciones relacionadas con los pokemones de esta generacion.
* Hace uso de una lista de objetos de Generacion1DTO y proporciona metodos para crear, eliminar, actualizar y leer.
*/

public class Generacion3DAO implements CRUDOperation {
	private ArrayList<Generacion3DTO> listaGen3;

	/*
	 * Constructor de la clase Generacion3DAO que inicializa la lista de la
	 * generacion y utiliza la funcion de leer desde serializado.
	 */

	public Generacion3DAO() {
		listaGen3 = new ArrayList<>();
		// *leerDesdeArchivo();
		leerDesdeSerializado();
	}
	/*
	 * Lee la lista de la generacion 3 de pokemones mediante un archivo serializado.
	 */

	public void leerDesdeSerializado() {

		Object temp = FileHandler.abrirYLeerSerializable("Pokedex.nrs");
		if (temp == null) {
			listaGen3 = new ArrayList<>();
		} else {
			listaGen3 = (ArrayList<Generacion3DTO>) temp;
		}
	}

	/*
	 * La funcion atrae todo lo que se haya digitado en consola a contenido , y en
	 * contenido crea un archivo y lo escribe con lo que hay en el contenido.
	 */

	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaGen3.size(); i++) {
			contenido += listaGen3.get(i).getNombre() + ";";
			contenido += listaGen3.get(i).getTipoPokemon() + ";";
			contenido += listaGen3.get(i).getId() + ";";
			contenido += listaGen3.get(i).getVida() + ";";
			contenido += listaGen3.get(i).getAtaque() + ";";
			contenido += listaGen3.get(i).getDefensa() + ";";
			contenido += listaGen3.get(i).getListaAtaque() + ";";
			contenido += listaGen3.get(i).getDefensaEspecial() + ";";
			contenido += listaGen3.get(i).getVelocidad();

			if (i < listaGen3.size() - 1) {
				contenido += "\n";
			}

		}

		FileHandler.abrirYEscribirArchivo("Pokedex.csv", contenido);
	}

	/*
	 * Lee la lista de la generacion 3 de pokemones desde un archivo de texto.
	 */

	public void leerDesdeArchivo() {
		String contenido = FileHandler.abrirYLeerArchivo("Pokedex.csv");
		if (contenido.equals("")) {
			listaGen3 = new ArrayList<>();
			return;
		}

		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			Generacion3DTO temp = new Generacion3DTO();
			temp.setNombre(columnas[0]);
			temp.setTipoPokemon(columnas[1]);
			temp.setId(Integer.parseInt(columnas[2]));
			temp.setVida(Integer.parseInt(columnas[3]));
			temp.setAtaque(Integer.parseInt(columnas[4]));
			temp.setDefensa(Integer.parseInt(columnas[5]));
			String[] ataquesStr = columnas[6].split(";");
			ArrayList<AtaqueDTO> listaAtaques = new ArrayList<>();
			for (String ataqueStr : ataquesStr) {
				Generacion3DTO ataque = new Generacion3DTO();
				ataque.setNombre(ataqueStr.trim());
				listaAtaques.add(new AtaqueDTO());
			}
			temp.setListaAtaque(listaAtaques);

			listaGen3.add(temp);
			temp.setDefensaEspecial(columnas[7]);
			temp.setVelocidad(Integer.parseInt(columnas[8]));

		}
	}

	/*
	 * Este metodo agrega un metodo Generacion3DTO a la lista de la generacion en el
	 * DAO y escribe los cambios en un archivo.
	 */

	@Override
	public void create(Object o) {
		Generacion3DTO nuevo = (Generacion3DTO) o;
		listaGen3.add(nuevo);
		escribirEnArchivo();
		FileHandler.abrirYEscribirSerializado("Pokedex.nrs", listaGen3);
	}

	/*
	 * * Este metodo elimina un pokemon de la generacion 3 de la lista de pokemones
	 * 
	 * @param index
	 * 
	 * @return true si el pokemon se elimino correctamente, false si la posicion no
	 * existe.
	 */

	@Override
	public boolean delete(int index) {
		if (index < 0 || index >= listaGen3.size()) {
			return false;
		} else {
			listaGen3.remove(index);
			escribirEnArchivo();
			return true;
		}
	}

	/*
	 * Este metodo actualiza un pokemon de esta generacion, de la lista en la
	 * posicion especificada por index con los atributos de otro objeto
	 * Generacion3DTO.Luego, guarda los datos en el archivo.
	 */

	@Override
	public boolean update(int index, Object o) {
		if (index < 0 || index >= listaGen3.size()) {
			return false;
		} else {
			Generacion3DTO info = (Generacion3DTO) o;
			listaGen3.get(index).setNombre(info.getNombre());
			listaGen3.get(index).setTipoPokemon(info.getTipoPokemon());
			listaGen3.get(index).setId(info.getId());
			listaGen3.get(index).setVida(info.getVida());
			listaGen3.get(index).setAtaque(info.getAtaque());
			listaGen3.get(index).setDefensa(info.getDefensa());
			listaGen3.get(index).setListaAtaque(info.getListaAtaque());
			listaGen3.get(index).setDefensaEspecial(info.getDefensaEspecial());
			listaGen3.get(index).setVelocidad(info.getVelocidad());

		}
		escribirEnArchivo();
		return true;
	}

	/*
	 * Este método devuelve una cadena que contiene una representación de todos los
	 * pokemones de la generacion 3 almacenados en el DAO.
	 */

	@Override
	public String read() {
		String exit = "";
		for (Generacion3DTO g : listaGen3) {
			exit += g.toString() + "\n";
		}

		return exit;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

}
