package listdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*IT's nothing but a dynamic array, which automatically grew once you start inserting the data*/

public class ArrayListPractise {

	public static void main(String[] args) {
		ArrayListPractise obj = new ArrayListPractise();
//		obj.addRemoveData();
		obj.useOfListIterato();

	}

	private void addRemoveData() {
		// declaring ArrayList with initial size n
		List<Integer> arrli = new ArrayList();

		// Appending the new element at the end of the list
		arrli = Stream.iterate(1, n -> n + 1).limit(10).collect(Collectors.toList());

		// Printing elements
		System.out.println(arrli);

		/*
		 * Remove element at index 3, whenever we remove the data from list I
		 * automatically shift rest of the data in the arraylist
		 */ arrli.remove(3);

		// Displaying ArrayList after deletion
		System.out.println(arrli);

		// Printing elements one by one
		arrli.forEach(data -> System.out.printf("%3d", data));

	}

	private void useOfListIterato() {
		// declaring ArrayList with initial size n
		List<Integer> arrli = new ArrayList();

		// Appending the new element at the end of the list
		arrli = Stream.iterate(1, n -> n + 1).limit(10).collect(Collectors.toList());

		ListIterator<Integer> lt = arrli.listIterator();
		while(lt.hasNext()) {
			int temp = lt.next();
			if(temp % 2 ==0) {
				/*We can not add and remove while using the simple iterator*/
				lt.remove();
				lt.add(-1);
			}
		}
		
		arrli.forEach(data -> System.out.println( data));
		
		
	}

}
