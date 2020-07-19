package listdemo;

import java.util.Stack;

/*Linked list is data structure which work on links.
 *The head node contains data and address for the next node. Generally we travel from head to tail node
 *The below example is for one way linked list. */

/*We have created a class for that will help us to prepare a node, hold the data and 
 * address for next node.*/
class SinglyLinkedListNode {
	int data;
	SinglyLinkedListNode next;

	public SinglyLinkedListNode(int data) {
		this.data = data;
	}

}

public class LinkedListPractise {

	public static void main(String[] args) {
		LinkedListPractise obj = new LinkedListPractise();
		
		//We want to create a linked list from 1 to 5;
		SinglyLinkedListNode head1 = obj.creatLinkedList(1, 5);
		obj.printLinkedList(head1);
	
		//We want to create a linked list from 6 to 10;
		SinglyLinkedListNode head2 = obj.creatLinkedList(6, 10);
		obj.printLinkedList(head2);
		
		//Merge to linked list
		obj.printLinkedList(obj.mergeLists(head1, head2));
		
		//Get the second node from linked list from last
		System.out.println("Second last node from first linked list :"+getNode(head1,1));
	}

	// Create the linked list
	private SinglyLinkedListNode creatLinkedList(int start, int end) {
		SinglyLinkedListNode head = null;
		SinglyLinkedListNode last = null;
		while (start <= end) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(start);
			if (head == null) {
				head = node;
				last = node;
				start++;
				continue;
			}

			last.next = node;
			last = node;
			start++;
		}
		return head;
	}

	//Print the linked list from given head to till end
	private void printLinkedList(SinglyLinkedListNode head) {
		if (head != null) {
			while (head != null) {
				System.out.print(head.data + " ->");
				head = head.next;
			}
			System.out.println("null");
		}

	}

	//Merge given two different linked list 
	private SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		SinglyLinkedListNode result = null;
		SinglyLinkedListNode resultData = null;

		if (head1.data <= head2.data) {
			result = new SinglyLinkedListNode(head1.data);
			head1 = head1.next;
		} else {
			result = new SinglyLinkedListNode(head2.data);
			head2 = head2.next;
		}
		resultData = result;
		while (head1 != null && head2 != null) {
			SinglyLinkedListNode newNode;
			if (head1.data <= head2.data) {
				newNode = new SinglyLinkedListNode(head1.data);
				head1 = head1.next;
			} else {
				newNode = new SinglyLinkedListNode(head2.data);
				head2 = head2.next;
			}
			result.next = newNode;
			result = newNode;
		}
		if (head1 != null) {
			result.next = head1;
		}
		if (head2 != null) {
			result.next = head2;
		}
		return resultData;
	}

	//This function can help to get node from give position start from last
	static int getNode(SinglyLinkedListNode head, int positionFromTail) {
		Stack<Integer> stack = new Stack();
		while (head != null) {
			stack.push(head.data);
			head = head.next;
		}
		while (positionFromTail-- > 0) {
			stack.pop();
		}
		return stack.pop();
	}
}
