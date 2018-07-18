package com.ks22valluga.energy;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

public class OnOffEnergySchedule extends AbstractEnergyProfile  {
    // basic non varying value
	private boolean[] weeklyShedule;
	private BigDecimal powerKWh;
	//starts Sunday 0hr 0min [0] end Mon pm 23hrs 59mins [(7*24*60)-1]

	
	
	public OnOffEnergySchedule(BigDecimal powerKWh){
	    this.powerKWh = powerKWh;
	    weeklyShedule=new boolean[7*24*60];
	    for(int i=0;i<weeklyShedule.length;i++){
		weeklyShedule[i]=false;
	    }
	
		  
	}
	
	public void setOnPeriods(GregorianCalendar start, GregorianCalendar end){
		//Start - end  must be start > Mon , End > start, end < 
	      WeeklyTimeSlot  wts= new WeeklyTimeSlot(start, end);
	      int startIndex=wts.getStartIndex();
	      int endIndex=wts.getEndIndex();
	      for(;startIndex<endIndex+1;startIndex++){
		 weeklyShedule[startIndex]=true;
	      }
	        
	}
	
	public void setOnPeriods(int dowStart,int hodStart,int mohStart,int dowEnd,int hodEnd,int mohEnd){
	    WeeklyTimeSlot  wts=new WeeklyTimeSlot(dowStart, hodStart, mohStart, dowEnd, hodEnd, mohEnd); 
	}

	@Override
	public BigDecimal getEnergyValue(int index) {
	
		if(weeklyShedule[index]){
		    return powerKWh.divide(new BigDecimal(60));//energy accumulates in a minute
		}
		return new BigDecimal(0);
	}

}
