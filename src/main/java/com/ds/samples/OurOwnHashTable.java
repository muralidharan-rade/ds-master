package com.ds.samples;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class OurOwnHashTable {

	public static void main(String[] args) {

		HashTable table = new HashTable();
		table.put("apple", "first");
		table.put("Ball", "second");
		table.put("Cat", "third");
		table.put("Dog", "Fourth");
		table.put("Elephant", "Fifth");
		table.put("Fish", "Sixth");
		table.put("t", "Seventh");
		table.put("u", "Seventh");
		table.put("v", "Seventh");
		table.put("w", "Seventh");
		table.put("x", "Eight");
		table.put("H", "9");
		table.put("I", "10");
		table.put("J", "1");
		table.put("K", "2");
		table.put("L", "3");
		table.put("M", "7");
		table.put("N", "4");
		table.put("O", "6");
		table.put("P", "5");
		table.put("Q", "8");
		table.put("R", "9");
		table.put("Sa", "11");

		table.printAll();
		System.out.println(table.get("Fish"));
		System.out.println(table.get("apple"));
		System.out.println(table.get("P"));
	}

}

class HashTable {

	LinkedList<Entry>[] hashLinkedList;
	int initial_capacity = 10;
	int size;

	public HashTable() {
		this.hashLinkedList = new LinkedList[initial_capacity];
		this.size = 0;
	}

	public void printAll() {
		int indexArr = 0;
		for (LinkedList<Entry> ll : hashLinkedList) {
			if (ll != null) {
				Iterator<Entry> i = ll.iterator();
				while (i.hasNext()) {
					System.out.println(indexArr + " :: " + i.next());
				}
			}
			indexArr++;
		}
	}

	private int hashAddr(String key) {
		if (key == null) {
			throw new UnsupportedOperationException();
		}
		int val = (key.hashCode() % hashLinkedList.length);
		return val;
	}

	// O(1) - average case - constant time
	public void put(String key, String value) {

		int index = hashAddr(key);
		System.out.println("index :: " + index + " :: size :: " + size);
		if (size >= Math.floor(initial_capacity * 0.7)) {
			resize();
		}

		if (hashLinkedList[index] == null) {
			LinkedList<Entry> ll = new LinkedList<Entry>();
			ll.add(new Entry(key, value));
			hashLinkedList[index] = ll;
			size++;
		} else {
			LinkedList<Entry> addLL = hashLinkedList[index];

			for (int i = 0; i < addLL.size(); i++) {
				if (addLL.get(i).key.equals(key)) {
					addLL.get(i).value = value;
				} else {
					addLL.add(new Entry(key, value));
					size++;
				}
			}
		}
	}

	private void put(String key, String value, int dummy) {

		int index = hashAddr(key);

		if (hashLinkedList[index] == null) {
			LinkedList<Entry> ll = new LinkedList<Entry>();
			ll.add(new Entry(key, value));
			hashLinkedList[index] = ll;
		} else {
			LinkedList<Entry> addLL = hashLinkedList[index];

			for (int i = 0; i < addLL.size(); i++) {
				if (addLL.get(i).key.equals(key)) {
					addLL.get(i).value = value;
				} else {
					addLL.add(new Entry(key, value));
				}
			}
		}
	}

	// Average case - constant time O(1)
	public String get(String key) {
		if (key == null) {
			throw new UnsupportedOperationException();
		}

		int index = hashAddr(key);
		if (hashLinkedList[index] == null) {
			return null;
		} else {
			LinkedList<Entry> indexLL = hashLinkedList[index];
			if (indexLL.size() == 1) {
				return indexLL.get(0).value;
			} else {
				for (int i = 0; i < indexLL.size(); i++) {
					if (indexLL.get(i).key.equals(key)) {
						return indexLL.get(i).value;
					}
				}
			}
		}

		return null;
	}

	public void remove(String key) {

	}

	public Set<String> keySet() {
		
		return null;
	}

	private void resize() {
		LinkedList<Entry>[] temp = hashLinkedList;

		initial_capacity = initial_capacity * 3;
		hashLinkedList = new LinkedList[initial_capacity];

		for (LinkedList<Entry> ll : temp) {
			if (ll != null) {
				Iterator<Entry> i = ll.iterator();
				while (i.hasNext()) {
					Entry e = i.next();
					put(e.key, e.value, 0);
				}
			}
		}

		System.out.println("resize :: " + initial_capacity);
		System.out.println(hashLinkedList.length);
	}

}

class Entry {

	public String key;
	public String value;

	public Entry(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Entry [key=" + key + ", value=" + value + "]";
	}

}