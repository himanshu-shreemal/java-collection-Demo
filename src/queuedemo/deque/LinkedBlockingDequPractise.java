package queuedemo.deque;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/*optionally-bounded functionality based on linked nodes, means if you give the capacity while
 * initializing the deque and if you try to overload the deque from given capacity it wil throw
 * and exception saying that deque is full. that's why the name is linkedBlockingDeque
 * If we use take() it will block the thread till the value is available else use poll() to get null response*/
public class LinkedBlockingDequPractise {

	public static void main(String[] args) {

		LinkedBlockingDequPractise obj = new LinkedBlockingDequPractise();
		obj.addRemoveOpertaion();

	}

	private void addRemoveOpertaion() {
		//First we initialized with no capacity
		LinkedBlockingDeque<Integer> LBD = new LinkedBlockingDeque();

		// Add numbers to end of LinkedBlockingDeque
		
		//Adding the null will throw an error
//		LBD.add(null);
		
		LBD.add(35658786);
		LBD.add(5278367);
		LBD.add(74381793);
		LBD.add(743793);
		LBD.add(74381);

		// print Dequee
		System.out.println("Linked Blocking Deque1: " + LBD);
		System.out.println("Size of Linked Blocking Deque1: " + LBD.size());

		//Now we are creating with a given size, it should not contains beyond the size
		LinkedBlockingDeque<Integer> LBD1 = new LinkedBlockingDeque<Integer>(3);

		// Add numbers to end of LinkedBlockingDeque
		LBD1.add(785);
		LBD1.add(386);
		LBD1.add(57);

		try {
			//Will block the queue if we have fix the size
			LBD1.put(4);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			//If we do not use tryCatch it's a illegalState exeception.
			LBD1.add(71793);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}

		try {
			System.out.println(LBD1.take());
			System.out.println(LBD1.take());
			System.out.println(LBD1.take());
			System.out.println("Take the values from the empty");
			System.out.println(LBD1.take());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// print Dequee
		System.out.println("Linked Blocking Deque2: " + LBD1);
		System.out.println("Size of Linked Blocking Deque2: " + LBD1.size());

		/*create object of LinkedBlockingDeque
		 * using LinkedBlockingDeque(Collection c) constructor*/
		List<Integer> list  = new ArrayList();
		list.add(12);
		list.add(2);
		list.add(12);
		list.add(02);
		list.add(92);
		
		LinkedBlockingDeque<Integer> LBD2 = new LinkedBlockingDeque<Integer>(list);

		// print Dequee
		System.out.println("Linked Blocking Deque3: " + LBD2);
		
		
		LBD1.drainTo(list);
		System.out.println("After drainTo method "+list);
	}

}
