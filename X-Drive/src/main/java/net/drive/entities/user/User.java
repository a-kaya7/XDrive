package net.drive.entities.user;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="users")
@Data
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Primärschlüssel (Primary Key) einer Datenbanktabelle automatisch 
	Long id;
	String userName;
	String passwort;
	
    @Enumerated(EnumType.STRING)
    private Rolle role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Rolle getRole() {
		return role;
	}

	public void setRole(Rolle role) {
		this.role = role;
	}
    
    
    
	
}
