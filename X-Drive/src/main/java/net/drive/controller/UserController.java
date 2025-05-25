package net.drive.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.drive.entities.user.*;
import net.drive.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;
	
	
	public UserController(UserService userService) {  //injektion
		this.userService = userService;
	}
	
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
		
	}
	
	@GetMapping("/{userId}")
	public User getOnerUser(@PathVariable("userId") Long userId) {
		return userService.getOneUser(userId);
	}
	
	@PutMapping("/{userId}")
	public User updateUser(@PathVariable("userId") Long userId , @RequestBody User newUser) {
		return userService.updateUser(userId , newUser);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		 userService.deleteUser(userId);
	}
	
}
