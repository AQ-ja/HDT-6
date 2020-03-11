import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Factory<A,E> {

	public Map getMap(String map) {
		
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
