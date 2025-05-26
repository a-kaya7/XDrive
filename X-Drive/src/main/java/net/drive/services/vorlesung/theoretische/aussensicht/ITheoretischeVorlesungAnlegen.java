package net.drive.services.vorlesung.theoretische.aussensicht;

import net.drive.entities.vorlesung.theoretische.TheoretischeVorlesung;

public interface ITheoretischeVorlesungAnlegen {

	

	TheoretischeVorlesung vorlesungAnlegen(TheoretischeVorlesung theoretischeVorlesung, Long lehrerId);
}
