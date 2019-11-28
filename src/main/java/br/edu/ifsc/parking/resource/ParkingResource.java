package br.edu.ifsc.parking.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsc.parking.domain.DashboardParking;
import br.edu.ifsc.parking.domain.Vagas;
import br.edu.ifsc.parking.service.ParkingService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/parking")
public class ParkingResource {

	private ParkingService parkingService = new ParkingService();

	@RequestMapping(value = "/slots", method = RequestMethod.GET)
	public ResponseEntity<List<Vagas>> listAvailableSlots() {
		List<Vagas> vagas = new ArrayList<Vagas>();
		vagas = parkingService.getSlots();
		return new ResponseEntity<List<Vagas>>(vagas, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/occupy", method = RequestMethod.GET)
	public ResponseEntity<Integer> occupySlot(){
		int slot = parkingService.occupySlot();
		if(slot > 0)
			return new ResponseEntity<>(slot, HttpStatus.OK);
		return new ResponseEntity<Integer>(slot, HttpStatus.UNAUTHORIZED);
	}
	
	@RequestMapping(value = "/freeSlot/{slot}", method = RequestMethod.POST)
	public ResponseEntity<Boolean> freeSlot(@PathVariable int slot){
		boolean result = parkingService.freeSlot(slot);
		
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ResponseEntity<DashboardParking> dashboard(){
		int qtd = parkingService.freeSlot();
		int qtdTotal = parkingService.getSlots().size();
		DashboardParking dashboardParking = new DashboardParking();
		dashboardParking.setFreeParkingSpace(qtd);
		dashboardParking.setTotalParkingSpaces(qtdTotal);
		return new ResponseEntity<DashboardParking>(dashboardParking, HttpStatus.OK);
	}
	
}