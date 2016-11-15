package com.rms.business;

import java.util.List;

import com.rms.model.RiskItem;



public interface RiskItemBusiness {
	
	
	public String addRiskItem(RiskItem riskItem);
	
	public List<RiskItem> getAllRiskItem();
	
	public List<RiskItem> getMyRiskItem(Long userid);
}
