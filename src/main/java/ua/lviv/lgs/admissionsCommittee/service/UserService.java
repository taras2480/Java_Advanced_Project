package ua.lviv.lgs.admissionsCommittee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.admissionsCommittee.dao.UserRepository;
import ua.lviv.lgs.admissionsCommittee.domain.User;
import ua.lviv.lgs.admissionsCommittee.domain.UserRole;

@Service
public class UserService {

	private Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public void save(User user) {

		logger.info("Register  new user" + user);

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setConfirmPassword(bCryptPasswordEncoder.encode(user.getConfirmPassword()));
		user.setRole(UserRole.ROLE_USER);
		userRepository.save(user);
	}

	public User findByEmail(String email) {

		logger.info("Find  user by email" + email);
		return userRepository.findByEmail(email).get();
	}

	public User findById(Integer id) {
		
		logger.info("Find  user by id" + id);
		return userRepository.findById(id).get();
	}

}
