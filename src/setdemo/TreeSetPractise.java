package setdemo;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/*Set contains only unique values.
 * Tree set does not holds any null value.
 * it keep the values in natural order.
 * For changing the order we need to impecomparator interface.
 * for storing the objects, the object class should have implemented comparable interface.
 * Below are few examples */

/*Below class TestTreeSetFailure does not implements Comparable interface but
 * overrides the equals and hashcode method, even though it is not gonna work*/
class TestTreeSetFailure {
	int id;
	String name;

	public TestTreeSetFailure(int id) {
		super();
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestTreeSetFailure other = (TestTreeSetFailure) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TestTreeSet [id=" + id + "]";
	}

}

/*
 * Class that implements comparable interface; Make sure you create a comparable
 * of class type
 */
class TestTreeSetSuccess implements Comparable<TestTreeSetSuccess> {
	int id;
	String name;

	public TestTreeSetSuccess(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "TestTreeSetSuccess [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compareTo(TestTreeSetSuccess s) {
		return this.name.compareTo(s.name);
	}

}

public class TreeSetPractise {

	/* Uncomment any of the method you want to execute */

	public static void main(String[] args) {
		TreeSetPractise obj = new TreeSetPractise();
		obj.addStringDataToTreeSet();
		 obj.addNullDataToTreeSet();
		// obj.addObjectDataAndGetError();
		// obj.addTestTreeSetFailureClassObject();
		// obj.addTestTreeSetSuccessClassObject();
		// obj.removeAndPoll();
		// obj.fetchHeadOrTail();

	}

	// Add simple string data and it will automatically get sorted
	private void addStringDataToTreeSet() {
		TreeSet<String> ts = new TreeSet<>();

		/* For reversing the order comment above line and uncomment below line */
		// TreeSet<String> ts = new TreeSet<>(Comparator.reverseOrder());

		ts.add("Z");
		ts.add("B");
		ts.add("A");
		ts.add("O");
		System.out.println(ts);
	}

	private void addNullDataToTreeSet() {
		TreeSet<String> ts = new TreeSet<>();
		ts.add(null);

	}

	private void addObjectDataAndGetError() {
		TreeSet ts = new TreeSet();
		ts.add(1);
		ts.add("Z");
		ts.add(new TestTreeSetFailure(2));
		ts.add(0.0);
		System.out.println(ts);

	}

	private void addTestTreeSetFailureClassObject() {
		TreeSet<TestTreeSetFailure> ts = new TreeSet<TestTreeSetFailure>();
		ts.add(new TestTreeSetFailure(2));
		ts.add(new TestTreeSetFailure(26));
		ts.add(new TestTreeSetFailure(10));
		ts.add(new TestTreeSetFailure(1));

	}

	private void addTestTreeSetSuccessClassObject() {

		SortedSet<TestTreeSetSuccess> ts = new TreeSet();
		TestTreeSetSuccess t1 = new TestTreeSetSuccess("A");
		TestTreeSetSuccess t2 = new TestTreeSetSuccess("Z");
		TestTreeSetSuccess t3 = new TestTreeSetSuccess("G");
		TestTreeSetSuccess t4 = new TestTreeSetSuccess("H");
		ts.add(t1);
		ts.add(t2);
		ts.add(t3);
		ts.add(t4);
		System.out.println(ts.toString());

	}

	private void removeAndPoll() {
		TreeSet<Integer> numbers = new TreeSet<>();

		numbers.add(10);
		numbers.add(15);
		numbers.add(20);
		numbers.add(25);
		numbers.add(30);
		numbers.add(42);
		numbers.add(49);
		numbers.add(50);

		System.out.println("numbers TreeSet : " + numbers);

		// Remove an element from the TreeSet
		boolean isRemoved = numbers.remove(49);
		if (isRemoved) {
			System.out.println("After Removing 49 : " + numbers);
		}

		// Remove all elements divisible by 3
		numbers.removeIf(number -> number % 3 == 0);
		System.out.println("After removeIf() : " + numbers);

		// Retrieve and remove the first element from the TreeSet
		Integer num = numbers.pollFirst();
		System.out.println("Removed first element " + num + " from the TreeSet : " + numbers);

		// Retrieve and remove the last element from the TreeSet
		num = numbers.pollLast();
		System.out.println("Removed last element " + num + " from the TreeSet : " + numbers);
	}

	private void fetchHeadOrTail() {
		TreeSet<Integer> numbers = new TreeSet<>();

		numbers.add(10);
		numbers.add(15);
		numbers.add(20);
		numbers.add(25);
		numbers.add(30);
		numbers.add(42);
		numbers.add(49);
		numbers.add(50);

		System.out.println("numbers TreeSet : " + numbers);

		System.out.println("nodes after 25 : " + numbers.tailSet(25));
		System.out.println("nodes before 25 exclding the 25 :" + numbers.headSet(25));

	}

}
