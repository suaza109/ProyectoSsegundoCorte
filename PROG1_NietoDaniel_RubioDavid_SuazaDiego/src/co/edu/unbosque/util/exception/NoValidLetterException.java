package co.edu.unbosque.util.exception;

/**
 * La clase NoValidLetterException se utiliza para lanzar una excepcion propia.
 */
public class NoValidLetterException extends Exception {

	/**
	 * Constructor de la clase NoValidLetterException , imprime el mensaje que se
	 * lanza en la excepcion.
	 */
	public NoValidLetterException() {
		super("Las letras no son validas en este campo");
	}
}
