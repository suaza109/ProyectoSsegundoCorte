package co.edu.unbosque.util.exception;

/**
 * La clase NameNotValidException se utiliza para lanzar una excepcion propia.
 */
public class NameNotValidException extends Exception {

	/**
	 * Constructor de la clase NameNotValidException para imprimir el mensaje que se
	 * lanza en la excepcion.
	 */

	public NameNotValidException() {
		super("Los nombres no pueden tener numeros ni simbolos");
	}

}