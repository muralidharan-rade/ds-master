package com.ds.samples;

import java.util.ArrayList;
import java.util.List;

public class OurOwnStack {

	public static void main(String[] args) {

		Stack stack = new Stack("Base");
		System.out.println(stack);

		stack.push("one");
		stack.push("two");
		stack.push("three");
		System.out.println(stack);

		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());

		// ------------ stack using arrays
		ArrayStack arrSack = new ArrayStack();
		arrSack.push("Google");
		arrSack.push("Udemy");
		arrSack.push("xxx");

		System.out.println(arrSack);
		System.out.println(arrSack.peek());
		System.out.println(arrSack.pop());
		System.out.println(arrSack);
		System.out.println(arrSack.pop());
		System.out.println(arrSack.pop());
		System.out.println(arrSack.pop());
		System.out.println(arrSack);
	}

}

class Stack {

	StackNode top;
	int size;

	public Stack(String val) {
		StackNode node = new StackNode(val);
		this.top = node;
		this.size++;
	}

	public StackNode peek() {
		if (size > 0) {
			return this.top;
		}
		return null;
	}

	public StackNode pop() {
		if (size > 0) {
			StackNode node = this.top;
			this.top = node.next;
			this.size--;
			return node;
		}
		return null;
	}

	public void push(String value) {
		StackNode node = new StackNode(value);
		node.next = this.top;
		this.top = node;
		this.size++;
	}

	@Override
	public String toString() {
		return "Stack [head=" + top + ", size=" + size + "]";
	}

}

class StackNode {

	StackNode next;
	String value;

	StackNode(String val) {
		this.value = val;
	}

	@Override
	public String toString() {
		return "StackNode [value=" + value + "]";
	}

}

class ArrayStack {

	@Override
	public String toString() {
		return "ArrayStack [list=" + list + ", top=" + top + "]";
	}

	List<String> list;
	int top = -1;

	public ArrayStack() {
		this.list = new ArrayList<String>();
	}

	String peek() {
		return list.get(top);
	}

	void push(String value) {
		list.add(++top, value);
	}

	String pop() {
		if (top < 0) {
			return null;
		}
		return list.remove(top--);
	}
}
