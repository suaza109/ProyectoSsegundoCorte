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
			contenido += listaPokemon.get(i).getVelocidad() + ";";

			if (i < listaPokemon.size() - 1) {
				contenido += "\n";
			}

		}

		FileHandler.abrirYEscribirArchivo("Planeta.csv", contenido);
	}

	public void leerDesdeArchivo() {
		String contenido = FileHandler.abrirYLeerArchivo("Planeta.csv");
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
	            // Aquí deberías parsear los datos del ataque según tu estructura en el archivo CSV
	            // Supongamos que el nombre del ataque está en la primera posición de los datos del ataque
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

}
