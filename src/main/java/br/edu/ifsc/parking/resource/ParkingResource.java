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
    @CrossOrigin
    @RequestMapping(value = "/slots", method = RequestMethod.GET)
    public ResponseEntity<List<Vagas>> listAvailableSlots() {
        List<Vagas> vagas;
        vagas = parkingService.getSlots();
        return new ResponseEntity<>(vagas, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/allSlots", method = RequestMethod.GET)
    public ResponseEntity<Vagas[]> listAllSlots() {
        Vagas[] vagas;
        vagas = parkingService.getAllSlots();
        return new ResponseEntity<>(vagas, HttpStatus.OK);
    }


    @CrossOrigin
    @RequestMapping(value = "/occupy", method = RequestMethod.GET)
    public ResponseEntity<Integer> occupySlot() {
        int slot = parkingService.occupySlot();
        if (slot > 0)
            return new ResponseEntity<>(slot, HttpStatus.OK);
        return new ResponseEntity<>(slot, HttpStatus.UNAUTHORIZED);
    }

    @CrossOrigin
    @RequestMapping(value = "/occupySlot/{slot}", method = RequestMethod.POST)
    public ResponseEntity<Boolean> occupySlot(@PathVariable int slot) {
        boolean result = parkingService.occupySlot(slot);
        if(result)
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(result,HttpStatus.SERVICE_UNAVAILABLE);
    }
    @CrossOrigin
    @RequestMapping(value = "/freeSlot/{slot}", method = RequestMethod.POST)
    public ResponseEntity<Boolean> freeSlot(@PathVariable int slot) {
        boolean result = parkingService.freeSlot(slot);
        if(result)
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(result,HttpStatus.SERVICE_UNAVAILABLE);
    }




    @CrossOrigin
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ResponseEntity<DashboardParking> dashboard() {
        int qtd = parkingService.freeSlots();
        int qtdTotal = parkingService.getSlots().size();
        DashboardParking dashboardParking = new DashboardParking();
        dashboardParking.setFreeParkingSpace(qtd);
        dashboardParking.setTotalParkingSpaces(qtdTotal);
        return new ResponseEntity<>(dashboardParking, HttpStatus.OK);
    }

}