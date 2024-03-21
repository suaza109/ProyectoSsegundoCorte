package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.AtaqueDTO;
import co.edu.unbosque.model.Generacion2DTO;

public class Generacion2DAO implements CRUDOperation {
	private ArrayList<Generacion2DTO> lista;
	
	public Generacion2DAO() {
		lista =new ArrayList<>();
		leerDesdeSerializado();
	}
	public void leerDesdeSerializado() {

		Object temp = FileHandler.abrirYLeerSerializable("Planeta.ds");
		if (temp == null) {
			lista = new ArrayList<>();
		} else {
			lista = (ArrayList<Generacion2DTO>) temp;
		}
	}

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
	@Override
	public void create(Object o) {
		Generacion2DTO info= (Generacion2DTO)o; 
		lista.add(info);
		
	}

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
