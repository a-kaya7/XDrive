package net.drive.services.administration.allgemein.aussensicht;

import java.util.List;

import net.drive.dto.administration.AdminbenutzergruppeDTO;
import net.drive.entities.administration.allgemein.Adminbenutzergruppeneuanlage;

public interface IAdminbenutzergruppenanzeigenService {

	List<AdminbenutzergruppeDTO> getAllbenutzergruppen();
	Adminbenutzergruppeneuanlage getOneBenutzergruppe(Long id);
}
