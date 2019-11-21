package br.edu.ifsc.domain;

public class ParkingLot {

	private boolean[] leftPark = new boolean[64];
	private boolean[] rightPark = new boolean[44];

	public ParkingLot() {

	}

	public void switchUse(boolean isLeft, int slot) {
		if (isLeft)
			leftPark[slot] = !leftPark[slot];
		else
			rightPark[slot] = !rightPark[slot];
	}

	public int useSlot() {
		int slot = this.getLeftFreeSlot();
		
		if (slot != -1) {
			this.switchUse(true, slot);
			return this.getFreeSlots();
		} else {
			slot = this.getRightFreeSlot();
			if (slot != -1) {
				this.switchUse(false, slot);
				return this.getFreeSlots();
			}
			return -1;
		}

	}
	
	public int freeSlot(int slot) {
		if(rightPark[slot]) {
			this.switchUse(false, slot);
			return this.getFreeSlots();
		}
		if(leftPark[slot]) {
			this.switchUse(true, slot);
			return this.getFreeSlots();
		}
		return -1;
		
	}
	

	private int getLeftFreeSlot() {
		for (int i = 0; i < leftPark.length; i++) {
			if (leftPark[i] == false)
				return i;
		}
		return -1;
	}

	private int getRightFreeSlot() {
		for (int i = 0; i < rightPark.length; i++) {
			if (rightPark[i] == false)
				return i;
		}
		return -1;
	}
	
	
	public int getFreeSlots() {
		int count = 0;
		
		for (int i = 0; i < leftPark.length; i++) {
			if(leftPark[i])
				count++;
		}
		for (int i = 0; i < rightPark.length; i++) {
			if(rightPark[i])
				count++;
		}
		
		return count;
	}

	public boolean[] getLeftPark() {
		return leftPark;
	}

	public void setLeftPark(boolean[] leftPark) {
		this.leftPark = leftPark;
	}

	public boolean[] getRightPark() {
		return rightPark;
	}

	public void setRightPark(boolean[] rightPark) {
		this.rightPark = rightPark;
	}

}
