package edu.rms.business;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import edu.rms.model.RiskItem;


public interface RiskItemBusiness {
	
	
	public String addRiskItem(RiskItem riskItem);
	
	public List<RiskItem> getAllRiskItem();
	
	public List<RiskItem> getMyRiskItem(int userid);
	
	public RiskItem getRiskById(String riskItemid);

	public List<RiskItem> getItemListByIdList(List<String> tempIdList);

	public List<RiskItem> getRiskItemByReg(String beginTime, String endTime);

	public List<RiskItem> getRiskItemByPro(String beginTime, String endTime);

	public Map<String, Integer> getRiskOrderByReg();

	public Map<String, Integer> getRiskOrderByPro();

	public Map<String, Integer> getRiskOrderByRegTime(String beginTime, String endTime);

	public Map<String, Integer> getRiskOrderByProTime(String beginTime, String endTime);
}
