package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.AtaqueDAO;
import co.edu.unbosque.model.persistence.PokemonDAO;
/*
 * ModelFacade es la clase en la cual se crean e instancian los DAO para despues ser llamados desde esta misma clase.
 */
public class ModelFacade {
	
	/*
	 * Se crean los DAO haciendo uso de la clase a la que se le va a asignar cada uno
	 */
	private PokemonDAO pDAO;
	private AtaqueDAO aDAO;
	
	/*
	 * Constructor de la clase ModelFacade.
	 * Inicializa pDAO y aDAO.
	 */

	public ModelFacade() {
		pDAO = new PokemonDAO();
		aDAO = new AtaqueDAO();

	}
	
	/*
	 * Obtiene pDAO de la clase PokemonDAO
	 * 
	 * @return pDAO
	 */

	public PokemonDAO getpDAO() {
		return pDAO;
	}
	
	/*
	 * Establece pDAO de la clase PokemonDAO
	 * 
	 * @param pDAO	nuevo pDAO de la clase PokemonDAO.
	 */

	public void setpDAO(PokemonDAO pDAO) {
		this.pDAO = pDAO;
	}
	
	/*
	 * Obtiene el aDAO de la clase AtaqueDAO.
	 * 
	 * @return aDAO
	 */

	public AtaqueDAO getaDAO() {
		return aDAO;
	}
	
	/*
	 * Establece aDAO de la clase AtaqueDAO
	 * 
	 * @param aDAO	el nuevo aDAO de la clase AtaqueDAO.
	 */

	public void setaDAO(AtaqueDAO aDAO) {
		this.aDAO = aDAO;
	}

}