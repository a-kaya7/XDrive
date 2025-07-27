package net.drive.dto.administration;

public record AdminbenutzergruppeDTO(
		  Long id,
	      String benutzergruppe,
	      String beschreibung,
	      boolean freigabe
){}
