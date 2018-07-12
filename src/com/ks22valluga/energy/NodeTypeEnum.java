package com.ks22valluga.energy;

public enum NodeTypeEnum {

	energy_section(
			"This node type acts as a mechamism to group other nodes."
					+ " For simple modelling, the  section can neither consume or generate."
					+ " Not strictly true, elec cable section consumes a little energy as heat, but can be ignored for simple modelling.")
			, consumer("Node that consumes energy, e.g. fridge, lights,heater")
			, source("Node that generates energy, Solar panels, wind generator, import from grid. ")
			, storage("Node that consumes, generates or does neither depending on its state.")
			, meter("Node that should bridge cable sections it has a register for each direction of energy flow");

	private String desc;

	private NodeTypeEnum(String desc) {
		this.desc = desc;
	}

	public String getDescription() {
		return desc;
	}

}
