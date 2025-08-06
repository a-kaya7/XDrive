package net.drive.dto.administration;

import net.drive.entities.datentypen.Adresse;

public record MandantenDTO(
		    Long id,
		    String idname,
		    String bezeichnung,
		    Long institut,
		    String locale,
		    String name1,
		    String name2,
		    Adresse adresse,
		    String telefon,
		    String email
) {}
