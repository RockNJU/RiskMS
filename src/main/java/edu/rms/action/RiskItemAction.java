package edu.rms.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import edu.rms.business.RiskItemBusiness;
import edu.rms.business.UserBusiness;
import edu.rms.model.RiskItem;
import edu.rms.model.User;

@Component
public class RiskItemAction extends BaseAction{
	@Autowired
	private RiskItemBusiness riskItemBusiness;
	private RiskItem riskItem_add;
	@Autowired
	private UserBusiness userBusiness; 
	private User user;
	private List<RiskItem> riskItemList;
	private List<User> optionalUserList;
	private String[] selectedUserList;
	private List<RiskItem> riskItemListOfCurrentUser;
	
	public RiskItemBusiness getRiskItemBusiness() {
		return riskItemBusiness;
	}
	public void setRiskItemBusiness(RiskItemBusiness riskItemBusiness) {
		this.riskItemBusiness = riskItemBusiness;
	}
	public RiskItem getRiskItem_add() {
		return riskItem_add;
	}
	public void setRiskItem_add(RiskItem riskItem_add) {
		this.riskItem_add = riskItem_add;
	}
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<RiskItem> getRiskItemList() {
		return riskItemList;
	}
	public void setRiskItemList(List<RiskItem> riskItemList) {
		this.riskItemList = riskItemList;
	}
	
	
	public List<User> getOptionalUserList() {
		return optionalUserList;
	}
	public void setOptionalUserList(List<User> optionalUserList) {
		this.optionalUserList = optionalUserList;
	}
	
	
	public List<RiskItem> getRiskItemListOfCurrentUser() {
		return riskItemListOfCurrentUser;
	}
	public void setRiskItemListOfCurrentUser(List<RiskItem> riskItemListOfCurrentUser) {
		this.riskItemListOfCurrentUser = riskItemListOfCurrentUser;
	}
	
	
	public String[] getSelectedUserList() {
		return selectedUserList;
	}
	public void setSelectedUserList(String[] selectedUserList) {
		this.selectedUserList = selectedUserList;
	}
	//获得�?有风险条�?
	public void getAllRiskItem(){	
		riskItemList =  riskItemBusiness.getAllRiskItem();	
	}
	
	//获得当前登录人员可参与的风险条目
	public void getMyRiskItem(){	
		User current=(User) session.get("user");
		riskItemListOfCurrentUser =  riskItemBusiness.getMyRiskItem(current.getUser_id());
	}
	
	//获得可�?�的跟踪�?
	public void getOptionalTrackers(){
		User current=(User) session.get("user");
		optionalUserList = userBusiness.getOptionalTrackers();
	}
	
	//增加风险条目
	public String addRiskItem(){
		int userId = ((User) session.get("user")).getUser_id();
		riskItem_add.setSubmitter(userId);
		String userIdStr="";
		for(int i=0;i<selectedUserList.length;i++){
			userIdStr+=selectedUserList[i]+";";
		}
		riskItem_add.setThreshold(userIdStr);
		return riskItemBusiness.addRiskItem(riskItem_add);
		
	}
}
