package net.drive.controller.user;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.drive.entities.user.User;
import net.drive.services.user.aussensicht.IUserAnlegenService;

@RestController
@RequestMapping("/user/anlegen")
public class UserAnlegenController {
	
	private final IUserAnlegenService userAnlegenService;
	
	public UserAnlegenController(IUserAnlegenService userAnlegenService) {  // construktor injection
		this.userAnlegenService = userAnlegenService;
	}
	

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userAnlegenService.createUser(user);
		
	}

}
