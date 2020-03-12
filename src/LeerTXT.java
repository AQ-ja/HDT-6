/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Importacion de los paquetes necesarios. 
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Alfredo Quezada
 * @author Estefania Barrio
 */
public class LeerTXT {
    /**
	 * Como no sabemos donde tendra guardado el archivo el tester, 
         * usamos un metodo que permitira escoger desde donde el lo quiera
         * asi nos evitamos problemas :). 
	 * @return
	 */
	public static String getPath()  {
		
		JFileChooser chooser = new JFileChooser();
	 	FileNameExtensionFilter filtroImagen =new FileNameExtensionFilter("*.TXT", "txt");
	 	chooser.setFileFilter(filtroImagen);
	 	File f = null;
	 	
		try {
			f = new File(new File(".").getCanonicalPath());
		} catch (IOException e) {
                    // TODO Auto-generated catch block
		}
		
		String path = "";
		
		try {
			chooser.setCurrentDirectory(f);
			chooser.setCurrentDirectory(null);
			chooser.showOpenDialog(null);
	    
			path = chooser.getSelectedFile().toString();
		}catch(HeadlessException e) {
			
		}
	    return path;
	}
	
	
	
	/**
	 * Esta es la funcion para leer los datos del txt.
	 * @return
	 */
	public static ArrayList<String> leerTXT(String path) {
		
		File archivo = new File(path);
		FileReader fr;
		BufferedReader br;
		ArrayList<String> Datos = new ArrayList<>();
		
		try {
			
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			
			String linea = "";
			
			while((linea = br.readLine()) != null) {
				Datos.add(linea);
				
			}
			
			
			br.close();
			fr.close();
			
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado leyendo su archivo.  " + e);
		}
		
		return Datos;
	}

}

/**
 * Links de referencia:
 * https://netbeans.org/kb/docs/java/gui-filechooser.html
 * https://www.youtube.com/watch?v=nVWXJ3qqi0o
 */