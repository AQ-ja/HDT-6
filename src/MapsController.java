/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Comparator;
import javax.swing.JOptionPane;
/**
 * @author Estefania Barrio
 * @author Alfredo Quezada
 */

//Empieza la clase 
public class MapsController {
   private Map<String, String> map;
	private Map<String, String> userData;
	
	private Factory<String,String> factory;
	
	
	
	
	
	public MapsController() {
		map = null;
		userData = null;
		factory = new Factory<String,String>();
	}
	
	
	
	// Empiza el factory a funcionar basado en lo que se seleccione. 
	
	public void setMap(String map) {
		this.map = factory.getMap(map);
		this.userData = factory.getMap(map);
	}
	
	
	 // Lee la info del txt y la ordena

	public void fillMap() {
		try {
			ArrayList<String> data = LeerTXT.leerTXT(LeerTXT.getPath());
			
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
	
        //Aca se limita a obtener solo el valor deseado
	public Object[] getListType(String type) {
		ArrayList<String> ap = new ArrayList<String>();
		Set<String> as = map.keySet();
		for (String i: as) {
			if (map.get(i).equals(type)) {
				ap.add(i);
			}
		}
		Object[] data = ap.toArray();
		Arrays.sort(data);
		return  data;
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
	
	
	//  COn esto regresa los valores que buscaba
	public String getType(String nombreCarta) throws IllegalArgumentException{        
		String tipo = "";                              
			if(map.containsKey(nombreCarta))
				tipo = map.get(nombreCarta);
			else if (userData.containsKey(nombreCarta))
				tipo = userData.get(nombreCarta);
			else
				throw new IllegalArgumentException("La carta buscada no existe");
			
			
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
		Object[] dat = data.toArray();
		Arrays.sort(dat);
		return dat;
	}
	
	  
	//Funcion que ordena los valores del las cartas
	public Object getDeckKeysOrderedByValue() {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> dataHechizo = new ArrayList<String>();
		ArrayList<String> dataMounstro = new ArrayList<String>();
		ArrayList<String> dataTrampa = new ArrayList<String>();
		
		for (Map.Entry<String, String> carta : map.entrySet()) {
			if (carta.getValue().equals("Hechizo")) {
				dataHechizo.add(carta.getKey());
			}
			if (carta.getValue().equals("Monstruo")) {
				dataMounstro.add(carta.getKey());
			}
			if (carta.getValue().equals("Trampa")) {
				dataTrampa.add(carta.getKey());
			}
		}
		
		data.addAll(dataHechizo);
		data.addAll(dataMounstro);
		data.addAll(dataTrampa);
		
		
		
		return data.toArray();
	}
	
	
	// Y esta los ordena por tipo de carta, todo el la baraja (el txt)
	public Object getUserKeysOrderedByValue() {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<String> dataHechizo = new ArrayList<String>();
		ArrayList<String> dataMounstro = new ArrayList<String>();
		ArrayList<String> dataTrampa = new ArrayList<String>();
		
		for (Map.Entry<String, String> carta : userData.entrySet()) {
			if (carta.getValue().equals("Hechizo")) {
				dataHechizo.add(carta.getKey());
			}
			if (carta.getValue().equals("Monstruo")) {
				dataMounstro.add(carta.getKey());
			}
			if (carta.getValue().equals("Trampa")) {
				dataTrampa.add(carta.getKey());
			}
		}
		
		data.addAll(dataHechizo);
		data.addAll(dataMounstro);
		data.addAll(dataTrampa);
		
		
		
		return data.toArray();
	}
	
	
	//Luego de encontrar la carta la ingresa al panel del usuario 
        
	public void insertCard(String key) throws IllegalArgumentException{
		
		if(map.containsKey(key)) {
			userData.put(key,map.remove(key));
			
		}
		else {
			throw new IllegalArgumentException("La carta ingresada no esta en el tu txt :( ");
		}
		
	}	

    Object[] getListTypeUser(String trampa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getTypeSizeUser(String trampa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getMapSizeUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    Object[] getKeys() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
