package net.drive.controller.administration.allgemein;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import net.drive.entities.administration.allgemein.Adminbenutzergruppeneuanlage;
import net.drive.services.administration.allgemein.aussensicht.IAdminBenutzergruppeneuanlageService;

@Controller
@RequestMapping("/api")
public class AdminbenutzergruppeneuanlageController {
	
	private final  IAdminBenutzergruppeneuanlageService benutzergruppeneuanlageService;
	
	
	public AdminbenutzergruppeneuanlageController(IAdminBenutzergruppeneuanlageService benutzergruppeneuanlageService ) {
		this.benutzergruppeneuanlageService = benutzergruppeneuanlageService;
	}

	@PostMapping("/benutzergruppeneuanlage")
	 public ResponseEntity<String> beuntzergruppeneuAnlage(@RequestBody Adminbenutzergruppeneuanlage benutzergruppeneuanlage){
		
		 try {
	            benutzergruppeneuanlageService.createBenutzergruppe(benutzergruppeneuanlage);
	            return ResponseEntity.ok("Benutzergruppe erfolgreich erstellt!");
	        } catch (Exception e) {
	            return ResponseEntity.badRequest().body("Fehler beim Speichern: " + e.getMessage());
	        }
	}
}
