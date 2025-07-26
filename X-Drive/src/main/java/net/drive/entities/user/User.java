package net.drive.entities.user;

import jakarta.persistence.Entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="users")
@Data
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Primärschlüssel (Primary Key) einer Datenbanktabelle automatisch 
	private Long id;
	private String userName;
	private String passwort;
	
    @Enumerated(EnumType.STRING)
    private Rolle role;

	
}
