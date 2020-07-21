package mapdemo;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/*LinkedHashMap is a Hash table and linked list implementation of the Map interface
 * This implementation differs from HashMap in that it maintains a doubly-linked list 
 * running through all of its entries. This linked list defines the iteration ordering, 
 * which is normally the order in which keys were inserted into the map (insertion-order). */

public class LinkedHashMapPractise {

	public static void main(String args[]) {
		// HashMap Declaration
		LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>();

		// Adding elements to LinkedHashMap
		linkedHashMap.put(22, "Abey");
		linkedHashMap.put(33, "Dawn");
		linkedHashMap.put(1, "Sherry");
		linkedHashMap.put(2, "Karon");
		linkedHashMap.put(100, "Jim");

		// Generating a Set of entries
		Set set = linkedHashMap.entrySet();

		// Displaying elements of LinkedHashMap
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry me = (Map.Entry) iterator.next();
			System.out.print("Key is: " + me.getKey() + "& Value is: " + me.getValue() + "\n");
		}
	}
}
