package mapdemo;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/*A TreeMap is always sorted based on keys.
 *A TreeMap cannot contain duplicate keys.
 *TreeMap cannot contain the null key. However, It can have null values.
 *You may also provide a custom Comparator to the TreeMap at the time of creation to let it sort the keys using the supplied Comparator*/

public class TreeMapPractise {

	public static void main(String[] args) {
		TreeMapPractise obj = new TreeMapPractise();
		obj.addAndSort();
//		obj.accessingTreeMap();
		obj.addNull();
	}


	private void addAndSort() {
		SortedMap<Integer, String> map = new TreeMap();
		map.put(2, "B");
		map.put(5, "E");
		map.put(1, "A");
		map.put(20, null);

		System.out.println("Sort data in natural order based on key");
		map.entrySet().stream().forEach(data -> System.out.println(data));

		System.out.println("Sort data in descending order based on key");
		SortedMap<Integer, String> sortInDescedingOrder = new TreeMap(Comparator.reverseOrder());
		sortInDescedingOrder.putAll(map);
		sortInDescedingOrder.entrySet().stream().forEach(data -> System.out.println(data));

		System.out.println("Sort data in natural order based on value");
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

		System.out.println("Sort data in revers order based on value");
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEach(System.out::println);
	}

	private void accessingTreeMap() {
		TreeMap<Integer, String> employees = new TreeMap<>();

		employees.put(1003, "Rajeev");
		employees.put(1001, "James");
		employees.put(1002, "Sachin");
		employees.put(1004, "Chris");

		System.out.println("Employees map : " + employees);

		// Finding the size of a TreeMap
		System.out.println("Total number of employees : " + employees.size());

		// Check if a given key exists in a TreeMap
		Integer id = 1004;
		if (employees.containsKey(id)) {
			// Get the value associated with a given key in a TreeMap
			String name = employees.get(id);
			System.out.println("Employee with id " + id + " : " + name);
		} else {
			System.out.println("Employee does not exist with id : " + id);
		}

		// Find the first and last entry
		System.out.println("First entry in employees map : " + employees.firstEntry());
		System.out.println("Last entry in employees map : " + employees.lastEntry());

		// Find the entry whose key is just less than the given key
		Map.Entry<Integer, String> employeeJustBelow = employees.lowerEntry(1002);
		System.out.println("Employee just below id 1002 : " + employeeJustBelow);

		// Find the entry whose key is just higher than the given key
		Map.Entry<Integer, String> employeeJustAbove = employees.higherEntry(1002);
		System.out.println("Employee just above id 1002 : " + employeeJustAbove);

		//Get the head values from given key
		System.out.println("Fetching head entry before given key :" + employees.headMap(1003));
		
		//Get and remove first entry from map
		System.out.println("Fetching first entry and removing from map :" +employees.pollFirstEntry());
		System.out.println(employees);

		//Get and remove last entry from map
		System.out.println("Fetching first entry and removing from map :" +employees.pollLastEntry());
		System.out.println(employees);
		
		//For clearing the whole map
		employees.clear();
		System.out.println("After clearing the map there should be no data :"+employees);
	}

	private void addNull() {
		SortedMap<Integer, String> map = new TreeMap();
		
		/*Uncomment below line will give you null pointer exception*/
		//map.put(null, "B");
	
		map.put(5, "E");
		map.put(1, "A");
		
		//While map allow multiple null values, but can not sort on null values
		map.put(20, null);
		map.put(15, null);
		
		//But while sorting the data with null values, we will gate nullpointer exception
//		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		
		System.out.println(map);
		
	}
}
