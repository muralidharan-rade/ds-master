package com.ds.samples;

import java.util.HashSet;
import java.util.Set;

public class CompareTwoArraysAndFindElement {

	public static void main(String[] args) {

		String[] arr1 = { "a", "b", "b", "d", "e" };
		String[] arr2 = { "v", "w", "x", "y", "a" };

		boolean isPresent = compareAndFind(arr1, arr2);
		System.out.println(isPresent);
	}

	/*
	 * brute force - iterate two arrays by nesting and compare O(n^2) instead
	 * populate arr1 into a set (where lookup is constant time) and then compare
	 * with arr2. complexity is O(a+b) or O(n)
	 */

	private static boolean compareAndFind(String[] arr1, String[] arr2) {
		Set<String> arrSet = new HashSet<String>();

		for (String s : arr1) {
			arrSet.add(s);
		}

		for (String s : arr2) {
			if (arrSet.contains(s)) {
				return true;
			}
		}

		return false;
	}

}
