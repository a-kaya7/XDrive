package net.drive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.drive.entities.fahrschuler.Fahrschueler;

@Repository
public interface FarhschuelerRepository extends JpaRepository <Fahrschueler, Long> {

}
