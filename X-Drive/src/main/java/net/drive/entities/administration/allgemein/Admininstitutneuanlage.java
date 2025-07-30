package net.drive.entities.administration.allgemein;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="instituten")
@Data
public class Admininstitutneuanlage {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idname;

    @Column(name = "institutsname")
    private String institutsname;

    @Column(name = "bezeichnung")
    private String bezeichnung;

    private String bankleitzahl;
    private String bic;
    private String bwl;

    @Column(name = "locale")
    private String locale;

	
	public Admininstitutneuanlage() {
		
	}

}
