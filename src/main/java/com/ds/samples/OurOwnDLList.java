package com.ds.samples;

public class OurOwnDLList {

	public static void main(String[] args) {
		DoubleLinkedList dll = new DoubleLinkedList("1st");
		System.out.println(dll);

		dll.prepend("zero");
		System.out.println(dll);

		dll.append("2nd");
		System.out.println(dll);

		dll.append("4th");
		System.out.println(dll);

		dll.insert("3rd", 3);
		System.out.println(dll);

		dll.remove(4);
		System.out.println(dll);
	}

}

class DoubleLinkedList {

	DLNode head;
	DLNode tail;
	int length;

	public DoubleLinkedList(String val) {
		DLNode initial = new DLNode(val);
		this.head = initial;
		this.tail = initial;
		this.length++;
	}

	public int size() {
		return this.length;
	}

	@Override
	public String toString() {
		return "DoubleLinkedList [head=" + head + ", tail=" + tail + ", length=" + length + "]";
	}

	public void prepend(String value) {
		DLNode node = new DLNode(value);
		this.head.previous = node;
		node.next = this.head;
		this.head = node;
		this.length++;
	}

	public void append(String value) {
		DLNode node = new DLNode(value);
		this.tail.next = node;
		node.previous = this.tail;
		this.tail = node;
		this.length++;
	}

	public void insert(String value, int index) {

		if (index < 0) {
			System.out.println("not valid index");
		} else if (index == 0) {
			this.prepend(value);
		} else if (index == this.length) {
			this.append(value);
		} else {

			DLNode leaderNode = getIndexNode(index - 1);
			DLNode newNode = new DLNode(value);
			if (leaderNode != null) {
				DLNode temp = leaderNode.next;

				newNode.previous = leaderNode;
				newNode.next = temp;
				leaderNode.next = newNode;
				temp.previous = newNode;
				this.length++;
			}

		}
	}

	private DLNode getIndexNode(int index) {

		if (index < 0 || index > this.length) {
			System.out.println("Not a valid index");
			return null;
		}

		int counter = 0;
		DLNode counterNode = this.head;

		while (counter < index) {

			counterNode = counterNode.next;
			counter++;
		}

		return counterNode;
	}

	public void remove(int index) {
		if (index < 0 || index >= this.length) {
			System.out.println("not valid index");
		} else if (index == 0) {
			this.head = this.head.next;
			this.length--;
		} else if (index == this.length - 1) {
			this.tail = this.tail.previous;
			this.length--;
		} else {
			DLNode leaderNode = getIndexNode(index - 1);
			if (leaderNode != null) {
				DLNode temp = leaderNode.next;

				leaderNode.next = temp.next;
				temp.next.previous = leaderNode;
				this.length--;
			}
		}
	}
}

class DLNode {

	DLNode next;
	DLNode previous;
	String value;

	DLNode(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

}
