package mapdemo;

import java.util.HashMap;
import java.util.Map;

/*One of the common Map that we use while using the Map Data structure.
 * This does not maintain order or does not sort the data. It just hold your data
 * in the form of key & value. The response time of map is O(1), it internally uses Hashing.
 * Only single unique key is allowed. if duplicate key is there than we need to decide which value
 * we will keep. The value can be duplicate.
 * it can hold a single null key.
 * */

public class HashMapPractise {

	Map<String, Integer> hashMap1 = new HashMap();
	Map<String, Integer> hashMap2 = new HashMap();

	public static void main(String[] args) {
		HashMapPractise obj = new HashMapPractise();
		obj.addData();
		obj.mergeData();
	}

	// Add data in map and print, You may observer that data is printed in sorted
	// form but it's due to less data
	private void addData() {
		hashMap1.put("A", 1);
		hashMap1.put("C", 3);
		hashMap1.put("B", 2);
		hashMap1.put("D", 4);

		hashMap1.entrySet().stream().forEach(System.out::println);
	}

	// We want to merger to map they may or may not have the same key.
	private void mergeData() {
		hashMap2.put("X", 8);
		hashMap2.put("Y", 9);
		hashMap2.put("Z", 10);

		// ONe way is to create third map and put all the other hashMaps
		HashMap<String, Integer> hashMap3 = new HashMap();
		hashMap3.putAll(hashMap1);
		hashMap3.putAll(hashMap2);

		// We have merge the values and print all the value in hashMap3
		System.out.println("\nPrint Map hash3");
		hashMap3.entrySet().stream().forEach(System.out::print);

		// suppose there are key which is available in both the Map,
		// then we need to decide which value we will keep in the new map
		hashMap2.put("A", 5);
		HashMap<String, Integer> hashMap4 = new HashMap();
		hashMap4.putAll(hashMap1);
		hashMap4.putAll(hashMap2);
		System.out.println("\n \nPrint Map hash4");

		// If you look at value of "A" it has been overridden
		hashMap4.entrySet().stream().forEach(System.out::print);

		 /*If we want to have previous value instead of new than
		 and we don't want a new map, instead we want to merge in same below code
		 from java 8*/
		hashMap2.forEach((k, v) -> hashMap1.merge(k, v, (v1, v2) -> v1));

		System.out.println("\n \nPrint Map hash2");
		// If you look at value of "A" it been kept from hashMap1 only
		hashMap1.entrySet().stream().forEach(System.out::print);
	}
}
