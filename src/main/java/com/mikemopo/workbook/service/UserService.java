package com.mikemopo.workbook.service;

import java.util.List;

import com.mikemopo.workbook.model.User;

public interface UserService {
	
	public User saveUser (User user);
	public List<User> saveUsers (List<User> users);
	public List<User> getUsers ();
	public User getUserById (Long id);
	public User deleteUser(Long id);
	public User updateUser(User user);

}
