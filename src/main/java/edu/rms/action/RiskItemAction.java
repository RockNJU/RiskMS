package edu.rms.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.rms.business.RiskItemBusiness;
import edu.rms.business.UserBusiness;
import edu.rms.model.RiskItem;
import edu.rms.model.User;

@Repository
public class RiskItemAction extends BaseAction{
	@Autowired
	private RiskItemBusiness riskItemBusiness;
	private RiskItem riskItem;
	@Autowired
	private UserBusiness userBusiness; 
	private User user;
	
	public RiskItemBusiness getRiskItemBusiness() {
		return riskItemBusiness;
	}
	public void setRiskItemBusiness(RiskItemBusiness riskItemBusiness) {
		this.riskItemBusiness = riskItemBusiness;
	}
	public RiskItem getRiskItem() {
		return riskItem;
	}
	public void setRiskItem(RiskItem riskItem) {
		this.riskItem = riskItem;
	}
	
	
	
	//获得�?有风险条�?
	public List<RiskItem> getAllRiskItem(){	
		return riskItemBusiness.getAllRiskItem();	
	}
	
	//获得当前登录人员可参与的风险条目
	public List<RiskItem> getMyRiskItem(){	
		User current=(User) session.get("user");
		return riskItemBusiness.getMyRiskItem(current.getUser_id());
	}
	
	//获得可�?�的跟踪�?
	public List<User> getOptionalTrackers(){
		User current=(User) session.get("user");
		return userBusiness.getOptionalTrackers(current.getUser_id());
	}
	
	//增加风险条目
	public String addRiskItem(RiskItem temp){
		int id= (riskItemBusiness.getAllRiskItem().size()+2);	
		temp.setRiskItem_id(id);	
		return riskItemBusiness.addRiskItem(temp);
		
	}
}
