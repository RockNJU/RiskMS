package edu.rms.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


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
	private int riskItemId;
	private int riskStateId;
	
	
	
	
	
	public int getRiskStateId() {
		return riskStateId;
	}

	public void setRiskStateId(int riskStateId) {
		this.riskStateId = riskStateId;
	}

	public int getRiskItemId() {
		return riskItemId;
	}

	public void setRiskItemId(int riskItemId) {
		this.riskItemId = riskItemId;
	}

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

	//鑾峰緱褰撳墠椋庨櫓鏉＄洰鐨勬墍鏈夌姸鎬佷俊鎭垪锟�?
	public String getOneRiskAllStates() throws ServletException,IOException{
		riskItemId=Integer.parseInt(req.getParameter("riskItemId"));
		if(riskItemId==0){
			riskItemId=(Integer)(session.get("riskItem_id"));
		}
		
		session.put("riskItem_id", riskItemId);
		
		System.out.println(riskItemId+"@@@@@@@@@@");
		
		itemStateList = riskStateTrackBusiness.getOneRiskAllStates(riskItemId);
		return SUCCESS;
	}
	
	public String refreshTableList() {
		if(riskItemId==0){
			riskItemId=(Integer)session.get("riskItem_id");
		}
		itemStateList = riskStateTrackBusiness.getOneRiskAllStates(riskItemId);
		return SUCCESS;
	}
	
	//鏂板
	public String save(){
		if(riskItemId==0){
			riskItemId=(Integer)session.get("riskItem_id");
		}
		
		riskStateTrack.setPreviousStateId(-1);
		riskStateTrack.setRiskItemId(riskItemId);
		riskStateTrack.setState(0);
		
		String result =  riskStateTrackBusiness.save(riskStateTrack);
		
		if(result!=null){
			return SUCCESS;
		}
		return INPUT;
	}
	
	public String turnProblem() throws ServletException,IOException{
		riskStateId=Integer.parseInt(req.getParameter("riskStateId"));
		if(riskStateId==0){
			riskStateId=(Integer)session.get("riskState_id");
		}
		session.put("riskState_id", riskStateId);
		
		riskStateTrack_modify=riskStateTrackBusiness.getStateTrackById(riskStateId);
		session.put("previous_id", riskStateTrack_modify.getRiskItemId());
		return SUCCESS;	
	}
	
	public String addProblem(){
		System.out.println(modify_content+"ssssssssssss");
		riskStateTrack=new RiskStateTrack();
		riskStateTrack.setContent(modify_content);
		riskStateTrack.setPreviousStateId((Integer)session.get("previous_id"));
		riskStateTrack.setRiskItemId((Integer)session.get("riskState_id"));
		riskStateTrack.setState(1);
       String result =  riskStateTrackBusiness.save(riskStateTrack);
		
		if(result!=null){
			return SUCCESS;
		}
		return INPUT;
		
	
	}

}
