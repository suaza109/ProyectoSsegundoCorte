package co.edu.unbosque.util.exception;

public class NoValidLetterException extends Exception {
	public NoValidLetterException() {
		super("Las letras no son validas en este campo");
	}
}
