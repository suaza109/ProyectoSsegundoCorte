package co.edu.unbosque.controller;

/**
 * AplMain es la clase principal que inicia la ejecucion del programa.
 */
public class AplMain {
	/*
	 * el metodo main es el punto de entrada de la aplicacion.
	 * 
	 * args son los argumentos de la linea de comando.
	 */
	public static void main(String[] args) {
		/*
		 * Se crea una instancia del controlador(Controller).
		 */
		Controller c = new Controller();
		/*
		 * Se llama al metodo run del Controller para iniciar la ejecucion de la aplicacion.
		 */
		c.run();

	}

}
