package queuedemo;

import java.util.PriorityQueue;


/*The elements of the priority queue are ordered according to their natural ordering, 
 * or by a Comparator provided at queue construction time, depending on which constructor is used.
 * A priority queue does not permit null elements.
 * A priority queue relying on natural ordering also does not permit insertion of non-comparable objects.
 */
public class PriorityQueuePractise {

	public static void main(String[] args) {
		PriorityQueuePractise obj = new PriorityQueuePractise();
		obj.addRemove();
	}
	
	private void addRemove() {
		 // Creating empty priority queue 
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(2); 
  
        //When trying to add null value
        //pQueue.add(null);
        
        // Adding items to the pQueue using add() 
        pQueue.add(10); 
        pQueue.add(20); 
        pQueue.add(15); 
  
        //using put or take method are not available in this class
//        pQueue.take(); pQueue.put();
        
        // Printing the top element of PriorityQueue but not remove
        System.out.println(pQueue.peek()); 
  
        // Printing the top element and removing it 
        // from the PriorityQueue container 
        System.out.println(pQueue.poll()); 
  
        // Printing the top element again 
        System.out.println(pQueue.poll());
        System.out.println(pQueue.poll());
        System.out.println(pQueue.poll());
	}
	
}
