package com.ks22valluga.energy;

import java.util.GregorianCalendar;

public class WeeklyTimeSlot {
	private GregorianCalendar start;
	private GregorianCalendar end;

	public WeeklyTimeSlot(GregorianCalendar start, GregorianCalendar end) {
		// check input
		int startIndex = getIndex(start);
		int endIndex = getIndex(end);

		if (startIndex >= endIndex) {
			throw new IllegalArgumentException(
					"start index has to be less than end, "
					+ "remember that year,month, day of month is not used to calculate index,"
					+ " check day of week , hour , minute!");
		}
	}

	public int getIndex(GregorianCalendar time) {
		int dayOfWeek = time.get(GregorianCalendar.DAY_OF_WEEK);
		int hourOfDay = time.get(GregorianCalendar.HOUR_OF_DAY);
		int minuteOfHour = time.get(GregorianCalendar.MINUTE);
		return (minuteOfHour) + (60 * hourOfDay) + (24 * 60 * dayOfWeek);
	}
	
	public GregorianCalendar setIndex(int dayOfWeek,int hourOfDay,int minuteOfHour){
		GregorianCalendar indexCal = new GregorianCalendar(1970, 0, 1, hourOfDay, minuteOfHour, 0);
		boolean isValid=false;
		do{
			int currentDayOfWeek=indexCal.get(GregorianCalendar.DAY_OF_WEEK);
			if(currentDayOfWeek==dayOfWeek){
				isValid=true;
			}else{
				indexCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
			}
		}while(isValid);
		
		
		return indexCal;
	
	}
	
	
}
