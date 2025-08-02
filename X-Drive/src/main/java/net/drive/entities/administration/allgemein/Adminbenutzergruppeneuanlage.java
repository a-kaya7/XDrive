package net.drive.entities.administration.allgemein;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="benutzergruppen")
@Data
public class Adminbenutzergruppeneuanlage {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String benutzergruppe;
	private String beschreibung;
	private boolean freigabe;
	
    public Adminbenutzergruppeneuanlage() {
        // für JPA; 
    }


}
