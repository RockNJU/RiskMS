package action;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import business.UserBusiness;
import model.User;

@Repository
public class LoginAction extends BaseAction{
	@Autowired
	private UserBusiness userBusiness; 
	private User user;
	private User user_add;

	
	public UserBusiness getUserBusiness() {
		return userBusiness;
	}
	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public User getUser_add() {
		return user_add;
	}
	public void setUser_add(User user_add) {
		this.user_add = user_add;
	}
	
	public String userLogin() throws ServletException,IOException{
		String message="";
		//获取name所对应的user对象
		User usr = userBusiness.loginUser(user.getUser_name());
		if(usr!=null){
			if(usr.getUser_psd().equals(user.getUser_psd())){
				session.put("user", usr);
				return SUCCESS;
			}else{
				message+="密码错误<br>";
				userBusiness.sentErrorMessage(message, req);
				return INPUT;
			}
		}else{
			message+="用户不存在<br>";
			userBusiness.sentErrorMessage(message, req);
			return INPUT;
		}
	}
	
	
	public String addUser(){
		return userBusiness.addUser(user_add);
	}	
	
	
}
