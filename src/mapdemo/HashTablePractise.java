package mapdemo;

import java.util.Hashtable;
import java.util.Map;

/*This class is same like hashTable or we should say hashMap is enhanced version of
 * hashtable. By default it's thread safe. it does not maintain the insertion oreder.
 * it has few more method you can see below.*/

public class HashTablePractise {

	public static void main(String args[]) {
		Map<Integer, String> hm = new Hashtable<Integer, String>();

		hm.put(100, "Amit");
		hm.put(102, "Ravi");
		hm.put(101, "Vijay");
		hm.put(103, "Rahul");

		for (Map.Entry m : hm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

		// Here, we specify the if and else statement as arguments of the method
		System.out.println(hm.getOrDefault(105, "Not Found"));

		// check whether a value exists or not 
        if (hm.containsKey(103))
            System.out.println("Key found in table"); 
		
		// check whether a value exists or not
		if (hm.containsValue("Rahul"))
			System.out.println("value found in table");
	}
}
