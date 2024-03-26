package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Generacion1DAO;
import co.edu.unbosque.model.persistence.Generacion2DAO;
import co.edu.unbosque.model.persistence.Generacion3DAO;
import co.edu.unbosque.model.persistence.Generacion9DAO;

public class ModelFacade {
	private Generacion1DAO g1;
	private Generacion2DAO g2;
	private Generacion3DAO g3;
	private Generacion9DAO g9;
	
	public ModelFacade() {
		g1 = new Generacion1DAO();
		g2 = new Generacion2DAO();
		g3 = new Generacion3DAO();
		g9 = new Generacion9DAO();
	}

	public Generacion1DAO getG1() {
		return g1;
	}

	public void setG1(Generacion1DAO g1) {
		this.g1 = g1;
	}

	public Generacion2DAO getG2() {
		return g2;
	}

	public void setG2(Generacion2DAO g2) {
		this.g2 = g2;
	}

	public Generacion3DAO getG3() {
		return g3;
	}

	public void setG3(Generacion3DAO g3) {
		this.g3 = g3;
	}

	public Generacion9DAO getG9() {
		return g9;
	}

	public void setG9(Generacion9DAO g9) {
		this.g9 = g9;
	}
	
}