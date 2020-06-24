package queuedemo;

import java.util.concurrent.SynchronousQueue;

/*Capacity of a synchrounous queue is always zero.
because in SynchronousQueue an insert will wait for a remove operation by another thread 
and vice versa.
put() call to a SynchronousQueue will not return until there is a corresponding take() call.
it iteration is also not possible.
Insert is not possible if there is a thread trying to remove it.*/

public class SynchronousQueuePractise {

	public static void main(String[] args) {
		SynchronousQueuePractise obj = new SynchronousQueuePractise();
		obj.addRemove();
	}

	 /*First try to execute the same way we use to earlier, then we will find that
	 this is not the same as otheres
	 it is use to handle producer consumer problem
	 to check producer consumer problem check my other repository with name producer-consumer-problem-java*/
	private void addRemove() {
		SynchronousQueue<String> sq = new SynchronousQueue<>();
		// Trying to add null to synchronousQueue, it will throw the exception
		// sq.add(null);

		// In this kind of queue we can not even add a single value as the size
		// is zero which is fixed and can not be change.
		// sq.add("A");

		// sq.add("B");

		//try to poll from the queue
		System.out.println(sq.poll());
		
		try {
			sq.put("C");
			System.out.println(sq.poll());

			// Will not print next statement till other thread take the given value
			// System.out.println("Waiting for thread to take the value");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(sq.poll());
	}

}
