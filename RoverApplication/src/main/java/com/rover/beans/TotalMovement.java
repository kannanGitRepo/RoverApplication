package com.rover.beans;

public class TotalMovement {

	private int totalMovement;
	private boolean destroyed;
	

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

	public int getTotalMovement() {
		return totalMovement;
	}

	public void setTotalMovement(int totalMovement) {
		this.totalMovement = totalMovement;
	}

	@Override
	public String toString() {
		return "TotalMovement [totalMovement=" + totalMovement + ", destroyed=" + destroyed + "]";
	}
	
	
	
}
