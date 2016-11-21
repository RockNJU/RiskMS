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
	private RiskItem riskItem;
	private RiskItem riskItem_unmodify;
	private RiskItem riskItem_hasmodify;
	@Autowired
	private UserBusiness userBusiness; 
	private User user;
	private List<RiskItem> riskItemList;
	private List<User> optionalUserList;
	private String[] selectedUserList;
	private List<RiskItem> riskItemListOfCurrentUser;
	


	public RiskItem getRiskItem_unmodify() {
		return riskItem_unmodify;
	}
	public void setRiskItem_unmodify(RiskItem riskItem_unmodify) {
		this.riskItem_unmodify = riskItem_unmodify;
	}
	public RiskItem getRiskItem_hasmodify() {
		return riskItem_hasmodify;
	}
	public void setRiskItem_hasmodify(RiskItem riskItem_hasmodify) {
		this.riskItem_hasmodify = riskItem_hasmodify;
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
	
	
	public RiskItem getRiskItem() {
		return riskItem;
	}
	public void setRiskItem(RiskItem riskItem) {
		this.riskItem = riskItem;
	}
	public String[] getSelectedUserList() {
		return selectedUserList;
	}
	public void setSelectedUserList(String[] selectedUserList) {
		this.selectedUserList = selectedUserList;
	}
	//获得�?有风险条�?
	public String getAllRiskItem(){	
		riskItemList =  riskItemBusiness.getAllRiskItem();	
		getOptionalTrackers();
		return SUCCESS;
	}
	
	//获得当前登录人员可参与的风险条目
	public String getMyRiskItem(){	
		User current=(User) session.get("developer");
		
		riskItemListOfCurrentUser =  riskItemBusiness.getMyRiskItem(current.getUser_id());
		
		return SUCCESS;
	}
	
	//获得可�?�的跟踪�?
	public void getOptionalTrackers(){
		optionalUserList = userBusiness.getOptionalTrackers();
		
	}
	
	//增加风险条目
	public String addRiskItem(){

		riskItem_add.setSubmitter(((User) session.get("manager")).getUser_id());
		riskItem_add.setSub_name(((User) session.get("manager")).getUser_name());
		String userIdStr="";
		for(int i=0;i<selectedUserList.length;i++){
			userIdStr+=selectedUserList[i]+";";
		}
		riskItem_add.setTracker_id(userIdStr);
		String result = riskItemBusiness.addRiskItem(riskItem_add);
		if(result!=null){
			return SUCCESS;
		}
		return INPUT;
		
	}
	
	//修改风险条目，主要是获取要修改的对象给界面
		public String modifyRiskItem(){
			String id = (String)(req.getParameter("modifyItemId"));
			session.put("modifyItemId", id);
			riskItem_unmodify=riskItemBusiness.getRiskById(id);
			session.put("unmodifyItem",riskItem_unmodify );
			return SUCCESS;
			
		}
		
		//更新风险条目，把界面修改后的条目更新到数据库
		public String updateRiskItem(){
			riskItem_unmodify = (RiskItem)session.get("unmodifyItem");
			riskItem_unmodify.setContent(riskItem_hasmodify.getContent());
			riskItem_unmodify.setEffects(riskItem_hasmodify.getEffects());
			riskItem_unmodify.setProbability(riskItem_hasmodify.getProbability());
			riskItem_unmodify.setThreshold(riskItem_hasmodify.getThreshold());
			riskItemBusiness.modifyRiskItem(riskItem_unmodify);
			req.setAttribute("raId", (int)session.get("showRAId"));
			return SUCCESS;
					
			}
}
