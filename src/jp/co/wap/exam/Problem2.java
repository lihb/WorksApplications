package jp.co.wap.exam;

import java.util.Arrays;
import java.util.List;

import jp.co.wap.exam.lib.Interval;

/**
 * Solve the problem1,get the maximum work time to assign to one worker.
 * @author lhb
 *
 */
public class Problem2 {
	
	/**
	 * Returns the maximum work time (minutes) to assign to one worker.
	 * <pre>
	 * e.g.
	 * 	when the intervals are ["06:00", "08:30"],["09:00", "11:00"], ["12:30", "14:00"],
	 *  ["08:00", "9:00"], ["09:00", "11:30"],["10:30", "14:00"];
	 *  work time is maximized when the three tasks are ["06:00", "08:30"], ["09:00", "11:30"], and ["12:30", "14:00"]
	 *  this method returns the sum of the three task's interval minute, this example is 390.
	 * </pre>
	 * @param intervals
	 * @return
	 */
	public int getMaxWorkingTime(List<Interval> intervals) {
		// TODO: Implement this method.
		int size = intervals.size();
		Interval[] array = intervals.toArray(new Interval[0]);
		
		//sort the array by the beginTime
		for (int i = 0; i < array.length-1; i++) {
			for (int j = i+1; j < array.length; j++) {
				if ((array[i].getBegin().compareTo(array[j].getBegin()) > 0)) {
					Interval temp = array[i];
					array[i] = array[j];
					array[j] =temp;
				}
			}
		}
		int[] time = new int[size];
		time[0] = array[0].getIntervalMinute();
		int max = time[0];
		for (int i = 0; i < array.length-1; i++) {
			if ((array[i + 1].getBegin().compareTo(array[i].getEnd()) < 0)) {			
				int j = i;
				while (j >= 0) {
					if ((array[j].getEnd().compareTo(array[i + 1].getBegin()) < 0)) {
						time[i + 1] = time[j]+ array[i + 1].getIntervalMinute();								
						break;
					}
					j--;
				}
				if(j<0){
					if (array[i+1].getIntervalMinute() < array[i].getIntervalMinute()) {
						time[i + 1] =time[i]; 
					}else {
						time[i + 1] =array[i+1].getIntervalMinute(); 
					}
				}
			} else {
				time[i+1] = time[i] + array[i+1].getIntervalMinute();
			}
			max = (max < time[i+1])?time[i+1]:max;
		}
		return  max;
	}
}
