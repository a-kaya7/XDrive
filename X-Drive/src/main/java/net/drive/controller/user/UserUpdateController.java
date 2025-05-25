package net.drive.controller.user;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.drive.entities.user.User;
import net.drive.services.user.aussensicht.IUserUpdateService;

@RestController
@RequestMapping("/user/update")
public class UserUpdateController {
	
	private final IUserUpdateService userUpdateService;
	
	public UserUpdateController (IUserUpdateService userUpdateService) {
		this.userUpdateService = userUpdateService;
	}
	
	@PutMapping("/{userId}")
	public User updateUser(@PathVariable("userId") Long userId , @RequestBody User newUser) {
		return userUpdateService.updateUser(userId , newUser);
	}

}
