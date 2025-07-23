package net.drive.entities.fahrschuler;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.drive.entities.datentypen.Adresse;
import net.drive.entities.datentypen.AdresseConverter;

@Entity
@Table(name="fahrschueler")
@Data
@Getter
@Setter
public class Fahrschueler {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;                
	private String vorname;         
	private String nachname;        
	private LocalDate geburtsdatum; 
	private String geschlecht;      
	private String email;           
	private String telefonnummer; 
	@Convert(converter = AdresseConverter.class)
	@Column(columnDefinition = "TEXT")
	private Adresse adresse;

}
