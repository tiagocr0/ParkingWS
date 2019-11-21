package br.edu.ifsc.service;

import org.springframework.stereotype.Service;

import br.edu.ifsc.domain.ParkingLot;

@Service
public class ParkingService  {
	ParkingLot pl = new ParkingLot();
	
	public boolean isNormalSlotAvaliable() {
		return pl.isNormalSlotAvailable();
	}
	
	public boolean isSpecialSlotAvaliable() {
		return pl.isAnySlotAvailable();
	}
	
//	public int occupySlot(int slot) {
//	}

}
