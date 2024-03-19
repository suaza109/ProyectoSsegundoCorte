package co.edu.unbosque.util.exception;

public class NameNotValidException extends Exception {

	public NameNotValidException() {
		super("Los nombres no pueden tener numeros ni simbolos");
	}

}