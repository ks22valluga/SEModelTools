package com.ks22valluga.energy.test;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.Test;

import com.ks22valluga.energy.WeeklyTimeSlot;

public class TestWeeklyTimeSlot {

	@Test
	public void test() {
		int dayOfWeekStart = 0;
		int hrOfDayStart = 1;
		int minOfHrStart = 0;
		
		int dayOfWeekEnd = 6;
		int hrOfDayEnd = 23;
		int minOfHrEnd = 59;
		
		GregorianCalendar start = WeeklyTimeSlot.setIndex(dayOfWeekStart, hrOfDayStart, minOfHrStart);
		GregorianCalendar end = WeeklyTimeSlot.setIndex(dayOfWeekEnd, hrOfDayEnd, minOfHrEnd);
		WeeklyTimeSlot wt = new WeeklyTimeSlot(start, end);
		int startIndex =wt.getStartIndex();
		int endIndex=wt.getEndIndex();
		
		
		
		start.add(GregorianCalendar.HOUR_OF_DAY, 1);
	}

}
