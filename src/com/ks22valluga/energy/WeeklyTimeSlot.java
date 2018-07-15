package com.ks22valluga.energy;

import java.util.GregorianCalendar;

public class WeeklyTimeSlot {
	private int startIndex;
	private int endIndex;


	public WeeklyTimeSlot(GregorianCalendar start, GregorianCalendar end) {
		// check input
		this.startIndex = getIndex(start);
		this.endIndex = getIndex(end);
		validateEntries();

	}
	
	public WeeklyTimeSlot(int dayOfWeekStart,int hrOfDayStart,int minOfHrStart,int dayOfWeekEnd,int hrOfDayEnd,int minOfHrEnd){
		this.startIndex = calculateIndex(dayOfWeekStart, hrOfDayStart, minOfHrStart);
		this.endIndex = calculateIndex(dayOfWeekEnd, hrOfDayEnd, minOfHrEnd);
		validateEntries();
	}

	public int getIndex(GregorianCalendar time) {
		int dayOfWeek = time.get(GregorianCalendar.DAY_OF_WEEK)-1;
		int hourOfDay = time.get(GregorianCalendar.HOUR_OF_DAY);
		int minuteOfHour = time.get(GregorianCalendar.MINUTE);
		return calculateIndex(dayOfWeek,hourOfDay,minuteOfHour);
	}
	
	private int calculateIndex(int dayOfWeek,int hourOfDay, int minuteOfHour){
		return (minuteOfHour) + (60 * hourOfDay) + (24 * 60 * dayOfWeek);
	}
	
	private void validateEntries(){
		if (startIndex >= endIndex) {
			throw new IllegalArgumentException(
					"start index has to be less than end, "
					+ "remember that year,month, day of month is not used to calculate index,"
					+ " check day of week , hour , minute!");
		}
	}
	
	public static GregorianCalendar setIndex(int dayOfWeek,int hourOfDay,int minuteOfHour){
		//assume 0-6 for array indexing
		dayOfWeek++;
		GregorianCalendar indexCal = new GregorianCalendar(1970, 0, 1, hourOfDay, minuteOfHour, 0);
		boolean isValid=false;
		do{
			int currentDayOfWeek=indexCal.get(GregorianCalendar.DAY_OF_WEEK);
			if(currentDayOfWeek==dayOfWeek){
				isValid=true;
			}else{
				indexCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
			}
		}while(!isValid);
		
		
		return indexCal;
	
	}
	
	public int getStartIndex() {
		return startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

}
