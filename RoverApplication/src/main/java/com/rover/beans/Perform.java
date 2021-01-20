package com.rover.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Perform {

	private ItemBucket collectSample;
	private ItemBucket itemUsage;
	public ItemBucket getCollectSample() {
		return collectSample;
	}
	@JsonProperty("collect-sample")
	public void setCollectSample(ItemBucket collectSample) {
		this.collectSample = collectSample;
	}
	public ItemBucket getItemUsage() {
		return itemUsage;
	}
	@JsonProperty("item-usage")
	public void setItemUsage(ItemBucket itemUsage) {
		this.itemUsage = itemUsage;
	}
	
	

}
