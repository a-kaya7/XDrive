package net.drive.services.vorlesung.theoretische.innensicht;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.drive.entities.vorlesung.theoretische.TheoretischeVorlesung;
import net.drive.repository.VorlesungRepository;
import net.drive.services.vorlesung.theoretische.aussensicht.ITheoretischeVorlesungAnzeigen;

@Service
public class TheoretischeVorlesungAnzeigen implements ITheoretischeVorlesungAnzeigen {
	
	private final VorlesungRepository vorlesungRepository;
	
	public TheoretischeVorlesungAnzeigen(VorlesungRepository vorlesungRepository) {
		this.vorlesungRepository = vorlesungRepository;
	}

	@Override
	public List<TheoretischeVorlesung> getAllVorlesung() {
		return vorlesungRepository.findAll();
	}

	@Override
	public TheoretischeVorlesung getOneVorlesung(Long vorlesungId) {
		return vorlesungRepository.findById(vorlesungId).orElse(null);
	}

	
	

}
