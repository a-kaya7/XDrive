package net.drive.repository.administration;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import net.drive.entities.administration.allgemein.Admininstitutneuanlage;

public interface IAdmininstitutRepository extends JpaRepository<Admininstitutneuanlage, Long> {

	boolean existsByIdname(String idname);
	Optional<Admininstitutneuanlage> findByIdname(String idname);


}
