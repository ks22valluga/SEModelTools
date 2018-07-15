package com.ks22valluga.energy;

import java.math.BigDecimal;

public class SolarPanel extends SimpleEnergyEntity{

	public SolarPanel(BigDecimal energyMeterA, BigDecimal energyMeterB,
			BigDecimal maxPowerGen, BigDecimal maxPowerConsume,
			BigDecimal maxEnergyStorage, String friendlyNodeName,
			String friendlyNameEMA, String friendlyNameEMB, NodeTypeEnum nte) {
		super(energyMeterA, energyMeterB, maxPowerGen, maxPowerConsume,
				maxEnergyStorage, friendlyNodeName, friendlyNameEMA, friendlyNameEMB,
				nte);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BigDecimal getCurrentPowerConsumption() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
