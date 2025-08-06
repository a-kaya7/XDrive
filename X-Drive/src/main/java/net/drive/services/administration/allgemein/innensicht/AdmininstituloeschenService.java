package net.drive.services.administration.allgemein.innensicht;

import java.util.Optional;


import org.springframework.stereotype.Service;

import net.drive.entities.administration.allgemein.Institut;
import net.drive.repository.administration.IAdmininstitutRepository;
import net.drive.services.administration.allgemein.aussensicht.IAdmininstitutloeschenService;

@Service
public class AdmininstituloeschenService implements IAdmininstitutloeschenService{

	private final IAdmininstitutRepository InsitutRepo;
	
	public AdmininstituloeschenService(IAdmininstitutRepository InsitutRepo) {
		this.InsitutRepo = InsitutRepo;
	}

	@Override
	public void deleteInstitutByIdname(String idname) {
	
		Optional<Institut> optInstitut = InsitutRepo.findByIdname(idname);
		if(optInstitut.isEmpty() ) {
			throw new RuntimeException("Kein Institut mit IDName: " + idname);
		}
		InsitutRepo.delete(optInstitut.get());
	}

}
