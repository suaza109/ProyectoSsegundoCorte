package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.AtaqueDAO;
import co.edu.unbosque.model.persistence.PokemonDAO;

public class ModelFacade {
	private PokemonDAO pDAO;
	private AtaqueDAO aDAO;

	public ModelFacade() {
		pDAO = new PokemonDAO();
		aDAO = new AtaqueDAO();

	}

	public PokemonDAO getpDAO() {
		return pDAO;
	}

	public void setpDAO(PokemonDAO pDAO) {
		this.pDAO = pDAO;
	}

	public AtaqueDAO getaDAO() {
		return aDAO;
	}

	public void setaDAO(AtaqueDAO aDAO) {
		this.aDAO = aDAO;
	}

}