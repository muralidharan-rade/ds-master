package com.ds.samples;

public class OurOwnQueue {

	public static void main(String[] args) {

		Queue queue = new Queue("first");
		System.out.println(queue);

		queue.enqueue("sec");
		queue.enqueue("third");
		queue.enqueue("four");
		System.out.println(queue);

		System.out.println(queue.peek());

		System.out.println(queue.dequeue());
		System.out.println(queue.peek());

		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue);
	}

}

class Queue {

	@Override
	public String toString() {
		return "Queue [first=" + first + ", last=" + last + ", size=" + size + "]";
	}

	QueueNode first;
	QueueNode last;
	int size;

	public Queue(String val) {

		QueueNode node = new QueueNode(val);
		this.first = node;
		this.last = node;
		size++;
	}

	void enqueue(String val) {
		QueueNode node = new QueueNode(val);
		if (this.first == null && this.last == null) {
			this.first = node;
			this.last = node;
		} else {
			this.last.next = node;
			this.last = node;
		}
		size++;
	}

	QueueNode dequeue() {

		if (this.first == null) {
			return null;
		}

		QueueNode temp = this.first;
		this.first = this.first.next;
		if (size == 1) {
			this.last = null;
		}
		size--;
		return temp;
	}

	QueueNode peek() {
		return this.first;
	}

}

class QueueNode {

	String value;
	QueueNode next;

	QueueNode(String val) {
		this.value = val;
	}

	@Override
	public String toString() {
		return "QueueNode [value=" + value + "]";
	}

}
