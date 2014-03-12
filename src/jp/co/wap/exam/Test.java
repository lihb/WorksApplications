package jp.co.wap.exam;

import java.util.Arrays;
import java.util.List;

import jp.co.wap.exam.lib.Interval;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval interval1 = new Interval("08:00", "12:00");
		Interval interval2 = new Interval("06:00", "09:00");
		Interval interval3 = new Interval("11:00", "13:30");
		List<Interval> figure1 = Arrays.asList(interval1, interval2, interval3);
		List<Interval> figure2 = Arrays.asList(new Interval("09:00", "12:30"),
				new Interval("06:00", "09:30"), new Interval("12:00", "14:30"),
				new Interval("10:00", "10:30"), new Interval("11:00", "13:30"));
		List<Interval> figure3 = Arrays.asList(new Interval("06:00", "08:30"),
				new Interval("09:00", "11:00"), new Interval("12:30", "14:00"),
				new Interval("08:00", "9:00"), new Interval("09:00", "11:30"),new Interval("10:30", "16:00"));

		Problem1 problem1 = new Problem1();
		Problem2 problem2 = new Problem2();
		System.out.println("Overlap:");
		System.out.println(problem1.getMaxIntervalOverlapCount(figure1));
		System.out.println(problem1.getMaxIntervalOverlapCount(figure2));
		System.out.println(problem1.getMaxIntervalOverlapCount(figure3));
		System.out.println("maxTime:");
		System.out.println(problem2.getMaxWorkingTime(figure1));
		System.out.println(problem2.getMaxWorkingTime(figure2));
		System.out.println(problem2.getMaxWorkingTime(figure3));
		
		
		
	}

}
