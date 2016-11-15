package com.rms.business;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.rms.model.User;


public interface UserBusiness {

	public void sentErrorMessage(String message, HttpServletRequest req);

	public User loginUser(String user_name);
	
	public String addUser(User user);
	
	public List<User> getAllUser();
	
	//获得某人可选的跟踪者
	public List<User> getOptionalTrackers(Long userid);
	
}
