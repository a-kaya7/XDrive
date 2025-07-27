package net.drive.services.administration.allgemein.innensicht;

import java.util.List;


import org.springframework.stereotype.Service;

import net.drive.dto.administration.AdminbenutzergruppeDTO;
import net.drive.entities.administration.allgemein.Adminbenutzergruppeneuanlage;
import net.drive.repository.administration.AdminbenutzergruppeRepository;
import net.drive.services.administration.allgemein.aussensicht.IAdminbenutzergruppenanzeigenService;
@Service
public class AdminbenutzergruppenanzeigenService implements IAdminbenutzergruppenanzeigenService {

	private final AdminbenutzergruppeRepository benutzergruppeRepository;
	
	public AdminbenutzergruppenanzeigenService (AdminbenutzergruppeRepository benutzergruppeRepository ) {
		this.benutzergruppeRepository = benutzergruppeRepository;
	}
	
	@Override
	public List<AdminbenutzergruppeDTO> getAllbenutzergruppen() {
		
		return benutzergruppeRepository.findAll().stream().map(this::mapToDto).toList();
	}
	
	private AdminbenutzergruppeDTO mapToDto(Adminbenutzergruppeneuanlage entity) {
        return new AdminbenutzergruppeDTO(
            entity.getId(),
            entity.getBenutzergruppe(),
            entity.getBeschreibung(),
            entity.isFreigabe()
        );
    }

	@Override
	public Adminbenutzergruppeneuanlage getOneBenutzergruppe(Long id) {
		return benutzergruppeRepository.findById(id).orElse(null);
	}

}
