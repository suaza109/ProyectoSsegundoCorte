package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Clase que proporciona métodos para manejar archivos, incluyendo lectura y
 * escritura de archivos de texto y archivos serializados.
 */
public class FileHandler {
	// OBJECT SE ENCARGA DE MODIFICARLO
	private static File archivo;
	private static Scanner lectorDeArchivo;
	private static PrintWriter escritorDeArchivo;
	// *Atributos para serializacion
	private static FileInputStream fis;
	private static ObjectInputStream ois;
	private static FileOutputStream fos;
	private static ObjectOutputStream oos;

	/**
	 * Abre y lee un archivo serializado.
	 *
	 * @param url El nombre del archivo serializado.
	 * 
	 * @return El contenido del archivo serializado como objeto.
	 */

	public static Object abrirYLeerSerializable(String url) {
		Object contenido = null;
		archivo = new File(url);
		try {
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);
			contenido = ois.readObject();
			fis.close();
			ois.close();

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return contenido;
	}

	/**
	 * Abre y escribe en un archivo serializado.
	 *
	 * @param url       El nombre del archivo serializado.
	 * 
	 * @param contenido El contenido que se desea escribir en el archivo
	 *                  serializado.
	 */

	public static void abrirYEscribirSerializado(String url, Object contenido) {
		archivo = new File(url);
		try {
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(contenido);
			fos.close();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Abre y lee un archivo de texto.
	 *
	 * @param url La URL o nombre del archivo de texto.
	 * 
	 * @return El contenido del archivo de texto como una cadena de caracteres.
	 */

	public static String abrirYLeerArchivo(String url) {
		String contenido = "";
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			lectorDeArchivo = new Scanner(archivo);
			while (lectorDeArchivo.hasNext()) {
				contenido += lectorDeArchivo.nextLine() + "\n";
			}
			lectorDeArchivo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contenido;
	}

	/**
	 * Abre y escribe en un archivo de texto.
	 *
	 * @param url       La URL o nombre del archivo de texto.
	 * 
	 * @param contenido El contenido que se desea escribir en el archivo de texto.
	 */

	public static void abrirYEscribirArchivo(String url, String contenido) {

		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			escritorDeArchivo = new PrintWriter(archivo);
			escritorDeArchivo.print(contenido);
			escritorDeArchivo.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
