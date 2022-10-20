package com.mikemopo.workbook.service;


import java.util.List;
import java.util.Optional;

import com.mikemopo.workbook.exception.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;

import com.mikemopo.workbook.model.User;
import com.mikemopo.workbook.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User saveUser (User user) {
		return userRepository.save(user);
	}
	
	public List<User> saveUsers (List<User> users) {
		return userRepository.saveAll(users);
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(()-> new UserNotFound("User with id: "+id+" not found"));
	}
	
	public User deleteUser(Long id) {
		User user = getUserById(id);
		if(userRepository.findById(id).equals(Optional.empty())){
			 userRepository.deleteById(id);
			return user;
		}
		else
		return userRepository.findById(id)
				.orElseThrow(()-> new UserNotFound("Cannot delete user id "+id+ ". Record does not exist"));


		
	}

	public User updateUser(User user) {
		User editUser =  userRepository.findById(user.getId()).orElse(null);
		editUser.setTitle(user.getTitle());
		editUser.setFirstname(user.getFirstname());
		editUser.setSurname(user.getSurname());
		editUser.setDob(user.getDob());
		editUser.setJobtitle(user.getJobtitle());
		return userRepository.save(editUser);
	}
}
