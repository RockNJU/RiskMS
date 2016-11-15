package com.rms.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rms.business.RiskItemBusiness;
import com.rms.business.UserBusiness;
import com.rms.model.RiskItem;
import com.rms.model.User;

@Repository
public class RiskItemAction extends BaseAction{
	@Autowired
	private RiskItemBusiness riskItemBusiness;
	private RiskItem riskItem;
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
	
	//获得所有风险条目
	public List<RiskItem> getAllRiskItem(){	
		return riskItemBusiness.getAllRiskItem();	
	}
	
	//获得当前登录人员可参与的风险条目
	public List<RiskItem> getMyRiskItem(){	
		User current=(User) session.get("user");
		return riskItemBusiness.getMyRiskItem(current.getUser_id());
	}
	
	
}
