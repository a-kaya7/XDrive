package net.drive.controller.administration.allgemein;

import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.drive.dto.administration.AdmininstitutDTO;
import net.drive.services.administration.allgemein.aussensicht.IAdmininstitutneuanlageService;

@RestController
@RequestMapping("/api")
public class AdmininstitutneuanlageController {

	private final IAdmininstitutneuanlageService adminInsitutneuanlageService;
	
	public AdmininstitutneuanlageController(IAdmininstitutneuanlageService adminInsitutneuanlageService) {
		this.adminInsitutneuanlageService = adminInsitutneuanlageService;
	}
	
	
	@PostMapping("/institute")
	 public ResponseEntity<AdmininstitutDTO> adminInstitutneuAnlage(@RequestBody AdmininstitutDTO adminInsitutneuanlage){
		
		return ResponseEntity.ok(adminInsitutneuanlageService.createIntitut(adminInsitutneuanlage));
	}
}
