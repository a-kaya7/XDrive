package net.drive.services.administration.allgemein.innensicht;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import net.drive.config.LogicResource;
import net.drive.dto.administration.AdmininstitutDTO;
import net.drive.dto.administration.MandantenDTO;
import net.drive.entities.administration.allgemein.Admininstitutneuanlage;
import net.drive.entities.administration.allgemein.Institut;
import net.drive.entities.administration.allgemein.Mandant;
import net.drive.repository.administration.IAdmininstitutRepository;
import net.drive.repository.administration.IAdminmandantenRepository;
import net.drive.services.administration.allgemein.aussensicht.IAdminmandantneuanlageService;

@Service
public class AdminmandantneuanlageService implements IAdminmandantneuanlageService {

    private final IAdminmandantenRepository repo;

    public AdminmandantneuanlageService(IAdminmandantenRepository repo) {
        this.repo = repo;
    }

    @Autowired
    private IAdmininstitutRepository institutRepo;

    @Autowired
    private LogicResource logicResource;

    @Override
    public MandantenDTO createMandant(MandantenDTO mandant) {
        if (mandant.idname() != null && !mandant.idname().isEmpty()) {
            if (repo.existsByIdname(mandant.idname())) {
                throw new RuntimeException(logicResource.getMessage("MandantExistiert") + mandant.idname());
            }
        }

        Mandant entity = mapToEntity(mandant);
        Mandant saved = repo.save(entity);
        return mapToDto(saved);
    }

    private Mandant mapToEntity(MandantenDTO dto) {
        if (dto.institut() == null || dto.institut() == null) {
            throw new IllegalArgumentException("Institut ID darf nicht null sein");
        }

        Admininstitutneuanlage institut = institutRepo.findById(dto.institut())
                .orElseThrow(() -> new IllegalArgumentException("Institut nicht gefunden mit Id: " + dto.institut()));

        Mandant mandant = new Mandant();
        mandant.setId(dto.id());
        mandant.setIdname(dto.idname());
        mandant.setBezeichnung(dto.bezeichnung());
        mandant.setInstitut(institut);
        mandant.setLocale(dto.locale());
        mandant.setName1(dto.name1());
        mandant.setName2(dto.name2());
        mandant.setAdresse(dto.adresse());
        mandant.setTelefon(dto.telefon());
        mandant.setEmail(dto.email());

        return mandant;
    }

    private MandantenDTO mapToDto(Mandant mandant) {
        return new MandantenDTO(
             mandant.getId(),
             mandant.getIdname(),
             mandant.getBezeichnung(),
             mandant.getInstitut() != null ? mandant.getInstitut().getId() : null,
             mandant.getLocale(),
             mandant.getName1(),
             mandant.getName2(),
             mandant.getAdresse(),
             mandant.getTelefon(),
             mandant.getEmail()
        );
    }

}
