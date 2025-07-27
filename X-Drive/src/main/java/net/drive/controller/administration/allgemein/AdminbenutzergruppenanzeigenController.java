package net.drive.controller.administration.allgemein;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.drive.dto.administration.AdminbenutzergruppeDTO;
import net.drive.entities.administration.allgemein.Adminbenutzergruppeneuanlage;
import net.drive.services.administration.allgemein.aussensicht.IAdminbenutzergruppenanzeigenService;

@RestController
@RequestMapping("/api")
public class AdminbenutzergruppenanzeigenController {
	
	private final IAdminbenutzergruppenanzeigenService benutzergruppenanzeigenService;
	

	public AdminbenutzergruppenanzeigenController(IAdminbenutzergruppenanzeigenService benutzergruppenanzeigenService ) {
		this.benutzergruppenanzeigenService = benutzergruppenanzeigenService;
	}
	
	@GetMapping("/benutzergruppen")
	public List<AdminbenutzergruppeDTO> getAllBenutzergruppen(){
		return benutzergruppenanzeigenService.getAllbenutzergruppen();
	}
	@GetMapping("/benutzergruppen{id}")
	public Adminbenutzergruppeneuanlage getOneBenutzergruppe(@PathVariable  Long id) {
		return benutzergruppenanzeigenService.getOneBenutzergruppe(id);
	}
}
