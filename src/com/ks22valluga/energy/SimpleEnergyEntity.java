package com.ks22valluga.energy;

import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class SimpleEnergyEntity {
private BigDecimal energyMeterA,energyMeterB;
private BigDecimal maxPowerGen,maxPowerConsume,maxEnergyStorage;
private String friendlyNodeName,friendlyNameEMA,friendlyNameEMB;
private NodeTypeEnum nte;
private ArrayList<SimpleEnergyEntity> directChildren;
private ArrayList<SimpleEnergyEntity> meters;
private ArrayList<SimpleEnergyEntity> meterUpstreamNodes;
private ArrayList<SimpleEnergyEntity> meterDownStreamNodes;
private SimpleEnergyEntity parentNode;

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
	this.directChildren = new ArrayList<>();
	this.parentNode=null;
	this.meters=new ArrayList<>();
	this.meterDownStreamNodes = new ArrayList<>();
	this.meterUpstreamNodes = new  ArrayList<>();
}


public void attachToParent(SimpleEnergyEntity see){
	this.parentNode=see;
	see.addChildNode(this);
	
}
private void addChildNode(SimpleEnergyEntity see) {
	this.directChildren.add(see);
}


//TODO: create methods that model the behaviour each node type

public abstract BigDecimal getCurrentPowerConsumption();
//NB generation is negative consumption

	
}
