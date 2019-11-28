package br.edu.ifsc.parking.domain;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

	private Vagas[] parking = new Vagas[108];

	public ParkingLot() {
		for (int i = 0; i < parking.length; i++) {
			parking[i] = new Vagas(i, false);
		}
	}

	public void switchUse(int slot) {
			parking[slot].setSituacao(!parking[slot].getSituacao());
	}

	public int useSlot() {
		int slot = this.getFreeSlot();
		
		if (slot != -1) {
			this.switchUse(slot);
			return 0;
		}
		return -1;

	}
	
	public boolean freeSlot(int slot) {
		if(parking[slot].getSituacao()) {
			this.switchUse(slot);
			return true;
		}
		return false;
		
	}
	
	public int freeSlot() {
		int total = 0;
		for(Vagas vagas : parking)
			if(vagas.getSituacao()) {
				total += 1;
			}
		return total;
	}
	
	private int getFreeSlot() {
		for (int i = 0; i < parking.length; i++) {
			if (!parking[i].getSituacao())
				return i;
		}
		return -1;
	}
		
	public List<Vagas> getFreeSlots() {
		List<Vagas> vagas = new ArrayList<>();
		
		for (int i = 0; i < parking.length; i++) {
			if(!parking[i].getSituacao())
				vagas.add(parking[i]);
		}		
		return vagas;
	}

	public Vagas[] getLeftPark() {
		return parking;
	}

	public void setLeftPark(Vagas[] leftPark) {
		this.parking = leftPark;
	}

}
