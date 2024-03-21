package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.AtaqueDTO;
import co.edu.unbosque.model.Generacion1DTO;
import co.edu.unbosque.model.PokemonDTO;

public class Generacion1DAO implements CRUDOperation {
	private ArrayList<Generacion1DTO> listaGen1;

	public Generacion1DAO() {
		listaGen1 = new ArrayList<>();
		// *leerDesdeArchivo();
		leerDesdeSerializado();
	}

	public void leerDesdeSerializado() {

		Object temp = FileHandler.abrirYLeerSerializable("Planeta.ds");
		if (temp == null) {
			listaGen1 = new ArrayList<>();
		} else {
			listaGen1 = (ArrayList<Generacion1DTO>) temp;
		}
	}

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
			String[] ataquesStr = columnas[6].split(";");
			ArrayList<AtaqueDTO> listaAtaques = new ArrayList<>();
			for (String ataqueStr : ataquesStr) {
				Generacion1DTO ataque = new Generacion1DTO();
				ataque.setNombre(ataqueStr.trim());
				listaAtaques.add(ataque);
			}
			temp.setListaAtaque(listaAtaques);

			listaGen1.add(temp);
			temp.setDefensaEspecial(columnas[7]);
			temp.setVelocidad(Integer.parseInt(columnas[8]));

		}
	}

	@Override
	public void create(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean delete(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(int index, Object o) {
		// TODO Auto-generated method stub
		return false;
	}

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
