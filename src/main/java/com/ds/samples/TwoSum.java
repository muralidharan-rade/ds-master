package com.ds.samples;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because
 * nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Input: nums = [3,2,4], target = 6 Output: [1,2]
 **/

public class TwoSum {

	public static void main(String[] args) {
		// int[] arr = { 2, 7, 11, 15 };
		// int sum = 9;
		int[] arr = { 3, 2, 5, 8, 9, 4 };
		int sum = 6;
		int[] result = findTheSumPair(arr, sum);
		System.out.println("Result :: " + printArr(result));
	}

	// time complexity is O(n)
	private static int[] findTheSumPair(int[] arr, int sum) {
		if (arr == null || arr.length == 0 || sum <= 0) {
			return null;
		}
		int[] resultSet = new int[2];
		Map<Integer, Integer> complimentMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (complimentMap.keySet().contains(arr[i])) {
				resultSet[0] = complimentMap.get(arr[i]);
				resultSet[1] = i;
				break;
			} else {
				complimentMap.put(sum - arr[i], i);
			}
		}
		return resultSet;
	}

	private static String printArr(int[] printArray) {
		if (printArray == null || printArray.length == 0) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		int i = 0;
		while (i < printArray.length) {
			builder.append(printArray[i++]);
			builder.append(" ");
		}

		return builder.toString();
	}

}
