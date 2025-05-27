package net.drive.services.vorlesung.theoretische.aussensicht;

import java.util.List;

import net.drive.entities.vorlesung.theoretische.TheoretischeVorlesung;

public interface ITheoretischeVorlesungAnzeigen {
	
	List<TheoretischeVorlesung> getAllVorlesung();

	TheoretischeVorlesung getOneVorlesung(Long vorlesungId);

}
