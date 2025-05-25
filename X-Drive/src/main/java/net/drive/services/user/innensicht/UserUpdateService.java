package net.drive.services.user.innensicht;

import java.util.Optional;

import org.springframework.stereotype.Service;

import net.drive.entities.user.User;
import net.drive.repository.UserRepository;
import net.drive.services.user.aussensicht.IUserUpdateService;


@Service
public class UserUpdateService implements IUserUpdateService {
	
	private final UserRepository userRepository;
	
	public UserUpdateService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User updateUser(Long userId, User newUser) {
		Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPasswort(newUser.getPasswort());
            return userRepository.save(foundUser);
        } else {
            throw new RuntimeException("User not found with id " + userId);
        }
	}

}
