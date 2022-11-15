package com.ds.samples;

public class ReverseString {

	public static void main(String[] args) {
		String str = "";
		System.out.println("TO BE REVERSED :: " + str);
		String reverseStr = reverseTheString(str);
		System.out.println("Reversed :: " + reverseStr);
	}

	private static String reverseTheString(String str) {
		if (str == null || str.length() <= 1 || str.trim().length() == 0) {
			return str;
		}
		char[] strSeq = str.toCharArray();
		char[] revSeq = new char[strSeq.length];
		for (int i = strSeq.length - 1, j = 0; i >= 0; i--, j++) {
			revSeq[j] = strSeq[i];
		}
		
		return new String(revSeq);
	}

}
