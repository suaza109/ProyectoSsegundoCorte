package co.edu.unbosque.util.exception;

/**
 * La clase NoValidNegativeNumber se utiliza para lanzar una excepcion propia.
 */
public class NoValidNegativeNumber extends Exception {

	/**
	 * Constructor de la clase NoValidNegativeNumber , imprime el mensaje que se
	 * lanza en la excepcion.
	 */
	public NoValidNegativeNumber() {
		super("No se aceptan Numeros Negativos en este Campo");
	}
}
