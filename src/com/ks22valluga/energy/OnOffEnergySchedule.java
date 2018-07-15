package com.ks22valluga.energy;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

public class OnOffEnergySchedule extends AbstractEnergyProfile  {
	private boolean[] weeklyShedule=new boolean[7*24*60];
	//starts Monday 0hr 0min [0] end Sun pm 23hrs 59mins [(7*24*60)-1]
	
	public void setOnPeriods(GregorianCalendar start, GregorianCalendar end){
		//Start - end  must be start > Mon , End > start, end <  
	}

	@Override
	public BigDecimal getEnergyValue(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
