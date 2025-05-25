package net.drive.services.user.innensicht;

import org.springframework.stereotype.Service;

import net.drive.repository.UserRepository;
import net.drive.services.user.aussensicht.IUserLoeschenService;


@Service
public class UserLoeschenService implements IUserLoeschenService {
	
	private final UserRepository userRepository;
	
	public UserLoeschenService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
		
	}

}
