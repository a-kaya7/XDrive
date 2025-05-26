package net.drive.entities.vorlesung.theoretische;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import net.drive.entities.user.User;

@Entity
@Table(name="theoretischevorlesung")
@Data
public class TheoretischeVorlesung {
	
	@Id
	long id;
	private String titel;
	private String inhalt;
	private LocalDateTime datumUhr;
	private int zeit;
	private String ort;
	
	
	 @ManyToOne
	 @JoinColumn(name = "lehrer_id")
	 private User fahrlehrer;
	

}
