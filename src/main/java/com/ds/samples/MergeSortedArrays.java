package com.ds.samples;

public class MergeSortedArrays {

	public static void main(String[] args) {

		int[] a = { 3, 5, 6, 9, 10 };
		int[] b = { 1, 2, 4, 6, 8, 11 };
		int[] combined = merge(a, b);
		System.out.println(printArr(combined));
	}

	private static int[] merge(int[] a, int[] b) {
		if (a == null || b == null) {
			return null;
		}

		if (a.length == 0 && b.length == 0) {
			return a;
		}

		if (a.length == 0) {
			return b;
		}

		if (b.length == 0) {
			return a;
		}

		int TotalLength = a.length + b.length;
		int[] mergedArr = new int[TotalLength];
		int mArrIndex = 0;
		int firstIndex = 0;
		int seconIndex = 0;

		while (mArrIndex < TotalLength) {

			if (a[firstIndex] < b[seconIndex]) {
				mergedArr[mArrIndex++] = a[firstIndex++];
			} else {
				mergedArr[mArrIndex++] = b[seconIndex++];
			}

			if (b.length == seconIndex && firstIndex < a.length) {
				while (firstIndex < a.length) {
					mergedArr[mArrIndex++] = a[firstIndex++];
				}

			}
			if (a.length == firstIndex && seconIndex < b.length) {
				while (seconIndex < b.length) {
					mergedArr[mArrIndex++] = b[seconIndex++];
				}
			}
		}

		return mergedArr;
	}

	private static String printArr(int[] printArray) {
		StringBuilder builder = new StringBuilder();
		int i = 0;
		while (i < printArray.length) {
			builder.append(printArray[i++]);
			builder.append(" ");
		}

		return builder.toString();
	}

}
