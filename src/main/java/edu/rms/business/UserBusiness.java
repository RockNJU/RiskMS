package edu.rms.business;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import edu.rms.model.User;


public interface UserBusiness {

	public void sentErrorMessage(String message, HttpServletRequest req);

	public User loginUser(String user_name);
	
	public String addUser(User user);
	
	public List<User> getAllUser();
	
	public List<User> getOptionalTrackers();
	
}
