package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.AtaqueDTO;
import co.edu.unbosque.model.PokemonDTO;

public class PokemonDAO implements CRUDOperation {

	private ArrayList<PokemonDTO> listaPokemon;

	public PokemonDAO() {
		listaPokemon = new ArrayList<>();
		leerDesdeArchivo();
	}

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
			// Parsear lista de ataques
			String[] ataquesStr = columnas[6].split(";"); // Suponiendo que los ataques están separados por comas
			ArrayList<AtaqueDTO> listaAtaques = new ArrayList<>();
			for (String ataqueStr : ataquesStr) {
				AtaqueDTO ataque = new AtaqueDTO();
				// Aquí deberías parsear los datos del ataque según tu estructura en el archivo
				// CSV
				// Supongamos que el nombre del ataque está en la primera posición de los datos
				// del ataque
				ataque.setNombre(ataqueStr.trim()); // Suponiendo que el nombre del ataque está en la primera posición
				listaAtaques.add(ataque);
			}
			temp.setListaAtaque(listaAtaques);

			listaPokemon.add(temp);
			temp.setDefensaEspecial(columnas[7]);
			temp.setVelocidad(Integer.parseInt(columnas[8]));

		}
	}

	@Override
	public void create(Object o) {
		PokemonDTO info = (PokemonDTO) o;
		listaPokemon.add(info);
		escribirEnArchivo();
		FileHandler.abrirYEscribirSerializado("Pokedex.nrs", o);
	}

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
