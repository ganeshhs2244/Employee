package com.employee.Employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.Employee.Dao.UserRepository;
import com.employee.Employee.entity.User;




@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/*
	 * Add new User
	 */
	public User addUser(User newUser) {
		return userRepository.save(newUser);
	}

	
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	/*
	 * Get User by Id
	 */
	
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}
	/*
	 * Delete User
	 */
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	/*
	 * Update User
	 */
	
	public User updateUser(Long id, User user)
	{
		Optional<User> updateOpt = userRepository.findById(id);
		User userInDb = null;
		if (updateOpt.isPresent()) {
			userInDb = updateOpt.get();
			userInDb.setUserId(id);
			userInDb.setCreateDate(user.getCreateDate());
			userInDb.setModifiedDate(user.getModifiedDate());
			userInDb.setPassword(user.getPassword());
			userInDb.setReminderQueryQuestion(user.getReminderQueryQuestion());
			userInDb.setReminderQueryAnswer(user.getReminderQueryAnswer());
			userInDb.setEmailAdress(user.getEmailAdress());
			userInDb.setFirstName(user.getFirstName());
			userInDb.setMiddleName(user.getMiddleName());
			userInDb.setLastName(user.getLastName());
			userInDb.setJobTitle(user.getJobTitle());
			userInDb.setLoginDate(user.getLoginDate());
			userInDb.setAgreeToTermsOfUse(user.isAgreeToTermsOfUse());
			userInDb.setStatus(user.getStatus());
			userInDb.setEmailAdressverified(user.isEmailAdressverified());
			userInDb.setRoles(user.getRoles());
			userRepository.save(userInDb);
			return userInDb;

		}
		return userInDb; 

	}

}
