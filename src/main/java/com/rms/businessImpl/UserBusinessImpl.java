package com.rms.businessImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.business.UserBusiness;
import com.rms.dao.UserDao;
import com.rms.model.User;

@Service
public class UserBusinessImpl implements UserBusiness {
	
	@Autowired
	private UserDao userDao;
	@Override
	public String addUser(User user) {
		 return userDao.save(user);		

	}
	
	@Override
	public User loginUser(String user_name) {
		return userDao.findByName(user_name);
		
	}
	@Override
	public void sentErrorMessage(String message, HttpServletRequest req) {
		req.setAttribute("message",message);	
	}
	
	@Override
	public List<User> getAllUser() {
		return userDao.getAll();
	}

	@Override
	public List<User> getOptionalTrackers(Long userid) {
		// TODO Auto-generated method stub
		return null;
	}

}
