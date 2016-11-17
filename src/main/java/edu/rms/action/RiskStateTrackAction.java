package edu.rms.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.rms.business.RiskItemBusiness;
import edu.rms.business.RiskStateTrackBusiness;
import edu.rms.model.RiskItem;
import edu.rms.model.RiskStateTrack;


@Repository
public class RiskStateTrackAction extends BaseAction{
	
	@Autowired
	private RiskItemBusiness riskItemBusiness;
	private RiskItem riskItem;
	@Autowired
	private RiskStateTrackBusiness riskStateTrackBusiness;
	private RiskStateTrack riskStateTrack;
	
	
	
	
	
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

	//获得当前风险条目的所有状态信息列�?
	public List<RiskStateTrack> getOneRiskAllStates(int riskItemId){
		return riskStateTrackBusiness.getOneRiskAllStates(riskItemId);
	}
	
	//新增
	public String save(RiskStateTrack rst){
		return riskStateTrackBusiness.save(rst);
	}
	
}
