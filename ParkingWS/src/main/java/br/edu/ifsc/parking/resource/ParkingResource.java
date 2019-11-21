package br.edu.ifsc.parking.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsc.parking.domain.Vagas;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/parking")
public class ParkingResource {

//	private ParkingService parkingService = new ParkingService();

	@RequestMapping(value = "/vagas", method = RequestMethod.GET)
	public ResponseEntity<List<Vagas>> vagas() {
		List<Vagas> vagas = new ArrayList<Vagas>();
		
		Vagas vaga = new Vagas();
		vaga.setNumero(1);
		vaga.setSituacao(true);
		
		Vagas vaga2 = new Vagas();
		vaga2.setNumero(2);
		vaga2.setSituacao(false);
		
		Vagas vaga3 = new Vagas();
		vaga3.setNumero(3);
		vaga3.setSituacao(true);
		
		Vagas vaga4 = new Vagas();
		vaga4.setNumero(4);
		vaga4.setSituacao(false);
		
		vagas.add(vaga);
		vagas.add(vaga2);
		vagas.add(vaga3);
		vagas.add(vaga4);
		
		return new ResponseEntity<List<Vagas>>(vagas, HttpStatus.OK);
	}
}