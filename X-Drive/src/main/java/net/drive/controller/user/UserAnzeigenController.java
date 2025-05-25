package net.drive.controller.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.drive.services.user.aussensicht.IUserAnzeigenService;
import net.drive.entities.user.User;

@RestController
@RequestMapping("/user/anzeigen")
public class UserAnzeigenController {
	
	private final IUserAnzeigenService userAnzeigenservice;
	
	public UserAnzeigenController(IUserAnzeigenService userAnzeigenService) {
		this.userAnzeigenservice = userAnzeigenService;
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return userAnzeigenservice.getAllUsers();
	}
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable("userId") Long userId){
		return userAnzeigenservice.getOneUser(userId);
	}
	
	

}
