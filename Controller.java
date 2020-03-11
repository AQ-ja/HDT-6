import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

public class Controller {

	private Map<String, String> map;
	private Factory<String,String> factory;
	
	
	
	
	public Controller() {
		map = null;
		factory = new Factory<String,String>();
	}
	
	
	
	public void setMap(String map) {
		this.map = factory.getMap(map);
	}
	
	/**
	 * Llena el mapa de cartas con la informacion en el txt
	 */
	public void fillMap() {
		try {
			ArrayList<String> data = ArchivoTXT.leerTXT(ArchivoTXT.getPath());
			
			for (int i = 0; i< data.size();i++) { 
				String[] p = getSplit(data.get(i),"|");
				map.put(p[0],p[1]);	
			}	
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo llenar el mapa");
		}
	}
	
	/**
	 * Funcion para separa el string a clave y valor
	 * @param texto
	 * @param separador
	 * @return
	 */
	private String[] getSplit(String texto, String separador) {
		String[] retorno = new String[] {"",""}; 
		String[] s = texto.split("");
		int pos = 0;
		for (String h: s) {

			if (h.equals("|") || h.equals(" |")) {
				pos++;
			}else {
				retorno[pos] += h;
			}
				
		}
		return retorno;
		
	}
	
	public Object[] getListType(String type) {
		ArrayList<String> ap = new ArrayList<String>();
		Set<String> as = map.keySet();
		for (String i: as) {
			if (map.get(i).equals(type)) {
				ap.add(i);
			}
		}
		return  ap.toArray();
	}
	
	public int getTypeSize(String type) {
		int r = 0;
		Set<String> as = map.keySet();
		for (String i: as) {
			if (map.get(i).equals(type)) {
				r++;
			}
		}
		return r;
	}
	
	/**
	 * Funcion que retorna el tipo de la carta ingresada
	 * @param nombreCarta
	 * @return
	 */
	public String getType(String nombreCarta) {
		String tipo = "";
		try {
			tipo = map.get(nombreCarta);
		}catch(Exception e) {}
		return tipo;
	}
	
	public int getMapSize() {
		return map.size();
	}
	
	public Object[] getKeysMap() {
		ArrayList<String> data = new ArrayList<String>();
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
		  data.add(it.next().toString());
		}
		return data.toArray();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
