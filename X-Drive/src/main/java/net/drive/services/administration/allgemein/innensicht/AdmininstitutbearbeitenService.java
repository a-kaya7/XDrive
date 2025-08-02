package net.drive.services.administration.allgemein.innensicht;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.drive.config.LogicResource;
import net.drive.entities.administration.allgemein.Admininstitutneuanlage;
import net.drive.repository.administration.IAdmininstitutRepository;
import net.drive.services.administration.allgemein.aussensicht.IAdmininstitutbearbeitenService;

@Service
public class AdmininstitutbearbeitenService implements IAdmininstitutbearbeitenService  {

	private final IAdmininstitutRepository repository;
	
	public AdmininstitutbearbeitenService(IAdmininstitutRepository  repository ) {
		this.repository = repository;
	}
	
	@Autowired
	private LogicResource logicResource;
	
	@Override
	public Admininstitutneuanlage updateInstitut(String idname, Admininstitutneuanlage updatedData) {
	    Admininstitutneuanlage bearbeitung = repository.findByIdname(idname)
	        .orElseThrow(() -> new RuntimeException("Institut nicht gefunden"));
	    if(idname == null || idname.trim().isEmpty()) {
	    	throw new IllegalArgumentException(logicResource.getMessage("InsitutBearbeiten"));
	    }else {

	    bearbeitung.setInstitutsname(updatedData.getInstitutsname());
	    bearbeitung.setBezeichnung(updatedData.getBezeichnung());
	    bearbeitung.setBankleitzahl(updatedData.getBankleitzahl());
	    bearbeitung.setBic(updatedData.getBic());
	    bearbeitung.setBwl(updatedData.getBwl());
	    bearbeitung.setLocale(updatedData.getLocale());

	    return repository.save(bearbeitung);
	    }
	}


	@Override
	public Admininstitutneuanlage getInstitutByIdname(String idname) {
		
		return repository.findByIdname(idname)
	            .orElseThrow(() -> new RuntimeException("Institut nicht gefunden"));
	}


}
