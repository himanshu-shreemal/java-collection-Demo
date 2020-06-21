package listdemo;

import java.util.Arrays;
import java.util.Vector;

/*vector is same like list but it's all methods are thread safe we don't need to handle
 *  explicitly when mulitple threads are removing and adding values from vector.
 *  we can add null as well, it contains duplicate and does maintain insertion oreder
 */

public class VectorPractise {

	public static void main(String[] args) {
		VectorPractise obj = new VectorPractise();
		 obj.addVlaues();
//		obj.copyData();
	}

	private void addVlaues() {
		Vector<Integer> v = new Vector();
		v.add(1);
		v.add(20);
		v.add(null);
		v.add(10);
		v.add(20);

		System.out.println("Added null and duplicate values");
		System.out.println(v);

		System.out.println("Remove value from vector");
		// It takes array index to remove the valu
		v.remove(2); // This will remove the null , as index starts with zero
		System.out.println(v);

		// We can print current capacity of vector, initial is 10
		System.out.println(v.capacity());

		// We can also give the capacity
		Vector<Integer> vWithCapacity = new Vector(20);
		System.out.println(vWithCapacity.capacity());
		
//		Fetch the first or last value from vector
		System.out.println("First element of vector is : "+v.firstElement());
		System.out.println("Last element of vector is : "+v.lastElement());

		
		//Trim the size of vector to current size of vector
		System.out.println("Before using trim the size of vector was : "+v.capacity());
		v.trimToSize();
		System.out.println("After using trim the size of vector is : "+ v.capacity());
	}
	
	private void copyData() {
		Vector<Integer> v = new Vector();
		v.add(1);
		v.add(20);
		v.add(null);
		v.add(10);
		v.add(20);
		
		Integer a[] = new Integer[v.size()];
		v.copyInto(a);
		
		//Creat a copy of vector to an array
		Arrays.stream(a).forEach(System.out::println);
	}

}
