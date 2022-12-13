package com.ds.samples;

public class OurOwnLinkedList {

	public static void main(String[] args) {

		LinkedList ll = new LinkedList("first");
		System.out.println(ll);

		ll.prepend("zero");
		System.out.println(ll);

		ll.append("second");
		ll.append("3rd");
		ll.append("4th");
		ll.append("5th");
		System.out.println(ll);

		System.out.println("size :: " + ll.size());

		ll.insert("10", 0);
		System.out.println(ll);

		ll.insert("100", 7);
		System.out.println(ll);

		ll.insert("1001", 10);
		System.out.println(ll);

		ll.insert("8th", 5);
		System.out.println(ll);

		ll.remove(0);
		System.out.println(ll);

		ll.remove(5);
		System.out.println(ll);

		ll.append("last");
		System.out.println(ll);

		ll.printall();
		ll.reverse();
	}

}

class LinkedList {

	Node head;
	Node tail;
	int length;

	public LinkedList(String val) {
		Node n = new Node(val);
		this.head = n;
		this.tail = n;
		this.length = 1;
	}

	public void printall() {
		Node n = this.head;
		while (n != null) {
			System.out.println(n.value);
			n = n.next;
		}
	}

	// O(1)
	public void prepend(String value) {
		Node newHead = new Node(value);
		newHead.next = this.head;
		this.head = newHead;
		length++;
	}

	// O(1)
	public void append(String value) {
		Node newTail = new Node(value);
		this.tail.next = newTail;
		this.tail = newTail;
		length++;
	}

	public void insert(String value, int index) {
		if (index == 0) {
			this.prepend(value);
		} else if (index == this.length) {
			this.append(value);
		} else if (index > this.length) {
			System.err.println("not valid index");
		} else {

			Node newNode = new Node(value);
			Node counterNode = getIndexNode(index - 1);
			newNode.next = counterNode.next;
			counterNode.next = newNode;
			this.length++;
		}
	}

	public void remove(int index) {
		if (index == 0) {
			this.head = this.head.next;
			this.length--;
		} else if (index > this.length) {
			System.err.println("not valid index");
		} else {
			Node counterNode = getIndexNode(index - 1);
			counterNode.next = counterNode.next.next;
			this.length--;
		}
	}

	private Node getIndexNode(int index) {
		Node counterNode = this.head;
		int counter = 0;

		while (counter <= index) {
			if (counter != index)
				counterNode = counterNode.next;
			counter++;
		}

		return counterNode;
	}

	public int size() {
		return length;
	}

	@Override
	public String toString() {
		return "LinkedList [head=" + head + ", /n tail=" + tail + ", length=" + length + "]";
	}

	public void reverse() {
		LinkedList tempLL = new LinkedList(this.head.value);
		Node n = this.head.next;
		while (n != null) {
			tempLL.prepend(n.value);
			if (n.next == null) {
				this.tail = n;
			}
			n = n.next;
		}

		System.out.println("Revers output :: ");
		tempLL.printall();
	}

}

class Node {

	String value;
	Node next;

	Node(String val) {
		this.value = val;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", next=" + next + "]";
	}

}
