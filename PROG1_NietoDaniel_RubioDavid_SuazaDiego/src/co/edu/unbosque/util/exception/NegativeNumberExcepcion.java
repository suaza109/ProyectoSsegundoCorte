package co.edu.unbosque.util.exception;

/*
 * La clase NegativeNumberException se utiliza para lanzar una excepcion propia.
 */

public class NegativeNumberExcepcion extends Exception {

	/*
	 * * Constructor de la clase NegativeNumberException para imprimir el mensaje
	 * que se lanza en la excepcion.
	 */

	public NegativeNumberExcepcion() {
		super("No se aceptan numeros negativos. ");
	}
}
