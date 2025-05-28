package net.drive.services.login.innensicht;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.drive.entities.user.User;
import net.drive.services.login.aussensicht.ILoginService;


@Service
public class LoginService implements ILoginService {
	
	 private final List<User> userList;

	 public LoginService(@Qualifier("userList") List<User> userList) {
	        this.userList = userList;
	    }

	@Override
	public boolean login(String username, String passwort) {
		
		return userList.stream().anyMatch(user -> 
		user.getUserName().equals(username) && 
		user.getPasswort().equals(passwort));
	}

}
