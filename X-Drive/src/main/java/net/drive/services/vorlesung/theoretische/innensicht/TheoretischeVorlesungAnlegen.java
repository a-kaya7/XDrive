package net.drive.services.vorlesung.theoretische.innensicht;

import org.springframework.stereotype.Service;

import net.drive.entities.user.Rolle;
import net.drive.entities.user.User;
import net.drive.entities.vorlesung.theoretische.TheoretischeVorlesung;
import net.drive.repository.UserRepository;
import net.drive.repository.VorlesungRepository;
import net.drive.services.vorlesung.theoretische.aussensicht.ITheoretischeVorlesungAnlegen;

@Service
public class TheoretischeVorlesungAnlegen implements ITheoretischeVorlesungAnlegen {

	
	private final VorlesungRepository vorlesungRepository;
	private final UserRepository userRepository;
	
	public TheoretischeVorlesungAnlegen(VorlesungRepository vorlesungRepository, UserRepository userRepository ) {
		this.vorlesungRepository = vorlesungRepository;
		this.userRepository = userRepository;
	}

	
	@Override
	public TheoretischeVorlesung vorlesungAnlegen(TheoretischeVorlesung theoretischeVorlesung, Long lehrerId) {
		
		User fahrlehrer = userRepository.findById(lehrerId).orElseThrow(() -> new IllegalArgumentException(""));
		
		if(fahrlehrer.getRole() != Rolle.FAHRLEHRER) {
			throw new IllegalStateException();
		
		
	}
		
	return vorlesungRepository.save(theoretischeVorlesung);
}
}
