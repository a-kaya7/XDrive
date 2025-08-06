package net.drive.controller.administration.allgemein;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.drive.dto.administration.MandantenDTO;
import net.drive.services.administration.allgemein.aussensicht.IAdminmandantneuanlageService;

@RestController
@RequestMapping("/api")
public class AdminmandantneuanlageController {


	private final IAdminmandantneuanlageService  mandantNeuanlage;
	

	public AdminmandantneuanlageController(IAdminmandantneuanlageService  mandantNeuanlage) {
		this.mandantNeuanlage = mandantNeuanlage;
	}
	
	@PostMapping("/mandantenneuanlage")
	public ResponseEntity<MandantenDTO> mandantenAnlegen(@RequestBody MandantenDTO mandant){
		
		  MandantenDTO saved = mandantNeuanlage.createMandant(mandant);
	      return ResponseEntity.ok(saved);
		
	}
	

}
