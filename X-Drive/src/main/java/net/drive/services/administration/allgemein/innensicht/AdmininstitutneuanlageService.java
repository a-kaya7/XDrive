package net.drive.services.administration.allgemein.innensicht;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import net.drive.config.LogicResource;
import net.drive.dto.administration.AdmininstitutDTO;
import net.drive.entities.administration.allgemein.Institut;
import net.drive.repository.administration.IAdmininstitutRepository;
import net.drive.services.administration.allgemein.aussensicht.IAdmininstitutneuanlageService;

@Service
public class AdmininstitutneuanlageService implements IAdmininstitutneuanlageService {
	
	private final IAdmininstitutRepository repo;
	

	public AdmininstitutneuanlageService(IAdmininstitutRepository repo ) {
		this.repo = repo;
	}
	
	@Autowired
	private LogicResource logicResource;
	
    @Override
    public AdmininstitutDTO createIntitut(AdmininstitutDTO dto) {
    	if (dto.idname() != null && !dto.idname().isEmpty()) {
    	    if (repo.existsByIdname(dto.idname())) {
    	        throw new RuntimeException(logicResource.getMessage("IdnameExistiert") + dto.idname());
    	    }
    	}

    	Institut entity = mapToEntity(dto);
    	Institut saved = repo.save(entity);
        return mapToDto(saved);
    }

    private Institut mapToEntity(AdmininstitutDTO dto) {
    	Institut entity = new Institut();
        entity.setId(dto.id());
        entity.setIdname(dto.idname());
        entity.setInstitutsname(dto.institutsname());
        entity.setBezeichnung(dto.bezeichnung());
        entity.setBankleitzahl(dto.bankleitzahl());
        entity.setBic(dto.bic());
        entity.setBwl(dto.bwl());
        entity.setLocale(dto.locale());

        return entity;
    }

    private AdmininstitutDTO mapToDto(Institut e) {
    	 return new AdmininstitutDTO(
    		        e.getId(),
    		        e.getIdname(),
    		        e.getInstitutsname(),
    		        e.getBezeichnung(),
    		        e.getBankleitzahl(),
    		        e.getBic(),
    		        e.getBwl(),
    		        e.getLocale()
    		    );
    }

}
