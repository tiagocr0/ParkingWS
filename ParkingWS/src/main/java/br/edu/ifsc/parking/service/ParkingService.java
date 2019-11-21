package br.edu.ifsc.parking.service;

import br.edu.ifsc.parking.domain.ParkingLot;

public class ParkingService  {
	ParkingLot pl = new ParkingLot();
	
	public boolean isSlotAvailable() {
		 if(pl.getFreeSlots() > 0) 
			 return true;
		 
		 return false;
	}

	
	public int occupySlot() {
		return pl.useSlot();
	}
	
	public int freeSlot(int slot) {
		return pl.freeSlot(slot);
	}

}
