package jp.co.wap.exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import jp.co.wap.exam.lib.Interval;

/**
 * Solve the problem1,get the max overlap interval.
 * @author lhb
 *
 */

public class Problem1 {
	
	/**
	 * Returns the max overlap of these intervals;
	 * <pre>
	 * e.g.
	 * 	when the intervals are [08:00,12:00],[06:00,09:00],[11:00,13:30];
	 *  this method returns 2.
	 * </pre>
	 * @param intervals
	 * @return
	 */
	public int getMaxIntervalOverlapCount(List<Interval> intervals) {
		// TODO: Implement this method.
		int size = 2 * intervals.size();
		int i=0,max=0,count=0;
		String[] array = new String[size];
		
		Arrays.fill(array, ""); //initialize the array
		Iterator it = intervals.iterator();
		
		while (it.hasNext()) {
			Interval interval = (Interval) it.next();
			array[i++] = interval.getBegin()+"B";
			array[i++] = interval.getEnd()+"E";
		}
		
		Arrays.sort(array, Collections.reverseOrder());
		for (int j = 0; j < array.length; j++) {
			char ch = array[j].charAt(array[j].length()-1); //get the last character,to distinguish the time is endTime or beginTime
			if(ch=='E')
				count++;
			else 
				count--;
			max = max<count?count:max;
		}
		return max;
		
	}
}
