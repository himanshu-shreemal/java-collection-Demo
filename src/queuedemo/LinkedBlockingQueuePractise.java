package queuedemo;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/*LinkedBlockingQueue is an optionally-bounded blocking queue based on linked nodes
This queue orders elements FIFO (first-in-first-out). 
It means that the head of this queue is the oldest element of the elements present in 
this queue. The tail of this queue is the newest element of the elements of this queue. 
The capacity, if unspecified, is equal to Integer.MAX_VALUE*/

public class LinkedBlockingQueuePractise {

	public static void main(String[] args) {
		LinkedBlockingQueuePractise obj = new LinkedBlockingQueuePractise();
		obj.addRemove();
	}

	private void addRemove() {
		LinkedBlockingQueue<Integer> lbq = new LinkedBlockingQueue<>(3);
		// add numbers
		lbq.add(1);
		lbq.add(2);
		lbq.add(3);
		
		//If queue is full and we try to add more, it will give illegal state exception
		lbq.add(4);
		
		try {
			//Will the execution if queue is full
			lbq.put(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Can not add null, will throw null pointer exception
		//lbq.add(null);

		try {
			while(!lbq.isEmpty())
			System.out.println(lbq.take());
			
			//As queue is empty now this will block the execution
			lbq.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// print queue
		System.out.println("LinkedBlockingQueue:" + lbq);

	}

}
