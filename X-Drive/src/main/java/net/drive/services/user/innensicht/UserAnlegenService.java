package net.drive.services.user.innensicht;

import org.springframework.stereotype.Service;

import net.drive.entities.user.User;
import net.drive.repository.UserRepository;
import net.drive.services.user.aussensicht.IUserAnlegenService;

@Service
public class UserAnlegenService implements IUserAnlegenService {
	
	private final UserRepository userRepository;
	
	public UserAnlegenService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	@Override
	public User createUser(User user) {
		 return userRepository.save(user);
	}

}
