package net.drive.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.drive.entities.user.User;
import net.drive.repository.UserRepository;


@Service
public class UserService {
	
	
	private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	
	
	public User createUser(User user) {
        return userRepository.save(user);
    }



	public List<User> getAllUsers() {
		
		return userRepository.findAll();
		}



	public User getOneUser(Long userId) {
		
		return userRepository.findById(userId).orElse(null);
	}



	public User updateUser(Long userId, User newUser) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			User findeUser = user.get();
			findeUser.setUserName(newUser.getUserName());
			findeUser.setPasswort(newUser.getPasswort());
			return userRepository.save(findeUser);
		}else {
			throw new RuntimeException("User wurde nicht gefunden" + userId);
		}
		
	}



	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
		
	}



	

}
