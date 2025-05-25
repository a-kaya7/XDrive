package net.drive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.drive.entities.vorlesung.theoretische.*;

@Repository
public interface VorlesungRepository extends JpaRepository <TheoretischeVorlesung, Long> {

}
