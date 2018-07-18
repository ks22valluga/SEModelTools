package com.ks22valluga.energy;

import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class SimpleEnergyEntity {
    private BigDecimal energyMeterA, energyMeterB;
    private BigDecimal maxPowerGen, maxPowerConsume, maxEnergyStorage;
    private String friendlyNodeName, friendlyNameEMA, friendlyNameEMB;
    private NodeTypeEnum nte;
    private ArrayList<SimpleEnergyEntity> directChildren;
    private ArrayList<SimpleEnergyEntity> meters;
    private ArrayList<SimpleEnergyEntity> meterUpstreamNodes;
    private ArrayList<SimpleEnergyEntity> meterDownStreamNodes;
    private ArrayList<SimpleEnergyEntity> allNodes;
    private SimpleEnergyEntity parentNode;
    private boolean iAmRootNode = false;

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
	this.parentNode = null;
	this.meters = new ArrayList<>();
	this.meterDownStreamNodes = new ArrayList<>();
	this.meterUpstreamNodes = new ArrayList<>();
	this.allNodes = new ArrayList<>();
    }

    public void attachToParent(SimpleEnergyEntity see) {
	this.parentNode = see;
	see.addChildNode(this);

    }

    private void addChildNode(SimpleEnergyEntity see) {
	this.directChildren.add(see);
    }

    public void setAsRootNode() {
	iAmRootNode = true;
    }

    public abstract BigDecimal getCurrentPowerConsumption();
    // NB generation is negative consumption

    public void learnNetwork() {
	if (iAmRootNode) {
	    // TODO:
	    // traverse tree structure of nodes, build lists of all nodes (global), and
	    // groups of nodes based between meters (specific to meter nodes)
	}

    }
    
    public void readNetwork(){
	//assumes 1 minute from previous cycle
	if (iAmRootNode) {
	    // TODO:
	    // use all nodes to work out overall gen/consumption
	    // use meter group nodes to work out energy flow through meter registers
	}
    }

    public BigDecimal getEnergyMeterA() {
        return energyMeterA;
    }

    public BigDecimal getEnergyMeterB() {
        return energyMeterB;
    }

    public BigDecimal getMaxPowerGen() {
        return maxPowerGen;
    }

    public BigDecimal getMaxPowerConsume() {
        return maxPowerConsume;
    }

    public BigDecimal getMaxEnergyStorage() {
        return maxEnergyStorage;
    }

    public String getFriendlyNodeName() {
        return friendlyNodeName;
    }

    public String getFriendlyNameEMA() {
        return friendlyNameEMA;
    }

    public String getFriendlyNameEMB() {
        return friendlyNameEMB;
    }

    public NodeTypeEnum getNte() {
        return nte;
    }

    public ArrayList<SimpleEnergyEntity> getDirectChildren() {
        return directChildren;
    }

    public ArrayList<SimpleEnergyEntity> getMeters() {
        return meters;
    }

    public ArrayList<SimpleEnergyEntity> getMeterUpstreamNodes() {
        return meterUpstreamNodes;
    }

    public ArrayList<SimpleEnergyEntity> getMeterDownStreamNodes() {
        return meterDownStreamNodes;
    }

    public ArrayList<SimpleEnergyEntity> getAllNodes() {
        return allNodes;
    }

    public SimpleEnergyEntity getParentNode() {
        return parentNode;
    }

    public boolean isiAmRootNode() {
        return iAmRootNode;
    }

}
