package net.drive.services.user.innensicht;

import java.util.List;

import org.springframework.stereotype.Service;

import net.drive.entities.user.User;
import net.drive.repository.UserRepository;
import net.drive.services.user.aussensicht.IUserAnzeigenService;

@Service
public class UserAnzeigenService implements IUserAnzeigenService {
	
	 private final UserRepository userRepository;
	
	public UserAnzeigenService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getOneUser(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}

}
