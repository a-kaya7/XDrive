package net.drive.controller.administration.allgemein;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.drive.dto.administration.InstitutListenDTO;
import net.drive.services.administration.allgemein.aussensicht.IAdmininstitutanzeigenService;


@RestController
@RequestMapping("/api")
public class AdmininstitutanzeigenController {

	private final IAdmininstitutanzeigenService service;
	 public AdmininstitutanzeigenController(IAdmininstitutanzeigenService service) {
	        this.service = service;
	    }
	
	@GetMapping("/institutanzeigen")
	public ResponseEntity<List<InstitutListenDTO>> getAllInstitut(){
		return ResponseEntity.ok(service.getAllInstitut());
	}
}
