package net.drive.services.administration.allgemein.innensicht;

import org.springframework.stereotype.Service;

import net.drive.entities.administration.allgemein.Adminbenutzergruppeneuanlage;
import net.drive.repository.administration.AdminbenutzergruppeRepository;
import net.drive.services.administration.allgemein.aussensicht.IAdminBenutzergruppeneuanlageService;


@Service
public class AdminbenutzergruppeneuanlageService implements IAdminBenutzergruppeneuanlageService {

	private final AdminbenutzergruppeRepository  benutzergruppeRepository;
	
	public AdminbenutzergruppeneuanlageService (AdminbenutzergruppeRepository benutzergruppeRepository) {
		this.benutzergruppeRepository = benutzergruppeRepository;
	}
	@Override
	public Adminbenutzergruppeneuanlage createBenutzergruppe(Adminbenutzergruppeneuanlage benutzergruppe) {
		
		return benutzergruppeRepository.save(benutzergruppe);
	}

}
