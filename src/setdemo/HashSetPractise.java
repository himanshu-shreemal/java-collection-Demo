package setdemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*HashSet stores the elements by using a mechanism called hashing.
HashSet contains unique elements only.
HashSet allows null value.
HashSet class is non synchronized.
HashSet doesn't maintain the insertion order.
HashSet is the best approach for search operations.
The initial default capacity of HashSet is 16, and the load factor is 0.75
16 means it can store up 16 objects.
0.75 means once it is full 75% it will increase it's size
*/
public class HashSetPractise {

	// Creating HashSet
	Set<String> set = new HashSet();  //we can also pass initial capacity like:  HashSet(20)

	public static void main(String args[]) {
		HashSetPractise obj = new HashSetPractise();
		obj.addElement();
		obj.removeData();
	}

	// add method helps us to add the data in set
	// it does not maintain the insertion order
	private void addElement() {
		set.add("One");
		set.add("Two");
		set.add("Three");
		set.add("Four");
		set.add("Five");
		Iterator<String> i = set.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

	private void removeData() {
		// Removing specific element from HashSet
		set.remove("Four");
		System.out.println("After invoking remove(object) method: " + set);

		//Removing elements on the basis of specified condition  
        set.removeIf(str->str.contains("Five"));    
        System.out.println("After invoking removeIf() method: "+set);  
		
		// Removing all the new elements from HashSet
		set.removeAll(set);
		System.out.println("After invoking removeAll() method: " + set);
	}

}
