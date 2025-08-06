package net.drive.controller.administration.allgemein;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.drive.entities.administration.allgemein.Institut;
import net.drive.repository.administration.IAdmininstitutRepository;
import net.drive.services.administration.allgemein.aussensicht.IAdmininstitutbearbeitenService;

@RestController
@RequestMapping("api")
public class AdmininstitutbearbeitenController {

	
	private final IAdmininstitutbearbeitenService institut;
	
	
	public AdmininstitutbearbeitenController(IAdmininstitutbearbeitenService institut) {
		this.institut = institut;
		
	}
	
	@GetMapping("/institute/{idname}")
    public ResponseEntity<Institut> getInstitut(@PathVariable("idname") String idname) {
		Institut result = institut.getInstitutByIdname(idname);
        return ResponseEntity.ok(result);
    }
	
	@PutMapping("/institute/{idname}")
	public ResponseEntity<Institut> updateInstitut(
	        @PathVariable("idname") String idname,
	        @RequestBody Institut updatedInstitut) {

		Institut updated = institut.updateInstitut(idname, updatedInstitut);
	    return ResponseEntity.ok(updated);
	}


}
