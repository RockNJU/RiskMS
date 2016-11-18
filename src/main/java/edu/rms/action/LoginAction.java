package edu.rms.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import edu.rms.business.UserBusiness;
import edu.rms.model.User;

@Repository
@Component

public class LoginAction extends BaseAction{

	@Autowired
	private UserBusiness userBusiness; 
	private User user;
	private User user_add;
	private List<User> userList;

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
	
	
	
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public String userLogin() throws ServletException,IOException{
		String message="";
		//获取name所对应的user对象
		User usr = userBusiness.loginUser(user.getUser_name());
		//System.out.println("userrole   "+usr.getRole());
		if(usr!=null){
			if(usr.getUser_psd().equals(user.getUser_psd())){
				if(usr.getRole()==1){
					session.put("manager", usr);
					return "manager";
				}else if(usr.getRole()==2){
					session.put("developer", usr);
					return "developer";
				}else if(usr.getRole()==0){
					session.put("admin", usr);
					return "admin";
				}
				return SUCCESS;
			}else{
				message+="密码错误<br>";
				userBusiness.sentErrorMessage(message, req);
				if(usr.getRole()==0){
					return "input-admin";
				}else {
					return "input-user";
				}
			}
		}else{
			message+="用户不存在<br>";
			userBusiness.sentErrorMessage(message, req);
			return INPUT;
		}
	}
	
	
	public String addUser(){
		if(userBusiness.addUser(user_add).equals("新增用户成功")){
			return SUCCESS;
		}
		return INPUT;
		
	}	
	
	
	public String getAllUser(){
		
		userList = userBusiness.getAllUser();
		return SUCCESS;
		
	}
	
}
