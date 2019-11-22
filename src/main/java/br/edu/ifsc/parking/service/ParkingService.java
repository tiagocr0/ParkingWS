package br.edu.ifsc.parking.service;

import java.util.List;

import br.edu.ifsc.parking.domain.ParkingLot;
import br.edu.ifsc.parking.domain.Vagas;

public class ParkingService  {
	ParkingLot pl = new ParkingLot();
	
	public int occupySlot() {
		return pl.useSlot();
	}
	
	public boolean freeSlot(int slot) {
		return pl.freeSlot(slot);
	}
	
	public List<Vagas> getSlots(){
		return this.pl.getFreeSlots();
	}

}
