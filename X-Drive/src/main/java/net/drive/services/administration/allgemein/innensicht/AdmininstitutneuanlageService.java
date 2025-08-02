package net.drive.services.administration.allgemein.innensicht;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.drive.config.LogicResource;
import net.drive.dto.administration.AdmininstitutDTO;
import net.drive.entities.administration.allgemein.Admininstitutneuanlage;
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

        Admininstitutneuanlage entity = mapToEntity(dto);
        Admininstitutneuanlage saved = repo.save(entity);
        return mapToDto(saved);
    }

    private Admininstitutneuanlage mapToEntity(AdmininstitutDTO dto) {
        Admininstitutneuanlage entity = new Admininstitutneuanlage();
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

    private AdmininstitutDTO mapToDto(Admininstitutneuanlage e) {
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
