package business;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.User;


public interface UserBusiness {

	public void sentErrorMessage(String message, HttpServletRequest req);

	public User loginUser(String user_name);
	
	public String addUser(User user);
	
	public List<User> getAllUser();
	
}
