package net.drive.controller.administration.allgemein;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.drive.services.administration.allgemein.aussensicht.IAdmininstitutloeschenService;

@RestController
@RequestMapping("/api")
public class AdminstitutloeschenController {

	public final IAdmininstitutloeschenService admininstitutloeschen;
	
	public  AdminstitutloeschenController(IAdmininstitutloeschenService admininstitutloeschen) {
		this.admininstitutloeschen = admininstitutloeschen;
	}
	
	@DeleteMapping("/institute/{idname}")
		public ResponseEntity<?> deleteInstitut(@PathVariable("idname") String idname){
		admininstitutloeschen.deleteInstitutByIdname(idname);
		return ResponseEntity.ok().body("Institut erfolgreich gelöscht.");
		
	}
		
	
}
