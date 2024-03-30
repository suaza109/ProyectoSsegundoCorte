package co.edu.unbosque.model.persistence;

/**
 * Interfaz que define operaciones basicas de CRUD (crear, eliminar, actualizar,
 * leer) sobre objetos.
 */
public interface CRUDOperation {

	/**
	 * Crea un objeto a partir de otro objeto
	 * 
	 * @param o el objeto a crear.
	 */
	public void create(Object o);

	/**
	 * Elimina un objeto en la coleccion mediante su indice
	 * 
	 * @param index el indice del objeto que desea eliminar.
	 * 
	 * @return true si la eliminacion fue exitosa o false si el indice no existe o
	 *         la eliminacion falla.
	 */

	public boolean delete(int index);

	/**
	 * Actualiza un objeto en la coleccion por medio de su indice
	 * 
	 * @param index el indice del objeto que se desea actualizar.
	 * @param o     el objeto con los nuevos datos.
	 * @return true si la actualizacion fue exitosa o false si el indice no existe o
	 *         la actualizacion falla.
	 */

	public boolean update(int index, Object o);

	/**
	 * Lee todos los objetos almacenados y los retorna como una cadena de texto.
	 * 
	 * @return una cadena que contiene todos los objetos almacenados.
	 */

	public String read();

	/**
	 * Crea un objeto.
	 */
}
