package net.drive.services.user.aussensicht;

import java.util.List;

import net.drive.entities.user.User;

public interface IUserAnzeigenService {
	
	 List<User> getAllUsers();
	 User getOneUser(Long userId);

}
