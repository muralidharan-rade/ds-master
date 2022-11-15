package com.ds.samples;

/* Meeting rooms Problem 
 * Given two arrays of start_time and end_time of mandatory meetings for a given day
 * Also the number of available meeting rooms are given
 * 
 * Find the minimum number of meeting rooms needed for conducting the given the meetings..
 * 
 * sample input:
 * start_time: [9:00, 9:30, 9:40, 10:00, 15:00, 17:00]
 * end_time: [9:10, 10:00, 10:30, 11:00, 18:00, 21:00]
 * no. of meeting rooms: 10
 * 
 */
public class MeetingRooms1 {

	public static void main(String[] args) {

		int[] start_time = { 900, 930, 940, 955, 1500, 1700 };
		int[] end_time = { 910, 1000, 1130, 1100, 1800, 2100 };
		int totalMeetingRooms = 10;
		int minMeetingRoomsNeeded = findMinimumNumberOfMeetingRooms(start_time, end_time, totalMeetingRooms);
		System.out.println("minimum Meeting rooms needed :: " + minMeetingRoomsNeeded);
		System.out.println(
				"Rooms completely available for day long events :: " + (totalMeetingRooms - minMeetingRoomsNeeded));
	}

	private static int findMinimumNumberOfMeetingRooms(int[] start_time, int[] end_time, int totalMeetingRooms) {
		if (start_time.length < 1 || end_time.length < 1 || start_time.length != end_time.length) {
			return 0;
		}

		int meetingRoomCount = 0;
		int currentCount = 0;
		int start = 0;
		int end = 0;

		while (start < start_time.length) {
			if (start_time[start] < end_time[end]) {
				start++;
				currentCount++;
			} else {
				end++;
				currentCount--;
			}
			meetingRoomCount = Math.max(meetingRoomCount, currentCount);
		}

		return meetingRoomCount;
	}

}
