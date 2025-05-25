package net.drive.services.user.aussensicht;

import net.drive.entities.user.User;

public interface IUserUpdateService {
	
	  User updateUser(Long userId, User newUser);

}
