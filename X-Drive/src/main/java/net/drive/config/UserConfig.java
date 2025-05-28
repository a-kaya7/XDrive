package net.drive.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.drive.entities.user.User;
import net.drive.repository.UserRepository;

@Configuration
public class UserConfig {

	private final UserRepository userRepository;

	public UserConfig(UserRepository userRepository) {
		this.userRepository = userRepository;

	}
	
	@Bean
    public List<User> userList() {
		return userRepository.findAll();
	}

}
