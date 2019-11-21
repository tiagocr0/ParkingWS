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

	public boolean isNormalSlotAvailable() {
		for (int i = 0; i < leftPark.length; i++) {
			if (isSpecialSlot(true, i) && leftPark[i]) {
				return true;
			}
		}
		for (int i = 0; i < rightPark.length; i++) {
			if (isSpecialSlot(false, i) && leftPark[i]) {
				return true;
			}
		}

		return false;
	}

	public boolean isAnySlotAvailable() {
		for (boolean slot : leftPark) {
			if (slot)
				return true;
		}
		for (boolean slot : rightPark) {
			if (slot)
				return true;
		}
		return false;
	}

	private boolean isSpecialSlot(boolean isLeft, int slot) {
		if (isLeft) {
			if (slot == 3 || slot == 4)
				return true;
		} else {
			if (slot == 26 || slot == 27)
				return true;
		}
		return false;
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
