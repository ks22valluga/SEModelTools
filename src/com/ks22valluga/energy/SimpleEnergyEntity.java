package com.ks22valluga.energy;

import java.math.BigDecimal;

public abstract class SimpleEnergyEntity {
private BigDecimal energyMeterA,energyMeterB;
private BigDecimal maxPowerGen,maxPowerConsume,maxEnergyStorage;
private String friendlyNodeName,friendlyNameEMA,friendlyNameEMB;
private NodeTypeEnum nte;

public SimpleEnergyEntity(BigDecimal energyMeterA, BigDecimal energyMeterB,
		BigDecimal maxPowerGen, BigDecimal maxPowerConsume,
		BigDecimal maxEnergyStorage, String friendlyNodeName,
		String friendlyNameEMA, String friendlyNameEMB, NodeTypeEnum nte) {
	this.energyMeterA = energyMeterA;
	this.energyMeterB = energyMeterB;
	this.maxPowerGen = maxPowerGen;
	this.maxPowerConsume = maxPowerConsume;
	this.maxEnergyStorage = maxEnergyStorage;
	this.friendlyNodeName = friendlyNodeName;
	this.friendlyNameEMA = friendlyNameEMA;
	this.friendlyNameEMB = friendlyNameEMB;
	this.nte = nte;
}

//TODO: create methods that model the behaviour each node type

public abstract BigDecimal getCurrentPowerConsumption();
public abstract BigDecimal getCurrentPowerGeneration();

	
}
