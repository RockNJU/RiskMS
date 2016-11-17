package edu.rms.dao;

import java.util.List;

import edu.rms.model.User;

public interface UserDao {
	
	public String save(User user);
	public User findByName(String name);
	public User getById(int user_id);
	public List<User> getAll();
	

}
