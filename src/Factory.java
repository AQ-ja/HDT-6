/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
/**
 * @author Alfredo Quezada
 * @author Estefania Barrio
 */
public class Factory<A,E> {

	public Map<A, E> getMap(String map) {
		
		switch (map) {
		case "HashMap":
			return new HashMap<A,E>();
			
		case "TreeMap":
			return new TreeMap<A,E>();
			
		case "LinkedHashMap":
			return new  LinkedHashMap<A,E>();
			
		default: return null;
		
		}
		
	}
	
	 
	
}
