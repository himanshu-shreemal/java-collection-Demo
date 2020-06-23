package queuedemo;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/*for working with delayQueue the on which we wants to work must have implemented Delayed.
 * it has two methods compareTo() and getDelay()
 * for which the time has expired it executes that.
 * We can not define size through constructor.
 * The head of the queue is that Delayed element whose delay expired furthest in the past. 
 * If no delay has expired there is no head and poll will return null
 * it's unbounded queue.
 * Even though unexpired elements cannot be removed using take or poll, they are otherwise 
 * treated as normal elements. For example, the size method returns the count of both 
 * expired and unexpired elements.
 * */

class WorkOnDelayQueue implements Delayed {

	long startTime;
	String name;

	public WorkOnDelayQueue(long time, String name) {
		this.startTime = (System.currentTimeMillis()/1000) + time;
		this.name = name;
	}

	@Override
	public int compareTo(Delayed obj) {
		if (this.startTime < ((WorkOnDelayQueue) obj).startTime) {
			return -1;
		}
		if (this.startTime > ((WorkOnDelayQueue) obj).startTime) {
			return 1;
		}
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long diff = startTime -(System.currentTimeMillis()/1000);
		System.out.println("getDelay method : "+unit.convert(diff, TimeUnit.SECONDS));
		return unit.convert(diff, TimeUnit.SECONDS);
	}

	@Override
	public String toString() {
		return "WorkOnDelayQueue [time=" + startTime + ", name=" + name + "]";
	}

}

public class DelayQueuePractise {

	public static void main(String[] args) {
		DelayQueuePractise obj = new DelayQueuePractise();
		obj.addRemove();
	}

	private void addRemove() {
		DelayQueue<WorkOnDelayQueue> dq = new DelayQueue();

		// When we try add null it gives null pointer exception
		// dq.add(null);

		// when deque is empty and we try to poll the data it will responde with null
		System.out.println(dq.poll());

		// this method will never block as queue is unbounded
		dq.put(new WorkOnDelayQueue(3, "A"));
		dq.put(new WorkOnDelayQueue(5, "B"));

		// We can use add method as well to add the task
		dq.add(new WorkOnDelayQueue(10, "C"));

		
		 System.out.println("DelayQueue: " + dq);
		 
		 //As the delay reqiure at least for 3 seonds, so poll will return null
		 System.out.println("try to poll the value :"+ dq.poll());
		try {
			//This will wait till time get expires
			System.out.println(" try to take the value take1 " +dq.take().toString());
			System.out.println("take 2 "+dq.take().toString());
			System.out.println("take 3" +dq.take().toString());

			// As the number of input is 3, it will keep waiting for next input
			System.out.println(dq.take().toString());
			System.out.println("Done");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
