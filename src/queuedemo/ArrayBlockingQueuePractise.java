package queuedemo;

import java.util.concurrent.ArrayBlockingQueue;

/*ArrayBlockingQueue class is a bounded blocking queue backed by an array. 
By bounded it means that the size of the Queue is fixed. 
 created, the capacity cannot be changed.
 Attempts to put an element into a full queue 
 via add(), will result in "java.lang.IllegalStateException: Queue full" 
 via put() method thread will wait till space is available
 Attempts to take an element from an empty queue will also be blocked.
 This queue orders elements FIFO (first-in-first-out)*/

public class ArrayBlockingQueuePractise {

	public static void main(String[] args) {
		ArrayBlockingQueuePractise obj = new ArrayBlockingQueuePractise();
		obj.addRemove();
	}

	private void addRemove() {
		int capacity = 3;

		// create object of ArrayBlockingQueue
		// using ArrayBlockingQueue(int initialCapacity) constructor
		ArrayBlockingQueue<Integer> abq = new ArrayBlockingQueue<Integer>(3);

		// add numbers
		abq.add(null);
		abq.add(2);
		abq.add(3);

		// print queue
		System.out.println("ArrayBlockingQueue:" + abq);
		
		/*try {
			//This can block the thread if there is no space
//			abq.put(3);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/

		//poll all the values
		System.out.println(abq.poll());
		System.out.println(abq.poll());
		System.out.println(abq.poll());
		System.out.println(abq.poll());
		try {
			//This can block the thread if there is no values in queue
			System.out.println(abq.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		abq.add(4);
		// print queue
				System.out.println("ArrayBlockingQueue:" + abq);
					
	}

}
