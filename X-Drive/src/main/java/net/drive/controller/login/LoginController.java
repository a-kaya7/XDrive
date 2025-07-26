package net.drive.controller.login;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.drive.entities.user.User;
import net.drive.services.login.aussensicht.ILoginService;

@Controller
@RequestMapping("/api")
public class LoginController {
	
	private final ILoginService loginService;
	
	 public LoginController(ILoginService loginService) {
	        this.loginService = loginService;
	    }
	 @PostMapping("/login")
	 public ResponseEntity<String> login(@RequestBody User user) {
	        boolean success = loginService.login(user.getUserName(), user.getPasswort());
	        if (success) {
	            return ResponseEntity.ok("Login erfolgreich");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Ungültige Anmeldedaten");
	        }
	    }

}
