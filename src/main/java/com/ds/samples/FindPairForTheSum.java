package com.ds.samples;

import java.util.HashSet;
import java.util.Set;

public class FindPairForTheSum {

	public static void main(String[] args) {
		int[] pairArray = { 2, 5, 6, 4, 3 };
		boolean isAvailable = hasPairForTheSum(pairArray, 12);
		System.out.println(isAvailable);

		System.out.println(hasPairForTheSum2(pairArray, 5));
	}

	// brute force O(n^2)
	private static boolean hasPairForTheSum(int[] pairArray, int sum) {
		// loop the array and try to pair each element for sum
		for (int i = 0; i < pairArray.length - 1; i++) {
			for (int j = i + 1; j < pairArray.length; j++) {
				if (pairArray[i] + pairArray[j] == sum) {
					return true;
				}
			}
		}

		return false;
	}

	// better approach O(n)
	private static boolean hasPairForTheSum2(int[] pairArray, int sum) {

		Set<Integer> comp = new HashSet<Integer>();

		for (int i = 0; i < pairArray.length; i++) {
			if (comp.contains(pairArray[i])) {
				return true;
			} else {
				comp.add(sum - pairArray[i]);
			}
		}

		return false;
	}

}
