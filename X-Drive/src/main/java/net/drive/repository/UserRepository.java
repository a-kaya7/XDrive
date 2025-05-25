package net.drive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.drive.entities.user.User;

@Repository
public interface  UserRepository extends JpaRepository<User, Long> {
	 

}
