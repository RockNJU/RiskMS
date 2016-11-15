package dao;

import java.util.List;

import model.User;

public interface UserDao {
	
	public String save(User user);
	public User findByName(String name);
	public User getById(Long user_id);
	public List<User> getAll();

}
