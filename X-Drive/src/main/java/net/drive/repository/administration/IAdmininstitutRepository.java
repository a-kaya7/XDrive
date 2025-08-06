package net.drive.repository.administration;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import net.drive.entities.administration.allgemein.Institut;

public interface IAdmininstitutRepository extends JpaRepository<Institut, Long> {

	boolean existsByIdname(String idname);
	Optional<Institut> findByIdname(String idname);

}
