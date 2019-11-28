package br.edu.ifsc.parking.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DashboardParking {
	
	@JsonProperty(value="TotalVagas")
	int totalParkingSpaces;
	
	@JsonProperty(value="VagasDisponiveis")
	int freeParkingSpace;

	public int getTotalParkingSpaces() {
		return totalParkingSpaces;
	}

	public void setTotalParkingSpaces(int totalParkingSpaces) {
		this.totalParkingSpaces = totalParkingSpaces;
	}

	public int getFreeParkingSpace() {
		return freeParkingSpace;
	}

	public void setFreeParkingSpace(int freeParkingSpace) {
		this.freeParkingSpace = freeParkingSpace;
	}
	
}
