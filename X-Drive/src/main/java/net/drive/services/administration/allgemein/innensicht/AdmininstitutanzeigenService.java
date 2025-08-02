package net.drive.services.administration.allgemein.innensicht;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import net.drive.dto.administration.InstitutListenDTO;

import net.drive.repository.administration.IAdmininstitutRepository;
import net.drive.services.administration.allgemein.aussensicht.IAdmininstitutanzeigenService;


@Service
public class AdmininstitutanzeigenService implements IAdmininstitutanzeigenService {

	private final IAdmininstitutRepository  repo; 
	
	public AdmininstitutanzeigenService(IAdmininstitutRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public List<InstitutListenDTO> getAllInstitut() {
		
		
		return repo.findAll().stream().map(entity -> new InstitutListenDTO(
				entity.getIdname(),
				entity.getBezeichnung(),
				entity.getInstitutsname())).collect(Collectors.toList());
	}
	
	
}
