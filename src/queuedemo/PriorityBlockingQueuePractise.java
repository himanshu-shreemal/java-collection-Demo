package queuedemo;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

/*PriorityBlockingQueue is an unbounded queue and grows dynamically. 
 * The default initial capacity is '11' which can be overridden using initialCapacity parameter.
 * It supplies blocking retrieval operations.
 * It does not allow NULL objects.
 * Objects added to PriorityBlockingQueue MUST be comparable otherwise it throws ClassCastException.
 * The objects of the priority queue are ordered by default in natural order.
 * The head of the priority queue is the least element based on the natural ordering or comparator based ordering. 
 * When we poll the queue, it returns the head object from the queue.
 * If multiple objects are present of same priority the it can poll any one of them randomly.
 * PriorityBlockingQueue is thread safe.
 * If we use take() method it will block the thread till the value is available.
 * The Iterator provided in method iterator() is not guaranteed to traverse the elements of the PriorityBlockingQueue in any particular order. 
 * If you need ordered traversal, consider using Arrays.sort(pbq.toArray()).
 * The drainTo() can be used to remove some or all elements in priority order and place them in another collection.*/

class EmployeePBQ implements Comparable<EmployeePBQ> {
	int id;
	String name;

	public EmployeePBQ(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(EmployeePBQ o) {
		return this.name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return "EmployeePBQ [name=" + name + "]";
	}

}

public class PriorityBlockingQueuePractise {

	public static void main(String[] args) {

		PriorityBlockingQueuePractise obj = new PriorityBlockingQueuePractise();
		obj.addRemove();
		obj.addCOmparableObj();

	}

	private void addRemove() {
		PriorityBlockingQueue<Integer> pbq = new PriorityBlockingQueue<>(1);
		System.out.println(pbq.poll());
		pbq.add(20);
		pbq.add(30);
		
		//Below will give you an error
//		pbq.add(null);
		
		//This will not block the operation as the size is not fix, it grow till any
		pbq.put(30);
		
		System.out.println(pbq.poll());
		System.out.println(pbq.poll());
		System.out.println(pbq.poll());
		try {
			//It will block the operation as there is no value
			System.out.println(pbq.take());
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("Curretn value in PBQ " + pbq + " and the size is " + pbq.size());

		// pbq.add(null);
		pbq.add(4);
		pbq.add(50);
		System.out.println(pbq);

		// Size can be grown dynamically
		System.out.println("After adding value in PBQ " + pbq + " and the size is now " + pbq.size());

		try {
			System.out.println("While try to add null value in PBQ");
			pbq.add(null);

		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		// IT's poll, peek, offer opertaions are thread safe as they use lock before
		// accessing
		System.out.println("\nFetch the value from head :" + pbq.poll());

	}

	private void addCOmparableObj() {
		Queue<EmployeePBQ> pbq = new PriorityBlockingQueue();
		pbq.add(new EmployeePBQ("J"));
		pbq.add(new EmployeePBQ("H"));
		pbq.add(new EmployeePBQ("P"));
		pbq.add(new EmployeePBQ("C"));
		pbq.add(new EmployeePBQ("P"));
		pbq.add(new EmployeePBQ("J"));
		pbq.add(new EmployeePBQ("H"));
		pbq.add(new EmployeePBQ("A"));
		pbq.add(new EmployeePBQ("C"));
		
		System.out.println(pbq);
		
		//iterator will not specify the order the order can be different
		Iterator<EmployeePBQ> it = pbq.iterator();
		while(it.hasNext())System.out.println(it.next());
		
		System.out.println("------------------------");
		
		//If multiple objects are present of same priority the it can poll any one of them randomly
		System.out.println(pbq.poll());
		System.out.println(pbq.poll());
		System.out.println(pbq.poll());
	}

}
