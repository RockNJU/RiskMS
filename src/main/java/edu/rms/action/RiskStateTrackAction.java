package edu.rms.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import edu.nju.dessert.model.Clerk;
import edu.rms.business.RiskItemBusiness;
import edu.rms.business.RiskStateTrackBusiness;
import edu.rms.model.RiskItem;
import edu.rms.model.RiskStateTrack;
import edu.rms.model.User;


@Component
public class RiskStateTrackAction extends BaseAction{
	
	@Autowired
	private RiskItemBusiness riskItemBusiness;
	private RiskItem riskItem;
	
	@Autowired
	private RiskStateTrackBusiness riskStateTrackBusiness;
	private RiskStateTrack riskStateTrack;
	private RiskStateTrack riskStateTrack_modify;
	private List<RiskStateTrack> itemStateList;
	private String modify_content;
	
	
	
	
	
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

	public RiskStateTrackBusiness getRiskStateTrackBusiness() {
		return riskStateTrackBusiness;
	}

	public void setRiskStateTrackBusiness(RiskStateTrackBusiness riskStateTrackBusiness) {
		this.riskStateTrackBusiness = riskStateTrackBusiness;
	}

	public RiskStateTrack getRiskStateTrack() {
		return riskStateTrack;
	}

	public void setRiskStateTrack(RiskStateTrack riskStateTrack) {
		this.riskStateTrack = riskStateTrack;
	}
	
	
	

	public RiskStateTrack getRiskStateTrack_modify() {
		return riskStateTrack_modify;
	}

	public void setRiskStateTrack_modify(RiskStateTrack riskStateTrack_modify) {
		this.riskStateTrack_modify = riskStateTrack_modify;
	}

	public List<RiskStateTrack> getItemStateList() {
		return itemStateList;
	}

	public void setItemStateList(List<RiskStateTrack> itemStateList) {
		this.itemStateList = itemStateList;
	}

	
	public String getModify_content() {
		return modify_content;
	}

	public void setModify_content(String modify_content) {
		this.modify_content = modify_content;
	}

	//获得当前风险条目的所有状态信息列�?
	public String getOneRiskAllStates() throws ServletException,IOException{
		int idno=Integer.parseInt(req.getParameter("id"));
		
		session.put("riskItem_id", idno);
		itemStateList = riskStateTrackBusiness.getOneRiskAllStates(idno);
		return SUCCESS;
	}
	
	//新增
	public String save(){
		
		riskStateTrack.setPreviousStateId(-1);
		riskStateTrack.setRiskItemId((int)session.get("riskItem_id"));
		riskStateTrack.setState(0);
		
		String result =  riskStateTrackBusiness.save(riskStateTrack);
		
		if(result!=null){
			return SUCCESS;
		}
		return INPUT;
	}
	
	public String turnProblem() throws ServletException,IOException{
		riskStateTrack_modify=riskStateTrackBusiness.getStateTrackById(Integer.parseInt(req.getParameter("id"));
		session.put("previous_id", riskStateTrack_modify.getRiskItemId());
		return SUCCESS;	
	}
	
	public String addProblem(){
		riskStateTrack.setContent(modify_content);
		riskStateTrack.setPreviousStateId(riskStateTrack_modify.getRiskStateTrack_id());
		riskStateTrack.setRiskItemId(riskStateTrack_modify.getRiskItemId());
		riskStateTrack.setState(1);
		return save();
		
	
	}

}
