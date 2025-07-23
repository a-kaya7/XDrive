package net.drive.entities.datentypen;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Adresse implements Serializable {
	
	  private String strasse;
	  private String hausnummer;
	  private String plz;
	  private String stadt;

}
