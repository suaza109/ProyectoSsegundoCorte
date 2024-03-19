package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandler {
	private static File archivo;
	private static Scanner lectorDeArchivo;
	private static PrintWriter escritorDeArchivo;
	// *Atributos para serializacion
	private static FileInputStream fis;
	private static ObjectInputStream ois;
	private static FileOutputStream fos;
	private static ObjectOutputStream oos;

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
