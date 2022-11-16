package com.ds.samples;

import java.util.HashMap;
import java.util.Map;

/*Google Question
*Given an array = [2,5,1,2,3,5,1,2,4]:
*It should return 2

*Given an array = [2,1,1,2,3,5,1,2,4]:
*It should return 1

*Given an array = [2,3,4,5]:
*It should return undefined
 */
public class FirstRecurringCharacter {

	public static void main(String[] args) {
		// int[] array = { 2, 5, 1, 2, 3, 5, 1, 2, 4 };
		// int[] array = { 2, 1, 1, 2, 3, 5, 1, 2, 4 };
		int[] array = { 2, 3, 4, 5 };
		Integer element = findFirstRecurringCharacter(array);
		System.out.println(element);
	}

	private static Integer findFirstRecurringCharacter(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}
		Map<Integer, Integer> intMap = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			Integer val = intMap.get(array[i]);
			if (val == null) {
				intMap.put(array[i], i);
			} else {
				return array[i];
			}
		}

		return null;
	}

}
