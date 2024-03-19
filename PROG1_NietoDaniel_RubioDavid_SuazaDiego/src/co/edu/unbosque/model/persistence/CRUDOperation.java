package co.edu.unbosque.model.persistence;

public interface CRUDOperation {
	public void create(Object o);

	public boolean delete(int index);

	public boolean update(int index, Object o);

	public String read();
}
