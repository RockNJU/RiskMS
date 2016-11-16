package business;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import model.User;

@Service
public interface UserBusiness {

	public void sentErrorMessage(String message, HttpServletRequest req);

	public User loginUser(String user_name);
	
	public String addUser(User user);
	
	public List<User> getAllUser();
	
	//获得某人可选的跟踪者
	public List<User> getOptionalTrackers(int i);
	
}
