package setdemo;

import java.util.LinkedHashSet;

/*LinkedHashSet maintains the insertion order. Elements gets sorted in the same sequence 
 * in which they have been added to the Set. It contains unique elements only.
 * Like HashSet permits null elements. This class is non synchronized.
*/
public class LinkedHashSetPractise {

	// Creating HashSet
	LinkedHashSet<String> set = new LinkedHashSet();

	public static void main(String args[]) {
		LinkedHashSetPractise obj = new LinkedHashSetPractise();

		// LinkedHashSet(int capacity, float fillRatio) we can pass initial capacity and
		// loadfactor
		obj.addData();
		obj.removeData();
	}

	private void addData() {
		set.add("One");
		set.add("Two");
		set.add("Three");
		set.add("Four");
		set.add("Five");

		// It ignores if we try to insert the same values
		// look at the output the "Four" insertion oreder is not changed
		set.add("Four");

		set.stream().forEach(System.out::println);

	}

	private void removeData() {
		set.removeIf(n -> n.equalsIgnoreCase("Four"));
		System.out.println(set);

		// It will not remove two as it is case sensitive
		set.remove("two");
		System.out.println(set);

		// will remove all the elements
		set.clear();
		System.out.println(set);

	}

}
