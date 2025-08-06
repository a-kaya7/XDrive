package net.drive.repository.administration;

import org.springframework.data.jpa.repository.JpaRepository;

import net.drive.entities.administration.allgemein.Mandant;

public interface IAdminmandantenRepository extends JpaRepository<Mandant, Long> {

	boolean existsByIdname(String idname);
}
