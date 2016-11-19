package edu.rms.business;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.rms.model.RiskItem;


public interface RiskItemBusiness {
	
	
	public String addRiskItem(RiskItem riskItem);
	
	public List<RiskItem> getAllRiskItem();
	
	public List<RiskItem> getMyRiskItem(int userid);
	
	public RiskItem getRiskById(String riskItemid);

	public List<RiskItem> getItemListByIdList(List<String> tempIdList);

	public List<RiskItem> getRiskItemByReg(Timestamp beginTime, Timestamp endTime);

	public List<RiskItem> getRiskItemByPro(Timestamp beginTime, Timestamp endTime);
}
