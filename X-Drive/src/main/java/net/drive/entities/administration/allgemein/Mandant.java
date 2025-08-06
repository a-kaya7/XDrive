package net.drive.entities.administration.allgemein;



import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import net.drive.entities.datentypen.Adresse;
import net.drive.entities.datentypen.AdresseConverter;

@Entity
@Table(name="mandanten")
@Data
public class Mandant {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name ="idname")
	private String idname;
	
	@Column(name ="bezeichnung")
	private String bezeichnung;
	
	@ManyToOne
    @JoinColumn(name = "institut_id" , insertable = false, updatable = false)
    private Institut institut;
	
	@Column(name = "institut_id")
	private Long institutId; 
	
	@Column(name ="local")
	private String locale;

	@Column(name ="name1")
	private String name1;
	
	@Column(name ="name2")
	private String name2;
	
	@Convert(converter = AdresseConverter.class)
	@Column(columnDefinition = "TEXT")
	private Adresse adresse;
	
	@Column(name ="telefon")
	private String telefon;
	
	@Column(name ="email")
	private String email;
	
	
}
