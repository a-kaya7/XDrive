package net.drive.controller.user;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.drive.services.user.aussensicht.IUserLoeschenService;

@RestController
@RequestMapping("/user/löschen")
public class UserLoeschenController {

	private final IUserLoeschenService userLoeschenService;
	
	
	public UserLoeschenController(IUserLoeschenService userLoeschenService) {
		this.userLoeschenService = userLoeschenService;
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		userLoeschenService.deleteUser(userId);
	}

}
